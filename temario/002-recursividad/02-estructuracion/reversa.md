<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [**Estructuración**](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Esquema](README.md) / [01](factorial.md) / [02](sumaNPrimeros.md) / [03](multiplicacionSumas.md) / [04](potencias.md) / [05](sumarDigitos.md) / [06](contar.md) / [**07**](reversa.md) / [08](invertirCadena.md) / [09](contarApariciones.md) / [10](sumaNumerosLista.md) / [11](filtrarLista.md) / [12](encontrarElemento.md) / [13](maximo.md) / [14](listaOrdenada.md)

</div>

# contarEnReversa

Generar una cadena con los números desde n hasta 0, en orden descendente.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|0
...
n-1|4|4,3,2,1,0
n|5|5,4,3,2,1,0

n & f(n-1)

</div>

## Pseudocódigo

```text
FUNCION contarEnReversa(n)

    SI n es 0 ENTONCES
        Devolver "0"
    FIN SI

    Devolver n + ", " + contarEnReversa(n - 1)

FIN FUNCIÓN
```
