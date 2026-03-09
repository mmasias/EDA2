<div align=right>

<sub>[Implementación](../implementacion/README.md)</sup><br>
<sup>[Torre de Hanoi](hanoi.md) / [El laberinto](laberinto.md) / [N Reinas](nreinas.md) / [Flood Fill](floodfill.md)</sub>

</div>

# La Torre de Hanoi

||||
|-|-|-|
|La Torre de Hanoi es el ejemplo más célebre de recursión con múltiples llamadas.|Con tres torres y n discos, la solución completa cabe en cuatro líneas de código.|Entender por qué esas cuatro líneas funcionan es entender qué significa que una función recursiva refleje la estructura de un problema.

## El problema

Tres torres. `n` discos apilados por tamaño decreciente en la torre origen. El objetivo es moverlos todos a la torre destino respetando una sola restricción: ningún disco puede colocarse sobre uno más pequeño.

<div align=center>

<table>
<tr><th>Estado inicial (n=3)</th><th>Estado final</th></tr>
<tr><td>

```

  |        |        |    
 [1]       |        |    
 [2]       |        |    
 [3]       |        |    
Torre A  Torre B  Torre C
```
</td><td>

```

  |        |        |
  |        |       [1]
  |        |       [2]
  |        |       [3]
Torre A  Torre B  Torre C
```
</td></tr>
</table>

</div>

## Anatomía recursiva

La observación clave: para mover `n` discos de A a C, hay exactamente tres pasos, y dos de ellos son el mismo problema con `n-1` discos.

```
mover(n, origen, destino, auxiliar):
    mover(n-1, origen, auxiliar, destino)   ← mismo problema, menor tamaño
    mover el disco n de origen a destino    ← operación concreta
    mover(n-1, auxiliar, destino, origen)   ← mismo problema, menor tamaño
```

Esto conecta directamente con el **[Paso 06](../implementacion/06-multiples-llamadas-ambas.md)**: dos llamadas recursivas que se ejecutan ambas, con una operación intercalada entre ellas. La estructura es idéntica al inorder de un árbol binario, pero el problema es completamente distinto.

| Elemento | En inorder | En Hanoi |
|---|---|---|
| Llamada 1 | `inorder(nodo.izquierda)` | `mover(n-1, origen, auxiliar, destino)` |
| Operación intermedia | `print(nodo.valor)` | mover el disco grande |
| Llamada 2 | `inorder(nodo.derecha)` | `mover(n-1, auxiliar, destino, origen)` |
| Caso base | `nodo == null` | `n == 1` |

## Implementación

```java
static void resolver(int n, char origen, char destino, char auxiliar) {
    if (n == 1) {
        System.out.println("Mover disco 1 de " + origen + " a " + destino);
        return;
    }

    resolver(n - 1, origen, auxiliar, destino);
    System.out.println("Mover disco " + n + " de " + origen + " a " + destino);
    resolver(n - 1, auxiliar, destino, origen);
}
```

El código tiene exactamente la misma forma que la descripción en palabras. Eso es lo que significa que la función refleja la estructura del problema.

> El código completo, incluyendo una versión con visualización paso a paso y una traza de llamadas, está en [Hanoi.java](../src/Hanoi.java).

## El árbol de llamadas

Lo que los movimientos visibles no muestran es todo lo que ocurre entre ellos: las llamadas recursivas que descienden en silencio hasta el caso base, y el ascenso posterior. La traza de llamadas hace eso visible. Para `n=3`:

```
--> resolver(3, A, C, B)
  --> resolver(2, A, B, C)
    --> resolver(1, A, C, B)
        [mover disco 1 de A a C]
    <-- resolver(1, A, C, B)
    [mover disco 2 de A a B]
    --> resolver(1, C, B, A)
        [mover disco 1 de C a B]
    <-- resolver(1, C, B, A)
  <-- resolver(2, A, B, C)
    [mover disco 3 de A a C]
  --> resolver(2, B, C, A)
    --> resolver(1, B, A, C)
        [mover disco 1 de B a A]
    <-- resolver(1, B, A, C)
    [mover disco 2 de B a C]
    --> resolver(1, A, C, B)
        [mover disco 1 de A a C]
    <-- resolver(1, A, C, B)
  <-- resolver(2, B, C, A)
<-- resolver(3, A, C, B)
```

La sangría es la profundidad de la pila. Y esta traza  nos permite tomar conciencia de que el primer movimiento no ocurre sino hasta que `-->` ha bajado `n` niveles. Es decir, que entre un movimiento y el siguiente puede haber **varias llamadas recursivas silenciosas**.

Siete movimientos para tres discos. Cada nivel del árbol duplica el número de llamadas: para `n` discos, el total de movimientos es siempre `2ⁿ - 1`.

## Lo que Hanoi no tiene (y por qué importa)

Hanoi no tiene estado mutable. No hay un objeto `actual` que se construya y deshaga. No hay exploración de posibilidades: en cada nivel, la solución es única y obligatoria.

Eso lo diferencia del backtracking que vimos en los pasos 08-13:

| | Hanoi | Backtracking |
|---|---|---|
| ¿Hay elecciones? | No. Cada paso está determinado. | Sí. Se exploran múltiples opciones. |
| ¿Hay estado mutable? | No. | Sí (el objeto `actual`). |
| ¿Hay hacer/deshacer? | No. | Sí. |
| ¿Puede fallar? | No. Siempre hay solución. | Sí. Una rama puede no llevar a ninguna solución. |
| Patrón del Paso 06 | ✓ | ✓ (como base) |

La recursión múltiple es el punto en común. El backtracking es recursión múltiple más exploración de posibilidades más hacer/deshacer. Hanoi es recursión múltiple sin nada de eso.

### Completar no es deshacer

La diferencia entre Hanoi y backtracking es visible en un solo parámetro. Obsérvense las dos llamadas recursivas:

```java
resolver(n - 1, origen,   auxiliar, destino);   // mover n-1 discos a auxiliar
// mover disco n de origen a destino
resolver(n - 1, auxiliar, destino,  origen);    // mover n-1 discos encima del disco n
```

Si la segunda llamada estuviera deshaciendo la primera, devolvería los `n-1` discos al punto de partida:

```java
resolver(n - 1, origen,   auxiliar, destino);   // mover n-1 discos a auxiliar
// ...
resolver(n - 1, auxiliar, origen,   destino);   // ← deshacer: volver a origen
```

No es eso lo que ocurre. El `destino` de la segunda llamada no es `origen` sino `destino`: los `n-1` discos avanzan hacia el destino final, apoyándose en el disco grande que acaba de quedar colocado debajo. La segunda llamada completa el trabajo que la primera dejó a medias.

Por eso no hay estado que restaurar: cada llamada deja el resultado en el sitio correcto para que la siguiente lo use. Eso es exactamente lo que distingue dividir y vencer de explorar y retroceder.

### Correcto por construcción

Una pregunta razonable: ¿qué impide que el algoritmo haga un movimiento inválido, como colocar un disco grande sobre uno pequeño?

La respuesta es que nada lo impide explícitamente. No hay ningún `if` que compruebe si el movimiento es legal. Lo que lo hace imposible es la propia estructura de la recursión. El argumento es inductivo:

**Caso base (n=1):** mover un único disco a cualquier torre es siempre válido. No hay nada encima de nada.

**Paso inductivo:** asumiendo que `resolver(n-1)` produce únicamente movimientos válidos, `resolver(n)` también los produce:

1. La primera llamada `resolver(n-1, origen, auxiliar, destino)` mueve los `n-1` discos superiores a `auxiliar`. Por hipótesis, todos sus movimientos internos son válidos. Al terminar, `origen` tiene solo el disco `n` y `destino` está vacío.
2. Se mueve el disco `n` a `destino`. Válido: `destino` está vacío.
3. La segunda llamada `resolver(n-1, auxiliar, destino, origen)` coloca los `n-1` discos sobre `destino`. Por hipótesis, todos sus movimientos internos son válidos. Y el destino final sobre el disco `n` es válido porque `n` es el mayor.

La corrección se garantiza a todos los niveles de la recursión, no solo en el nivel superior. Los movimientos intermedios, como colocar el disco 1 sobre el disco 2, son válidos porque el disco 1 es más pequeño: la regla prohíbe poner un disco sobre uno **más pequeño**, no sobre cualquier otro.

Esto contrasta con el laberinto (`if (laberinto[x][y] != LIBRE)`) o con N-Reinas, que valida explícitamente cada posición. En esos problemas hay movimientos posibles que son inválidos y el código debe detectarlos. En Hanoi no existen movimientos inválidos que detectar: la estructura recursiva los hace imposibles en todos los niveles.

## Complejidad

Cada disco adicional duplica el número de movimientos. Para `n` discos: `2ⁿ - 1` movimientos.

| Discos | Movimientos |
|---|---|
| 3 | 7 |
| 10 | 1.023 |
| 20 | 1.048.575 |
| 64 | 18.446.744.073.709.551.615 |

Con 64 discos, a un movimiento por segundo, se necesitarían aproximadamente 585 mil millones de años. El crecimiento exponencial no es una curiosidad teórica.

---

> [Siguiente: El laberinto →](laberinto.md)
