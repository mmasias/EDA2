# listaOrdenada

Verificar si una lista está ordenada de forma ascendente.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|[3]|verdadero
...
n-1|[3,5,6]|verdadero
n|[5,3,5,7]|falso
...
n-1|[3,5,6]|verdadero
n|[1,3,5,7]|verdadero

Cabeza < SiguienteCabeza && f(n-1)

</div>

## Pseudocódigo

```text
FUNCION listaOrdenada(lista)

    SI longitud(lista) es 0 o 1 ENTONCES
        Devolver Verdadero
    FIN SI

    cabeza = lista[0]
    resto = lista sin el primer elemento
    siguienteCabeza = resto[0]

    SI cabeza < siguienteCabeza Y listaOrdenada(resto) ENTONCES
        Devolver Verdadero
    SI NO
        Devolver Falso
    FIN SI

FIN FUNCIÓN
```
