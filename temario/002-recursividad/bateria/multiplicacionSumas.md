# multiplicacionSumas

Calcular el producto de dos números usando solo sumas.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||a,b|f(a,b)|
|-|-:|-:|
CB|5,0|0
...
CR|5,1|5 = 5 + 0
CR|5,2|10 = 5 + 5
CR|5,3|15 = 5 + 10
n-1|5,4|20 = 5 + 15
n|5,5|25 = 5 + 20

a + f(a,b-1)

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION multiplicar(a, b)

    SI b es 0 ENTONCES
        Devolver 0
    FIN SI

    Devolver a + multiplicar(a, b - 1)

FIN FUNCIÓN
```

</details>

<details>
<summary>Ver código Java</summary>

```java
public class MultiplicacionSumas {

    public static int multiplicar(int a, int b) {
        if (b == 0) {
            return 0;
        }

        return a + multiplicar(a, b - 1);
    }

    public static void main(String[] args) {
        System.out.println("5 × 5 = " + multiplicar(5, 5));  // 25
        System.out.println("3 × 7 = " + multiplicar(3, 7));  // 21
        System.out.println("8 × 0 = " + multiplicar(8, 0));  // 0
    }
}
```

</details>
