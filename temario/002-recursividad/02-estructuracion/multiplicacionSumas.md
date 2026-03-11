<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [**Estructuración**](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Esquema](README.md) / [01](factorial.md) / [02](sumaNPrimeros.md) / [**03**](multiplicacionSumas.md) / [04](potencias.md) / [05](sumarDigitos.md) / [06](contar.md) / [07](reversa.md) / [08](invertirCadena.md) / [09](contarApariciones.md) / [10](sumaNumerosLista.md) / [11](filtrarLista.md) / [12](encontrarElemento.md) / [13](maximo.md) / [14](listaOrdenada.md)

</div>

# multiplicacionSumas

Calcular el producto de dos números usando solo sumas.

## Análisis recursivo

<div align=center>

||a,b|f(a,b)|
|-|-:|-:|
CB|5,0|0
...
CR|5,1|5 = 5 + 0
CR|5,2|10 = 5 + 5
CR|5,3|15 = 5 + 10
n-1|5,4|20 = 5 + 15
n|5,5|25 = 5 + 20

a + f(a,b-1)

</div>

## Pseudocódigo

```text
FUNCION multiplicar(a, b)

    SI b es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver a + multiplicar(a, b - 1)

FIN FUNCIÓN
```
