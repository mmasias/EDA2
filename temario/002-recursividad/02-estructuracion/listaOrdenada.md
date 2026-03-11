<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [**Estructuración**](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Esquema](README.md) / [01](factorial.md) / [02](sumaNPrimeros.md) / [03](multiplicacionSumas.md) / [04](potencias.md) / [05](sumarDigitos.md) / [06](contar.md) / [07](reversa.md) / [08](invertirCadena.md) / [09](contarApariciones.md) / [10](sumaNumerosLista.md) / [11](filtrarLista.md) / [12](encontrarElemento.md) / [13](maximo.md) / [**14**](listaOrdenada.md)

</div>

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
