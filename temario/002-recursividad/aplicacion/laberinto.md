<div align=right>

<sub>[Implementación](../implementacion/README.md)</sup><br>
<sup>[Aplicación](README.md) / [Torre de Hanoi](hanoi.md) / [El laberinto](laberinto.md) / [N Reinas](nreinas.md) / [Flood Fill](floodfill.md)</sub>

</div>

# El laberinto

El laberinto es el primer ejemplo de backtracking aplicado a un espacio con forma de grafo. A diferencia de los subconjuntos, donde el espacio de búsqueda es un árbol sin ciclos, un laberinto puede tener bucles: desde una celda se puede llegar de vuelta a ella misma por un camino distinto. Eso obliga a una variación del patrón hacer/deshacer que vale la pena examinar.

## El problema

Un laberinto representado como una matriz de enteros: `0` es celda libre, `1` es pared. El punto de entrada es la celda `(0, 0)` y la salida es la celda `(filas-1, columnas-1)`. 

```
==========================================
 · [ ] ·  ·  ·  ·  · [ ] ·  · [ ] ·  ·  · 
 · [ ] · [ ][ ] · [ ][ ] · [ ][ ] · [ ] · 
 ·  ·  · [ ] ·  · [ ] ·  · [ ] ·  · [ ] · 
[ ][ ] · [ ] ·  ·  ·  ·  · [ ] ·  · [ ] · 
 · [ ] · [ ][ ][ ][ ][ ] · [ ][ ] · [ ] · 
 ·  ·  · [ ] ·  · [ ] ·  ·  ·  ·  · [ ] · 
[ ][ ] · [ ] ·  · [ ][ ] · [ ] ·  · [ ] · 
 ·  ·  ·  ·  · [ ] ·  ·  ·  ·  · [ ] ·  · 
==========================================
```

El objetivo es encontrar un camino desde la entrada (esquina superior izquierda) hasta la salida (esquina inferior derecha).

```
==========================================
 * [ ] ·  · [ ] ·  · [ ] ·  · [ ] *  *  * 
 * [ ] · [ ][ ] · [ ][ ] · [ ][ ] * [ ] * 
 *  *  * [ ] ·  · [ ] ·  · [ ] ·  * [ ] * 
[ ][ ] * [ ] ·  *  *  *  * [ ] ·  * [ ] * 
 · [ ] * [ ][ ] * [ ][ ] * [ ][ ] * [ ] * 
 ·  ·  * [ ] ·  * [ ] ·  *  ·  ·  * [ ] * 
[ ][ ] * [ ] *  * [ ][ ] * [ ] *  * [ ] * 
 ·  ·  *  *  * [ ] ·  ·  *  *  * [ ] ·  * 
==========================================
```

## Anatomía recursiva

El algoritmo intenta avanzar desde `(fila, columna)` en cuatro direcciones posibles. Si alguna lleva a la salida, el camino queda marcado. Si ninguna funciona, la celda se descarta y se retrocede.

Hay cuatro estados de celda:

| Constante | Valor | Significado |
| --- | --- | --- |
| `LIBRE` | 0 | Celda transitable, no visitada |
| `PARED` | 1 | Obstáculo, no transitable |
| `CAMINO` | 2 | Parte del camino solución |
| `VISITADO` | 3 | Explorada y descartada |

### El estado como matriz (Paso 08)

La matriz `laberinto` es el objeto mutable compartido por todas las llamadas. Cada celda que se modifica es visible desde cualquier punto de la pila de llamadas. Esto es exactamente lo que el [Paso 08](../implementacion/08-el-estado.md) describía: un objeto que viaja a través de todos los marcos.

### Find-first con `return true` (Paso 11)

El algoritmo busca una sola solución. En cuanto la encuentra, propaga el éxito hacia arriba sin deshacer nada:

```java
if (resolver(laberinto, fila + 1, columna) 
    || resolver(laberinto, fila, columna + 1) 
    || resolver(laberinto, fila - 1, columna) 
    || resolver(laberinto, fila, columna - 1)) {
    return true;
}
```

El `||` con cortocircuito es el `return true` del [Paso 11](../implementacion/11-una-solucion.md): en cuanto una dirección tiene éxito, las demás no se evalúan y el éxito sube por la pila.

Las celdas marcadas como `CAMINO` son la solución. No se deshacen porque no hace falta: el árbol se colapsa en cuanto se encuentra el primer camino válido.

### Hacer y deshacer con una variación (Paso 09)

Aquí aparece la diferencia más importante respecto al ejemplo de subconjuntos.

En subconjuntos, el deshacer restaura el estado original:

```
HACER:    actual.agregar(elemento)   →  camino = [..., elemento]
EXPLORAR: fabricar(...)
DESHACER: actual.quitar()            →  camino = [...]   ← igual que al entrar
```

En el laberinto, el deshacer **no restaura el estado original**:

```
HACER:    laberinto[fila][columna] = CAMINO   →  celda pasa de LIBRE a CAMINO
EXPLORAR: resolver(4 direcciones)
DESHACER: laberinto[fila][columna] = VISITADO →  celda pasa de CAMINO a VISITADO
```

La celda no vuelve a `LIBRE`. Queda marcada como `VISITADO`.

#### ¿Por qué?

Un laberinto puede tener ciclos. Si la celda `(2, 3)` conecta con `(2, 4)` y `(3, 3)`, y `(3, 3)` conecta de vuelta con `(2, 3)`, restaurar a `LIBRE` al retroceder crearía un bucle infinito: el algoritmo entraría y saldría de las mismas celdas indefinidamente.

`VISITADO` actúa como una marca permanente de callejón sin salida. Una vez descartada una celda, no se vuelve a intentar. El algoritmo garantiza así que termina.

Hay una segunda razón, más sutil. El `||` que evalúa las cuatro direcciones tiene cortocircuito: se detiene en el primer `true`, pero **continúa evaluando si obtiene `false`**. Cuando la primera dirección falla y el `||` pasa a la segunda, esa segunda llamada puede llegar a celdas que la primera ya exploró. Si esas celdas fueran `LIBRE`, la segunda dirección las exploraría de nuevo, recorrería los mismos callejones, y devolvería `false` igualmente — repitiendo trabajo ya hecho. Con `VISITADO`, la llamada entra en la función, comprueba `laberinto[fila][columna] != LIBRE`, y sale de inmediato. El trabajo muerto no se repite.

`VISITADO` cumple por tanto dos funciones a la vez: evita los ciclos infinitos y evita la reexploración de callejones ya conocidos entre las diferentes ramas del `||`.

||Subconjuntos|Laberinto|
|---|---|---|
|¿El espacio tiene ciclos?|No (árbol de decisiones)|Sí (grafo)|
|¿Qué hace el deshacer?|Restaura a estado original|Marca como visitado|
|¿Puede volver a la misma celda/elemento?|No (el índice avanza)|Sin la marca, sí|

La conclusión es que el hacer/deshacer del [Paso 09](../implementacion/09-hacer-y-deshacer.md) describe el principio general: al retroceder, el estado debe quedar tal que la exploración desde arriba sea correcta. En un árbol eso significa restaurar exactamente. En un grafo significa marcar para no repetir.

## Implementación

```java
static boolean resolver(int[][] laberinto, int fila, int columna) {
    if (fila < 0 || fila >= laberinto.length || columna < 0 || columna >= laberinto[0].length) {
        return false;
    }
    if (laberinto[fila][columna] != LIBRE) {
        return false;
    }
    if (fila == laberinto.length - 1 && columna == laberinto[0].length - 1) {
        laberinto[fila][columna] = CAMINO;
        return true;
    }

    laberinto[fila][columna] = CAMINO;                                      // HACER

    if (resolver(laberinto, fila + 1, columna) || resolver(laberinto, fila, columna + 1) ||
        resolver(laberinto, fila - 1, columna) || resolver(laberinto, fila, columna - 1)) {
        return true;                                               // propagar éxito
    }

    laberinto[fila][columna] = VISITADO;                                    // DESHACER (≠ LIBRE)
    return false;
}
```

> El código completo está en [Laberinto.java](../src/Laberinto.java).

## Estructura en el árbol de decisiones

Cada llamada representa una celda. Las cuatro direcciones son las cuatro ramas posibles. La poda es implícita: las primeras dos comprobaciones (`fuera de límites` y `celda != LIBRE`) descartan ramas antes de entrar en ellas, exactamente igual que la poda del [Paso 13](../implementacion/13-poda.md).

La diferencia con los ejemplos anteriores es que el árbol tiene forma de grafo subyacente. La pila de llamadas sigue siendo el árbol, pero el espacio que recorre es una red, no una secuencia.

## El orden de exploración importa

El algoritmo prueba las cuatro direcciones en un orden fijo: abajo, derecha, arriba, izquierda. Ese orden determina cuál camino se encuentra, no si se encuentra alguno.

```java
int[][] siguientes = {{fila + 1, columna}, {fila, columna + 1}, {fila - 1, columna}, {fila, columna - 1}};
```

Cambiar este array a `{derecha, abajo, arriba, izquierda}` produciría un camino diferente en el mismo laberinto, igualmente válido pero distinto. El algoritmo encuentra **una** solución, no **la** solución. Esto es consecuencia directa de find-first: la "primera" solución que encuentra depende del orden en que explora.

No estamos optimizando. Esa es una decisión explícita: el objetivo aquí es encontrar **si existe** un camino, no encontrar el más corto.

## Para quien quiera ir más lejos

Una observación: el algoritmo no tiene memoria de qué dirección funcionó en el paso anterior. Desde cada celda, empieza siempre por "abajo". Si el camino tiende a ir en una dirección concreta, el algoritmo lo redescubre en cada celda en lugar de aprovecharlo.

Una mejora posible: recordar la última dirección que llevó a avanzar y probarla primero en la siguiente celda. Eso no cambiaría la corrección del algoritmo ni el resultado final, pero reduciría el número de intentos fallidos. Es la diferencia entre exploración ciega y exploración informada.

Esa idea tiene nombre: **heurística**. Es el principio detrás de algoritmos de búsqueda informada que usan estimaciones del coste restante para decidir qué explorar primero, aunque con una estructura completamente distinta a la de este algoritmo.

> [Siguiente: N Reinas](nreinas.md)
