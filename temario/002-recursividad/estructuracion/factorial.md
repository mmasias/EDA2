# factorial

Calcular el producto de todos los números enteros positivos desde 1 hasta n. Por definición, el factorial de 0 es 1.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|1
...
...
...
CR n-1|4|24 = 4x3x2x1
CR n|5|120 = 5x4x3x2x1

120 = 5 x f(n-1) *o lo que es igual* **n * factorial(n-1)**

</div>

## Pseudocódigo

```text
FUNCION factorial(n)

    SI n es 0 ENTONCES
        Devolver 1
    FIN SI

    Devolver n * factorial(n - 1)

FIN FUNCIÓN
```
