<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [Estructuración](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [**Aplicación**](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Inicio](README.md) / [Torre de Hanoi](hanoi.md) / [El laberinto](laberinto.md) / [**N Reinas**](nreinas.md) / [Flood Fill](floodfill.md)

</div>

# N Reinas

N Reinas es el problema donde la poda deja de ser una comprobación integrada en la lógica de exploración y pasa a ser una función con nombre propio. Esa separación no es cosmética: cuando la condición de descarte es lo bastante rica para merecer su propio cuerpo, aislarla hace el algoritmo más legible y permite comprobar su corrección de forma independiente. El resto del patrón - estado mutable compartido, hacer/deshacer, find-first o find-all - es exactamente igual que antes.

## El problema

Colocar `n` reinas en un tablero `n×n` de manera que ninguna amenace a otra. Dos reinas se amenazan si comparten fila, columna o diagonal.

```text
 .  Q  .  .        .  .  Q  .
 .  .  .  Q        Q  .  .  .
 Q  .  .  .        .  .  .  Q
 .  .  Q  .        .  Q  .  .

  solución 1         solución 2
```

Para `n=4` existen exactamente dos soluciones. Para `n=8`, noventa y dos.

## Anatomía recursiva

El algoritmo coloca reinas **columna por columna**. Cada llamada se encarga de una columna: prueba todas las filas posibles en esa columna y avanza a la siguiente si puede colocar.

```text
resolver(tablero, columna):
    si columna == n  →  solución completa
    para cada fila en 0..n-1:
        si puedeColocar(tablero, fila, columna):
            tablero[fila][columna] = 1       // HACER
            resolver(tablero, columna + 1)
            tablero[fila][columna] = 0       // DESHACER
```

### El estado como tablero (Paso 08)

El `tablero` es la matriz entera compartida por todas las llamadas. Cada `1` que se escribe es visible desde cualquier punto de la pila. Es el [Paso 08](../03-implementacion/08-el-estado.md): un objeto mutable que viaja a través de todos los marcos.

### La poda: `puedeColocar` (Paso 13)

En el laberinto, la poda era inline: `if (laberinto[x][y] != LIBRE) return false`. En N Reinas, la condición requiere recorrer tres direcciones del tablero, y eso merece un método propio:

```java
static boolean puedeColocar(int[][] tablero, int fila, int columna) {
    for (int c = 0; c < columna; c = c + 1) {
        if (tablero[fila][c] == 1) {                              // horizontal izquierda
            return false;
        }
    }
    for (int f = fila, c = columna; f >= 0 && c >= 0; f = f - 1, c = c - 1) {
        if (tablero[f][c] == 1) {                                 // diagonal arriba-izquierda
            return false;
        }
    }
    for (int f = fila, c = columna; f < tablero.length && c >= 0; f = f + 1, c = c - 1) {
        if (tablero[f][c] == 1) {                                 // diagonal abajo-izquierda
            return false;
        }
    }
    return true;
}
```

**Solo mira hacia la izquierda.** Las reinas se colocan de izquierda a derecha, así que a la derecha de `columna` no hay nada todavía. Eso elimina dos de las cinco restricciones:

| Dirección | ¿Se comprueba? | Razón |
| --- | --- | --- |
| Horizontal izquierda | Sí | Puede haber reina en la misma fila |
| Diagonal arriba-izquierda | Sí | Puede haber reina en diagonal |
| Diagonal abajo-izquierda | Sí | Puede haber reina en diagonal |
| Horizontal derecha | No | Siempre vacío: las reinas avanzan de izquierda a derecha |
| Misma columna | No | Imposible: cada llamada gestiona exactamente una columna |

La última fila es la más sutil. Como cada llamada es responsable de una sola columna, colocar dos reinas en la misma columna es estructuralmente imposible. El algoritmo descarta esa restricción sin ningún `if`, igual que Hanoi descartaba los movimientos inválidos por construcción.

La separación tiene además una ventaja práctica: `puedeColocar` puede probarse de forma independiente del algoritmo de búsqueda. Corrección y exploración son dos preocupaciones distintas.

### Hacer y deshacer (Paso 09)

El patrón es el mismo de siempre. El deshacer restaura la celda a `0` - su estado original - porque el tablero no tiene ciclos: una celda descartada desde una columna puede ser válida desde otra. No hay aquí la asimetría del laberinto.

```text
tablero[fila][columna] = 1;           // HACER:    reina colocada
resolver(tablero, columna + 1);       // EXPLORAR: intentar columna siguiente
tablero[fila][columna] = 0;           // DESHACER: reina retirada
```

### Una solución y todas las soluciones (Pasos 11 y 12)

N Reinas admite naturalmente las dos variantes del patrón de búsqueda. La diferencia entre ellas es de dos líneas:

| | `unaSolucion` (Paso 11) | `todasLasSoluciones` (Paso 12) |
| --- | --- | --- |
| Tipo de retorno | `boolean` | `void` |
| Al encontrar solución | `return true` (colapsa el árbol) | `mostrar` y `return` |
| El `DESHACER` | solo si la rama fracasa | siempre, incondicionalmente |
| Árbol explorado | Hasta la primera hoja válida | Completo |

## Implementación

```java
static boolean unaSolucion(int[][] tablero, int columna) {
    if (columna == tablero.length) {
        return true;
    }
    for (int fila = 0; fila < tablero.length; fila = fila + 1) {
        if (puedeColocar(tablero, fila, columna)) {
            tablero[fila][columna] = 1;                  // HACER
            if (unaSolucion(tablero, columna + 1)) {
                return true;                             // propagar éxito
            }
            tablero[fila][columna] = 0;                  // DESHACER
        }
    }
    return false;
}

static void todasLasSoluciones(int[][] tablero, int columna) {
    if (columna == tablero.length) {
        mostrar(tablero);
        return;
    }
    for (int fila = 0; fila < tablero.length; fila = fila + 1) {
        if (puedeColocar(tablero, fila, columna)) {
            tablero[fila][columna] = 1;                  // HACER
            todasLasSoluciones(tablero, columna + 1);
            tablero[fila][columna] = 0;                  // DESHACER
        }
    }
}
```

> El código completo, incluyendo `puedeColocar` y `unaSolucionConVisualizacion`, está en [NReinas.java](../../../src/recursividad/NReinas.java).

## El backtracking visible

`unaSolucionConVisualizacion` hace explícito lo que normalmente ocurre en silencio. Para `n=4`, `unaSolucion` encuentra la solución 2:

```text
--> Reina 1 en fila 1: puede
 Q  .  .  .
 .  .  .  .
 .  .  .  .
 .  .  .  .

 x  Reina 2 en fila 1: no puede
 x  Reina 2 en fila 2: no puede
--> Reina 2 en fila 3: puede
 Q  .  .  .
 .  .  .  .
 .  Q  .  .
 .  .  .  .

 x  Reina 3 en fila 1: no puede
 x  Reina 3 en fila 2: no puede
 x  Reina 3 en fila 3: no puede
 x  Reina 3 en fila 4: no puede
    Reina 3 sin posición. Retrocedo a reina 2.
<-- Reina 2 retirada de fila 3
 Q  .  .  .
 .  .  .  .
 .  .  .  .
 .  .  .  .

--> Reina 2 en fila 4: puede
 Q  .  .  .
 .  .  .  .
 .  .  .  .
 .  Q  .  .

 x  Reina 3 en fila 1: no puede
--> Reina 3 en fila 2: puede
 Q  .  .  .
 .  .  Q  .
 .  .  .  .
 .  Q  .  .

 x  Reina 4 en fila 1: no puede
 x  Reina 4 en fila 2: no puede
 x  Reina 4 en fila 3: no puede
 x  Reina 4 en fila 4: no puede
    Reina 4 sin posición. Retrocedo a reina 3.
<-- Reina 3 retirada de fila 2
 x  Reina 3 en fila 3: no puede
 x  Reina 3 en fila 4: no puede
    Reina 3 sin posición. Retrocedo a reina 2.
    Reina 2 sin posición. Retrocedo a reina 1.
<-- Reina 1 retirada de fila 1
 .  .  .  .
 .  .  .  .
 .  .  .  .
 .  .  .  .

--> Reina 1 en fila 2: puede
 x  Reina 2 en fila 1: no puede
 x  Reina 2 en fila 2: no puede
 x  Reina 2 en fila 3: no puede
--> Reina 2 en fila 4: puede
--> Reina 3 en fila 1: puede
 x  Reina 4 en fila 1: no puede
 x  Reina 4 en fila 2: no puede
--> Reina 4 en fila 3: puede
 .  .  Q  .
 Q  .  .  .
 .  .  .  Q
 .  Q  .  .
```

Tres cosas que la traza hace visibles:

**El `DESHACER` libera la casilla para la fila siguiente.** Entre dos `-->` de la misma reina, el tablero muestra el hueco que dejó la retirada. La reina avanza visiblemente por su columna.

**El fracaso se propaga hacia atrás hasta encontrar opciones disponibles.** Cuando Reina 3 agota sus cuatro filas, el retroceso llega a Reina 2. Cuando Reina 2 agota las suyas, llega a Reina 1. La pila se deshace nivel por nivel hasta encontrar un nivel con margen.

**Los `x` son la poda en acción.** Cada `x` es una llamada a `puedeColocar` que evita entrar en una rama entera. Sin poda, el algoritmo entraría igualmente, exploraría todas sus hojas, y devolvería `false` - repitiendo trabajo ya descartable.

> [Siguiente: Flood Fill](floodfill.md)
