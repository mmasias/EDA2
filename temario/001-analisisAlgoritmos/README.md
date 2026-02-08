# 001. Análisis de algoritmos

## ¿Por qué?

Habiendo aprendido a construir programas que funcionan correctamente, es pertinente abordar la siguiente pregunta: ***¿qué tan bien funcionan?*** Un algoritmo que resuelve un problema para cientos de elementos puede volverse inusable cuando la entrada crece a millones.

La medición directa del tiempo de ejecución (en segundos) es insuficiente: depende del hardware, del sistema operativo, de la carga del momento en que se ejecuta... Dos ejecuciones del mismo algoritmo en máquinas distintas arrojan resultados diferentes, aunque el algoritmo sea idéntico.

Para hacer comparaciones significativas, es necesario un marco de referencia independiente del hardware. Esto requiere contar operaciones en función del tamaño de la entrada y entender qué constituye dicha entrada: la longitud de un array, la cantidad de nodos en un árbol, el número de bits de un entero.

Del mismo modo, no basta con conocer el comportamiento promedio: en ingeniería se requiren garantías. El peor caso —aunque parezca pesimista— es la única medida que permite asegurar que un sistema no colapsará bajo condiciones adversas. El caso promedio describe la realidad estadística, pero es difícil de probar. El mejor caso es una ilusión que ofrece poco valor para el diseño robusto.

## ¿Qué?

La notación asintótica es el lenguaje matemático que permite describir el comportamiento de un algoritmo ***cuando el tamaño de la entrada tiende a infinito***. Establece categorías de complejidad que hacen posible comparar algoritmos de manera abstracta, sin atarse a implementaciones específicas.

<div align=center>

|Big O (O)|Big Omega (Ω)|Big Theta (Θ)|
|-|-|-|
|Cota superior.|Cota inferior.|Cota ajustada.
|Describe el peor escenario posible: el algoritmo "no será más lento que esto".|Describe el mejor escenario posible: el algoritmo "al menos tardará esto".|Cuando Big O y Big Omega coinciden, se tiene una caracterizacion precisa del algoritmo.
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
|O(2ⁿ) / O(n!)|Exponencial / Factorial|Probar todas las combinaciones de una cerradura|

</div>

O(log n) es más eficiente que O(n), que a su vez es más eficiente que O(n²). O(n log n) se considera el límite práctico para algoritmos de ordenación por comparación.

## Para qué?

El análisis de complejidad permite dos capacidades fundamentales: categorizar estrategias algorítmicas y evaluar compromisos en el diseño.

**Categorización de paradigmas**

Los algoritmos pueden clasificarse en familias según la estrategia que emplean para resolver problemas:

<div align=center>

|Paradigma|Descripción|Ejemplo(s)|
|-|-|-|
|**Fuerza bruta**|Probar todas las posibilidades. Simple pero ineficiente.|Búsqueda lineal.
|**Divide y vencerás**|Partir el problema en subproblemas más pequeños, resolverlos recursivamente y combinar las soluciones.|MergeSort, QuickSort, árboles de búsqueda.
|**Voraces (Greedy)**|Tomar la mejor decisión local en cada paso, esperando que lleve a una solución global óptima.|Algoritmos de grafos y rutas más cortas.
|**Vuelta atrás (Backtracking)**|Explorar el espacio de soluciones mediante búsqueda sistemática con retroceso cuando una rama no es viable.|Laberintos, resolución de Sudoku.
|**Programación dinámica**| Descomponer un problema en subproblemas superpuestos y almacenar resultados intermedios para evitar recalcular. Optimiza la recursividad mediante *memoization*.

</div>

Esta clasificación será el hilo conductor del resto del curso.

**Evaluación de compromisos**

El análisis de complejidad nos permite abordar decisiones de diseño donde no existe solución perfecta:

- **Tiempo vs. Espacio**: Usar más memoria permite ganar velocidad. Hashing ofrece O(1) a costa de espacio adicional; algoritmos in-place ahorran memoria pero pueden ser más lentos.
- **Legibilidad vs. Micro-optimización**: No todo código requiere optimización extrema. Una solución O(n²) puede ser perfectamente adecuada para datos que nunca excederán los 100 elementos. La legibilidad y mantenibilidad tienen valor.

Saber cuándo optimizar es tan importante como saber cómo hacerlo.

## Cómo?

El análisis de complejidad se realiza contando operaciones elementales en función del tamaño de la entrada n.

**Ejemplos de implementación**

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

**Análisis de algoritmos iterativos**

- **Sentencias secuenciales**: Las complejidades se suman. Si una parte hace O(n) y otra O(log n), el total es O(n + log n) = O(n).
- **Bucles independientes**: Las complejidades se multiplican. Un bucle externo O(n) que contiene un bucle interno O(n) resulta en O(n × n) = O(n²).
- **Bucles dependientes**: Cuando el bucle interno depende del índice del externo (ej: `for i in 0..n; for j in 0..i`), se utiliza sumatorias. Este caso genera la serie aritmética 1 + 2 + 3 + ... + n = n(n+1)/2 = O(n²).

**Análisis de algoritmos recursivos**

La recursividad se analiza visualizando el árbol de llamadas que genera. Cada nivel del árbol representa una expansión del problema, y la altura del árbol determina la complejidad.

Las relaciones de recurrencia formalizan este análisis (ej: T(n) = 2T(n/2) + O(n) para MergeSort). El teorema maestro permite resolver estas relaciones, aunque su tratamiento detallado se abordará en el módulo de Recursividad.

**Complejidad espacial**

El análisis temporal tiene su contraparte en el uso de memoria.

- **Memoria auxiliar**: Es el espacio extra requerido más allá de los datos de entrada. Un algoritmo que duplica un array para procesarlo tiene O(n) de espacio auxiliar.
- **Stack vs. Heap**: La recursividad consume espacio en el stack de llamadas. Cada llamada recursiva añade un *frame*, y el acumulado puede causar *stack overflow* si la recursividad es excesiva.
- **Algoritmos in-place**: Son aquellos que operan con O(1) de espacio auxiliar, mutando la entrada directamente. Compromiso: ganan eficiencia espacial pero pierden las ventajas de la inmutabilidad.
