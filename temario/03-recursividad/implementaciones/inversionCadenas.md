# Inversión recursiva de cadenas de texto

## ¿Por qué?

Invertir una cadena de texto es una operación frecuente en programación que tradicionalmente se implementa mediante bucles. Sin embargo, esta operación presenta un escenario ideal para ilustrar el paradigma recursivo debido a:

1. La naturaleza lineal de las cadenas permite una descomposición natural en componentes más pequeños (subcadenas).
1. El proceso de inversión puede definirse elegantemente en términos recursivos.
1. Se precisa un ejemplo que demuestre el concepto de "salto de fe" (leap of faith) en implementaciones recursivas.
1. Se requiere una operación donde la combinación de resultados parciales ocurra durante la fase de retorno (backtracking) de la recursión.

Aunque la versión iterativa es más eficiente en la práctica, la implementación recursiva revela patrones de pensamiento valiosos para abordar problemas más complejos.

## ¿Qué?

La inversión recursiva de cadenas consiste en obtener una nueva cadena cuyos caracteres aparecen en orden inverso al de la cadena original. Este problema se aborda mediante la técnica cabeza-cola:

1. **Cabeza (head)**: El primer carácter de la cadena.
1. **Cola (tail)**: El resto de la cadena sin el primer carácter.

La inversión de la cadena original se define recursivamente como la inversión de la cola seguida por la cabeza. Este proceso se aplica repetidamente hasta alcanzar el caso base.

## ¿Para qué?

La implementación recursiva de inversión de cadenas proporciona:

1. Una demostración clara del concepto de "salto de fe" en recursión, fundamental para el pensamiento recursivo.
1. Un ejemplo de cómo la recursión puede producir resultados mediante la combinación de soluciones parciales en la fase de retorno.
1. Una oportunidad para comprender el crecimiento de la pila de llamadas y su impacto en el rendimiento.
1. Una base para analizar cómo los lenguajes de programación manejan las operaciones con cadenas de texto.
1. Un caso de estudio para evaluar cuándo la recursión es o no apropiada para solucionar problemas.

## ¿Cómo?

Para implementar la inversión recursiva de cadenas en Java, se debe seguir esta estructura:

```java
public class InversionRecursiva {
    
    public static String invertir(String texto) {
        // Casos base: Cadena vacía o de un solo carácter
        if (texto.length() <= 1) {
            return texto;
        } else {
            // Caso recursivo:
            // 1. Obtener la cabeza (el primer carácter)
            char cabeza = texto.charAt(0);
            
            // 2. Obtener la cola (el resto de la cadena)
            String cola = texto.substring(1);
            
            // 3. Retornar la inversión recursiva de la cola seguida por la cabeza
            return invertir(cola) + cabeza;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Inversión de 'abcdef': " + invertir("abcdef"));
        System.out.println("Inversión de 'Hola, mundo!': " + invertir("Hola, mundo!"));
        System.out.println("Inversión de '': " + invertir(""));
        System.out.println("Inversión de 'X': " + invertir("X"));
    }
}
```

### Análisis del algoritmo

#### Identificación del caso base y casos recursivos

- **Casos base**: Una cadena vacía o de un solo carácter ya está "invertida".
- **Caso recursivo**: Invertir recursivamente la cola y añadir la cabeza al final.

#### Convergencia

La cadena se reduce en un carácter en cada llamada recursiva, garantizando que eventualmente se alcance alguno de los casos base.

#### El "salto de fe" (leap of faith)

Al implementar el caso recursivo, se confía en que `invertir(cola)` proporcionará correctamente la inversión de la subcadena, sin preocuparse por los detalles de cómo lo hace. Este "salto de fe" es esencial para el pensamiento recursivo.

> Recordar que ya usamos este concepto de "*salto de fe*" cuando usábamos HOOD (a.k.a. *FotB*)

#### Funcionamiento de la pila de llamadas

Para la cadena `"CAT"`, la pila de llamadas evoluciona así:

1. `invertir("CAT")` → cabeza='C', cola="AT"
1. `invertir("AT")` → cabeza='A', cola="T"
1. `invertir("T")` → retorna "T" (caso base)
1. Retroceso: "T" + 'A' = "TA"
1. Retroceso final: "TA" + 'C' = "TAC"

### Consideraciones de eficiencia

La implementación recursiva de inversión de cadenas presenta algunas limitaciones:

1. **Inmutabilidad de cadenas**: En Java, cada concatenación (`invertir(cola) + cabeza`) crea una nueva cadena, lo que resulta en ineficiencia.
1. **Eficiencia espacial**: Cada llamada recursiva añade un marco a la pila de llamadas, resultando en uso de memoria O(n) donde n es la longitud de la cadena.
1. **Eficiencia temporal**: La creación de subcadenas y concatenaciones repetidas tiene una complejidad temporal de O(n²), comparada con O(n) de la versión iterativa.

### Versión iterativa equivalente

```java
public static String invertirIterativo(String texto) {
    StringBuilder invertido = new StringBuilder();
    for (int i = texto.length() - 1; i >= 0; i--) {
        invertido.append(texto.charAt(i));
    }
    return invertido.toString();
}
```

### Implementación alternativa usando StringBuilder

Una implementación más eficiente que reduce la creación de objetos String intermedios:

```java
public static String invertirEficiente(String texto) {
    return new StringBuilder(texto).reverse().toString();
}
```
