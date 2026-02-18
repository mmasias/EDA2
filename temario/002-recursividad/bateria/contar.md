# contar

Generar una cadena con los números desde 0 hasta n, separados por comas.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|0
...
n-1|4|1,2,3,4
n|5|1,2,3,4,5

f(n-1) & n

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contar(n)

    SI n es 0 ENTONCES
        Devolver "0"
    FIN SI

    Devolver contar(n - 1) + ", " + n

FIN FUNCIÓN
```

</details>

<details>
<summary>Ver código Java</summary>

```java
public class Contar {

    public static String contar(int n) {
        if (n == 0) {
            return "0";
        }

        return contar(n - 1) + ", " + n;
    }

    public static void main(String[] args) {
        System.out.println(contar(5));
    }
}
```

</details>
