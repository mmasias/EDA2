# Búsqueda lineal

## ¿Por qué?

La búsqueda lineal, también conocida como búsqueda secuencial, es uno de los algoritmos de búsqueda más simples. Aunque no es el método más eficiente para colecciones grandes, su simplicidad lo convierte en una excelente introducción a los conceptos de búsqueda y sirve para entender mejor las operaciones fundamentales de comparación y recorrido en estructuras de datos.

## ¿Qué?

La búsqueda lineal funciona recorriendo la lista, array u otra estructura secuencial desde el primer hasta el último elemento. Compara cada elemento con el objetivo hasta encontrar una coincidencia o llegar al final. Si se encuentra el elemento, devuelve su posición; de lo contrario, indica que no está presente.

## ¿Para qué?

La búsqueda lineal, debido a su simplicidad, tiene aplicaciones en contextos donde la eficiencia no es crítica:

- Funciona bien en listas pequeñas o cuando los datos no están ordenados.
- Útil cuando no se dispone de estructuras de datos optimizadas para búsquedas rápidas.
- Ideal para enseñar los fundamentos de las operaciones de búsqueda.

## ¿Cómo?

### Implementación

```java
public class LinearSearch {
    public static int search(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // Devuelve la posición del elemento si se encuentra
            }
        }
        return -1; // Indica que el elemento no está presente
    }

    public static void main(String[] args) {
        int[] data = {4, 2, 3, 1, 5, 6};
        int target = 3;
        int index = search(data, target);
        if (index != -1) {
            System.out.println("Elemento encontrado en la posición: " + index);
        } else {
            System.out.println("Elemento no encontrado");
        }
    }
}
```

Esta implementación es directa y compara cada elemento con el objetivo. En el peor de los casos, tiene una complejidad temporal de \(O(n)\), lo que la hace ineficiente para grandes colecciones, pero útil en casos específicos.
