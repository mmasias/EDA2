# El orden

## ¿Por qué?

La comprensión del impacto que tiene el orden de operaciones en algoritmos recursivos se hace necesaria por varias razones fundamentales:

|Comportamientos divergentes|Flexibilidad algorítmica|Fundamento para técnicas avanzadas|Optimización de algoritmos|Aplicabilidad práctica|
|-|-|-|-|-|
|Es imprescindible entender cómo algoritmos con estructuras casi idénticas pueden generar resultados completamente diferentes simplemente alterando el orden de sus operaciones.|Se requiere conocer las distintas maneras en que un mismo problema puede abordarse mediante variaciones en la estructura recursiva, adaptándose a diferentes necesidades.|El dominio de estos conceptos es necesario como base para comprender técnicas más sofisticadas como el backtracking, que dependen crucialmente del orden en que se construyen y verifican soluciones.|Se precisa esta comprensión para mejorar el rendimiento y la eficiencia de soluciones recursivas, ya que el orden de operaciones puede afectar significativamente el uso de recursos.|Es esencial para seleccionar el enfoque adecuado según el problema específico, pues cada variante tiene aplicaciones particulares donde resulta óptima.|

## ¿Qué?

El orden en la recursividad se refiere a la secuencia en que se ejecutan las diferentes operaciones dentro de una función recursiva, particularmente la relación entre:

- El procesamiento del elemento o estado actual
- Las llamadas recursivas a problemas más pequeños
- Las operaciones adicionales antes o después de dichas llamadas

En una función recursiva típica, estos tres componentes fundamentales están presentes:

1. **Caso base**: Condición que detiene la recursión y proporciona una respuesta directa sin más llamadas recursivas.
2. **Caso recursivo**: Parte donde la función se llama a sí misma con un problema más pequeño o simplificado.
3. **Procesamiento**: Operaciones realizadas sobre el estado actual, que pueden ocurrir antes, entre o después de las llamadas recursivas.

Dependiendo de cómo se ordenen estos componentes, especialmente el procesamiento en relación con las llamadas recursivas, se obtienen algoritmos con comportamientos radicalmente diferentes aunque compartan la misma estructura básica.

## ¿Para qué?

El conocimiento sobre el orden en algoritmos recursivos tiene múltiples aplicaciones prácticas:

- **Selección de algoritmos óptimos**: Permite elegir la variante recursiva más adecuada para un problema específico según sus requisitos particulares.

- **Recorrido eficiente de estructuras de datos**: Facilita el procesamiento de estructuras jerárquicas como árboles y grafos de manera adaptada a necesidades concretas:
  - Construcción de árboles (pre-orden)
  - Ordenamiento de elementos (in-orden en árboles de búsqueda binaria)
  - Eliminación de estructuras (post-orden)

- **Evaluación de expresiones**: Posibilita la implementación de evaluadores para diferentes notaciones:
  - Notación polaca (prefija)
  - Notación infija (convencional)
  - Notación polaca inversa (postfija)

- **Técnicas avanzadas de búsqueda**: Sirve como fundamento para implementar algoritmos de backtracking que exploran espacios de soluciones de manera sistemática.

- **Transformación de algoritmos**: Permite convertir soluciones ineficientes en versiones más optimizadas mediante la reorganización de las operaciones recursivas.

## ¿Cómo?

Para ilustrar cómo el orden de operaciones afecta el comportamiento de algoritmos recursivos, examinaremos los tres recorridos clásicos de árboles binarios:

### Componentes comunes

Todos los recorridos comparten estos elementos:

```java
void recorrer(Nodo nodo) {
    // Caso base
    if (nodo == null) return;
    
    // Tres operaciones fundamentales que se pueden reordenar:
    // 1. procesar(nodo)              - Procesar nodo actual
    // 2. recorrer(nodo.izquierdo)    - Recorrer subárbol izquierdo
    // 3. recorrer(nodo.derecho)      - Recorrer subárbol derecho
}
```

### Tres variaciones fundamentales

<div align=center>

![](/images/arboles001.svg)

<table>
<tr><th>

[Pre-orden](https://github.com/mmasias/EDA1/tree/main/src/arboles/recorridos/preOrderSample)
</th><th>

[In-orden](https://github.com/mmasias/EDA1/tree/main/src/arboles/recorridos/inOrderSample)
</th><th>

[Post-orden](https://github.com/mmasias/EDA1/tree/main/src/arboles/recorridos/postOrderSample)
</th></tr>
<tr><td>

```java
void preorden(Nodo nodo) {
    if (nodo == null) return;
    
    procesar(nodo);
    preorden(nodo.izquierdo);
    preorden(nodo.derecho);
}
```
</td><td>

```java
void inorden(Nodo nodo) {
    if (nodo == null) return;
    
    inorden(nodo.izquierdo);
    procesar(nodo);
    inorden(nodo.derecho);
}
```
</td><td>

```java
void postorden(Nodo nodo) {
    if (nodo == null) return;
    
    postorden(nodo.izquierdo);
    postorden(nodo.derecho);
    procesar(nodo);
}
```
</td></tr>
<tr><td align=center>V / hI / hD</td><td align=center>hI / V / hD</td><td align=center>hI / hD / V</td></tr>
<tr><td align=center>a, b, d, e, h, i, c, f, g, j, k</td><td align=center>d, b, h, e, i, a, f, c, j, g, k</td><td align=center>d, h, i, e, b, f, j, k, g, c, a</td></tr>

</table>

</div>

Como se puede observar, un simple cambio en el orden de las operaciones produce secuencias completamente diferentes, cada una con aplicaciones específicas.

Esta flexibilidad en la organización de las operaciones recursivas es precisamente lo que hace tan poderosa esta técnica, y constituye la base para entender métodos más avanzados como el **[backtracking](backtracking.md)**, donde el orden en que se construyen, verifican y descartan soluciones determina la eficiencia y el comportamiento del algoritmo.
