# Ejemplo B: Encontrar el máximo

## Código

```java
static int findMax(int[] array) {
    int max = array[0];
    for (int i = 1; i < array.length; i++) {
        if (array[i] > max) {
            max = array[i];
        }
    }
    return max;
}
```

## Análisis del algoritmo findMax

### Identificación de las operaciones y su complejidad

<div align=center>

|Operación|Descripción|Complejidad|
|-|-|-|
|Inicialización del máximo|Incluir acceder al primer elemento y asignarlo a max. Se realiza una sola vez|`O(1)`|
|Bucle `for`|Se ejecuta `n-1` veces, donde n es el tamaño del arreglo|`O(N)`|
|Comparación dentro del bucle|La comparación `array[i] > max` se realiza una vez por iteración|`O(1)` por operación, pero `O(N)` al estar dentro del bucle|
|Asignación dentro del bucle|En el peor caso se realizará en cada iteración|`O(1)` por operación, pero `O(N)` en el peor caso|
|Retorno del máximo|Operación que se realiza una sola vez|`O(1)`|

</div>

### Suma de complejidades

<div align=center>

`O(1) + O(N) + O(N) + O(N) + O(1) --> 2·O(1) + 3·O(N)`

</div>

### Simplificación

En el análisis de complejidad asintótica, nos enfocamos en el comportamiento para grandes valores de N:

1. Las constantes (3 en 3·O(N)) se eliminan
2. Los términos de menor orden (O(1)) se vuelven insignificantes
3. Nos quedamos con el término de mayor crecimiento

Por lo tanto, la complejidad del algoritmo se simplifica a **O(N)**, lo cual es intuitivamente correcto ya que necesitamos examinar cada elemento del arreglo exactamente una vez para encontrar el máximo.
