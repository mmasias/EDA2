# Heap Sort (Ordenamiento por Montículo)

## ¿Por qué?

Heap Sort destaca por su capacidad para ordenar arreglos con una complejidad temporal garantizada de \(O(n \log n)\) para todos los casos, lo que lo hace muy predecible y confiable para aplicaciones críticas. 

Es particularmente útil en situaciones donde se requiere un rendimiento consistente, sin las variaciones de tiempo de ejecución que pueden exhibir otros algoritmos como Quick Sort en su peor caso.

## ¿Qué?

Heap Sort es un algoritmo de ordenamiento que utiliza una estructura de datos de tipo montículo (heap) para organizar los elementos del arreglo. Un montículo es un árbol binario especial donde el valor de cada nodo padre es mayor (en un montículo máximo) o menor (en un montículo mínimo) que los valores de sus nodos hijos. El proceso de ordenamiento con Heap Sort incluye dos fases principales:

1. **Construcción del montículo**: Se transforma el arreglo en un montículo máximo o mínimo.
2. **Extracción de elementos del montículo**: Se extraen los elementos del montículo uno por uno y se reorganiza el montículo para mantener su propiedad.

## ¿Para qué?

Heap Sort es ideal para aplicaciones que requieren extremos de datos como el máximo o mínimo, ya que estos siempre se encuentran en la raíz del montículo y pueden ser extraídos inmediatamente. Es útil en sistemas de priorización, donde los elementos con mayor o menor prioridad deben ser procesados primero. 

Además, su implementación no requiere memoria adicional, a diferencia de Merge Sort que necesita arreglos auxiliares, lo que lo hace atractivo para sistemas con restricciones de memoria.

Este método de ordenamiento es especialmente efectivo en escenarios donde la constancia de rendimiento es crítica, por lo que es comúnmente utilizado en entornos de producción que manejan grandes volúmenes de datos.

## ¿Cómo?

### Implementación

```java
public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;

        // Construir el montículo (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Uno por uno extraer un elemento del montículo
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            ararrayr[0] = array[i];
            array[i] = temp;

            // llamar a la función de reducción del montículo en el montículo reducido
            heapify(array, i, 0);
        }
    }

    // Para convertir un subarreglo en un montículo
    static void heapify(int array[], int n, int i) {
        int largest = i; // Inicializar largest como raíz
        int l = 2 * i + 1; // izquierda = 2*i + 1
        int r = 2 * i + 2; // derecha = 2*i + 2

        // Si el hijo izquierdo es mayor que la raíz
        if (l < n && array[l] > array[largest])
            largest = l;

        // Si el hijo derecho es mayor que largest hasta ahora
        if (r < n && array[r] > array[largest])
            largest = r;

        // Si largest no es la raíz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursivamente heapificar el subárbol afectado
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        sort(array);
        System.out.println("Array ordenado:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

```

#### Explicación

- **Construcción del montículo**: Comenzamos convirtiendo el arreglo en un montículo máximo usando la función `heapify` para todos los elementos que no son hojas, comenzando desde la mitad del arreglo hacia atrás. Esto asegura que todos los elementos más grandes "floten" hacia la parte superior del montículo.
  
- **Extracción del montículo**: Después de tener el montículo, repetidamente sacamos el elemento de la raíz (el máximo en un montículo máximo), lo movemos al final del arreglo, y luego realizamos `heapify` en el montículo reducido. Al final de este proceso, el arreglo está ordenado en orden ascendente.

Al principio del algoritmo, el montículo se construye asegurando que todos los elementos cumplan la propiedad de montículo máximo, donde cada padre es mayor que sus hijos.
  
Durante la extracción, al mover la raíz al final y sacarla del montículo activo, preservamos la propiedad de montículo máximo en cada paso, lo que nos permite continuar sacando el máximo elemento restante en cada iteración.


### Traza

|Paso|Acción |Estado del Montículo (antes) |Elemento Extraído|Montículo Reorganizado |Arreglo Ordenado Parcialmente |
|-|-|-|-|-|-|
|0 |Inicialización |\([12, 11, 13, 5, 6, 7]\) |- |- |\([]\) |
|1 |Construir montículo |- |- |\([13, 11, 12, 5, 6, 7]\) |\([]\) |
|2 |Extraer máximo y re-heapificar |\([13, 11, 12, 5, 6, 7]\) |13 |\([12, 11, 7, 5, 6]\) |\([13]\) |
|3 |Extraer máximo y re-heapificar |\([12, 11, 7, 5, 6]\) |12 |\([11, 6, 7, 5]\) |\([13, 12]\) |
|4 |Extraer máximo y re-heapificar |\([11, 6, 7, 5]\) |11 |\([7, 6, 5]\) |\([13, 12, 11]\) |
|5 |Extraer máximo y re-heapificar |\([7, 6, 5]\) |7 |\([6, 5]\) |\([13, 12, 11, 7]\) |
|6 |Extraer máximo y re-heapificar |\([6, 5]\) |6 |\([5]\) |\([13, 12, 11, 7, 6]\) |
|7 |Extraer máximo y re-heapificar |\([5]\) |5 |\([]\) |\([13, 12, 11, 7, 6, 5]\) |

- **Paso 0**: Se inicia con el arreglo original.
- **Paso 1**: El montículo se construye a partir del arreglo. Esto involucra varios pasos internos no mostrados aquí, donde se ajustan elementos para cumplir con la propiedad de montículo máximo. El mayor elemento (13) se asegura que quede en la raíz.
- **Paso 2-7**: En cada paso, el elemento en la raíz del montículo (el mayor) se extrae y se coloca al final del arreglo en la posición que le corresponde en orden descendente. El último elemento del montículo se mueve a la raíz, y luego se reorganiza el montículo para mantener la propiedad de montículo máximo. Este proceso continúa hasta que el montículo está vacío.

El arreglo ordenado parcialmente muestra cómo los elementos están siendo colocados en su posición correcta de forma descendente, comenzando desde el final del arreglo. Al final del proceso, el arreglo \([13, 12, 11, 7, 6, 5]\) está completamente ordenado. La extracción se realiza siempre del elemento que es la raíz del montículo, asegurando que se está extrayendo el máximo en cada paso.
