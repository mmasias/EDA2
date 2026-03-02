# encontrarElemento

Buscar si un elemento existe en una lista.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|[],3|false
CB|cabeza == 3|true
...
...
...
n-1|[6,3,5,2,4],3|true
n|[5,6,3,5,2,4],3|true

Cabeza != numero ==> f(n-1)

</div>

## Pseudocódigo

```text
FUNCION encontrarElemento(lista, numero)

    SI longitud(lista) es 0 ENTONCES
        Devolver Falso
    FIN SI

    SI lista[0] es igual a numero ENTONCES
        Devolver Verdadero
    FIN SI

    resto = lista sin el primer elemento
    Devolver encontrarElemento(resto, numero)

FIN FUNCIÓN
```
