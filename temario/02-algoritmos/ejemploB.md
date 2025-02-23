# Ejemplo B

Vamos a explorar otro ejemplo clásico de algoritmo y su análisis de complejidad: un algoritmo de búsqueda binaria en un arreglo **ordenado**. Este ejemplo es interesante porque la búsqueda binaria tiene una complejidad diferente a la de algoritmos como la suma de elementos de un arreglo.

```java
public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; 
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11}; 
        int target = 7;
        int result = binarySearch(array, target);
        if (result == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + result);
        }
    }
}

```

## Análisis del algoritmo de Búsqueda Binaria

### Identificación de las operaciones y su complejidad

<div align=center>

|Componente|Descripción|Complejidad|
|-|-|-|
|Inicialización|Las operaciones de inicialización (`left = 0`, `right = array.length - 1`) son constantes y se ejecutan una sola vez.|`O(1)`|
|Bucle `while`|Este bucle reduce el tamaño del problema a la mitad en cada iteración. El número de iteraciones es proporcional a (log N).|`O(log N)`   |
|Operaciones dentro del bucle|Calcular el medio, comparar el valor y actualizar los límites son todas operaciones constantes, pero contribuyen al total de la complejidad del bucle.|`O(1)` por operación, implicado en `O(log N)`|
|Retorno|El retorno del índice del elemento o -1 es una operación constante realizada una vez al final.|`O(1)`|

</div>

### Suma de complejidades

<div align=center>

`O(1) + O(log N) + O(1) --> O(log N) + 2O(1)`

</div>

### Simplificación & enfatizado del término dominante

Al simplificar y enfocarnos en el término de mayor crecimiento, las constantes y los términos de menor crecimiento son considerados insignificantes frente al término dominante. Por lo tanto, aunque técnicamente incluimos todas las operaciones en el análisis inicial, el resultado final se simplifica a `O(log N)`, reflejando la eficiencia de la búsqueda binaria en conjuntos de datos ordenados.
