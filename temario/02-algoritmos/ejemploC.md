# Ejemplo C

```java
public static int findMax(int[] array) {
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
        if (array[i] > max) {
            max = array[i];
        }
    }
    return max;
}
```

#### Análisis del algoritmo findMax

##### Identificación de las operaciones y su complejidad

||||
|-|-|-|
|Inicialización del máximo|Esta operación incluye acceder al primer elemento del arreglo y asignarlo a max. Se realiza una sola vez.|`O(1)`|
|Bucle `for`|Este bucle se ejecuta `n-1` veces, donde n es el tamaño del arreglo. Se inicia en 1 y recorre hasta el último elemento.|`O(N)`|
|Comparación dentro del bucle|La comparación `array[i] > max` se realiza una vez por iteración, pero al estar dentro del bucle se multiplica por el número de iteraciones.|`O(1)` por operación, pero `O(N)` al estar dentro del bucle|
|Asignación dentro del bucle|La asignación `max = array[i]` en el peor caso se realizará en cada iteración.|`O(1)` por operación, pero `O(N)` en el peor caso|
|Retorno del máximo|El retorno del valor máximo es una operación que se realiza una sola vez.|`O(1)`|

##### Suma de complejidades

`O(1) + O(N) + O(N) + O(N) + O(1) --> 2O(1) + 3O(N)`

##### Simplificación & enfatizado del término dominante

En el análisis de complejidad asintótica, nos enfocamos en el comportamiento para grandes valores de N. Por lo tanto:

1. Las constantes (3 en 3O(N)) se eliminan.
2. Los términos de menor orden (O(1)) se vuelven insignificantes.
3. Nos quedamos con el término de mayor crecimiento.

Por lo tanto, la complejidad del algoritmo se simplifica a `O(N)`, lo cual es intuitivamente correcto ya que necesitamos examinar cada elemento del arreglo exactamente una vez para encontrar el máximo.