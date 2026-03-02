# sumarDigitos

Calcular la suma de todos los dígitos de un número entero.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|5|5
...
...
...
n-1|5342|14
n|53421|15

cabeza + f(n-1)

</div>

## Pseudocódigo

```text
función sumaDigitos(n):
    SI n < 10:
        retornar n
    FIN SI

    numeroDeDígitos = contar_dígitos(n)
    divisor = 10^(numeroDeDígitos - 1)
    primerDígito = n / divisor
    resto = n % divisor

    retornar primerDígito + sumaDigitos(resto)
```
