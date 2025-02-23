# Categorías principales de Big O

Big O|Nombre|Descripción|Ejemplo
-|-|-|-
**O(1)** | constante | **El mejor.** El algoritmo siempre toma la misma cantidad de tiempo, independientemente de la cantidad de datos. |Buscar un elemento de un array por su índice.
**O(log n)** | logarítmico | **Muy bueno.** Este tipo de algoritmos reduce a la mitad la cantidad de datos en cada iteración. Si tienes 100 elementos, toma alrededor de 7 pasos encontrar la respuesta. Con 1,000 elementos, toma 10 pasos. Y 1,000,000 de elementos solo toman 20 pasos. Esto es súper rápido incluso para grandes cantidades de datos.|Búsqueda binaria.
**O(n)** | lineal | **Bueno.** Si tienes 100 elementos, esto hace 100 unidades de trabajo. Doblar la cantidad de elementos hace que el algoritmo tome exactamente el doble de tiempo (200 unidades de trabajo).|Búsqueda secuencial.
**O(n log n)** | "linealítmico" | **Decente.** Esto es ligeramente peor que lineal pero no demasiado malo.|Los algoritmos de ordenación de propósito general más rápidos.
**O(n²)** | cuadrático | **Un poco lento.** Si tienes 100 elementos, esto hace 100^2 = 10,000 unidades de trabajo. Doblar la cantidad de elementos lo hace cuatro veces más lento (porque 2 al cuadrado es igual a 4).|Algoritmos que usan bucles anidados, como el ordenamiento por inserción.
**O(n³)** | cúbico | **Rendimiento pobre.** Si tienes 100 elementos, esto hace 100^3 = 1,000,000 unidades de trabajo. Doblar el tamaño de entrada lo hace ocho veces más lento.|Multiplicación de matrices.
**O(2^n)** | exponencial | **Rendimiento muy pobre.** Quieres evitar este tipo de algoritmos, pero a veces no tienes opción. Agregar solo un bit a la entrada duplica el tiempo de ejecución.|Problema del vendedor viajero.
**O(n!)** | factorial | **Intolerablemente lento.** Literalmente toma millones de años hacer cualquier cosa.|Generar todas las permutaciones|

## Simplificación (be careful)

<div align=center>

|1 bucle|2 bucles|3 bucles|...|m bucles
|:-:|:-:|:-:|:-:|:-:|
O(*n*)|O(*n²*)|O(*n³*)|...|O(*n^m*)

</div>

## Identificación

### Reconocimiento de patrones comunes

#### En código iterativo

- 1 bucle → **O(n)**
- 2 bucles anidados → **O(n²)**
- 3 bucles anidados → **O(n³)**
- m bucles anidados → **O(n^m)**

#### En código recursivo o dividir y conquistar

- División sucesiva **(O(log n))**
  - El problema se divide por un factor constante en cada paso
  - Ejemplo: búsqueda binaria (divide por 2)
- Recursión con múltiples llamadas **(O(2ⁿ) o peor)**
  - Cada llamada genera múltiples subproblemas
  - Ejemplo: Fibonacci recursivo sin memorización

### Reconocimiento por características

#### O(log N)

- ***División sucesiva***: Generalmente, los algoritmos que reducen el problema a la mitad (o una fracción) en cada paso tienen una complejidad logarítmica. Un ejemplo clásico es la búsqueda binaria, donde se elimina la mitad del espacio de búsqueda con cada comparación.


#### O(N²)

- ***Bucles anidados***: Cuando tienes un bucle dentro de otro bucle, y cada uno de estos recorre el arreglo de entrada, la complejidad es cuadrática. Un ejemplo típico es el algoritmo de ordenamiento de burbuja (Bubble Sort), donde cada elemento es comparado con los otros en secuencia.
- ***Pares de elementos***: Cualquier algoritmo que necesite considerar todos los pares posibles de elementos en un conjunto generalmente tendrá una complejidad O(N²).

#### O(N³)

- ***Triple anidación de bucles***: Similar a O(N²), pero con una capa adicional. Un buen ejemplo sería un algoritmo que verifica triples de elementos para alguna condición, como ciertos tipos de algoritmos de programación dinámica o multiplicación de matrices (dependiendo de la implementación).

#### O(2^N)

- ***Subconjuntos o combinaciones***: Cualquier algoritmo que necesite generar todos los subconjuntos posibles de un conjunto entrará en esta categoría, ya que hay 2^N subconjuntos de un conjunto de N elementos.
- ***Recursión con dos llamadas por nivel***: Los algoritmos que hacen dos llamadas recursivas en cada paso tienden a tener una complejidad O(2^N). Un ejemplo clásico es el cálculo de los números de Fibonacci mediante recursión sin memorización, donde cada término se calcula a partir de los dos términos precedentes, duplicando el número de operaciones necesarias con cada incremento en N.
