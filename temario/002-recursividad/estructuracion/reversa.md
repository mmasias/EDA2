# contarEnReversa

Generar una cadena con los números desde n hasta 0, en orden descendente.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|0|0
...
n-1|4|4,3,2,1,0
n|5|5,4,3,2,1,0

n & f(n-1)

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarEnReversa(n)

    SI n es 0 ENTONCES
        Devolver "0"
    FIN SI

    Devolver n + ", " + contarEnReversa(n - 1)

FIN FUNCIÓN
```

</details>

<details>
<summary>Ver código Java</summary>

```java
public class ContarEnReversa {

    public static String contar(int n) {
        if (n == 0) {
            return "0";
        }

        return n + ", " + contar(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Cuenta atrás de 5: " + contar(5));
    }
}
```

</details>
