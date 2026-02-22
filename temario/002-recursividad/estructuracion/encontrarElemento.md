# encontrarElemento

Buscar si un elemento existe en una lista.

<details>
<summary>Ver análisis recursivo</summary>

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

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

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

</details>

<details>
<summary>Ver código Java</summary>

```java
import java.util.Arrays;

public class EncontrarElemento {

    public static boolean buscar(int[] lista, int numero) {
        if (lista.length == 0) {
            return false;
        }

        int cabeza = lista[0];
        if (cabeza == numero) {
            return true;
        }

        int[] resto = Arrays.copyOfRange(lista, 1, lista.length);
        return buscar(resto, numero);
    }

    public static void main(String[] args) {
        int[] datos = {5, 6, 3, 5, 2, 4};
        System.out.println("¿Está el 3?: " + buscar(datos, 3));
        System.out.println("¿Está el 9?: " + buscar(datos, 9));
    }
}
```

</details>
