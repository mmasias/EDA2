# sumaNumerosLista

Calcular la suma de todos los números de una lista.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|[]|0
...
...
...
n-1|[2,3,4,5]|14
n|[1,2,3,4,5]|15

Cabeza + f(n-1)

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumaNumerosLista(lista)

    SI lista está vacía ENTONCES
        Devolver 0
    FIN SI

    cabeza = primer elemento de la lista
    resto = lista sin el primer elemento
    Devolver cabeza + sumaNumerosLista(resto)

FIN FUNCIÓN
```

</details>

<details>
<summary>Ver código Java</summary>

```java
import java.util.Arrays;

public class SumaNumerosLista {

    public static int sumar(int[] lista) {
        if (lista.length == 0) {
            return 0;
        }

        int cabeza = lista[0];

        int[] resto = Arrays.copyOfRange(lista, 1, lista.length);

        return cabeza + sumar(resto);
    }

    public static void main(String[] args) {
        int[] datos = {1, 2, 3, 4, 5};
        System.out.println("La suma es: " + sumar(datos));
    }
}
```

</details>

***Otra forma:***

En Java, para representar el "resto" de un array de forma eficiente sin crear copias nuevas en cada paso, lo habitual es usar un índice que vamos incrementando.

```java
public class SumaNumerosLista {

    public static int sumar(int[] lista, int indice) {
        if (indice == lista.length) {
            return 0;
        }

        return lista[indice] + sumar(lista, indice + 1);
    }

    public static void main(String[] args) {
        int[] datos = {1, 2, 3, 4, 5};
        System.out.println("La suma es: " + sumar(datos, 0));
    }
}
```