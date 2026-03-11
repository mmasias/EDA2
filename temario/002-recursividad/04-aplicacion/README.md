<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [Estructuración](/temario/002-recursividad/02-estructuracion/README.md) / [Implementación](/temario/002-recursividad/03-implementacion/README.md) / [**Aplicación**](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[**Inicio**](README.md) / [Torre de Hanoi](hanoi.md) / [El laberinto](laberinto.md) / [N Reinas](nreinas.md) / [Flood Fill](floodfill.md)

</div>

# Aplicación

Esta sección presenta cuatro problemas clásicos que ilustran los patrones de recursión estudiados en la sección de implementación. Cada artículo parte del problema concreto y lo conecta explícitamente con los pasos que lo explican.

## [La Torre de Hanoi](hanoi.md)

El ejemplo más célebre de recursión con múltiples llamadas. Con tres torres y `n` discos, la solución completa cabe en cuatro líneas de código.

El artículo muestra que la estructura del código refleja directamente la estructura del problema: dos llamadas recursivas con una operación intercalada, ***idéntica al recorrido inorder de un árbol binario***. También examina por qué el algoritmo no necesita ningún `if` de validación —la corrección se garantiza por inducción sobre la propia recursión— y por qué esto lo diferencia del backtracking.

> *Patrón central: recursión múltiple (Paso 06). Sin estado mutable, sin exploración, sin hacer/deshacer.*

## [El laberinto](laberinto.md)

El primer ejemplo de backtracking aplicado a un espacio con forma de grafo. A diferencia de los subconjuntos, un laberinto puede tener ciclos, lo que obliga a una variación del patrón hacer/deshacer.

El artículo examina por qué el deshacer en este problema no restaura el estado original sino que marca la celda como `VISITADO`. Esa diferencia tiene dos causas concretas: evitar bucles infinitos en grafos con ciclos y evitar la reexploración de callejones ya conocidos entre las ramas del `||`.

> *Patrón central: backtracking find-first (Pasos 08, 09, 11) con hacer/deshacer asimétrico.*

## [N Reinas](nreinas.md)

El ejemplo canónico de backtracking con poda explícita. La poda tiene nombre propio —`puedeColocar`— y eso no es cosmético: separa qué se explora de si se puede explorar, haciendo el algoritmo legible como dos piezas independientes.

El artículo presenta las variantes find-first y find-all, señala la diferencia exacta entre ambas (dos líneas), y explica por qué `puedeColocar` solo mira hacia la izquierda. También hace visible algo que los textos suelen omitir: cuando se retira una reina, el backtracking es literalmente visible —la reina se mueve a la fila siguiente de su columna.

> *Patrón central: backtracking con poda (Pasos 08, 09, 11, 12, 13).*

## [Flood Fill](floodfill.md)

El algoritmo detrás del bote de pintura de cualquier editor de imagen. A diferencia de todos los algoritmos anteriores, el cambio de estado no es un medio para encontrar algo: es el resultado en sí mismo.

El artículo examina por qué no hay hacer/deshacer —las modificaciones son permanentes e intencionales— y por qué eso lo distingue del backtracking. También contrasta con el laberinto: ambos usan una matriz y marcan celdas para no revisitarlas, pero el significado de la marca es opuesto. En el laberinto `VISITADO` señala fracaso; en Flood Fill el color nuevo señala éxito.

> *Patrón central: recursión multidireccional con estado permanente (Pasos 06, 08). Sin exploración, sin hacer/deshacer.*