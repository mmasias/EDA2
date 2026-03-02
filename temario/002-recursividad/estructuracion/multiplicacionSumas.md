# multiplicacionSumas

Calcular el producto de dos números usando solo sumas.

## Análisis recursivo

<div align=center>

||a,b|f(a,b)|
|-|-:|-:|
CB|5,0|0
...
CR|5,1|5 = 5 + 0
CR|5,2|10 = 5 + 5
CR|5,3|15 = 5 + 10
n-1|5,4|20 = 5 + 15
n|5,5|25 = 5 + 20

a + f(a,b-1)

</div>

## Pseudocódigo

```text
FUNCION multiplicar(a, b)

    SI b es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver a + multiplicar(a, b - 1)

FIN FUNCIÓN
```
