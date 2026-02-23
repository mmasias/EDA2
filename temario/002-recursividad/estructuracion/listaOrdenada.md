# listaOrdenada

Verificar si una lista está ordenada de forma ascendente.

<details>
<summary>Ver análisis recursivo</summary>

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

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

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

</details>

<details>
<summary>Ver código Java</summary>

```java
import java.util.Arrays;

public class ListaOrdenada {

    public static boolean estaOrdenada(int[] lista) {
        if (lista.length <= 1) {
            return true;
        }

        int cabeza = lista[0];
        int[] resto = Arrays.copyOfRange(lista, 1, lista.length);

        int siguienteCabeza = resto[0];

        if (cabeza < siguienteCabeza && estaOrdenada(resto)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        int[] ok = {1, 3, 5, 7};
        int[] mal = {5, 3, 5, 7};

        System.out.println("¿Está ordenada {1, 3, 5, 7}?: " + estaOrdenada(ok));
        System.out.println("¿Está ordenada {5, 3, 5, 7}?: " + estaOrdenada(mal));
    }
}
```

</details>
