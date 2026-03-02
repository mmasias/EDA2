# potencias

Calcular 2 elevado a la potencia n.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|1
...
...
...
n-1|4|16
n|5|32

2 x f(n-1)

</div>

## Pseudocódigo

```text
FUNCION potencia(n)

    SI n es 0 ENTONCES
        Devolver 1
    FIN SI

    Devolver 2 * potencia(n - 1)

FIN FUNCIÓN
```