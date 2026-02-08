# Ejemplo D: Ordenar y procesar

## Código

```java
class SortAndProcess {
    
    static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            if (array[i] <= array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }

        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= right)
            temp[k++] = array[j++];

        for (int m = 0; m < temp.length; m++)
            array[left + m] = temp[m];
    }

    static double sortAndCalculateAverage(int[] array) {
        int n = array.length;

        mergeSort(array, 0, n - 1);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += array[i];
        }

        return (double) sum / n;
    }

    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        double average = sortAndCalculateAverage(array);

        System.out.println("Array ordenado: " + java.util.Arrays.toString(array));
        System.out.println("Promedio: " + average);
    }
}
```

## Análisis del algoritmo sortAndCalculateAverage

Este algoritmo es interesante porque combina múltiples componentes con complejidades distintas, resultando en una fórmula que debemos simplificar identificando el término dominante.

### Identificación de las operaciones y su complejidad

<div align=center>

|Operación|Descripción|Complejidad|
|-|-|-|
|Inicialización de variables|`int n = array.length`, `int sum = 0`|`O(1)`|
|Ordenación (mergeSort)|Algoritmo recursivo divide y vencerás. Divide el array en mitades lg n veces y cada nivel de fusión cuesta O(n)|`O(n log n)`|
|Recorrido para suma|Bucle `for` que recorre los n elementos una vez|`O(n)`|
|Cálculo de promedio|División simple|`O(1)`|
|Retorno|Operación constante|`O(1)`|

</div>

### Suma de complejidades

<div align=center>

`O(1) + O(n log n) + O(n) + O(1) + O(1) --> 3·O(1) + O(n log n) + O(n)`

</div>

### Análisis del término dominante

Para entender por qué O(n log n) domina sobre O(n), evaluemos con valores crecientes de n:

<div align=center>

|n|n log n|n|Diferencia|
|-|:-:|:-:|:-:|
|10|33|10|n log n es 3.3× mayor|
|100|664|100|n log n es 6.6× mayor|
|1,000|9,966|1,000|n log n es 10× mayor|
|10,000|132,877|10,000|n log n es 13.3× mayor|

</div>

### Simplificación

Cuando n crece, el término `n log n` crece significativamente más rápido que `n`. Las constantes multiplicativas (3 en 3·O(1)) se eliminan, y los términos de menor orden se vuelven insignificantes.

Por lo tanto, la complejidad del algoritmo se simplifica a **O(n log n)**.

**Intuición**: Aunque recorremos el array dos veces (una para ordenar, otra para sumar), la ordenación es tan costosa que domina el tiempo total. La suma adicional es insignificante comparada con la ordenación cuando n es grande.
