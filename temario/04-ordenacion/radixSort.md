# Radix Sort (Ordenamiento por Raíz)

## ¿Por qué?

En escenarios donde se manejan grandes volúmenes de datos numéricos con longitudes similares, los algoritmos de ordenamiento tradicionales basados en comparaciones alcanzan su límite de eficiencia teórica de O(n log n). Esta limitación se convierte en un problema crítico en aplicaciones que procesan millones de registros, como sistemas bancarios, análisis de tráfico de red o procesamiento de imágenes digitales. Adicionalmente, cuando se trabaja con números enteros de múltiples dígitos, las comparaciones directas no aprovechan la estructura posicional inherente a la representación numérica, realizando operaciones redundantes que podrían evitarse.

Los algoritmos comparativos también presentan inestabilidad en muchas de sus implementaciones eficientes, lo que resulta problemático en aplicaciones donde el orden relativo original de elementos con el mismo valor debe preservarse. Esta característica es crucial en ordenamientos secundarios o en sistemas que requieren trazabilidad precisa de los datos.

Se requiere, por tanto, un enfoque que supere estas limitaciones y aproveche las características específicas de los datos numéricos para lograr ordenamientos más eficientes en determinados contextos.

## ¿Qué?

Radix Sort representa un paradigma fundamentalmente distinto de ordenamiento, clasificado como algoritmo no comparativo, que procesa los números dígito por dígito. En lugar de determinar el orden relativo entre elementos mediante comparaciones directas, examina cada posición numérica de manera independiente, aprovechando la representación posicional de los números.

Este algoritmo opera bajo el principio de realizar múltiples pasadas de ordenamiento sobre los datos, cada una enfocada en una posición específica de los dígitos, comenzando típicamente desde el dígito menos significativo (LSD - Least Significant Digit) hasta el más significativo (MSD - Most Significant Digit). En cada pasada, se utiliza un algoritmo de ordenamiento estable, generalmente Counting Sort, para organizar los elementos según el dígito en la posición actual.

La clave de su funcionamiento radica en la estabilidad del algoritmo de ordenamiento utilizado en cada pasada, lo que garantiza que el orden relativo de los elementos con el mismo dígito en la posición actual se preserve, manteniendo así el ordenamiento conseguido en pasadas anteriores.

## ¿Para qué?

La implementación de Radix Sort ofrece múltiples ventajas que responden directamente a las limitaciones previamente identificadas:

1. **Eficiencia superior para enteros**: Bajo condiciones específicas, Radix Sort alcanza una complejidad temporal de O(d*(n+k)), donde d es el número de dígitos, n es la cantidad de elementos y k es el rango de los dígitos. Cuando d es constante y k no es excesivamente grande, esto se traduce efectivamente en O(n), superando teóricamente el límite de O(n log n) de los algoritmos comparativos.
1. **Estabilidad inherente**: Al utilizar un algoritmo de ordenamiento estable en cada pasada, Radix Sort mantiene el orden relativo de elementos con valores iguales en la posición actual, característica fundamental para aplicaciones que requieren ordenamientos secundarios o trazabilidad de datos.
1. **Predecibilidad de rendimiento**: A diferencia de algoritmos como QuickSort, cuyo rendimiento puede degradarse significativamente en ciertos escenarios, Radix Sort mantiene un comportamiento predecible independientemente de la distribución inicial de los datos.
1. **Paralelización eficiente**: La naturaleza del algoritmo permite su implementación eficiente en arquitecturas paralelas, dividiéndose el trabajo por dígitos o por rangos de datos.
1. **Optimización para casos específicos**: En aplicaciones donde los datos son enteros con número limitado de dígitos, como códigos postales, identificadores, o timestamps en ciertos formatos, Radix Sort ofrece un rendimiento excepcional.

Estas características hacen de Radix Sort una opción particularmente valiosa en sistemas de procesamiento de base de datos, ordenamiento de logs, análisis de datos masivos, procesamiento de imágenes y cualquier aplicación donde se manejen grandes volúmenes de datos numéricos con características uniformes.

## ¿Cómo?

A continuación, se presenta una implementación detallada de Radix Sort en Java, incluyendo el análisis paso a paso de su funcionamiento:

```java
public class RadixSort {
    public void sort(int[] array) {
        // Encuentra el número máximo para conocer el número de dígitos
        int max = getMax(array);
        
        // Realiza counting sort para cada dígito
        // Se comienza con el dígito menos significativo
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }
    
    // Método para encontrar el valor máximo en el array
    private int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    
    // Método de counting sort modificado para ordenar por un dígito específico
    private void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // Array de salida
        int[] count = new int[10]; // Rango de dígitos: 0-9
        
        // Inicializa el array de conteo
        for (int i = 0; i < 10; i++) {
            count[i] = 0;
        }
        
        // Almacena el conteo de ocurrencias del dígito actual
        for (int i = 0; i < n; i++) {
            count[(array[i] / exp) % 10]++;
        }
        
        // Cambia count[i] para que contenga la posición actual
        // de este dígito en output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Construye el array de salida
        for (int i = n - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }
        
        // Copia el array de salida a array[] para que contenga
        // los números ordenados según el dígito actual
        for (int i = 0; i < n; i++) {
            array[i] = output[i];
        }
    }
    
    public static void main(String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};
        
        System.out.println("Array original:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        
        radixSort.sort(data);
        
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
```

### Traza de Ejecución

Para ilustrar el funcionamiento del algoritmo, se presenta a continuación una traza de ejecución detallada utilizando el array de ejemplo `[170, 45, 75, 90, 802, 24, 2, 66]`.

**Paso 1: Encontrar el valor máximo**

- Valor máximo: 802
- Número de dígitos: 3

**Paso 2: Primera pasada (dígito de las unidades, exp = 1)**

Extraemos el dígito de las unidades de cada número:

- 170 → 0
- 45 → 5
- 75 → 5
- 90 → 0
- 802 → 2
- 24 → 4
- 2 → 2
- 66 → 6

Conteo inicial: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Después de contar: [2, 0, 2, 0, 1, 2, 1, 0, 0, 0]
Después de acumular: [2, 2, 4, 4, 5, 7, 8, 8, 8, 8]

Construcción del array de salida (recorriendo de atrás hacia adelante):

- 66 → dígito 6 → posición 7 → output[7] = 66
- 2 → dígito 2 → posición 3 → output[3] = 2
- 24 → dígito 4 → posición 4 → output[4] = 24
- 802 → dígito 2 → posición 2 → output[2] = 802
- 90 → dígito 0 → posición 1 → output[1] = 90
- 75 → dígito 5 → posición 6 → output[6] = 75
- 45 → dígito 5 → posición 5 → output[5] = 45
- 170 → dígito 0 → posición 0 → output[0] = 170

Array después de la primera pasada: [170, 90, 802, 2, 24, 45, 75, 66]

**Paso 3: Segunda pasada (dígito de las decenas, exp = 10)**

Extraemos el dígito de las decenas de cada número:

- 170 → 7
- 90 → 9
- 802 → 0
- 2 → 0
- 24 → 2
- 45 → 4
- 75 → 7
- 66 → 6

Conteo inicial: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Después de contar: [2, 0, 1, 0, 1, 0, 1, 2, 0, 1]
Después de acumular: [2, 2, 3, 3, 4, 4, 5, 7, 7, 8]

Construcción del array de salida:

- 66 → dígito 6 → posición 4 → output[4] = 66
- 75 → dígito 7 → posición 6 → output[6] = 75
- 45 → dígito 4 → posición 3 → output[3] = 45
- 24 → dígito 2 → posición 2 → output[2] = 24
- 2 → dígito 0 → posición 1 → output[1] = 2
- 802 → dígito 0 → posición 0 → output[0] = 802
- 90 → dígito 9 → posición 7 → output[7] = 90
- 170 → dígito 7 → posición 5 → output[5] = 170

Array después de la segunda pasada: [802, 2, 24, 45, 66, 170, 75, 90]

**Paso 4: Tercera pasada (dígito de las centenas, exp = 100)**

Extraemos el dígito de las centenas de cada número:

- 802 → 8
- 2 → 0
- 24 → 0
- 45 → 0
- 66 → 0
- 170 → 1
- 75 → 0
- 90 → 0

Conteo inicial: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
Después de contar: [6, 1, 0, 0, 0, 0, 0, 0, 1, 0]
Después de acumular: [6, 7, 7, 7, 7, 7, 7, 7, 8, 8]

Construcción del array de salida:

- 90 → dígito 0 → posición 5 → output[5] = 90
- 75 → dígito 0 → posición 4 → output[4] = 75
- 170 → dígito 1 → posición 6 → output[6] = 170
- 66 → dígito 0 → posición 3 → output[3] = 66
- 45 → dígito 0 → posición 2 → output[2] = 45
- 24 → dígito 0 → posición 1 → output[1] = 24
- 2 → dígito 0 → posición 0 → output[0] = 2
- 802 → dígito 8 → posición 7 → output[7] = 802

**Array final ordenado**: [2, 24, 45, 66, 75, 90, 170, 802]

### Análisis de Complejidad

- **Complejidad temporal**: O(d * (n + k)), donde:
  - d es el número de dígitos en el número máximo
  - n es la cantidad de elementos en el array
  - k es el rango de valores posibles para un dígito (10 para el sistema decimal)

  Cuando d es constante y relativamente pequeño, la complejidad se aproxima a O(n).

- **Complejidad espacial**: O(n + k), necesario para el array de salida y el array de conteo.

### Consideraciones prácticas

1. **Tratamiento de números negativos**: La implementación presentada no maneja números negativos directamente. Para adaptarla, puede implementarse un desplazamiento que transforme todos los valores a positivos durante el proceso, o separar los números negativos y positivos en dos grupos.
1. **Optimización para sistemas no decimales**: En ciertas aplicaciones, como ordenamiento de direcciones IP o datos binarios, puede modificarse el algoritmo para trabajar con bases distintas a 10.
1. **Variante MSD (Most Significant Digit)**: Aunque la implementación mostrada utiliza el enfoque LSD, existe la variante que comienza por el dígito más significativo, útil para aplicaciones donde se requiere ordenamiento lexicográfico.
