# maximo

Encontrar el elemento máximo de una lista de números.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|[4]|4
...
n-1|[2,4]|4
n|[2,2,4]|4
...
n-1|[2,4]|4
n|[5,2,4]|5

Cabeza > f(n-1) ==> Cabeza
Cabeza <= f(n-1) ==> f(n-1)

</div>

## Pseudocódigo

```text
FUNCION maximo(lista)

    SI longitud(lista) es 1 ENTONCES
        Devolver lista[0]
    FIN SI

    cabeza = lista[0]
    resto = lista sin el primer elemento

    maximoResto = maximo(resto)

    SI cabeza > maximoResto ENTONCES
        Devolver cabeza
    SI NO
        Devolver maximoResto
    FIN SI

FIN FUNCIÓN
```
