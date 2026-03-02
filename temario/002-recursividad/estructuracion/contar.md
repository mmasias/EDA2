# contar

Generar una cadena con los números desde 0 hasta n, separados por comas.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|0
...
n-1|4|1,2,3,4
n|5|1,2,3,4,5

f(n-1) & n

</div>

## Pseudocódigo

```text
FUNCION contar(n)

    SI n es 0 ENTONCES
        Devolver "0"
    FIN SI

    Devolver contar(n - 1) + ", " + n

FIN FUNCIÓN
```
