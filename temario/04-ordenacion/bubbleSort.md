# Bubble Sort

## ¿Por qué?

El Bubble Sort u ordenamiento por burbuja, es uno de los algoritmos de ordenamiento más simples. Aunque no es el más eficiente para listas grandes de datos, su simplicidad lo hace útil como introducción al concepto de algoritmos de ordenamiento y para entender mejor las operaciones fundamentales que involucran comparaciones y cambios de posiciones en estructuras de datos.

## ¿Qué?

El Bubble Sort funciona revisando repetidamente la lista que se quiere ordenar, comparando elementos adyacentes e intercambiándolos si están en el orden incorrecto. Este proceso se repite hasta que no se necesiten más intercambios, lo que significa que la lista está ordenada. El nombre del algoritmo proviene de la forma en que los elementos mayores "burbujean" hacia el final de la lista con cada pasada completa a través de la lista.

## ¿Para qué?

Aunque el Bubble Sort no es eficiente para el manejo de grandes volúmenes de datos debido a su complejidad algorítmica O(n²) en el peor y en el caso promedio, tiene algunas ventajas en ciertos contextos. 

- Es útil cuando la simplicidad es más importante que la eficiencia, por ejemplo, en listas pequeñas donde la complejidad del código es más crítica que el tiempo de ejecución. 
- Tiene un rendimiento razonable en listas que ya están casi ordenadas, ya que en el mejor caso (lista ya ordenada) tiene una complejidad de O(n).

## ¿Cómo?

### Implementación

```java
public class BubbleSort {
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // i es el número de pasadas completas
            for (int j = 0; j < n - 1; j++) { // j es el índice para comparar elementos adyacentes
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}

```

```java
public class BubbleSort {
    public static void sort(int[] array) {
        boolean sorted = false;
        int passIndex = 0; // Para reducir el alcance del barrido en cada pasada
        while (!sorted) {
            sorted = true; // Se asume que el arreglo está ordenado
            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false; // Se encontró un desorden, se continua
                }
            }
            passIndex++;
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}

```

### Implementación (con control de intercambios)

```java
public class BubbleSort {
    public static void sort(int[] array) {
        boolean swapped;
        int passIndex = 0;
        do {
            swapped = false;
            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; // Se registró un intercambio
                }
            }
            passIndex++;
        } while (swapped); // Continuar mientras se realicen intercambios
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}

```
