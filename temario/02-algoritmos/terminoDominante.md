# Término dominante

## ¿Por qué?

En el análisis de complejidad algorítmica mediante [Big O](theBigO.md), necesitamos identificar qué parte de nuestro algoritmo tendrá el mayor impacto en su rendimiento cuando la entrada crece significativamente. Esta identificación es crucial porque nos permite simplificar nuestro análisis y centrarnos en lo que realmente importa al evaluar el rendimiento a gran escala.

## ¿Qué?

El término dominante es el componente de una fórmula de complejidad que crece más rápidamente con respecto al tamaño de la entrada (N) cuando N se acerca al infinito.

Por ejemplo, en una fórmula como:

<div align=center>

```
T(n) = 3n³ + 2n² + 5n + 1
```

</div>

El término dominante es 3n³, ya que crece mucho más rápido que los otros términos cuando n es grande.

## ¿Para qué?

La identificación del término dominante nos permite:

<div align=center>

|Simplificación|Clasificación|Comparación|
|-|-|-|
|Reducir fórmulas complejas a su esencia, facilitando el análisis|Determinar la categoría de complejidad del algoritmo|Comparar diferentes algoritmos basándonos en su comportamiento a gran escala|

</div>

## ¿Cómo?

### Proceso de identificación

1. Escribir la fórmula completa
   - Identificar todas las operaciones que realiza el algoritmo
   - Expresar cada parte en términos del tamaño de entrada N
   - Incluir constantes multiplicativas
1. Comparar términos
   - Ordenar los términos por tasa de crecimiento
   - Evaluar el comportamiento con valores grandes de N
   - Identificar qué término domina cuando N crece
1. Simplificar
   - Eliminar constantes multiplicativas
   - Eliminar términos no dominantes
   - Expresar en notación Big O

### Jerarquía de crecimiento

De menor a mayor tasa de crecimiento:

<div align=center>

|Notación|Nombre|Ejemplo típico|
|-|-|-|
|O(1)|Constante|Acceso a un array por índice|
|O(log n)|Logarítmico|Búsqueda binaria|
|O(n)|Lineal|Recorrer un array una vez|
|O(n log n)|Lineal logarítmico|Merge sort|
|O(n²)|Cuadrático|Bucles anidados simples|
|O(2ⁿ)|Exponencial|Fibonacci recursivo|

</div>

### Ejemplos prácticos

1. **Fórmula: 7n³ + 15n² + 2n + 8**
   - n = 10: 7(1000) + 15(100) + 2(10) + 8 = 7000 + 1500 + 20 + 8 = 8528
   - n = 100: 7(1000000) + 15(10000) + 2(100) + 8 = 7000000 + 150000 + 200 + 8 = 7150208
   - Término dominante: 7n³
   - Notación Big O: O(n³)
1. **Fórmula: 5n log n + 3n + 2**
   - n = 10: 5(10)(3.32) + 3(10) + 2 = 166 + 30 + 2 = 198
   - n = 100: 5(100)(6.64) + 3(100) + 2 = 3320 + 300 + 2 = 3622
   - Término dominante: 5n log n
   - Notación Big O: O(n log n)

### Tips para identificación rápida

- Los términos exponenciales (2ⁿ) siempre dominan sobre los polinomiales
- Entre términos polinomiales, el de mayor exponente domina
- Los términos logarítmicos crecen más lentamente que los lineales
- Las constantes y los términos de menor grado pueden ignorarse
