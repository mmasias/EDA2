# Merge Sort (Ordenamiento por Mezcla)

## ¿Por qué?

Merge Sort es fundamental en la ciencia de la computación por su eficiencia y capacidad para manejar grandes volúmenes de datos. A diferencia de los algoritmos de ordenamiento cuadráticos como Bubble Sort o Insertion Sort, Merge Sort tiene una complejidad temporal en el peor caso de \(O(n \log n)\), lo que lo hace adecuado para aplicaciones que requieren alta eficiencia con listas extensas. Este algoritmo es un excelente ejemplo del enfoque "divide y vencerás" en el diseño de algoritmos, que descompone un problema en subproblemas más manejables, los resuelve de forma independiente y combina sus soluciones para formar una solución completa.

## ¿Qué?

Merge Sort es un **algoritmo de ordenamiento recursivo** que divide repetidamente la lista en dos mitades hasta que cada sublista contiene un solo elemento o ningún elemento (lo que automáticamente la hace ordenada). Luego, estas sub-listas ordenadas se combinan o "fusionan" de nuevo juntas en el orden correcto para formar una lista más grande ordenada. Este proceso de fusión es la clave del algoritmo y donde realmente ocurre el ordenamiento.

## ¿Para qué?

Merge Sort es muy útil en entornos donde la estabilidad en el ordenamiento (los elementos iguales mantienen su orden original) es crucial y en aplicaciones que requieren mantener registros cronológicos exactos en un orden específico.

Además, debido a su eficiencia inherente y su capacidad para trabajar bien con listas vinculadas y accesos secuenciales (por ejemplo, en archivos grandes almacenados en discos duros), es ampliamente utilizado en sistemas que procesan grandes cantidades de datos como bases de datos y sistemas de archivos.

## ¿Cómo?

Veamos cómo se implementaría Merge Sort en Java:

### Implementación de Merge Sort

```java
public class MergeSort {

    // Método para dividir y fusionar el array
    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            // Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            // Divide la primera y segunda mitad (llamada recursiva).
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Une las mitades.
            merge(array, left, middle, right);
        }
    }

    // Método para fusionar las dos mitades.
    private static void merge(int[] array, int left, int middle, int right) {
        // Tamaños de los subarrays temporales.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Subarrays temporales.
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia los datos a los arrays temporales.
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        }

        // Índices iniciales de los subarrays.
        int i = 0, j = 0;

        // Índice inicial del subarray mezclado.
        int k = left;

        // Ordenamiento y mezcla.
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de L, si los hay.
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de R, si los hay.
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] data = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array original:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
```

#### Traza

|Paso|Acción|Subarray(s) involucrado(s)|Resultado|
|-|-|-|-|
|1|Dividir|\([12, 11, 13, 5, 6, 7]\)|Divide en \([12, 11, 13]\) y \([5, 6, 7]\)|
|2|Dividir|\([12, 11, 13]\)|Divide en \([12]\) y \([11, 13]\)|
|3|Dividir|\([11, 13]\)|Divide en \([11]\) y \([13]\)|
|4|Fusión|\([11]\) y \([13]\)|Fusiona en \([11, 13]\)|
|5|Fusión|\([12]\) y \([11, 13]\)|Fusiona en \([11, 12, 13]\)|
|6|Dividir|\([5, 6, 7]\)|Divide en \([5]\) y \([6, 7]\)|
|7|Dividir|\([6, 7]\)|Divide en \([6]\) y \([7]\)|
|8|Fusión|\([6]\) y \([7]\)|Fusiona en \([6, 7]\)|
|9|Fusión|\([5]\) y \([6, 7]\)|Fusiona en \([5, 6, 7]\)|
|10| Fusión Final|\([11, 12, 13]\) y \([5, 6, 7]\)|Fusiona en \([5, 6, 7, 11, 12, 13]\)|

- **Paso 1-3**: El arreglo se divide repetidamente hasta que cada subconjunto tiene 1 elemento, haciendo cada uno de estos subconjuntos trivialmente ordenados.
- **Paso 4-5**: Los elementos individuales se comienzan a fusionar de vuelta juntos en orden, comenzando por los subconjuntos más pequeños (\([11]\) y \([13]\)), seguido por la fusión con el elemento restante \([12]\).
- **Paso 6-8**: Similar a los primeros pasos, la segunda mitad del arreglo original \([5, 6, 7]\) se divide y luego se fusiona en subconjuntos ordenados.
- **Paso 9**: Los subconjuntos pequeños dentro de la segunda mitad se fusionan en un solo subconjunto ordenado.
- **Paso 10**: Finalmente, los dos grandes subconjuntos ordenados \([11, 12, 13]\) y \([5, 6, 7]\) se fusionan en un arreglo completo y ordenado.
