# contarEnReversa

Generar una cadena con los números desde n hasta 0, en orden descendente.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|0
...
n-1|4|4,3,2,1,0
n|5|5,4,3,2,1,0

n & f(n-1)

</div>

## Pseudocódigo

```text
FUNCION contarEnReversa(n)

    SI n es 0 ENTONCES
        Devolver "0"
    FIN SI

    Devolver n + ", " + contarEnReversa(n - 1)

FIN FUNCIÓN
```
