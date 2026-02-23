# filtrarLista

Filtrar una lista manteniendo solo los elementos mayores que un umbral dado.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-:|
CB|[],3|[]
...
n-1|[5],3|[5]
n|[4,5],3|[4,5]
...
n-1|[2,3,4,5],3|[4,5]
n|[1,2,3,4,5],3|[4,5]

Cabeza < 3 ==> f(n-1)

Cabeza > 3 ==> Cabeza + f(n-1)

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION filtrarLista(lista, umbral)

    SI longitud(lista) es 0 ENTONCES
        Devolver lista vacía
    FIN SI

    cabeza = lista[0]
    resto = lista sin el primer elemento

    resultadoResto = filtrarLista(resto, umbral)

    SI cabeza > umbral ENTONCES
        Devolver lista formada por [cabeza] + resultadoResto
    SI NO
        Devolver resultadoResto
    FIN SI

FIN FUNCIÓN
```

</details>

<details>
<summary>Ver código Java</summary>

```java
import java.util.Arrays;

public class FiltrarLista {

    public static int[] filtrar(int[] lista, int umbral) {
        if (lista.length == 0) {
            return new int[0];
        }

        int cabeza = lista[0];
        int[] resto = Arrays.copyOfRange(lista, 1, lista.length);

        int[] resultadoResto = filtrar(resto, umbral);

        if (cabeza > umbral) {
            int[] nuevoResultado = new int[resultadoResto.length + 1];

            nuevoResultado[0] = cabeza;

            for (int i = 0; i < resultadoResto.length; i++) {
                nuevoResultado[i + 1] = resultadoResto[i];
            }
            return nuevoResultado;
        } else {
            return resultadoResto;
        }
    }

    public static void main(String[] args) {
        int[] datos = {1, 2, 3, 4, 5};
        int[] res = filtrar(datos, 3);
        System.out.println(Arrays.toString(res));
    }
}
```

</details>
