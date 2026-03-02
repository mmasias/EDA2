# contarApariciones

Contar cuántas veces aparece una letra en una cadena de texto.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|"",a|0
...
...
...
n-1|"da"|1
n|"ada"|2
...
n-1|"cdada"|2
n|"bcdada"|2

cabeza != letra ==> f(n-1)

cabeza == letra ==> 1 + f(n-1)

</div>

## Pseudocódigo

```text
FUNCION contarApariciones(cadena, letra)

    SI cadena está vacía ENTONCES
        Devolver 0
    FIN SI

    cabeza = primer carácter de cadena
    resto = subcadena desde posición 1 hasta el final

    SI cabeza es igual a letra ENTONCES
        Devolver 1 + contarApariciones(resto, letra)
    SI NO
        Devolver contarApariciones(resto, letra)
    FIN SI

FIN FUNCIÓN
```
