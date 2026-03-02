# invertirCadena

Invertir una cadena de texto dada.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|""|""
...
...
...
n-1|"bcd"|"dcb"
n|"abcd"|"dcba"

f(n-1) + cabeza

</div>

## Pseudocódigo

```text
FUNCION invertirCadena(cadena)

    SI longitud(cadena) es 0 ENTONCES
        Devolver ""
    FIN SI

    cabeza = primer carácter de cadena
    resto = subcadena desde la posición 1 hasta el final

    Devolver invertirCadena(resto) + cabeza

FIN FUNCIÓN
```
