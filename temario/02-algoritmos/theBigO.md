# Big O

## ¿Por qué?

A medida que desarrollamos (o elegimos) algoritmos para proyectos maś complejos, es crucial poder prever cómo el rendimiento de un programa puede cambiar con el tamaño de los datos procesados. Necesitamos una forma de entender y comunicar el impacto que tendrá uno u otro algoritmo en términos de tiempo de ejecución y uso de memoria, especialmente en casos extremos o a gran escala.

Por ejemplo, consideremos tres algoritmos diferentes para el mismo problema. La siguiente tabla muestra el número de operaciones básicas que realizaría cada algoritmo según el tamaño de la entrada:

|Tamaño de entrada (n)|Operaciones O(n)|Operaciones O(log n)|Operaciones O(n²)|
|-|-|-|-|
|10|10|3.32|100|
|100|100|6.64|10,000|
|1,000|1,000|9.97|1,000,000|
|10,000|10,000|13.29|100,000,000|

Esta consideración impacta en:

|Escala|Recursos|UX|
|-|-|-|
|Lo que funciona bien para 100 elementos puede ser inaceptablemente lento para 1,000,000|Los recursos computacionales (tiempo, memoria) son finitos y costosos|La diferencia entre un algoritmo eficiente y uno ineficiente puede ser la diferencia entre una aplicación útil y una inutilizable|

## ¿Qué?

La notación Big O es una herramienta matemática utilizada en ciencias de la computación para describir la complejidad de un algoritmo, expresando cómo el tiempo de ejecución o el espacio de memoria requerido por un algoritmo crece en relación con el tamaño de la entrada.

Se enfoca en el crecimiento a largo plazo, permitiendo comparar la eficiencia de diferentes algoritmos de una manera que es independiente de las variaciones de hardware o implementación específica. Permite pues:

|Describir el crecimiento|Comparar algoritmos|Identificar el peor caso|
|-|-|-|
|Cómo aumenta el tiempo de ejecución o uso de memoria cuando crece el tamaño de la entrada|De manera independiente del hardware o implementación específica|Enfocando en el comportamiento del algoritmo en su escenario más desfavorable|

## ¿Para qué?

|Eficiencia|Rendimiento|Escalabilidad|
|-|-|-|
|Facilita la comparación entre algoritmos para elegir el más adecuado basado en su comportamiento esperado con grandes volúmenes de datos.|Identifica cuellos de botella y guía el proceso de optimización al mostrar dónde se ganará más reduciendo la complejidad.|Ayuda a entender cómo un algoritmo manejará un aumento en el tamaño de los datos, lo cual es vital para sistemas que deben ser capaces de escalar.|

## ¿Cómo?

Para aplicar la notación Big O en la práctica, se sigue un proceso de identificación del peor escenario posible, simplificación de la fórmula de complejidad para resaltar el [término dominante](terminoDominante.md), y clasificación del algoritmo en una categoría de complejidad.

Este análisis permite a los desarrolladores entender y predecir el rendimiento de los algoritmos en diferentes condiciones, facilitando decisiones informadas sobre diseño e implementación.

- **Evaluar el peor caso**: Analizar el escenario más desfavorable en términos de tiempo o espacio.
- **Simplificar la expresión**: Reducir la fórmula de complejidad al término que más crece con el tamaño de la entrada, ignorando constantes y términos menores.
- **Clasificar la complejidad**: Usar la notación para categorizar la complejidad del algoritmo, como O(1), O(n *log n*), O(n²), etc., basándose en la expresión simplificada.

[Categorías principales de complejidad](categorias.md)

### Identificación en la práctica

- **Conteo de operaciones**: Para identificar la complejidad, se cuenta cómo crece el número de operaciones necesarias a medida que aumenta N. Si el número de operaciones se duplica cada vez que añades un elemento, se piensa en O(2^N). Si el crecimiento parece relacionarse con el cuadrado o el cubo del tamaño de entrada, se piensa en O(N²) o O(N³), respectivamente.
- **Estructura del algoritmo**: Examinar la estructura del algoritmo: la presencia de bucles anidados o llamadas recursivas múltiples suele ser un indicador claro de la complejidad.
- **Divide y vencerás**: Los algoritmos de divide y vencerás que parten el problema en mitades (o fracciones constantes) tienden a tener una complejidad O(log N), especialmente si se resuelve una mitad a la vez o si la combinación de soluciones es lineal o logarítmica.

La identificación precisa de la complejidad algorítmica a menudo requiere descomponer el algoritmo en sus componentes básicos y analizar cómo cada parte contribuye al rendimiento general en función del tamaño de entrada.

<div align="center">

|[sumArray](ejemploA.md)|[Búsqueda binaria](ejemploB.md)|[findMax](ejemploC.md)|
|:-:|:-:|:-:|
|O(N)|O(log N)|O(N)|

</div>

### ¿Y ahora qué?

Para profundizar en el análisis de algoritmos, se propone:

#### Recursos adicionales

- Visualizadores de algoritmos:
  - https://visualgo.net/en
  - https://algorithm-visualizer.org/
  - https://www.toptal.com/developers/sorting-algorithms
- Problemas de práctica.
- Literatura recomendada.

#### Próximos pasos

- Análisis de espacio vs tiempo.
- Estructuras de datos avanzadas.
- Técnicas de optimización.

#### Consideraciones prácticas

- Compromisos en el mundo real.
- Cuando la optimización prematura es el enemigo.
- Equilibrio entre legibilidad y rendimiento.
- ¡Practicar! [Con](https://github.com/puntoReflex/.github/blob/viajeMarco/EDA2/BigO/retos%26proyectos/viajeMarco/src/vEDA2/README.md) [nuestros](https://github.com/puntoReflex/pyCCCF/blob/EDA2/src/vEDA2/README.md) [ejemplos](https://github.com/puntoReflex/pyAspiradora/blob/vEDA2/src/vEDA2/README.md).
