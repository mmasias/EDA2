<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [**Estructuración**](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Esquema](README.md) / [01](factorial.md) / [02](sumaNPrimeros.md) / [03](multiplicacionSumas.md) / [04](potencias.md) / [05](sumarDigitos.md) / [06](contar.md) / [07](reversa.md) / [08](invertirCadena.md) / [**09**](contarApariciones.md) / [10](sumaNumerosLista.md) / [11](filtrarLista.md) / [12](encontrarElemento.md) / [13](maximo.md) / [14](listaOrdenada.md)

</div>

# contarApariciones

Contar cuántas veces aparece una letra en una cadena de texto.

## Análisis recursivo

<div align=center>

||n|f(n)|
|-|-|-|
CB|"",a|0
...
...
...
n-1|"da"|1
n|"ada"|2
...
n-1|"cdada"|2
n|"bcdada"|2

cabeza != letra ==> f(n-1)

cabeza == letra ==> 1 + f(n-1)

</div>

## Pseudocódigo

```text
FUNCION contarApariciones(cadena, letra)

    SI cadena está vacía ENTONCES
        Devolver 0
    FIN SI

    cabeza = primer carácter de cadena
    resto = subcadena desde posición 1 hasta el final

    SI cabeza es igual a letra ENTONCES
        Devolver 1 + contarApariciones(resto, letra)
    SI NO
        Devolver contarApariciones(resto, letra)
    FIN SI

FIN FUNCIÓN
```
