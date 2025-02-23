# Término dominante

## ¿Por qué?

Dado que para aplicar la notación Big O en la práctica se sigue un proceso de identificación del peor escenario posible, simplificación de la fórmula de complejidad para resaltar el término dominante y clasificación del algoritmo en una categoría de complejidad.

## ¿Qué?

El **término dominante** en una fórmula de complejidad de tiempo (o espacio) es el componente que crece más rápidamente con respecto al tamaño de la entrada, N, cuando N se acerca al infinito. 

## ¿Para qué?

La identificación del término dominante es crucial para la notación Big O porque este término determina la clasificación de la complejidad del algoritmo.

## ¿Cómo?

Para encontrar el término dominante, sigamos estos pasos:

- **Escribir la fórmula de complejidad completa**: Esto puede incluir varios términos que describen diferentes partes del algoritmo, como bucles anidados, operaciones recursivas, operaciones aritméticas directas, entre otros.
- **Analizar el comportamiento de cada término a medida que N crece**: Considerar cómo cada parte de la fórmula cambia a medida que el tamaño de la entrada se hace muy grande.
- **Identificar el término que crece más rápidamente**: Este será el término cuyo tamaño aumenta más rápidamente en comparación con los demás a medida que N se hace grande. Los términos comunes incluyen N, N², N³, 2^N, log(N), etc.
- **Simplificar la expresión eliminando términos no dominantes y constantes**: Los términos que crecen más lentamente y las constantes multiplicativas no afectan la clasificación de complejidad en la notación Big O, por lo que se pueden omitir para simplificar la expresión.

<div align="center">

|Fórmula de complejidad|Término dominante|Notación BigO
|-|:-:|:-:|
|7N³ + 15N² + 2N + 8|N³|O(N³)

</div>

### Ejemplo A

```java
public class SumArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("La suma de los elementos del arreglo es: " + sumArray(array));
    }

    private static int sumArray(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}
```

#### Análisis del algoritmo sumArray

##### Identificación de las operaciones y su complejidad

||||
|-|-|-|
Inicialización de la suma|Esta operación se realiza una sola vez, independientemente del tamaño del arreglo. Por lo tanto, su complejidad es constante|`O(1)`
Bucle `for`|Este bucle se ejecuta una vez por cada elemento en el arreglo. Si el arreglo tiene N elementos, el bucle se ejecutará N veces.|`O(N)`
Operación dentro del bucle|Operación de suma **pero** dentro del bucle: La suma (sum += array[i]) se realiza una vez|`O(1)` por operación, pero `O(N)` al estar dentro de un bucle
Retorno de la suma|Al igual que la inicialización, el retorno de la suma es una operación que se realiza una sola vez|`O(1)`

##### Suma de complejidades

`O(1) + O(N) + O(N) + O(1) --> 2O(1) + 2O(N)`

##### Simplificación & enfatizado del término dominante

Dado que en un análisis de complejidad estamos interesados en el comportamiento asintótico para grandes valores de N, las constantes y los términos de menor crecimiento (como O(1)) se consideran insignificantes frente al término de mayor crecimiento.

Por lo tanto, simplificamos la expresión a O(N), que es el término dominante.

### Ejemplo B

Vamos a explorar otro ejemplo clásico de algoritmo y su análisis de complejidad: un algoritmo de búsqueda binaria en un arreglo **ordenado**. Este ejemplo es interesante porque la búsqueda binaria tiene una complejidad diferente a la de algoritmos como la suma de elementos de un arreglo.

```java
public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; 
            }
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 11}; 
        int target = 7;
        int result = binarySearch(array, target);
        if (result == -1) {
            System.out.println("Elemento no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + result);
        }
    }
}

```
#### Análisis del algoritmo de Búsqueda Binaria

##### Identificación de las operaciones y su complejidad

|Componente|Descripción|Complejidad|
|-|-|-|
|Inicialización              | Las operaciones de inicialización (`left = 0`, `right = array.length - 1`) son constantes y se ejecutan una sola vez. | `O(1)`       |
|Bucle `while`               | Este bucle reduce el tamaño del problema a la mitad en cada iteración. El número de iteraciones es proporcional a (log N). | `O(log N)`   |
|Operaciones dentro del bucle| Calcular el medio, comparar el valor y actualizar los límites son todas operaciones constantes, pero contribuyen al total de la complejidad del bucle. | `O(1)` por operación, implicado en `O(log N)`|
|Retorno                     | El retorno del índice del elemento o -1 es una operación constante realizada una vez al final.                   | `O(1)`       |

##### Suma de complejidades

`O(1) + O(log N) + O(1) --> O(log N) + 2O(1)`

##### Simplificación & enfatizado del término dominante

Al simplificar y enfocarnos en el término de mayor crecimiento, las constantes y los términos de menor crecimiento son considerados insignificantes frente al término dominante. Por lo tanto, aunque técnicamente incluimos todas las operaciones en el análisis inicial, el resultado final se simplifica a `O(log N)`, reflejando la eficiencia de la búsqueda binaria en conjuntos de datos ordenados.
