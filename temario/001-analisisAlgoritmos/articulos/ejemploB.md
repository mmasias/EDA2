# Ejemplo B: Búsqueda binaria

## Código

```java
class BinarySearch {
    static final int NOT_FOUND = -1;

    static int binarySearch(int[] array, int target) {
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
        return NOT_FOUND;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11};
        int target = 7;
        int result = binarySearch(array, target);
        if (result == NOT_FOUND) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + result);
        }
    }
}
```

## Análisis del algoritmo de búsqueda binaria

### Identificación de las operaciones y su complejidad

<div align=center>

|Componente|Descripción|Complejidad|
|-|-|-|
|Inicialización|Las operaciones (`left = 0`, `right = array.length - 1`) son constantes|`O(1)`|
|Bucle `while`|Reduce el tamaño del problema a la mitad en cada iteración. El número de iteraciones es proporcional a log N|`O(log N)`|
|Operaciones dentro del bucle|Calcular el medio, comparar y actualizar límites son operaciones constantes|`O(1)` por operación, implicado en `O(log N)`|
|Retorno|El retorno del índice o de NOT_FOUND (-1) es una operación constante|`O(1)`|

</div>

### Suma de complejidades

<div align=center>

`O(1) + O(log N) + O(1) --> O(log N) + 2O(1)`

</div>

### Simplificación

Al simplificar y enfocarnos en el término de mayor crecimiento, las constantes y los términos de menor crecimiento son considerados insignificantes frente al término dominante. Por lo tanto, el resultado final se simplifica a **O(log N)**, reflejando la eficiencia de la búsqueda binaria en conjuntos de datos ordenados.
