# contarApariciones

Contar cuántas veces aparece una letra en una cadena de texto.

<details>
<summary>Ver análisis recursivo</summary>

<div align=center>

||n|f(n)|
|-|-|-|
CB|"",a|0
...
...
...
n-1|"da"|1
n|"ada"|2
...
n-1|"cdada"|2
n|"bcdada"|2

cabeza != letra ==> f(n-1)

cabeza == letra ==> 1 + f(n-1)

</div>

</details>

## Pseudocódigo & código

<details>
<summary>Ver pseudocódigo</summary>

```text
FUNCION contarApariciones(cadena, letra)

    SI cadena está vacía ENTONCES
        Devolver 0
    FIN SI

    cabeza = primer carácter de cadena
    resto = subcadena desde posición 1 hasta el final

    SI cabeza es igual a letra ENTONCES
        Devolver 1 + contarApariciones(resto, letra)
    SI NO
        Devolver contarApariciones(resto, letra)
    FIN SI

FIN FUNCIÓN
```

</details>

<details>
<summary>Ver código Java</summary>

```java
public class ContarApariciones {

    public static int contar(String cadena, char letra) {
        if (cadena.isEmpty()) {
            return 0;
        }

        char cabeza = cadena.charAt(0);
        String resto = cadena.substring(1);

        if (cabeza == letra) {
            return 1 + contar(resto, letra);
        } else {
            return contar(resto, letra);
        }
    }

    public static void main(String[] args) {
        System.out.println("Apariciones de 'a' en 'bcdada': " + contar("bcdada", 'a'));
    }
}
```

</details>
