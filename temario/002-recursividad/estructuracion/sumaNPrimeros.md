# sumaNPrimeros

Calcular la suma de los n primeros números enteros positivos.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|0
...
...
...
n-1|4|10
n|5|15

n + f(n-1)

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION sumaNPrimeros(n)

    SI n es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver n + sumaNPrimeros(n - 1)

FIN FUNCIÓN
```

</details>

<details>
<summary>Ver código Java</summary>

```java
public class SumaNPrimeros {

    public static int calcular(int n) {
        if (n == 0) {
            return 0;
        }

        return n + calcular(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Suma de los 5 primeros: " + calcular(5));
    }
}
```

</details>