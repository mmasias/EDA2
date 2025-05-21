# Búsquedas

## ¿Por qué?

|||
|-|-|
|Encontrar información específica dentro de grandes volúmenes de datos es una necesidad clave en el desarrollo de software.|Los algoritmos de búsqueda eficaces permiten acceder de forma rápida y precisa a datos relevantes, optimizando las operaciones y brindando respuestas más ágiles a los usuarios.|

## ¿Qué?

Son algoritmos diseñados para localizar un elemento específico dentro de una colección, como un array, lista o estructura de datos más compleja, usando diferentes estrategias basadas en el tipo y organización de los datos.

*En computación, un algoritmo de búsqueda es un método o procedimiento utilizado para encontrar un elemento particular en una colección de datos. El enfoque varía según el tipo de datos y la estructura en la que se encuentran. Algunos algoritmos son básicos y se aplican a listas desordenadas, mientras que otros están diseñados para sacar el máximo provecho de estructuras ordenadas o especializadas.*

## ¿Para qué?

Los algoritmos de búsqueda son fundamentales no solo por su aplicación directa en la recuperación de información, sino también como una base para otras operaciones más complejas.

|||
|-|-|
Optimización de la eficiencia|El uso de un algoritmo de búsqueda adecuado puede marcar la diferencia en el tiempo de respuesta de una aplicación, sobre todo con datos grandes.
Sistemas de bases de datos|Las bases de datos dependen de algoritmos de búsqueda eficientes para proporcionar respuestas rápidas a las consultas.
Estructuras de datos avanzadas|Las estructuras de datos como árboles de búsqueda o tablas hash están optimizadas para búsquedas rápidas.
Entrevistas técnicas|Las búsquedas son un tema clave en las entrevistas, ya que evalúan la capacidad del candidato para comprender y aplicar estructuras de datos adecuadas.

## ¿Cómo?

|Algoritmo||Características|
|-|-|-|
|**[Búsqueda lineal](linearSearch.md)**|Recorre la colección elemento por elemento hasta encontrar el objetivo.|- Simple de implementar<br>- Ineficiente para colecciones grandes<br>- Funciona en listas desordenadas|
|**[Búsqueda binaria](binarySearch.md)**|Divide una lista ordenada a la mitad repetidamente para localizar el elemento.|- Muy eficiente para listas ordenadas<br>- No funciona con listas desordenadas<br>- Complejidad temporal: \(O(\log n)\)|
|**[Búsqueda en árbol](treeSearch.md)**|Recurre a estructuras de árbol para buscar elementos, como árboles binarios de búsqueda (BST) o árboles balanceados.|- Eficiente si el árbol está balanceado<br>- Complejidad temporal: \(O(\log n)\)<br>- Puede ser ineficiente con árboles desbalanceados|

<!--
|**[Búsqueda en grafos](graphSearch.md)**|Explora un grafo para localizar nodos específicos usando algoritmos como BFS (Breadth-First Search) o DFS (Depth-First Search).|- Permite encontrar caminos o rutas entre nodos<br>- Adaptable para diferentes tipos de grafos<br>- Puede ser costoso en términos de memoria|
|**[Búsqueda interpolada](interpolationSearch.md)**|Calcula la posición probable del elemento basado en una clave, similar a la búsqueda binaria.|- Eficiente para listas ordenadas y distribuidas uniformemente<br>- Puede fallar con datos no uniformemente distribuidos<br>- Complejidad temporal: \(O(\log \log n)\)|
|**[Búsqueda exponencial](exponentialSearch.md)**|Duplica el intervalo en cada paso hasta encontrar el rango probable, luego usa búsqueda binaria.|- Útil para colecciones muy grandes<br>- Requiere una lista ordenada<br>- Complejidad temporal: \(O(\log n)\)|
|**[Búsqueda de saltos](jumpSearch.md)**|Salta de bloque en bloque para encontrar el intervalo correcto antes de aplicar búsqueda lineal.|- Eficiente para listas ordenadas<br>- Menos eficiente que la búsqueda binaria en listas pequeñas<br>- Complejidad temporal: \(O(\sqrt{n})\)|
|**[Búsqueda fibonacci](fibonacciSearch.md)**|Divide la lista usando la secuencia de Fibonacci para reducir el rango.|- Similar a la búsqueda binaria<br>- Requiere lista ordenada<br>- Complejidad temporal: \(O(\log n)\)|
|**[Búsqueda en tries](trieSearch.md)**|Utiliza un árbol trie para almacenar cadenas de forma jerárquica.|- Eficiente para búsquedas de cadenas con prefijos comunes<br>- Puede ser costoso en memoria<br>- Complejidad temporal: \(O(L)\), donde \(L\) es la longitud de la cadena|
|**[Búsqueda en índices invertidos](invertedIndexSearch.md)**|Utiliza un índice invertido para encontrar documentos que contienen palabras clave.|- Muy eficiente para consultas textuales<br>- Requiere almacenamiento adicional<br>- Adecuado para sistemas de bases de datos y motores de búsqueda|
|**[Búsqueda de patrones](patternMatching.md)**|Encuentra patrones o subcadenas dentro de cadenas largas.|- Útil para búsquedas en texto y análisis de secuencias<br>- Incluye algoritmos como KMP o Boyer-Moore<br>- Complejidad temporal varía según el algoritmo|
|**[Búsqueda por hashing](hashingSearch.md)**|Utiliza una función hash para mapear claves a ubicaciones en una tabla.|- Muy rápida con colisiones mínimas<br>- Necesita un diseño de función hash eficaz<br>- Puede requerir manejo de colisiones|