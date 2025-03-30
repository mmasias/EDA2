# Insertion Sort (Ordenamiento por Inserción)

## ¿Por qué?

El ordenamiento por inserción es eficiente en listas pequeñas o casi ordenadas, donde supera a otros métodos más complejos como Quick Sort o Merge Sort. Este algoritmo es intuitivo y simula la forma en que las personas ordenan cartas en sus manos, seleccionando una carta y colocándola en la posición correcta. 

Es particularmente útil en entornos donde los datos llegan de manera incremental y necesitan ser ordenados inmediatamente, como en la gestión de transacciones en tiempo real.

## ¿Qué?

El Insertion Sort es un algoritmo de ordenamiento que construye la salida final un elemento a la vez, insertando cada elemento en su posición correcta dentro de una sublista ya ordenada.

Comienza por el segundo elemento de la lista, ya que un solo elemento se considera ordenado, y va compando este elemento con los elementos en la sublista ordenada, desplazándolos hacia la derecha hasta encontrar la posición correcta para el nuevo elemento.

## ¿Para qué?

Este método es ideal para listas pequeñas o cuando se agregan pocos elementos a una lista ya ordenada. En comparación con otros algoritmos de ordenamiento que tienen mejor rendimiento en teoría, el Insertion Sort ofrece un mejor tiempo de ejecución en la práctica bajo estas condiciones debido a su simplicidad y al menor número de comparaciones necesarias en listas parcialmente ordenadas. 

Además, es un algoritmo estable, lo que significa que no cambia el orden relativo de elementos con valores iguales, una propiedad valiosa para ciertas aplicaciones como algoritmos de ordenamiento que respetan la cronología de transacciones.

## ¿Cómo?

### Implementación

```java
public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];  // Desplaza el elemento hacia la derecha
                j--;
            }
            array[j + 1] = current; // Inserta el elemento en su lugar correcto
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        sort(data);
        System.out.println("Array ordenado:");
        for (int value : data) {
            System.out.print(value + " ");
        }
    }
}
```

#### Traza

- Lista original: \([22, 11, 99, 88, 9, 7, 42]\)

##### Iteración 1: Insertar 11 en su posición correcta

- Comparamos 11 con 22 (primer elemento anterior a 11).
- Como 22 es mayor que 11, movemos 22 a la derecha.
- Insertamos 11 donde estaba 22.
- Lista resultante: \([11, 22, 99, 88, 9, 7, 42]\)

##### Iteración 2: Insertar 99 en su posición correcta

- Comparamos 99 con 22.
- 99 es mayor que 22, por lo que queda en su posición.
- Lista resultante: \([11, 22, 99, 88, 9, 7, 42]\)

##### Iteración 3: Insertar 88 en su posición correcta

- Comparamos 88 con 99.
- Como 99 es mayor, movemos 99 a la derecha.
- 88 es mayor que 22, por lo que queda en su posición.
- Lista resultante: \([11, 22, 88, 99, 9, 7, 42]\)

##### Iteración 4: Insertar 9 en su posición correcta

- Comparamos 9 con 99, 88, 22 y finalmente 11.
- Todos son mayores que 9, por lo que todos se desplazan a la derecha.
- Insertamos 9 en la posición inicial.
- Lista resultante: \([9, 11, 22, 88, 99, 7, 42]\)

##### Iteración 5: Insertar 7 en su posición correcta

- Comparamos 7 con 99, 88, 22, 11 y 9.
- Todos son mayores que 7, se desplazan a la derecha.
- Insertamos 7 en la posición inicial.
- Lista resultante: \([7, 9, 11, 22, 88, 99, 42]\)

##### Iteración 6: Insertar 42 en su posición correcta

- Comparamos 42 con 99, 88, 22 y 11.
- 42 es menor que 99 y 88, pero mayor que 22.
- Movemos 99 y 88 a la derecha.
- Insertamos 42 donde estaba 22.
- Lista resultante: \([7, 9, 11, 22, 42, 88, 99]\)

##### Lista Final Ordenada:

- \([7, 9, 11, 22, 42, 88, 99]\)

Cada iteración del Insertion Sort toma un elemento de la parte no ordenada, compara este elemento con los ya ordenados en la parte izquierda, y los mueve a la derecha hasta encontrar la posición correcta para el elemento actual. Este método es especialmente eficaz para listas que están casi ordenadas inicialmente, ya que requiere menos movimientos.
