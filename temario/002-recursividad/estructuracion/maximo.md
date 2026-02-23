# maximo

Encontrar el elemento máximo de una lista de números.

<details>
<summary>Ver análisis recursivo</summary>

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

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

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

</details>

<details>
<summary>Ver código Java</summary>

```java
import java.util.Arrays;

public class MaximoLista {

    public static int maximo(int[] lista) {
        if (lista.length == 1) {
            return lista[0];
        }

        int cabeza = lista[0];
        int[] resto = Arrays.copyOfRange(lista, 1, lista.length);

        int maximoResto = maximo(resto);

        if (cabeza > maximoResto) {
            return cabeza;
        } else {
            return maximoResto;
        }
    }

    public static void main(String[] args) {
        int[] datos = {5, 2, 4};
        System.out.println("El máximo es: " + maximo(datos));
    }
}
```

</details>
