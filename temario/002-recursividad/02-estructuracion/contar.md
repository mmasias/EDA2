<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [**Estructuración**](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Esquema](README.md) / [01](factorial.md) / [02](sumaNPrimeros.md) / [03](multiplicacionSumas.md) / [04](potencias.md) / [05](sumarDigitos.md) / [**06**](contar.md) / [07](reversa.md) / [08](invertirCadena.md) / [09](contarApariciones.md) / [10](sumaNumerosLista.md) / [11](filtrarLista.md) / [12](encontrarElemento.md) / [13](maximo.md) / [14](listaOrdenada.md)

</div>

# contar

Generar una cadena con los números desde 0 hasta n, separados por comas.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|0
...
n-1|4|1,2,3,4
n|5|1,2,3,4,5

f(n-1) & n

</div>

## Pseudocódigo

```text
FUNCION contar(n)

    SI n es 0 ENTONCES
        Devolver "0"
    FIN SI

    Devolver contar(n - 1) + ", " + n

FIN FUNCIÓN
```
