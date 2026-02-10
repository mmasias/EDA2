# Ejemplo C: Búsqueda de par en array

## Código

```java
class FindPair {

    static int[] findPairWithSum(int[] array, int target) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = {2, 7, 11, 15};
        int target = 9;
        int[] result = findPairWithSum(array, target);

        if (result != null) {
            System.out.println("Par encontrado: " + result[0] + " + " + result[1] + " = " + target);
        } else {
            System.out.println("No existe par que sume " + target);
        }
    }
}
```

## Análisis del algoritmo findPairWithSum

Este algoritmo busca dos elementos en un array que sumen un valor objetivo. La estrategia es probar todos los pares posibles.

### Identificación de las operaciones y su complejidad

<div align=center>

|Operación|Descripción|Complejidad|
|-|-|-|
|Inicialización|Declaración del método y variables de control|`O(1)`|
|Bucle externo (`i`)|Se ejecuta `n-1` veces (desde 0 hasta n-2)|`O(n)`|
|Bucle interno (`j`)|Para cada iteración de `i`, se ejecuta desde `i+1` hasta `n-1`. En promedio `n/2` veces|`O(n)` por cada `i`|
|Comparación de suma|Operación constante dentro del bucle anidado|`O(1)` por iteración|
|Retorno|Operación constante (se ejecuta una vez)|`O(1)`|

</div>

### Suma de complejidades

<div align=center>

`O(1) + O(n) × O(n) + O(1) --> O(n²)`

</div>

### Análisis visual del anidamiento

El bucle interno depende del externo:

```
i=0: j recorre 1, 2, 3, ..., n-1     -> n-1 iteraciones
i=1: j recorre 2, 3, 4, ..., n-1     -> n-2 iteraciones
i=2: j recorre 3, 4, 5, ..., n-1     -> n-3 iteraciones
...
i=n-2: j recorre n-1                 -> 1 iteración
```

Total de iteraciones: `(n-1) + (n-2) + (n-3) + ... + 1`

Esta es la **serie aritmética**: `1 + 2 + 3 + ... + (n-1) = n(n-1)/2 = O(n²)`

### Simplificación

<div align=center>

|n|Iteraciones del bucle anido|n²|Relación|
|-|:-:|:-:|:-:|
|5|10|25|40% de n²|
|10|45|100|45% de n²|
|100|4,950|10,000|49.5% de n²|
|1,000|499,500|1,000,000|49.95% de n²|

</div>

Aunque el número exacto de iteraciones es `n(n-1)/2`, que es aproximadamente la mitad de `n²`, en notación Big O las constantes (como ½) se eliminan.

Por lo tanto, la complejidad del algoritmo se simplifica a **O(n²)**.

**Intuición**: Este algoritmo compara cada elemento con todos los demás elementos. Si duplicamos el tamaño del array, el número de comparaciones se cuadriplica. Este crecimiento cuadrático lo hace impracticable para arrays grandes.

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
