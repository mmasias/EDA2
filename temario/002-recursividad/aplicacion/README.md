<div align=right>

<sub>[Implementación](../implementacion/README.md)</sup><br>
<sup>[Aplicación](README.md) / [Torre de Hanoi](hanoi.md) / [El laberinto](laberinto.md) / [N Reinas](nreinas.md) / [Flood Fill](floodfill.md)</sub>

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
