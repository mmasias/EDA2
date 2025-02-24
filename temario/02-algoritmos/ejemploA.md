# Ejemplo A

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

## Análisis del algoritmo sumArray

### Identificación de las operaciones y su complejidad

||||
|-|-|-|
|Inicialización de la suma|Esta operación se realiza una sola vez, independientemente del tamaño del arreglo. Por lo tanto, su complejidad es constante|`O(1)`|
|Bucle `for`|Este bucle se ejecuta una vez por cada elemento en el arreglo. Si el arreglo tiene N elementos, el bucle se ejecutará N veces.|`O(N)`|
|Operación dentro del bucle|Operación de suma **pero** dentro del bucle: La suma (sum += array[i]) se realiza una vez|`O(1)` por operación, pero `O(N)` al estar dentro de un bucle|
|Retorno de la suma|Al igual que la inicialización, el retorno de la suma es una operación que se realiza una sola vez|`O(1)`|

### Suma de complejidades

`O(1) + O(N) + O(N) + O(1) --> 2·O(1) + 2·O(N)`

### Simplificación & enfatizado del término dominante

Dado que en un análisis de complejidad estamos interesados en el comportamiento asintótico para grandes valores de N, las constantes y los términos de menor crecimiento (como O(1)) se consideran insignificantes frente al término de mayor crecimiento.

Por lo tanto, simplificamos la expresión a O(N), que es el término dominante.
