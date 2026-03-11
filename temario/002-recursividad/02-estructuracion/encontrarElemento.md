<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [**Estructuración**](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Esquema](README.md) / [01](factorial.md) / [02](sumaNPrimeros.md) / [03](multiplicacionSumas.md) / [04](potencias.md) / [05](sumarDigitos.md) / [06](contar.md) / [07](reversa.md) / [08](invertirCadena.md) / [09](contarApariciones.md) / [10](sumaNumerosLista.md) / [11](filtrarLista.md) / [**12**](encontrarElemento.md) / [13](maximo.md) / [14](listaOrdenada.md)

</div>

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
