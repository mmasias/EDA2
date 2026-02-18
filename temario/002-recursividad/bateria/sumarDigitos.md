# sumarDigitos

Calcular la suma de todos los dígitos de un número entero.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|5|5
...
...
...
n-1|5342|14
n|53421|15

cabeza + f(n-1)

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
función sumaDigitos(n):
    SI n < 10:
        retornar n
    FIN SI

    numeroDeDígitos = contar_dígitos(n)
    divisor = 10^(numeroDeDígitos - 1)
    primerDígito = n / divisor
    resto = n % divisor

    retornar primerDígito + sumaDigitos(resto)
```

</details>

<details>
<summary>Ver código Java</summary>

```java
public class SumarDigitosMath {

    public static int sumar(int n) {
        if (n < 10) {
            return n;
        }

        int numeroDeDigitos = contarDigitos(n);
        int divisor = (int) Math.pow(10, numeroDeDigitos - 1);

        int primerDigito = n / divisor;
        int resto = n % divisor;

        return primerDigito + sumar(resto);
    }

    private static int contarDigitos(int n){
        if (n == 0){
            return 1;
        }
        int numeroDeDigitos = 0;
        while (n != 0) {
            n = n / 10;
            numeroDeDigitos++;
        }
        return numeroDeDigitos;
    }

    public static void main(String[] args) {
        System.out.println("Suma de 12345: " + sumar(12345));
    }
}
```

</details>
