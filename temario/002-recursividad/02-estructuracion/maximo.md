<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [**Estructuración**](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Esquema](README.md) / [01](factorial.md) / [02](sumaNPrimeros.md) / [03](multiplicacionSumas.md) / [04](potencias.md) / [05](sumarDigitos.md) / [06](contar.md) / [07](reversa.md) / [08](invertirCadena.md) / [09](contarApariciones.md) / [10](sumaNumerosLista.md) / [11](filtrarLista.md) / [12](encontrarElemento.md) / [**13**](maximo.md) / [14](listaOrdenada.md)

</div>

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
