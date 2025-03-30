# Counting Sort (Ordenamiento por Conteo)

## ¿Por qué?

Counting Sort es un algoritmo de ordenamiento no comparativo que es especialmente útil cuando el rango de datos en el conjunto de entrada es no demasiado grande y se puede predecir. Este método puede ser extremadamente eficiente porque opera con una complejidad temporal de \(O(n + k)\), donde \(n\) es el número de elementos en el arreglo de entrada y \(k\) es el rango de entrada. Esto lo hace más rápido que los algoritmos de comparación en muchos escenarios prácticos, especialmente donde \(k\) no supera significativamente a \(n\).

## ¿Qué?

Counting Sort funciona contando la cantidad de objetos que tienen un valor de clave distinto. Utiliza esas cuentas para calcular la posición de cada objeto en la secuencia de salida. Es esencialmente un algoritmo de clasificación basado en claves entre un rango específico. Se diferencia de los métodos más simples de ordenamiento por comparación en que opera directamente sobre los valores sin compararlos entre sí.

## ¿Para qué?

Este algoritmo es ideal para situaciones donde el rango de datos es conocido y limitado, como caracteres alfabéticos, calificaciones por letras, o pequeños enteros en aplicaciones específicas. Es muy útil en aplicaciones que requieren estabilidad en el ordenamiento (los elementos iguales mantienen el orden en que aparecen en la entrada) y rapidez para grandes volúmenes de datos, como en el procesamiento de formularios, ordenamiento de grandes registros basados en claves simples, o incluso en algoritmos internos de otros procedimientos más complejos de ordenamiento.

## ¿Cómo?

```java
public class CountingSort {
    public void sort(int[]  array) {
        int length =  array.length;
        // El  arreglo de salida que tendrá los elementos ordenados
        int output[] = new int[length];

        // Encuentra el elemento mayor para saber el rango
        int max =  array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max)
                max =  array[i];
        }

        // Arreglo de conteo
        int count[] = new int[max + 1];

        // Almacenar el conteo de cada elemento
        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }

        // Cambiar count[i] para que count[i] contenga la posición actual
        // de este elemento en output[]
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Construir el  arreglo de salida
        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copiar los elementos ordenados al  arreglo original
        for (int i = 0; i < length; i++) {
             array[i] = output[i];
        }
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        obj.sort(data);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
```

### Traza

**Arreglo de entrada:** \([4, 2, 2, 8, 3, 3, 1]\)

**Max value (k):** 8

**Arreglo de conteo inicializado:** \([0, 0, 0, 0, 0, 0, 0, 0, 0]\) — 9 elementos (0 a 8)

#### Paso 1: contar

Recorremos el arreglo de entrada y contamos cada elemento, incrementando la posición correspondiente en el arreglo de conteo.

- Elemento 4: \([0, 0, 0, 0, 1, 0, 0, 0, 0]\)
- Elemento 2: \([0, 0, 1, 0, 1, 0, 0, 0, 0]\)
- Elemento 2: \([0, 0, 2, 0, 1, 0, 0, 0, 0]\)
- Elemento 8: \([0, 0, 2, 0, 1, 0, 0, 0, 1]\)
- Elemento 3: \([0, 0, 2, 1, 1, 0, 0, 0, 1]\)
- Elemento 3: \([0, 0, 2, 2, 1, 0, 0, 0, 1]\)
- Elemento 1: \([0, 1, 2, 2, 1, 0, 0, 0, 1]\)

#### Paso 2: acumular

Modificamos el arreglo de conteo para acumular la cantidad de elementos que deben preceder a cada índice.

- Acumulación: \([0, 1, 3, 5, 6, 6, 6, 6, 7]\)

#### Paso 3: colocar

Utilizamos el arreglo de conteo para colocar cada elemento en su posición correcta en un nuevo arreglo de salida.

Empezamos desde el final del arreglo original para mantener la estabilidad.

- \( arr[6] = 1 \): \([1, 0, 0, 0, 0, 0, 0]\) y \( count[1] \) decrece a 0: \([0, 0, 3, 5, 6, 6, 6, 6, 7]\)
- \( arr[5] = 3 \): \([1, 0, 0, 3, 0, 0, 0]\) y \( count[3] \) decrece a 4: \([0, 0, 3, 4, 6, 6, 6, 6, 7]\)
- \( arr[4] = 3 \): \([1, 0, 0, 3, 3, 0, 0]\) y \( count[3] \) decrece a 3: \([0, 0, 3, 3, 6, 6, 6, 6, 7]\)
- \( arr[3] = 8 \): \([1, 0, 0, 3, 3, 0, 8]\) y \( count[8] \) decrece a 6: \([0, 0, 3, 3, 6, 6, 6, 6, 6]\)
- \( arr[2] = 2 \): \([1, 2, 0, 3, 3, 0, 8]\) y \( count[2] \) decrece a 2: \([0, 0, 2, 3, 6, 6, 6, 6, 6]\)
- \( arr[1] = 2 \): \([1, 2, 2, 3, 3, 0, 8]\) y \( count[2] \) decrece a 1: \([0, 0, 1, 3, 6, 6, 6, 6, 6]\)
- \( arr[0] = 4 \): \([1, 2, 2, 3, 3, 4, 8]\) y \( count[4] \) decrece a 5: \([0, 0, 1, 3, 5, 6, 6, 6, 6]\)

#### Final

**Arreglo ordenado:** \([1, 2, 2, 3, 3, 4, 8]\)
