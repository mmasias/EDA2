<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [**Estructuración**](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Esquema](README.md) / [01](factorial.md) / [02](sumaNPrimeros.md) / [03](multiplicacionSumas.md) / [04](potencias.md) / [**05**](sumarDigitos.md) / [06](contar.md) / [07](reversa.md) / [08](invertirCadena.md) / [09](contarApariciones.md) / [10](sumaNumerosLista.md) / [11](filtrarLista.md) / [12](encontrarElemento.md) / [13](maximo.md) / [14](listaOrdenada.md).

</div>

# sumarDigitos

Calcular la suma de todos los dígitos de un número entero.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|5|5
...
...
...
n-1|5342|14
n|53421|15

cabeza + f(n-1)

</div>

## Pseudocódigo

```text
función sumaDigitos(n):
    SI n < 10:
        retornar n
    FIN SI

    numeroDeDígitos = contar_dígitos(n)
    divisor = 10^(numeroDeDígitos - 1)
    primerDígito = n / divisor
    resto = n % divisor

    retornar primerDígito + sumaDigitos(resto)
```
