# potencias

Calcular 2 elevado a la potencia n.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-:|-|
CB|0|1
...
...
...
n-1|4|16
n|5|32

2 x f(n-1)

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION potencia(n)

    SI n es 0 ENTONCES
        Devolver 1
    FIN SI

    Devolver 2 * potencia(n - 1)

FIN FUNCIÓN
```

</details>

<details>
<summary>Ver código Java</summary>

```java
public class Potencia {

    public static int calcular(int n) {
        if (n == 0) {
            return 1;
        }

        return 2 * calcular(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("2^5 = " + calcular(5));
    }
}
```

</details>