# 001. Análisis de algoritmos

## ¿Por qué?

Los algoritmos son procedimientos o fórmulas para resolver problemas. Pueden ser tan simples como un procedimiento de suma o tan complejos como el algoritmo que subyace a un motor de búsqueda en Internet. Los algoritmos se definen por su claridad, precisión y la finitud de sus pasos. (Visto en [Programación 1](https://github.com/mmasias/PRG1/blob/main/temario/00100-algoritmos.md))

Habiendo aprendido a construir programas que funcionan correctamente, es pertinente abordar la siguiente pregunta: ***¿qué tan bien funcionan?*** Un algoritmo que resuelve un problema para cientos de elementos puede volverse inusable cuando la entrada crece a millones.

> [*¿Por qué importa cómo organizamos los datos?*](articulos/organizacionImporta.md).

## ¿Qué?

El análisis de algoritmos es la disciplina que estudia cómo medir y comparar el rendimiento de las soluciones computacionales. Proporciona un marco teórico —la notación asintótica— y herramientas prácticas para evaluar la eficiencia de manera independiente del hardware, permitiendo así tomar decisiones fundamentadas sobre qué algoritmo usar para un problema dado.

## Para qué?

Se hace necesario pues:

- **Predecir** el rendimiento de los algoritmos en diferentes condiciones.
- **Elegir** el algoritmo más eficiente y adecuado para una tarea específica, optimizando recursos.
- **Diseñar y desarrollar** soluciones de software escalables que puedan manejar un crecimiento en el volumen de datos sin degradar significativamente el rendimiento.

### Evaluación de compromisos

El análisis de complejidad nos permite abordar decisiones de diseño donde no existe solución perfecta:

- **Tiempo vs. Espacio**: Usar más memoria permite ganar velocidad. Hashing ofrece velocidad a cambio de uso de espacio adicional; algoritmos in-place ahorran memoria pero pueden ser más lentos.
- **Legibilidad vs. Micro-optimización**: No todo código requiere optimización extrema. Una solución "lenta" puede ser perfectamente adecuada para datos que nunca excederán los 100 elementos. La legibilidad y mantenibilidad tienen valor.

> *Saber cuándo optimizar es tan importante como saber cómo hacerlo.*

## Cómo?

### El problema de la medición

La medición directa del tiempo de ejecución (en segundos) es insuficiente: depende del hardware, del sistema operativo, de la carga del momento en que se ejecuta... Dos ejecuciones del mismo algoritmo en máquinas distintas arrojan resultados diferentes, aunque el algoritmo sea idéntico.

Para hacer comparaciones significativas, **es necesario un marco de referencia independiente del hardware**. Esto requiere contar operaciones en función del tamaño de la entrada y entender qué constituye dicha entrada: la longitud de un array, la cantidad de nodos en un árbol, el número de bits de un entero.

Del mismo modo, no basta con conocer el comportamiento promedio: **en ingeniería se requiren garantías**.

<div align=center>

|El mejor caso|El caso promedio|El peor caso|
|:-:|:-:|:-:|
Es una ilusión que ofrece poco valor para un diseño robusto.|Describe la realidad estadística, pero es difícil de probar.|Aunque parezca pesimista es la única medida que permite asegurar que un sistema no colapsará bajo condiciones adversas.

</div>

### La notación asintótica: herramienta de análisis

La notación asintótica es el lenguaje matemático que permite describir el comportamiento de un algoritmo ***cuando el tamaño de la entrada tiende a infinito***. Establece categorías de complejidad que hacen posible comparar algoritmos de manera abstracta, sin atarse a implementaciones específicas.

<div align=center>

|Big O (O)|Big Omega (Ω)|Big Theta (Θ)|
|-|-|-|
|Cota superior.|Cota inferior.|Cota ajustada.
|Describe el peor escenario posible: el algoritmo "no será más lento que esto".|Describe el mejor escenario posible: el algoritmo "al menos tardará esto".|Cuando Big O y Big Omega coinciden, se tiene una caracterizacion **precisa** del algoritmo.
|Es la medida estándar en ingeniería porque ofrece una garantía de rendimiento.|Establece un límite inferior de rendimiento.|

</div>

Se puede pues establecer un ranking de eficiencia:

<div align=center>

|Complejidad|Categoría|Ejemplo cotidiano|
|-|-|-|
|O(1)|Constante|Acceder a página conocida del libro; mirar el reloj|
|O(log n)|Logarítmica|Buscar palabra en diccionario (abrir por mitad)|
|O(n)|Lineal|Leer libro página por página; contar personas en fila|
|O(n log n)|Lineal-logarítmica|Organizar mazo de cartas por grupos (divide y ordena)|
|O(n²)|Cuadrático|Comparar cada persona con todas las demás (saludos en fiesta)|
|O(2ⁿ)<br><br>O(n!)|Exponencial<br><br>Factorial|Probar todas las combinaciones de una cerradura|

</div>


> [Paradigmas](articulos/paradigmas.md)

### Metodología de análisis

<div align=center>

|Análisis del problema|Diseño de la solución|Evaluación de la eficiencia|
|-|-|-|
|Identificar claramente los datos de entrada y la salida esperada|Descomponer el problema en subproblemas más pequeños|Analizar el tiempo de ejecución esperado|
|Determinar las restricciones y casos especiales|Identificar patrones y estructuras de datos apropiadas|Considerar el uso de memoria|
|Considerar el volumen de datos a manejar|Considerar diferentes enfoques (iterativo vs recursivo, etc.)|Identificar posibles cuellos de botella|

</div>

El análisis de complejidad se realiza contando operaciones elementales en función del tamaño de la entrada n.

**Análisis de algoritmos iterativos**

- **Sentencias secuenciales**: Las complejidades se suman. Si una parte hace O(n) y otra O(log n), el total es O(n + log n) = O(n).
- **Bucles independientes**: Las complejidades se multiplican. Un bucle externo O(n) que contiene un bucle interno O(n) resulta en O(n × n) = O(n²).
- **Bucles dependientes**: Cuando el bucle interno depende del índice del externo (ej: `for i in 0..n; for j in 0..i`), se utiliza sumatorias. Este caso genera la serie aritmética 1 + 2 + 3 + ... + n = n(n+1)/2 = O(n²).

> **Profundización**: Para un análisis detallado con ejemplos prácticos, simplificación de fórmulas y comparación de algoritmos iterativos, ver [Análisis de algoritmos iterativos](articulos/analisis-iterativos.md).

**Análisis de algoritmos recursivos**

La recursividad se analiza visualizando el árbol de llamadas que genera. Cada nivel del árbol representa una expansión del problema, y la altura del árbol determina la complejidad.

Las relaciones de recurrencia formalizan este análisis (ej: T(n) = 2T(n/2) + O(n) para MergeSort). El teorema maestro permite resolver estas relaciones, aunque su tratamiento detallado se abordará en el módulo de Recursividad.

**Complejidad espacial**

El análisis temporal tiene su contraparte en el uso de memoria.

- **Memoria auxiliar**: Es el espacio extra requerido más allá de los datos de entrada. Un algoritmo que duplica un array para procesarlo tiene O(n) de espacio auxiliar.
- **Stack vs. Heap**: La recursividad consume espacio en el stack de llamadas. Cada llamada recursiva añade un *frame*, y el acumulado puede causar *stack overflow* si la recursividad es excesiva.
- **Algoritmos in-place**: Son aquellos que operan con O(1) de espacio auxiliar, mutando la entrada directamente. Compromiso: ganan eficiencia espacial pero pierden las ventajas de la inmutabilidad.

### Ejemplos de implementación

A continuación se presentan ejemplos en código Java para cada categoría de complejidad:

<div align=center>

|Complejidad|Ejemplo implementado|Código|Documentación|
|-|-|-|-|
|O(1)|Acceso directo, tomar primer elemento|[ComplejidadConstante.java](../../src/001/ComplejidadConstante.java)||
|O(log n)|Búsqueda binaria, adivinar número|[ComplejidadLogaritmica.java](../../src/001/ComplejidadLogaritmica.java)||
|O(n)|Recorrido secuencial, búsqueda lineal|[ComplejidadLineal.java](../../src/001/ComplejidadLineal.java)||
|O(n log n)|MergeSort (dividir y ordenar)|[ComplejidadLinealLogaritmica.java](../../src/001/ComplejidadLinealLogaritmica.java)|[Crecimiento](../../src/001/ComplejidadLinealLogaritmico.md)|
|O(n²)|Saludos en fiesta, ordenación burbuja|[ComplejidadCuadratica.java](../../src/001/ComplejidadCuadratica.java)||
|O(2ⁿ)|Combinaciones binarias, cerradura|[ComplejidadExponencial.java](../../src/001/ComplejidadExponencial.java)|[Crecimiento](../../src/001/ComplejidadExponencial.md)|

</div>

## Dicho esto

**Perspectiva**: Sobre la tensión entre teoría académica y práctica profesional, ver [Compromiso teoría/práctica](articulos/realidad.md).
