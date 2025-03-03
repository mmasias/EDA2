# Introducción

## ¿Por qué?

La recursividad surge como una respuesta natural a problemas fundamentales en matemáticas y computación. Su origen en la programación se encuentra estrechamente vinculado a varios factores históricos y conceptuales:

- **Raíces matemáticas**: La recursividad tiene sus orígenes en la matemática, donde muchas definiciones y funciones se expresan naturalmente en términos de sí mismas. Por ejemplo, la función factorial, las series de Fibonacci o el algoritmo de Euclides ya se definían recursivamente mucho antes de la existencia de las computadoras.
- **Desarrollo del cálculo lambda**: Con el trabajo de Alonzo Church en los años 1930, el cálculo lambda formalizó la idea de funciones recursivas, estableciendo las bases teóricas para los lenguajes funcionales y la recursividad en programación.
- **Aparición de LISP**: En 1958, John McCarthy desarrolló LISP, uno de los primeros lenguajes de programación que incorporó la recursividad como mecanismo fundamental. LISP fue diseñado para procesar listas (su nombre deriva de "LISt Processing"), estructuras que se manejan naturalmente de forma recursiva.
- **Limitaciones de la iteración**: Se observó que ciertos problemas resultaban extremadamente complejos de resolver mediante enfoques iterativos tradicionales, especialmente aquellos relacionados con estructuras de datos jerárquicas o problemas que requieren backtracking.
- **Adecuación natural a ciertos dominios**: La recursividad emerge como solución idónea para trabajar con estructuras inherentemente recursivas: árboles (como expresiones algebraicas, estructuras sintácticas, jerarquías), recorridos en grafos, y problemas que siguen el patrón "dividir y conquistar".
- **Abstracción y modularidad**: La recursividad permite expresar soluciones a nivel conceptual más alto, más cercano a la definición matemática de los problemas, facilitando el razonamiento sobre algoritmos complejos.

A pesar de su reputación intimidante, la recursividad se basa en dos conceptos sencillos: llamadas a funciones y estructuras de datos de pila. La dificultad no reside en la complejidad del concepto, sino en la forma en que interactúa con mecanismos "invisibles" para el programador, como la pila de llamadas que se gestiona automáticamente durante la ejecución.

## ¿Qué?

La recursión puede definirse desde diferentes perspectivas:

<div align=center>

|Definición general|En programación|
|-|-|
|Una cosa recursiva es aquella cuya definición incluye a sí misma.|Una función recursiva es aquella que se llama a sí misma durante su ejecución.|
|Es una definición auto-referencial.|Esta auto-referencia debe tener condiciones específicas para evitar problemas.|

</div>

## ¿Para qué?

La recursión se utiliza para diversos propósitos prácticos en programación:

- **Simplificar problemas complejos**: Dividir un problema grande en instancias más pequeñas y similares del mismo problema.
- **Recorrer estructuras de datos jerárquicas**: Árboles, grafos y estructuras anidadas se recorren naturalmente de forma recursiva.
- **Implementar algoritmos elegantes**: Muchos algoritmos clásicos como QuickSort, MergeSort, recorrido de árboles binarios, etc., tienen implementaciones recursivas claras.
- **Resolver problemas matemáticos**: Cálculos como factorial, secuencia de Fibonacci, o el algoritmo de Euclides se expresan naturalmente mediante recursión.
- **Backtracking**: Problemas como el de las N-Reinas, generación de permutaciones o solución de laberintos utilizan recursión para explorar diferentes caminos.

La recursión es especialmente útil cuando un problema puede descomponerse en subproblemas más pequeños de la misma naturaleza, y cuando esos subproblemas a su vez pueden descomponerse de la misma manera.

## ¿Cómo?

### Definiciones esenciales

Para entender la recursión, es necesario comprender dos conceptos clave:

1. **Caso base**: Es la condición que detiene la recursión. Cuando se cumple, la función no hace más llamadas recursivas y simplemente retorna un valor. Sin un caso base, la recursión nunca terminaría (causando un "stack overflow").

2. **Caso recursivo**: Es la parte donde la función se llama a sí misma, normalmente con argumentos diferentes o avanzando hacia el caso base.

### La pila de llamadas (call stack)

Para comprender completamente cómo funciona la recursión, es fundamental entender el "call stack":

- Cada vez que se llama a una función, se crea un "frame" (marco) que se coloca en la pila.
- Este frame contiene:
  - La dirección de retorno (a dónde volver cuando termine la función)
  - Los argumentos pasados a la función
  - Las variables locales creadas durante la ejecución de la función
- Cuando la función termina, su frame se elimina de la pila y la ejecución vuelve al punto desde donde se llamó.
- Si una función se llama a sí misma repetidamente sin retornar, la pila crece hasta que se produce un "stack overflow" (desbordamiento de pila).

<div align=center>

<table>
<tr>
<td valign=top>

```java
public class Example {
    public static void a() {
        String spam = "Ant";
        System.out.println("spam is " + spam);
        b();
        System.out.println("spam is " + spam);
    }
    
    public static void b() {
        String spam = "Bobcat";
        System.out.println("spam is " + spam);
        c();
        System.out.println("spam is " + spam);
    }
    
    public static void c() {
        String spam = "Coyote";
        System.out.println("spam is " + spam);
    }
    
    public static void main(String[] args) {
        a();
    }
}
```
</td>
<td valign=top>

```
spam is Ant
spam is Bobcat
spam is Coyote
spam is Bobcat
spam is Ant
```
</td>
</tr>
</table>

|![](/images/callStack.webp)
|:-:
|El estado de la pila de llamadas mientras se ejecuta el programa `Example.java`
|![](/images/callStackOverflow.webp)
|Un desbordamiento de pila ocurre cuando la pila de llamadas se vuelve demasiado alta y demasiados objetos *marco* ocupan la memoria.


<table>
<tr>
<td valign=top>

```java
public class Shortest {
    public static void shortest() {
        shortest();
    }
    
    public static void main(String[] args) {
        shortest();
    }
}
```
</td>
<td valign=top>

```
Exception in thread "main" java.lang.StackOverflowError
    at Shortest.shortest(Shortest.java:3)
    at Shortest.shortest(Shortest.java:3)
    at Shortest.shortest(Shortest.java:3)
    at Shortest.shortest(Shortest.java:3)
    at Shortest.shortest(Shortest.java:3)
    ...
    
```
</td>
</tr>
</table>

</div>

### 🚬

```java
public static void cuentaAtrasAdelante(int number) {

    System.out.println(number);

    if (number == 0) {
        System.out.println("Llegamos al caso base.");
        return;
    }
    else {
        cuentaAtrasAdelante(number - 1);
        System.out.println(number + " volviendo");
    }
}
```

<details>

<summary>Detalle de operaciones para cuentaAtrasAdelante(3)</summary>

<div align=center>

|Fase de descenso|Caso base|Fase de ascenso|
|:-:|:-:|:-:|
|3
|2
|1
|0
||Llegamos al caso base.||
|||1 volviendo
|||2 volviendo
|||3 volviendo

</div>

</details>

Para implementar correctamente una función recursiva, deben seguirse estos pasos:

1. **Identificar el caso base**: Se debe definir claramente cuándo la recursión debe detenerse. Esta es la condición más simple del problema que puede resolverse directamente.
1. **Definir el caso recursivo**: Es necesario formular cómo el problema se reduce a una instancia más pequeña de sí mismo.
1. **Garantizar el progreso**: Cada llamada recursiva debe acercarse al caso base, reduciendo el tamaño o la complejidad del problema.
1. **Unificar las soluciones**: Se debe determinar cómo combinar los resultados de las llamadas recursivas para obtener la solución del problema original.

### Consideraciones importantes

- **Verificación del caso base**: Es crucial asegurarse de que todas las llamadas recursivas eventualmente lleguen al caso base.
- **Profundidad de recursión**: Debe tenerse en cuenta la limitación del tamaño de la pila de llamadas en el entorno de ejecución.
- **Eficiencia**: A veces, las soluciones recursivas pueden ser menos eficientes que las iterativas debido a la sobrecarga de las llamadas a funciones.
- **Recursión de cola**: Un tipo especial de recursión donde la llamada recursiva es la última operación en la función, lo que permite optimizaciones en algunos lenguajes.
- **Memorización**: Técnica para almacenar resultados intermedios y evitar cálculos redundantes en funciones recursivas.
