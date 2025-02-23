# Big O

## ¿Por qué?

A medida que desarrollamos (o elegimos) algoritmos para proyectos maś complejos, es crucial poder prever cómo el rendimiento de un programa puede cambiar con el tamaño de los datos procesados. Necesitamos una forma de entender y comunicar el impacto que tendrá uno u otro algoritmo en términos de tiempo de ejecución y uso de memoria, especialmente en casos extremos o a gran escala.

Por ejemplo, consideremos tres algoritmos diferentes para el mismo problema. La siguiente tabla muestra el número de operaciones básicas que realizaría cada algoritmo según el tamaño de la entrada:

<div align=center>

|Tamaño de entrada (n)|Operaciones O(n)|Operaciones O(log n)|Operaciones O(n²)|
|-|-|-|-|
|10|10|3.32|100|
|100|100|6.64|10,000|
|1,000|1,000|9.97|1,000,000|
|10,000|10,000|13.29|100,000,000|

</div>

Esta consideración impacta en:

<div align=center>

|Escala|Recursos|UX|
|-|-|-|
|Lo que funciona bien para 100 elementos puede ser inaceptablemente lento para 1,000,000|Los recursos computacionales (tiempo, memoria) son finitos y costosos|La diferencia entre un algoritmo eficiente y uno ineficiente puede ser la diferencia entre una aplicación útil y una inutilizable|

</div>

## ¿Qué?

La notación Big O es una herramienta matemática utilizada en ciencias de la computación para describir la complejidad de un algoritmo, expresando cómo el tiempo de ejecución o el espacio de memoria requerido por un algoritmo crece en relación con el tamaño de la entrada.

Se enfoca en el crecimiento a largo plazo, permitiendo comparar la eficiencia de diferentes algoritmos de una manera que es independiente de las variaciones de hardware o implementación específica. Permite pues:

<div align=center>

|Describir el crecimiento|Comparar algoritmos|Identificar el peor caso|
|-|-|-|
|Cómo aumenta el tiempo de ejecución o uso de memoria cuando crece el tamaño de la entrada|De manera independiente del hardware o implementación específica|Enfocando en el comportamiento del algoritmo en su escenario más desfavorable|

</div>

## ¿Para qué?

<div align=center>

|Eficiencia|Rendimiento|Escalabilidad|
|-|-|-|
|Facilita la comparación entre algoritmos para elegir el más adecuado basado en su comportamiento esperado con grandes volúmenes de datos.|Identifica cuellos de botella y guía el proceso de optimización al mostrar dónde se ganará más reduciendo la complejidad.|Ayuda a entender cómo un algoritmo manejará un aumento en el tamaño de los datos, lo cual es vital para sistemas que deben ser capaces de escalar.|

</div>

## ¿Cómo?

El análisis de complejidad mediante Big O se realiza siguiendo un proceso sistemático que involucra tres pasos principales:

1. **Evaluar el peor caso**: Analizar el escenario más desfavorable en términos de tiempo o espacio.
2. **Simplificar la expresión**: Identificar el [término dominante](terminoDominante.md) - aquel componente de la fórmula que crece más rápidamente con el tamaño de la entrada.
3. **Clasificar la complejidad**: Usar la notación para categorizar el algoritmo (O(1), O(n log n), O(n²), etc.).

### Identificación en la práctica

Para identificar la complejidad de un algoritmo en la práctica, consideramos:

- Conteo de operaciones
  - Si el número de operaciones se duplica al añadir un elemento → O(2^N).
  - Si el crecimiento se relaciona con el cuadrado del tamaño → O(N²).
  - Si el crecimiento se relaciona con el cubo del tamaño → O(N³).
- Estructura del algoritmo
  - Bucles anidados.
  - Llamadas recursivas múltiples.
  - Patrones de división del problema.
- Divide y vencerás
  - Algoritmos que parten el problema en mitades suelen ser O(log N).
  - Especialmente si se resuelve una mitad a la vez.
  - O si la combinación de soluciones es lineal o logarítmica.

### Ejemplos comunes

|[sumArray](ejemploA.md)|[Búsqueda binaria](ejemploB.md)|[findMax](ejemploC.md)|
|:-:|:-:|:-:|
|O(N)|O(log N)|O(N)|

## ¿Y ahora qué?

Primero, [la realidad...](realidad.md)

Además, para profundizar en el análisis de algoritmos, se propone:

### Recursos adicionales

- Visualizadores de algoritmos:
  - https://visualgo.net/en
  - https://algorithm-visualizer.org/
  - https://www.toptal.com/developers/sorting-algorithms
- Problemas de práctica
- Literatura recomendada

### Próximos pasos

- Análisis de espacio vs tiempo
- Estructuras de datos avanzadas
- Técnicas de optimización

### Consideraciones prácticas

- Compromisos en el mundo real
- Cuando la optimización prematura es el enemigo
- Equilibrio entre legibilidad y rendimiento
- ¡Practicar! [Con](https://github.com/puntoReflex/.github/blob/viajeMarco/EDA2/BigO/retos%26proyectos/viajeMarco/src/vEDA2/README.md) [nuestros](https://github.com/puntoReflex/pyCCCF/blob/EDA2/src/vEDA2/README.md) [ejemplos](https://github.com/puntoReflex/pyAspiradora/blob/vEDA2/src/vEDA2/README.md)
