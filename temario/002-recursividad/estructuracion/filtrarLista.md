# filtrarLista

Filtrar una lista manteniendo solo los elementos mayores que un umbral dado.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-:|-:|
CB|[],3|[]
...
n-1|[5],3|[5]
n|[4,5],3|[4,5]
...
n-1|[2,3,4,5],3|[4,5]
n|[1,2,3,4,5],3|[4,5]

Cabeza < 3 ==> f(n-1)

Cabeza > 3 ==> Cabeza + f(n-1)

</div>

## Pseudocódigo

```text
FUNCION filtrarLista(lista, umbral)

    SI longitud(lista) es 0 ENTONCES
        Devolver lista vacía
    FIN SI

    cabeza = lista[0]
    resto = lista sin el primer elemento

    resultadoResto = filtrarLista(resto, umbral)

    SI cabeza > umbral ENTONCES
        Devolver lista formada por [cabeza] + resultadoResto
    SI NO
        Devolver resultadoResto
    FIN SI

FIN FUNCIÓN
```
