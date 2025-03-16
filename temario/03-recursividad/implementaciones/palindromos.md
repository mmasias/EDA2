# Detección recursiva de palíndromos

## ¿Por qué?

La detección de palíndromos (palabras o frases que se leen igual de izquierda a derecha que de derecha a izquierda) presenta un problema interesante donde la naturaleza del procesamiento requiere comparar caracteres ubicados en extremos opuestos de una cadena.

Los enfoques de verificación de palíndromos mediante bucles resultan más intuitivos y eficientes, pero limitan la comprensión de ciertas propiedades simétricas fundamentales. El problema en sí mismo posee una definición naturalmente recursiva: una cadena es palíndromo si sus extremos coinciden y su interior también es palíndromo.

Las implementaciones iterativas, aunque más eficientes, no capturan la elegancia conceptual de esta definición recursiva ni permiten analizar los patrones de verificación bidireccional con la misma claridad estructural que ofrece el enfoque recursivo.

## ¿Qué?

La detección recursiva de palíndromos consiste en verificar si una cadena de texto se lee igual en ambas direcciones, utilizando recursión para reducir progresivamente la cadena desde ambos extremos hacia el centro. Un palíndromo puede definirse recursivamente como:

1. Una cadena vacía o de un solo carácter es siempre un palíndromo (caso base).
1. Una cadena es palíndromo si y solo si su primer y último caracteres son iguales, y la subcadena entre ellos también es un palíndromo.

Esta definición recursiva se traduce naturalmente en un algoritmo que verifica los extremos y luego recursa hacia el interior.

## ¿Para qué?

La implementación recursiva de detección de palíndromos proporciona:

1. **Demostración de variante recursiva**: Presenta una técnica que no sigue estrictamente el patrón cabeza-cola, sino que trabaja simultáneamente desde ambos extremos hacia el centro.
1. **Aprovechamiento de cortocircuito booleano**: Muestra cómo la evaluación lógica de corto circuito puede optimizar la recursión, evitando llamadas innecesarias cuando se detecta la primera discrepancia.
1. **Transformación conceptual**: Ilustra cómo un problema aparentemente secuencial puede replantearse siguiendo un enfoque que divide el problema desde los extremos hacia el centro.
1. **Procesamiento recursivo mixto**: Ejemplifica un caso donde el algoritmo combina elementos de evaluación temprana (comparación de extremos) y tardía (verificación del interior).
1. **Fundamento para algoritmos avanzados**: Proporciona una base para entender algoritmos más complejos que requieren comparaciones de caracteres en posiciones opuestas (como comparación de cadenas con errores tolerados).
1. **Introducción a análisis simétricos**: Establece un patrón de verificación bidireccional aplicable a diversos problemas de procesamiento de texto y estructuras de datos.
1. **Puente hacia problemas de subcadenas**: Sirve como introducción conceptual a algoritmos más avanzados como distancia de edición o coincidencia de patrones.

## ¿Cómo?

Para implementar la detección recursiva de palíndromos en Java, se debe seguir esta estructura:

```java
public class DeteccionPalindromos {
    
    public static boolean esPalindromo(String texto) {
        // Casos base: cadena vacía o de un solo carácter
        if (texto.length() <= 1) {
            return true;
        } else {
            // Extraer primer y último caracteres
            char primero = texto.charAt(0);
            char ultimo = texto.charAt(texto.length() - 1);
            
            // Extraer la subcadena interior (sin el primero ni el último carácter)
            String interior = texto.substring(1, texto.length() - 1);
            
            // Verificar si los extremos coinciden Y si el interior es palíndromo
            return primero == ultimo && esPalindromo(interior);
        }
    }
    
    public static void main(String[] args) {
        String[] pruebas = {"racecar", "amanaplanacanalpanama", "tacocat", "zophie"};
        
        for (String texto : pruebas) {
            System.out.println(texto + " es palíndromo: " + esPalindromo(texto));
        }
    }
}
```

### Análisis del algoritmo

#### Identificación del caso base y casos recursivos

- **Casos base**: Una cadena vacía o de un solo carácter, que siempre es palíndromo.
- **Caso recursivo**: Verificar si los caracteres extremos coinciden y si la subcadena interior es palíndromo.

#### Convergencia

La cadena se reduce en dos caracteres (uno de cada extremo) en cada llamada recursiva, garantizando que eventualmente se alcance alguno de los casos base.

#### Cortocircuito booleano

La expresión `primero == ultimo && esPalindromo(interior)` utiliza cortocircuito booleano: si los caracteres extremos no coinciden, la evaluación se detiene inmediatamente y retorna `false` sin realizar la llamada recursiva.

#### Patrón de procesamiento mixto

Este algoritmo combina:

- Procesamiento temprano (evaluación de `primero == ultimo`)
- Procesamiento tardío (llamada recursiva a `esPalindromo(interior)`)

#### Funcionamiento de la pila de llamadas

Para la cadena `"racecar"`, la pila de llamadas evoluciona así:

1. `esPalindromo("racecar")` → primero='r', ultimo='r', interior="aceca"
1. `esPalindromo("aceca")` → primero='a', ultimo='a', interior="cec"  
1. `esPalindromo("cec")` → primero='c', ultimo='c', interior="e"
1. `esPalindromo("e")` → retorna true (caso base)
1. Retroceso en cascada: true && true && true = true

### Consideraciones de eficiencia

La implementación recursiva de detección de palíndromos presenta:

1. **Eficiencia espacial**: Cada llamada recursiva crea una nueva subcadena, resultando en uso de memoria O(n²) donde n es la longitud de la cadena.
1. **Eficiencia temporal**: La creación de subcadenas añade una complejidad temporal de O(n²), comparada con O(n) de la versión iterativa.
1. **Terminación temprana**: El cortocircuito booleano proporciona una optimización significativa, deteniendo la recursión en cuanto se encuentra la primera discrepancia.

### Versión iterativa equivalente

```java
public static boolean esPalindromoIterativo(String texto) {
    int inicio = 0;
    int fin = texto.length() - 1;
    
    while (inicio < fin) {
        if (texto.charAt(inicio) != texto.charAt(fin)) {
            return false;
        }
        inicio++;
        fin--;
    }
    return true;
}
```
