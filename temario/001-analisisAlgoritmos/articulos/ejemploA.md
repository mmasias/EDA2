# Ejemplo A: Suma de elementos

## Código

```java
class SumArray {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("La suma de los elementos del arreglo es: " + sumArray(array));
    }

    static int sumArray(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }
}
```

## Análisis del algoritmo sumArray

### Identificación de las operaciones y su complejidad

<div align=center>

|Operación|Descripción|Complejidad|
|-|-|-|
|Inicialización de la suma|Se realiza una sola vez, independientemente del tamaño del arreglo|`O(1)`|
|Bucle `for`|Se ejecuta una vez por cada elemento. Si el arreglo tiene N elementos, se ejecutará N veces|`O(N)`|
|Operación dentro del bucle|La suma (sum += array[i]) se realiza una vez por iteración|`O(1)` por operación, pero `O(N)` al estar dentro del bucle|
|Retorno de la suma|Operación que se realiza una sola vez|`O(1)`|

</div>

### Suma de complejidades

<div align=center>

`O(1) + O(N) + O(N) + O(1) --> 2·O(1) + 2·O(N)`

</div>

### Simplificación

Dado que en un análisis de complejidad estamos interesados en el comportamiento asintótico para grandes valores de N, las constantes y los términos de menor crecimiento (como O(1)) se consideran insignificantes frente al término de mayor crecimiento.

Por lo tanto, simplificamos la expresión a **O(N)**, que es el término dominante.
