# Búsqueda binaria

## ¿Por qué?

La búsqueda binaria es uno de los algoritmos de búsqueda más eficientes, siempre y cuando los datos estén ordenados. Su eficacia radica en la reducción continua del rango de búsqueda, lo que la convierte en una opción ideal para listas ordenadas y colecciones grandes. Este algoritmo es un ejemplo fundamental para ilustrar la potencia de las técnicas de "divide y vencerás".

## ¿Qué?

La búsqueda binaria divide repetidamente una lista ordenada en mitades, comparando el elemento medio con el objetivo. Si el objetivo es menor que el elemento medio, la búsqueda continúa en la mitad inferior; si es mayor, en la mitad superior. El proceso se repite hasta encontrar el elemento o reducir el rango de búsqueda a cero.

## ¿Para qué?

La búsqueda binaria es esencial en aplicaciones donde la eficiencia es crucial, ya que su complejidad temporal es de \(O(\log n)\). Algunas de sus aplicaciones incluyen:

- Búsqueda rápida en bases de datos o listas grandes.
- Acceso eficiente a datos ordenados, como directorios, índices, y catálogos.
- Uso en estructuras de datos avanzadas como árboles de búsqueda.

## ¿Cómo?

### Implementación

```java
public class BinarySearch {
    public static int search(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2; // Evita desbordamiento

            if (array[mid] == target) {
                return mid; // El objetivo se encuentra en la posición media
            } else if (array[mid] < target) {
                left = mid + 1; // El objetivo está en la mitad derecha
            } else {
                right = mid - 1; // El objetivo está en la mitad izquierda
            }
        }

        return -1; // El objetivo no se encuentra en el array
    }

    public static void main(String[] args) {
        int[] data = {1, 3, 5, 7, 9, 11, 13};
        int target = 7;
        int index = search(data, target);
        if (index != -1) {
            System.out.println("Elemento encontrado en la posición: " + index);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
}
```

La búsqueda binaria requiere una lista ordenada para funcionar correctamente, lo que añade el requisito de ordenar los datos antes de usarla, si no están previamente organizados.
