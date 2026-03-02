# sumaNumerosLista

Calcular la suma de todos los números de una lista.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-:|-|
CB|[]|0
...
...
...
n-1|[2,3,4,5]|14
n|[1,2,3,4,5]|15

Cabeza + f(n-1)

</div>

## Pseudocódigo

```text
FUNCION sumaNumerosLista(lista)

    SI lista está vacía ENTONCES
        Devolver 0
    FIN SI

    cabeza = primer elemento de la lista
    resto = lista sin el primer elemento
    Devolver cabeza + sumaNumerosLista(resto)

FIN FUNCIÓN
```
