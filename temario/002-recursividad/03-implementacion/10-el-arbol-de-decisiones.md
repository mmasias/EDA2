<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [Estructuración](/temario/002-recursividad/02-estructuracion/README.md) / [**Implementación**](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [**10**](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)

</div>

# 10. El árbol de decisiones

## ¿Por qué?

El código de `fabricar` hace algo que puede parecer mágico: genera los ocho subconjuntos correctos sin llevar ningún registro explícito de cuáles ha generado. ¿Cómo sabe qué ha explorado ya y qué le queda?

La respuesta es que la **pila de llamadas** es ese registro. Cada llamada activa en la pila representa un punto de decisión pendiente. La estructura de todas esas llamadas forma un árbol, y recorrerlo es exactamente lo que hace la recursión.

## ¿Qué?

El árbol de decisiones es la representación visual del espacio que la recursión explora. Cada nodo es una llamada. Cada rama es una decisión. Cada hoja es un resultado.

No es una estructura de datos separada: es la forma del árbol de llamadas recursivas.

## ¿Para qué?

- Entender qué está haciendo la recursión en cada momento
- Razonar sobre cuántas llamadas se harán y cuántas soluciones se encontrarán
- Identificar qué ramas podrían eliminarse (preparación para el Paso 13)

## ¿Cómo?

### El árbol de `fabricar([1, 2, 3])`

Cada nodo muestra el valor de `actual` en ese punto. Cada nivel corresponde a la decisión sobre un elemento.

<div align=center>

|![Árbol de decisiones](/images/modelosUML/10-arbol-decisiones.svg)
|-:
|[*Codigo fuente*](/modelosUML/10-arbol-decisiones.puml)

</div>

Las ocho hojas son los ocho subconjuntos. El orden en que aparecen en la salida es el orden en que la recursión visita las hojas: de izquierda a derecha, en profundidad.

### Qué es `actual` en cada nodo

La lista `actual` en cualquier nodo contiene exactamente los elementos elegidos en el camino desde la raíz hasta ese nodo.

<div align=center>

|Nodo|Camino de decisiones|`actual`|
|-|-|-|
|Raíz|—|`[]`|
|Izquierda nivel 1|incluir 1|`[1]`|
|Izquierda nivel 2 (rama izquierda)|incluir 1, incluir 2|`[1, 2]`|
|Hoja más a la izquierda|incluir 1, incluir 2, incluir 3|`[1, 2, 3]`|
|Hoja más a la derecha|excluir 1, excluir 2, excluir 3|`[]`|

</div>

No hay ninguna variable que lleve ese registro: la propia pila de llamadas lo mantiene implícitamente.

### Cómo se mueve la recursión por el árbol

<div align=center>

|![Recorrido del árbol](../images/modelosUML/10-arbol-recorrido.svg)
|-:
|[*Codigo fuente*](/modelosUML/10-arbol-recorrido.puml)

</div>

Los nodos están numerados en orden de visita. Entre el (V) y el (VI) hay un salto hacia arriba: ahí es donde ocurre el `quitar` — la recursión sube un nivel para tomar la otra decisión.

### La pila de llamadas ES el camino actual

En cualquier momento de la ejecución, el estado de la pila refleja exactamente el camino desde la raíz hasta el nodo actual del árbol:

```
Pila cuando se imprime [1, 2, 3]:

  fabricar(3, [1,2,3])  ← tope (caso base, imprime)
  fabricar(2, [1,2])    ← decidió incluir 3
  fabricar(1, [1])      ← decidió incluir 2
  fabricar(0, [])       ← decidió incluir 1
  main                  ← fondo
```

Cada marco corresponde a un nivel del árbol. El tope de la pila es la hoja actual.

## Mapa

<div align=center>

|Árbol de decisiones|Código recursivo|
|-|-|
|Nodo|Una llamada a `fabricar`|
|Rama izquierda (incluir)|`agregar` + llamada recursiva + `quitar`|
|Rama derecha (excluir)|Segunda llamada recursiva (sin agregar/quitar)|
|Hoja|Caso base: `indice == nums.length`|
|Profundidad del árbol|Número de elementos en `nums`|
|Número de hojas|2^n (decisiones binarias por n elementos)|

</div>

Con este mapa, la recursión deja de ser una caja negra: es un recorrido en profundidad del árbol de decisiones, donde `actual` acumula el camino y el `quitar` deshace cada paso al volver.

> [Siguiente: Una solución](11-una-solucion.md)
