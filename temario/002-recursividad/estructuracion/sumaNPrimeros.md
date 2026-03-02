# sumaNPrimeros

Calcular la suma de los n primeros números enteros positivos.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|0
...
...
...
n-1|4|10
n|5|15

n + f(n-1)

</div>

## Pseudocódigo

```text
FUNCION sumaNPrimeros(n)

    SI n es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver n + sumaNPrimeros(n - 1)

FIN FUNCIÓN
```