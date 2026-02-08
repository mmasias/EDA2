# Limitaciones del análisis asintótico

La notación Big O describe el comportamiento de un algoritmo **cuando el tamaño de la entrada tiende a infinito**. Sin embargo, en la práctica trabajamos con conjuntos de datos finitos y muchas veces pequeños. En estos casos, el análisis asintótico puede ser engañoso.

## El factor de las constantes ocultas

Big O elimina las constantes multiplicativas, pero estas importan en escenarios reales:

- **Algoritmo hipotético A**: T(n) = 100n + 1000 → O(n)
- **Algoritmo hipotético B**: T(n) = n² → O(n²)

Para n = 10:

- Algoritmo A: 100(10) + 1000 = 2000 operaciones
- Algoritmo B: 10² = 100 operaciones

**El algoritmo "peor" (B) es 20 veces más rápido para n = 10.**

## Comparación práctica: O(n²) vs O(n log n)

Comparando dos algoritmos de ordenación con diferentes constantes:

<div align=center>

|n|5n²|100n log₂n|Ganador|
|-|:-:|:-:|:-:|
|5|125|1160|O(n²) **9× más rápido**|
|10|500|3320|O(n²) **6.6× más rápido**|
|50|12,500|28,200|O(n²) **2.3× más rápido**|
|100|50,000|66,400|O(n²) **1.3× más rápido**|
|500|1,250,000|448,000|O(n log n) **2.8× más rápido**|
|1000|5,000,000|996,000|O(n log n) **5× más rápido**|

</div>

## El punto de inflexión

El punto donde O(n log n) supera a O(n²) depende de las constantes:

- Si Algoritmo A tiene constante pequeña y B tiene constante grande → El cruce ocurre más tarde
- Para conjuntos de datos menores al punto de inflexión → El algoritmo "peor" según Big O gana

**Ejemplo del mundo real**: *Insertion sort* (O(n²)) es más rápido que *Merge sort* (O(n log n)) para arrays pequeños (< 50 elementos) porque tiene overhead mínimo. Por esto, muchos algoritmos de ordenación optimizados usan Insertion sort para sub-arrays pequeños.

## Lección

El análisis asintótico es una herramienta poderosa para predec comportamiento a gran escala, pero:

1. **Para conjuntos de datos pequeños**, las constantes ocultas importan más que la complejidad asintótica
2. **El hardware real** (cachés,分支 prediction) afecta el rendimiento de manera que Big O no captura
3. **La implementación específica** importa: dos algoritmos O(n log n) pueden tener rendimiento muy diferente

Big O nos da el comportamiento a largo plazo, pero no necesariamente predice el ganador para el tamaño de datos que realmente tenemos.