<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)</sub>  
<sub>[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [**Estructuración**](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Esquema](README.md) / [**01**](factorial.md) / [02](sumaNPrimeros.md) / [03](multiplicacionSumas.md) / [04](potencias.md) / [05](sumarDigitos.md) / [06](contar.md) / [07](reversa.md) / [08](invertirCadena.md) / [09](contarApariciones.md) / [10](sumaNumerosLista.md) / [11](filtrarLista.md) / [12](encontrarElemento.md) / [13](maximo.md) / [14](listaOrdenada.md)

</div>

# factorial

Calcular el producto de todos los números enteros positivos desde 1 hasta n. Por definición, el factorial de 0 es 1.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|1
...
...
...
CR n-1|4|24 = 4x3x2x1
CR n|5|120 = 5x4x3x2x1

120 = 5 x f(n-1) *o lo que es igual* **n * factorial(n-1)**

</div>

## Pseudocódigo

```text
FUNCION factorial(n)

    SI n es 0 ENTONCES
        Devolver 1
    FIN SI

    Devolver n * factorial(n - 1)

FIN FUNCIÓN
```
