<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [**Estructuración**](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Esquema](README.md) / [01](factorial.md) / [02](sumaNPrimeros.md) / [03](multiplicacionSumas.md) / [04](potencias.md) / [05](sumarDigitos.md) / [06](contar.md) / [07](reversa.md) / [08](invertirCadena.md) / [09](contarApariciones.md) / [**10**](sumaNumerosLista.md) / [11](filtrarLista.md) / [12](encontrarElemento.md) / [13](maximo.md) / [14](listaOrdenada.md)

</div>

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
