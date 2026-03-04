<div align=right>

<sub>[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [**14**](14-cierre.md)</sub>

</div>

# 14. Síntesis: el concepto de backtracking

## El patrón y sus componentes

La convergencia de conceptos que los pasos 00–13 introdujeron por separado es lo que se conoce como backtracking:

<div align=center>

|Paso|Concepto|Qué aporta|
|-|-|-|
|00|Topología de una función recursiva|La posición de cada pieza determina el comportamiento|
|01|Método iterativo|Referencia: lo que la recursión no es|
|02|Recursión sin caso base|Sin salida, la pila crece sin límite|
|03|Un caso base|La condición de parada hace la recursión funcional|
|04|Múltiples casos base|Granularidad en los casos de parada|
|05|Múltiples llamadas (condicional)|Bifurcación: solo una de las ramas se toma|
|06|Múltiples llamadas (ambas)|Bifurcación completa: se toman las dos ramas|
|07|Interrupción del caso recursivo|Una rama puede terminar antes de agotarse|
|08|El estado|Un objeto mutable viaja a través de todos los marcos|
|09|Hacer y deshacer|Agregar antes de llamar, quitar al volver|
|10|El árbol de decisiones|La pila de llamadas es el árbol|
|11|Una solución|`return true` colapsa el árbol al encontrar la primera solución|
|12|Todas las soluciones|Guardar y continuar; el `quitar` es siempre incondicional|
|13|Poda|Descartar ramas imposibles antes de entrar en ellas|

</div>

## La observación estructural

La pila de llamadas no recorre un árbol de decisiones: la pila de llamadas *es* el árbol. El árbol no existe como estructura de datos en memoria. Existe como configuración de marcos de activación en cada instante de la ejecución.

El objeto `actual` (o cualquier estado mutable equivalente) es la proyección visible de esa configuración: contiene exactamente los elementos que corresponden a los marcos activos en la pila en ese momento.

Cuando el `quitar` deshace el último `agregar`, el árbol ha retrocedido un nivel. Eso es todo lo que es el backtracking.

## Estructura general

```java
void explorar(estado, parametros) {
    if (esSolucion(estado)) {
        procesar(estado);           // imprimir, guardar, return true
        return;
    }
    if (sinSalida(estado)) {
        return;
    }
    if (esImposible(estado)) {      // PODA (opcional)
        return;
    }

    para (cada opcion) {
        estado.agregar(opcion);     // HACER
        explorar(estado, ...);      // EXPLORAR
        estado.quitar();            // DESHACER
    }
}
```

Las variantes son configuraciones de este esqueleto:

<div align=center>

|Variante|Diferencia|
|-|-|
|find-first|Al encontrar solución, `return true` que se propaga; `quitar` solo si fracasa|
|find-all|Al encontrar solución, imprimir y `return`; `quitar` siempre|
|con poda|Condición adicional antes del bucle de opciones|
|sin poda|Ausencia de esa condición (correcto, pero potencialmente más lento)|

</div>

## Corrección y eficiencia

La poda no afecta a la corrección: es optimización. La corrección la garantiza la estructura hacer/deshacer. La poda reduce el trabajo sin alterar el resultado, siempre que la condición de poda sea una condición de imposibilidad real (no una heurística).

Estas dos preocupaciones son independientes:

1. Verificar que el algoritmo es correcto sin poda
2. Añadir poda como optimización, verificando que no elimina soluciones válidas

## Dónde aparece este patrón

<div align=center>

|Problema|Variante aplicable|
|-|-|
|Permutaciones y combinaciones|find-all|
|N reinas|find-all con poda por restricciones|
|Sudoku|find-first con poda por restricciones|
|Coloración de grafos|find-all o find-first con poda|
|Búsqueda en grafos (DFS)|backtracking sobre grafo con marca de visitados|
|Mergesort, quicksort|recursión bifurcada sin estado mutable (variante del Paso 06)|

</div>

El patrón es uniforme: los problemas varían en cómo se define el estado, qué cuenta como solución y qué condiciones de poda se pueden demostrar válidas.

[Volver al README de Implementación →](README.md)
