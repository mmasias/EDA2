# Análisis de algoritmos iterativos

## ¿Por qué?

A medida que desarrollamos (o elegimos) algoritmos para proyectos más complejos, es crucial poder prever cómo el rendimiento de un programa cambiará con el tamaño de los datos procesados. Necesitamos una forma de entender y comunicar el impacto que tendrá uno u otro algoritmo en términos de tiempo de ejecución y uso de memoria, especialmente en casos extremos o a gran escala.

## ¿Qué?

El análisis de algoritmos iterativos consiste en identificar patrones en el código —bucles, sentencias secuenciales, anidamientos— y calcular cómo crece el número de operaciones en función del tamaño de entrada. Este análisis permite simplificar expresiones complejas a su esencia mediante la identificación del **término dominante**: el componente que crece más rápidamente cuando el tamaño de entrada tiende a infinito.

El término dominante es la parte de una fórmula de complejitud que crece más rápido. Por ejemplo, en `T(n) = 3n³ + 2n² + 5n + 1`, el término dominante es `3n³`, porque cuando n crece, este término arrastra el crecimiento hacia O(n³).

## ¿Para qué?

La identificación del término dominante nos permite:

<div align=center>

|Simplificación|Clasificación|Comparación|
|-|-|-|
|Reducir fórmulas complejas a su esencia|Determinar la categoría de complejidad del algoritmo|Comparar diferentes algoritmos basándonos en su comportamiento a gran escala|

</div>

## Cómo?

### Proceso de identificación

1. **Escribir la fórmula completa**
   - Identificar todas las operaciones que realiza el algoritmo
   - Expresar cada parte en términos del tamaño de entrada N
   - Incluir constantes multiplicativas

2. **Comparar términos**
   - Ordenar los términos por tasa de crecimiento
   - Evaluar el comportamiento con valores grandes de N
   - Identificar qué término domina cuando N crece

3. **Simplificar**
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

### Identificación en la práctica

Para identificar la complejidad de un algoritmo iterativo, consideramos:

**Conteo de operaciones**

- Si el número de operaciones se duplica al añadir un elemento → O(2ⁿ)
- Si el crecimiento se relaciona con el cuadrado del tamaño → O(n²)
- Si el crecimiento se relaciona con el cubo del tamaño → O(n³)

**Estructura del algoritmo**

- **1 bucle** → O(n)
- **2 bucles anidados** → O(n²)
- **3 bucles anidados** → O(n³)
- **m bucles anidados** → O(nᵐ)

**Divide y vencerás**

- Algoritmos que parten el problema en mitades suelen ser O(log n)
- Especialmente si se resuelve una mitad a la vez
- O si la combinación de soluciones es lineal o logarítmica

### Tips para identificación rápida

- Los términos exponenciales (2ⁿ) siempre dominan sobre los polinomiales
- Entre términos polinomiales, el de mayor exponente domina
- Los términos logarítmicos crecen más lentamente que los lineales
- Las constantes y los términos de menor grado pueden ignorarse

### Ejemplos prácticos de simplificación

**Fórmula: 7n³ + 15n² + 2n + 8**

- n = 10: 7(1000) + 15(100) + 2(10) + 8 = 7000 + 1500 + 20 + 8 = 8528
- n = 100: 7(1000000) + 15(10000) + 2(100) + 8 = 7000000 + 150000 + 200 + 8 = 7150208
- **Término dominante**: 7n³
- **Notación Big O**: O(n³)

**Fórmula: 5n log n + 3n + 2**

- n = 10: 5(10)(3.32) + 3(10) + 2 = 166 + 30 + 2 = 198
- n = 100: 5(100)(6.64) + 3(100) + 2 = 3320 + 300 + 2 = 3622
- **Término dominante**: 5n log n
- **Notación Big O**: O(n log n)

## Ejemplo comparativo: Búsqueda lineal vs. Búsqueda binaria

Para ilustrar la diferencia práctica entre O(n) y O(log n), comparemos dos algoritmos de búsqueda:

### Código implementado

```java
static final int NO_ENCONTRADO = -1;

// O(n) - Búsqueda lineal
public int busquedaLineal(int[] array, int objetivo) {
    for (int i = 0; i < array.length; i++) {
        if (array[i] == objetivo)
          return i;
    }
    return NO_ENCONTRADO;
}

// O(log n) - Búsqueda binaria
public int busquedaBinaria(int[] arrayOrdenado, int objetivo) {
    int inicio = 0;
    int fin = arrayOrdenado.length - 1;

    while (inicio <= fin) {
        int medio = (inicio + fin) / 2;
        if (arrayOrdenado[medio] == objetivo)
            return medio;
        if (arrayOrdenado[medio] < objetivo)
            inicio = medio + 1;
        else
            fin = medio - 1;
    }
    return NO_ENCONTRADO;
}
```

### Comparación de rendimiento

<div align=center>

|Tamaño n|Operaciones O(n)|Operaciones O(log n)|Tiempo O(n)|Tiempo O(log n)|¡La diferencia!|
|:-:|-:|-:|-:|-:|-:|
|1|1|1|0.000001 s|0.000001 s|=|
|10|10|3.32|0.00001 s|0.00000332 s|3x más rápido|
|100|100|6.64|0.0001 s|0.00000664 s|15x más rápido|
|1,000|1,000|9.97|0.001 s|0.00000997 s|100x más rápido|
|10,000|10,000|13.29|0.01 s|0.0000133 s|752x más rápido|

</div>

> *Asumiendo 1 microsegundo (0.000001 segundos) por operación*

### Observaciones clave

1. **Para arrays pequeños (n=1)** no hay diferencia significativa.
2. **La diferencia se vuelve dramática conforme crece n**.
3. **Para n=10,000**, la búsqueda binaria es 752 veces más rápida.
4. **Los números de O(log n) son log₂(n)**, ya que en cada paso dividimos por 2.

Este ejemplo ilustra por qué el análisis de complejidad importa: la diferencia no solo existe teóricamente, sino que tiene un impacto real y medible en el rendimiento.

## Ejemplos de análisis paso a paso

Para profundizar en el proceso completo de análisis —identificar operaciones, sumar complejidades y simplificar— se presentan los siguientes ejemplos detallados:

<div align=center>

|Ejemplo|Algoritmo|Complejidad|Enlace|
|-|-|-|-|
|Ejemplo A|Suma de elementos de un array|O(n)|[Ver análisis completo →](ejemploA.md)|
|Ejemplo B|Búsqueda binaria en array ordenado|O(log n)|[Ver análisis completo →](ejemploB.md)|
|Ejemplo C|Encontrar el máximo en un array|O(n)|[Ver análisis completo →](ejemploC.md)|

</div>
