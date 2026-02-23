# invertirCadena

Invertir una cadena de texto dada.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|""|""
...
...
...
n-1|"bcd"|"dcb"
n|"abcd"|"dcba"

f(n-1) + cabeza

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION invertirCadena(cadena)

    SI longitud(cadena) es 0 ENTONCES
        Devolver ""
    FIN SI

    cabeza = primer carácter de cadena
    resto = subcadena desde la posición 1 hasta el final

    Devolver invertirCadena(resto) + cabeza

FIN FUNCIÓN
```

</details>

<details>
<summary>Ver código Java</summary>

```java
public class InvertirCadena {

    public static String invertir(String cadena) {
        if (cadena.isEmpty()) {
            return "";
        }

        char cabeza = cadena.charAt(0);
        String resto = cadena.substring(1);

        return invertir(resto) + cabeza;
    }

    public static void main(String[] args) {
        System.out.println("Invertido: " + invertir("abcd")); // Imprime "dcba"
    }
}
```

</details>
