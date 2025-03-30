# Ordenación

## ¿Por qué?

|||
|-|-|
|La organización de los datos en un orden específico (como ascendente o descendente) es una tarea previa y crítica en muchas aplicaciones informáticas.|Ordenar datos puede aumentar significativamente la eficiencia de los algoritmos de búsqueda posteriores y es esencial para facilitar el procesamiento y la visualización de datos, permitiendo análisis más rápidos y eficaces.|

## ¿Qué?

Son algoritmos que reorganizan una serie de elementos de una colección (como un array o una lista) en un orden especificado, típicamente numérico o lexicográfico.

*En computación y matemáticas un algoritmo de ordenamiento es un algoritmo que pone elementos de una lista o un vector en una secuencia dada por una relación de orden, es decir, el resultado de salida ha de ser una permutación —o reordenamiento— de la entrada que satisfaga la relación de orden dada. Las relaciones de orden más usadas son el orden numérico y el orden lexicográfico. Ordenamientos eficientes son importantes para optimizar el uso de otros algoritmos (como los de búsqueda y fusión) que requieren listas ordenadas para una ejecución rápida. También es útil para poner datos en forma canónica y para generar resultados legibles por humanos.*

## ¿Para qué?

Estos algoritmos son esenciales no solo por su aplicación directa en tareas de ordenamiento, sino también como componentes críticos en sistemas más complejos que requieren de datos preordenados para optimizar la eficiencia operacional.

|||
|-|-|
|Base para estructuras de datos más avanzadas|Muchas estructuras de datos avanzadas y algoritmos eficientes, como los árboles de búsqueda balanceados y las tablas hash, dependen del conocimiento de los principios de ordenación.
|Optimización de la eficiencia|Saber qué algoritmo de ordenación utilizar en un contexto dado puede significar la diferencia entre un programa que se ejecuta en segundos y uno que tarda horas, especialmente con grandes volúmenes de datos.
|Aplicaciones prácticas|Desde sistemas de bases de datos hasta software de gráficos y videojuegos, los algoritmos de ordenación se utilizan para optimizar búsquedas, renderizado, y más.
|Entrevistas técnicas|Los algoritmos de ordenación son temas frecuentes en las entrevistas para roles técnicos, ya que demuestran la capacidad del candidato para entender y aplicar conceptos fundamentales de algoritmos y estructuras de datos.

## ¿Cómo?

|Algoritmo||Características|
|-|-|-|
|**[Bubble Sort](bubbleSort.md)**|Compara pares adyacentes y los intercambia si están en desorden.|- Simple de entender<br>- Muy ineficiente para listas grandes<br>- Estable: mantiene el orden de elementos iguales|
|**[Selection Sort](selectionSort.md)**|Encuentra el mínimo y lo coloca al inicio de la lista no ordenada.|- No es eficiente para listas grandes<br>- Inestable en su forma básica<br>- Realiza menos intercambios que Bubble Sort|
|**[Insertion Sort](insertionSort.md)**|Construye la lista final un elemento a la vez, insertando cada nuevo elemento en su lugar correcto.|- Eficiente para listas pequeñas o parcialmente ordenadas<br>- Estable: mantiene el orden de elementos iguales<br>- Opción ideal para inserción en tiempo real|
|**[Merge Sort](mergeSort.md)**|Divide la lista en mitades, ordena cada mitad y luego las fusiona.|- Eficiente y tiene una complejidad de tiempo constante \(O(n \log n)\)<br>- Estable: mantiene el orden de elementos iguales<br>- Utiliza memoria adicional para el arreglo temporal|
|**[Quick Sort](quickSort.md)**|Selecciona un 'pivote' y particiona los elementos alrededor de él antes de ordenar las sublistas.|- Generalmente más rápido que otros \(O(n \log n)\), pero su rendimiento depende del pivote<br>- Inestable: puede cambiar el orden de elementos iguales<br>- Puede degradarse a \(O(n^2)\) si se elige un mal pivote|
|**[Heap Sort](heapSort.md)**|Utiliza una estructura de heap para ordenar los elementos.|- Complejidad de tiempo constante \(O(n \log n)\)<br>- Inestable: puede cambiar el orden de elementos iguales<br>- No requiere memoria adicional, a diferencia de Merge Sort|
|**[Counting Sort](countingSort.md)**|Utiliza un arreglo de conteo para organizar los elementos según su clave.|- Lineal \(O(n)\) para rangos de claves pequeños<br>- Estable: puede mantener el orden de entrada de elementos iguales<br>- No adecuado para datos con claves numéricas muy dispersas|
|**[Radix Sort](radixSort.md)**|Ordena los elementos digito por digito, empezando por el menos significativo.|- Lineal \(O(n)\) para números de dígitos fijos<br>- Estable: adecuado para datos con múltiples dígitos<br>- Requiere una función de conteo eficiente como Counting Sort para cada dígito|
|**[Bucket Sort](bucketSort.md)**|Distribuye los elementos en varios 'buckets' o contenedores y luego ordena cada bucket individualmente.|- Eficiente cuando los datos se distribuyen uniformemente<br>- Estable si el ordenador de buckets es estable<br>- Rendimiento depende de la distribución de los datos|

> DISCLAIMER: Por un propósito estrictamente pedagógico se han mantenido aquí los comentarios en el código.
