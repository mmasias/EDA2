<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [Estructuración](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [**Aplicación**](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Inicio](README.md) / [Torre de Hanoi](hanoi.md) / [El laberinto](laberinto.md) / [N Reinas](nreinas.md) / [**Flood Fill**](floodfill.md)

</div>

# Flood Fill

||||
|-|-|-|
|Flood Fill es el algoritmo detrás del bote de pintura de cualquier editor de imagen.|La recursión avanza por la imagen coloreando celdas adyacentes hasta agotar la zona.|Es el ejemplo más limpio de recursión multidireccional donde el cambio de estado es el resultado, no un medio para encontrarlo.|

## El problema

Una imagen representada como una matriz de enteros, donde cada valor es un color. Dada una celda de partida, pintar toda la zona conectada que comparte el color original, reemplazándola por un color nuevo.

```text
Imagen original (15x10)          Flood Fill desde (2,3) con color 9

  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0          0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0          0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
  0  0  1  1  1  0  0  0  1  1  1  1  0  0  0          0  0  9  9  9  0  0  0  1  1  1  1  0  0  0
  0  0  1  1  1  0  0  0  1  1  1  1  0  0  0          0  0  9  9  9  0  0  0  1  1  1  1  0  0  0
  0  0  1  1  1  0  0  0  1  1  1  1  0  0  0          0  0  9  9  9  0  0  0  1  1  1  1  0  0  0
  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0          0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0    →     0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0          0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
  0  0  0  0  0  0  0  0  0  0  0  0  0  0  0          0  0  0  0  0  0  0  0  0  0  0  0  0  0  0
  0  0  0  0  0  0  0  0  0  0  0  1  1  1  0          0  0  0  0  0  0  0  0  0  0  0  1  1  1  0
```

La zona derecha (`1` en columnas 8-11) no se pinta porque no está conectada con el punto de partida.

## Anatomía recursiva

El algoritmo es directo: llegar a una celda, pintarla, propagarse a las cuatro direcciones.

```text
fill(imagen, fila, columna, colorOriginal, colorNuevo):
    si fuera de límites             → salir
    si imagen[fila][columna] ≠ colorOriginal → salir
    imagen[fila][columna] = colorNuevo          ← cambio permanente
    fill(imagen, fila + 1, columna, ...)        ← abajo
    fill(imagen, fila - 1, columna, ...)        ← arriba
    fill(imagen, fila, columna + 1, ...)        ← derecha
    fill(imagen, fila, columna - 1, ...)        ← izquierda
```

No hay retorno de valor. No hay exploración de posibilidades. Las cuatro llamadas se ejecutan siempre. El trabajo ocurre antes de las llamadas recursivas, no después.

### El estado como matriz (Paso 08)

La matriz `imagen` es el objeto mutable compartido por todas las llamadas. Cuando la recursión llega a una celda y la pinta, ese cambio es visible desde cualquier punto de la pila. Es el [Paso 08](../03-implementacion/08-el-estado.md): un objeto mutable que viaja a través de todos los marcos, y cuyas modificaciones persisten.

### Recursión multidireccional sin condicional (Paso 06)

Las cuatro llamadas se ejecutan todas, sin `||` ni `if` que las rodee. No se elige entre ellas: se lanzan en todas las direcciones y cada una decide sola si tiene trabajo que hacer, a través de los casos base. Esto sigue el patrón del [Paso 06](../03-implementacion/06-multiples-llamadas-ambas.md): múltiples llamadas que se ejecutan ambas (las cuatro, en este caso).

La diferencia con el laberinto es precisa: el laberinto usa `||` y se detiene en la primera dirección exitosa. Flood Fill no tiene éxito ni fracaso por dirección: simplemente continúa hacia todas partes.

## Implementación

```java
static void fill(int[][] imagen, int fila, int columna, int colorOriginal, int colorNuevo) {
    if (fila < 0 || fila >= imagen.length || columna < 0 || columna >= imagen[0].length) {
        return;
    }
    if (imagen[fila][columna] != colorOriginal) {
        return;
    }

    imagen[fila][columna] = colorNuevo;                              // cambio permanente

    fill(imagen, fila + 1, columna, colorOriginal, colorNuevo);
    fill(imagen, fila - 1, columna, colorOriginal, colorNuevo);
    fill(imagen, fila, columna + 1, colorOriginal, colorNuevo);
    fill(imagen, fila, columna - 1, colorOriginal, colorNuevo);
}
```

> **Precondición**: el cliente debe verificar que `colorOriginal ≠ colorNuevo` antes de llamar. Si son iguales, la segunda comprobación (`imagen[fila][columna] != colorOriginal`) nunca se cumple — la celda ya tiene el color nuevo, que coincide con el original — y el algoritmo entra en un bucle infinito.
>
> El código completo está en [FloodFill.java](../../../src/recursividad/FloodFill.java).

## Por qué termina

Cada celda pintada cambia de `colorOriginal` a `colorNuevo`. La segunda comprobación la descarta en cualquier llamada posterior. Como la imagen tiene un número finito de celdas y cada una se procesa exactamente una vez, la recursión siempre termina.

No hace falta una marca `VISITADO` explícita: el propio cambio de color actúa como marca. **El color nuevo es la marca de visitado.**

## El cambio es el resultado

En todos los algoritmos de backtracking vistos hasta aquí, el estado mutable era un medio: se modificaba para explorar y se restauraba al retroceder. El resultado era algo que se encontraba o construía en el camino.

En Flood Fill, el cambio de estado es el resultado. No hay nada que encontrar ni construir: la transformación de la imagen es el objetivo en sí mismo.

| | Backtracking | Flood Fill |
| --- | --- | --- |
| ¿Hay hacer/deshacer? | Sí | No |
| ¿El cambio de estado es permanente? | No (se deshace) | Sí |
| ¿Hay éxito o fracaso por celda? | Sí | No |
| ¿Qué es el resultado? | Una configuración encontrada | La imagen transformada |

La ausencia de hacer/deshacer no es un olvido: es lo que define al algoritmo. Flood Fill no explora posibilidades. Visita cada celda exactamente una vez y la pinta. No hay vuelta atrás porque no se toman decisiones.

## Comparación con el laberinto

Flood Fill y el laberinto comparten estructura superficial: ambos recorren una matriz en cuatro direcciones y ambos necesitan evitar revisitar celdas. Pero el propósito de la marca de visitado es opuesto.

| | Laberinto | Flood Fill |
| --- | --- | --- |
| Marca de "ya procesado" | `VISITADO` (callejón sin salida) | el color nuevo |
| ¿Qué significa la marca? | Esta celda no lleva a ninguna solución | Esta celda ya ha sido pintada |
| ¿Las celdas marcadas son parte del resultado? | No (se excluyen) | Sí (son el resultado) |
| ¿Hay retroceso? | Sí, con `VISITADO` | No |

En el laberinto, `VISITADO` señala fracaso. En Flood Fill, el color nuevo señala éxito. La misma técnica de marcar celdas cumple funciones opuestas en los dos algoritmos.
