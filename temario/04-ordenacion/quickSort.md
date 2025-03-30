# Quick Sort (Ordenamiento Rápido)

## ¿Por qué?

Quick Sort es uno de los algoritmos de ordenamiento más eficientes y comúnmente utilizados, especialmente útil para grandes conjuntos de datos. Su popularidad se debe a su eficiencia en el promedio de los casos, donde presenta una complejidad temporal de \(O(n \log n)\), similar a Merge Sort, pero en muchos escenarios es más rápido debido a menores constantes de tiempo y menos requerimientos de espacio adicional.

## ¿Qué?

Quick Sort es un algoritmo de ordenamiento que sigue el paradigma de "divide y vencerás". 

- Selecciona un elemento del arreglo para actuar como "pivote" y particiona los otros elementos en dos sub-arreglos, más pequeños que el pivote y mayores que el pivote.
- Después de particionar, el pivote ocupa su posición definitiva en el arreglo ordenado. Los sub-arreglos son entonces ordenados recursivamente.
- Este proceso se repite hasta que todo el arreglo está ordenado.

## ¿Para qué?

Este algoritmo es ampliamente utilizado en la práctica debido a su eficiencia y simplicidad. Es particularmente efectivo para ordenar listas y arreglos en memoria, como bases de datos y archivos grandes que necesitan ser procesados rápidamente.

Dado que puede ser implementado de manera in-place (sin necesidad de arreglos adicionales significativos), es una opción atractiva para sistemas con limitaciones de memoria.

## ¿Cómo?

### Implementación

```java
public class QuickSort {
    // Método para realizar el ordenamiento
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            // Particiona el arreglo y obtiene el índice del pivote en su posición correcta
            int pivotIndex = partition(array, low, high);

            // Ordena recursivamente los elementos antes y después de la partición
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    // Método para particionar el arreglo
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // Elige el último elemento como pivote
        int i = (low - 1);  // Índice de menor elemento

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor que el pivote
            if (array[j] < pivot) {
                i++;

                // Intercambia arr[i] y arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambia el elemento pivote con el elemento en la posición i+1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;  // Devuelve el índice del pivote
    }

    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
```

#### Traza

|Paso|Acción|Pivote|Subarray Antes|Subarray Después|Comentario|
|-|-|-|-|-|-|
|1|Ordenar \([10, 7, 8, 9, 1, 5]\)|5|\([10, 7, 8, 9, 1, 5]\)|\([1, 5, 8, 9, 10, 7]\)|5 es colocado entre menores a su izquierda y mayores a su derecha.|
|2|Ordenar subarray izquierdo \([1]\)|-|\([1]\)|\([1]\)|Subarray de un solo elemento, ya ordenado.|
|3|Ordenar subarray derecho \([8, 9, 10, 7]\)|7|\([8, 9, 10, 7]\)|\([7, 8, 9, 10]\)|7 mueve los mayores a su derecha.|
|4|Ordenar subarray izquierdo \([7]\)|-|\([7]\)|\([7]\)|Subarray de un solo elemento, ya ordenado.|
|5|Ordenar subarray derecho \([8, 9, 10]\)|10|\([8, 9, 10]\)|\([8, 9, 10]\)|10 es el máximo, no hay intercambio necesario.|
|6|Ordenar subarray izquierdo \([8, 9]\)|9|\([8, 9]\)|\([8, 9]\)|9 es mayor que 8, orden correcto establecido.|
|7|Ordenar subarray izquierdo \([8]\)|-|\([8]\)|\([8]\)|Subarray de un solo elemento, ya ordenado.|
|8|Ordenar subarray derecho \([9]\)|-|\([9]\)|\([9]\)|Subarray de un solo elemento, ya ordenado.|

- **Paso 1**: Inicia con el arreglo completo. El pivote es el último elemento, 5. Se realizan comparaciones y los elementos menores que 5 se mueven a la izquierda y los mayores a la derecha, con el pivote en la posición correcta al final de la partición.
- **Pasos 2 y 4**: Trata subarrays que contienen un solo elemento, que están trivialmente ordenados.
- **Paso 3**: Procede con el lado derecho del arreglo donde 7 es el pivote. Tras mover los elementos, 7 se coloca en su posición correcta.
- **Paso 5**: Continúa con un subarray mayor donde 10 es el pivote. Como 10 ya es el mayor elemento, no se requieren movimientos significativos.
- **Paso 6**: Ordena \([8, 9]\) con 9 como pivote. Trivialmente, se verifica que 8 es menor y se deja como está.
- **Pasos 7 y 8**: Cada subarray contiene solo un elemento, ya ordenado.
