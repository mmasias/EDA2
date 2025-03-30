# Bucket Sort (Ordenamiento por Cubetas)

## ¿Por qué?

En numerosos escenarios de procesamiento de datos, se enfrentan situaciones donde los valores a ordenar siguen una distribución uniforme dentro de un rango conocido. Los algoritmos de ordenamiento tradicionales basados en comparaciones, como QuickSort o MergeSort, no aprovechan esta característica distribucional y operan con la misma complejidad independientemente de cómo se distribuyan los datos. Esta ineficiencia resulta especialmente problemática cuando se procesan grandes volúmenes de información con propiedades distribucionales conocidas.

Adicionalmente, en aplicaciones que manejan datos continuos como valores flotantes o métricas estadísticas, los algoritmos de ordenamiento no comparativos como Counting Sort presentan limitaciones prácticas, ya que requieren un rango discreto y finito de valores posibles. Esto crea un vacío metodológico para el ordenamiento eficiente de datos continuos uniformemente distribuidos.

En entornos de procesamiento paralelo o distribuido, también se requieren algoritmos que permitan dividir naturalmente el problema en subproblemas independientes, característica que no todos los métodos de ordenamiento convencionales facilitan. Esta limitación obstaculiza el aprovechamiento óptimo de arquitecturas multiprocesador o sistemas distribuidos.

Se necesita, por tanto, un enfoque que aproveche la distribución uniforme de los datos, maneje eficientemente valores continuos y facilite la paralelización del proceso de ordenamiento.

## ¿Qué?

Bucket Sort representa un paradigma de ordenamiento que divide el conjunto de datos en subconjuntos o "cubetas" (buckets) según rangos de valores, para luego ordenar independientemente cada una de estas particiones. Este enfoque divide-y-vencerás aprovecha la distribución de los datos para lograr eficiencia en casos específicos.

El algoritmo opera bajo el principio fundamental de que, si los datos siguen una distribución uniforme, al dividirlos en particiones de igual tamaño, cada cubeta contendrá aproximadamente la misma cantidad de elementos. Posteriormente, estas cubetas se ordenan individualmente utilizando otro algoritmo de ordenamiento (típicamente uno eficiente para conjuntos pequeños, como Insertion Sort) y finalmente se concatenan para obtener la secuencia completa ordenada.

A diferencia de Counting Sort y Radix Sort, que son estrictamente algoritmos no comparativos, Bucket Sort utiliza un enfoque híbrido: la distribución inicial en cubetas es no comparativa, pero el ordenamiento dentro de cada cubeta generalmente implica comparaciones. Esta naturaleza híbrida le confiere versatilidad para manejar diferentes tipos de datos.

## ¿Para qué?

La implementación de Bucket Sort ofrece múltiples ventajas que responden directamente a las limitaciones previamente identificadas:

1. **Eficiencia para distribuciones uniformes**: En el caso promedio, cuando los datos siguen una distribución uniforme, Bucket Sort alcanza una complejidad temporal de O(n), superando teóricamente el límite de O(n log n) de los algoritmos comparativos tradicionales.
1. **Adaptabilidad a datos continuos**: A diferencia de Counting Sort, que requiere valores discretos en un rango limitado, Bucket Sort maneja naturalmente valores continuos como números flotantes, ampliando el espectro de aplicaciones donde puede utilizarse.
1. **Paralelización inherente**: La naturaleza del algoritmo, que procesa cada cubeta de manera independiente, facilita su implementación en entornos paralelos o distribuidos, permitiendo un aprovechamiento óptimo de múltiples unidades de procesamiento.
1. **Flexibilidad en la estrategia de particionamiento**: El algoritmo permite ajustar la cantidad y tamaño de las cubetas según las características específicas de los datos, optimizando el rendimiento para diferentes escenarios.
1. **Estabilidad condicional**: Dependiendo del algoritmo utilizado para ordenar cada cubeta, Bucket Sort puede mantener el orden relativo de elementos con valores iguales, característica importante en ordenamientos multiatributo.

Estas características hacen de Bucket Sort una opción particularmente valiosa en aplicaciones como procesamiento de imágenes digitales, análisis estadístico, simulaciones científicas y cualquier escenario donde los datos presenten propiedades distribucionales conocidas y se requiera alta eficiencia en el ordenamiento.

## ¿Cómo?

A continuación, se presenta una implementación detallada de Bucket Sort en Java, incluyendo el análisis paso a paso de su funcionamiento:

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    
    public void sort(float[] array) {
        if (array == null || array.length <= 1) {
            return; // Ya está ordenado o es inválido
        }
        
        int n = array.length;
        
        // 1. Crear n cubetas (listas)
        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new ArrayList[n];
        
        // Inicializar las cubetas
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // 2. Distribuir los elementos en las cubetas
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * array[i]); // Asume valores entre [0,1)
            buckets[bucketIndex].add(array[i]);
        }
        
        // 3. Ordenar cada cubeta
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]); // O se puede usar otro algoritmo de ordenamiento
        }
        
        // 4. Concatenar todas las cubetas de vuelta al array original
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (float value : buckets[i]) {
                array[index++] = value;
            }
        }
    }
    
    // Versión adaptada para valores fuera del rango [0,1)
    public void sortGeneral(float[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        
        // Encontrar valores mínimo y máximo
        float minValue = array[0];
        float maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        
        // Evitar división por cero si todos los elementos son iguales
        if (maxValue == minValue) {
            return;
        }
        
        int n = array.length;
        float range = maxValue - minValue;
        
        // Crear n cubetas
        @SuppressWarnings("unchecked")
        List<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        
        // Distribuir elementos normalizados
        for (int i = 0; i < n; i++) {
            // Normaliza el valor al rango [0, 1) y lo multiplica por n
            int bucketIndex = (int) ((array[i] - minValue) / range * (n - 1));
            buckets[bucketIndex].add(array[i]);
        }
        
        // Ordenar cada cubeta y concatenar
        int index = 0;
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
            for (float value : buckets[i]) {
                array[index++] = value;
            }
        }
    }
    
    // Método para imprimir un array
    private static void printArray(float[] array) {
        for (float value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        float[] data = {0.42f, 0.32f, 0.33f, 0.52f, 0.37f, 0.47f, 0.51f};
        System.out.println("Array original:");
        printArray(data);
        
        BucketSort bucketSort = new BucketSort();
        bucketSort.sort(data);
        
        System.out.println("Array ordenado:");
        printArray(data);
        
        // Ejemplo con valores fuera del rango [0,1)
        float[] generalData = {3.4f, 1.2f, 5.7f, 2.5f, 7.3f, 4.9f, 2.2f};
        System.out.println("Array general original:");
        printArray(generalData);
        
        bucketSort.sortGeneral(generalData);
        
        System.out.println("Array general ordenado:");
        printArray(generalData);
    }
}
```

### Traza de Ejecución

Para ilustrar el funcionamiento del algoritmo, se presenta a continuación una traza de ejecución detallada utilizando el array de ejemplo `[0.42, 0.32, 0.33, 0.52, 0.37, 0.47, 0.51]` con 7 elementos.

**Paso 1: Creación e inicialización de cubetas**

- Se crean 7 cubetas (listas vacías)

**Paso 2: Distribución de elementos en cubetas**

- Elemento 0.42 → Índice de cubeta: (int)(7 * 0.42) = 2 → cubetas[2].add(0.42)
- Elemento 0.32 → Índice de cubeta: (int)(7 * 0.32) = 2 → cubetas[2].add(0.32)
- Elemento 0.33 → Índice de cubeta: (int)(7 * 0.33) = 2 → cubetas[2].add(0.33)
- Elemento 0.52 → Índice de cubeta: (int)(7 * 0.52) = 3 → cubetas[3].add(0.52)
- Elemento 0.37 → Índice de cubeta: (int)(7 * 0.37) = 2 → cubetas[2].add(0.37)
- Elemento 0.47 → Índice de cubeta: (int)(7 * 0.47) = 3 → cubetas[3].add(0.47)
- Elemento 0.51 → Índice de cubeta: (int)(7 * 0.51) = 3 → cubetas[3].add(0.51)

Estado de las cubetas después de la distribución:

- cubetas[0] = []
- cubetas[1] = []
- cubetas[2] = [0.42, 0.32, 0.33, 0.37]
- cubetas[3] = [0.52, 0.47, 0.51]
- cubetas[4] = []
- cubetas[5] = []
- cubetas[6] = []

**Paso 3: Ordenamiento individual de cada cubeta**

- cubetas[0] = [] (vacía, no necesita ordenamiento)
- cubetas[1] = [] (vacía, no necesita ordenamiento)
- cubetas[2] = [0.32, 0.33, 0.37, 0.42] (después de ordenar)
- cubetas[3] = [0.47, 0.51, 0.52] (después de ordenar)
- cubetas[4] = [] (vacía, no necesita ordenamiento)
- cubetas[5] = [] (vacía, no necesita ordenamiento)
- cubetas[6] = [] (vacía, no necesita ordenamiento)

**Paso 4: Concatenación de todas las cubetas**

- Recorrer cada cubeta y agregar sus elementos al array original
- Resultado: [0.32, 0.33, 0.37, 0.42, 0.47, 0.51, 0.52]

**Array final ordenado**: [0.32, 0.33, 0.37, 0.42, 0.47, 0.51, 0.52]

### Análisis de complejidad

- **Complejidad temporal**:
  - Caso promedio (distribución uniforme): O(n + k), donde n es el número de elementos y k es el número de cubetas
  - Peor caso (todos los elementos en una sola cubeta): O(n²), considerando el uso de un algoritmo de ordenamiento cuadrático para las cubetas
  - Mejor caso (distribución perfectamente uniforme con una sola vuelta para el algoritmo de ordenamiento): O(n)
- **Complejidad espacial**: O(n + k), necesario para las cubetas auxiliares

### Optimizaciones y consideraciones prácticas

1. **Selección del número de cubetas**: El número de cubetas afecta significativamente el rendimiento. Una aproximación común es utilizar √n cubetas para balancear la distribución y el costo de ordenamiento.
1. **Algoritmo de ordenamiento para las cubetas**: Para cubetas pequeñas, Insertion Sort suele ser más eficiente que algoritmos asintóticamente superiores como QuickSort.
1. **Función de mapeo**: La función que asigna elementos a cubetas debe diseñarse cuidadosamente según la distribución esperada de los datos para maximizar la uniformidad.
1. **Manejo de valores extremos**: Para distribuciones con valores atípicos, pueden implementarse estrategias como cubetas de tamaño variable o manejo especial de valores extremos.
1. **Paralelización**: El ordenamiento de cada cubeta puede paralelizarse fácilmente, aprovechando arquitecturas multiprocesador para mejorar el rendimiento.
