<div align=right>

<sub>[**Inicio**](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)</sub>

</div>

# Implementación

## ¿Por qué?

Habiendo recorrido:

1. **Inducción** → Identificación de patrones estructurales (secuencial, recurrente, iterativo, recursivo)
2. **Fundamentos** → Con el mínimo de código: caso base, caso recursivo, pila de llamadas
3. **Estructuración** → Cómo **encontrar** la recursividad en problemas mediante el método tabular

Llega el momento de **construir** funciones recursivas.

La diferencia clave:

- **Estructuración**: "¿Cuál es la estructura recursiva de este problema?"
- **Implementación**: "¿Cómo escribir código que refleje esa estructura?"

## ¿Qué?

Un itinerario progresivo de implementación, desde las primeras funciones recursivas hasta el backtracking.

## ¿Para qué?

- Reconocer si un problema requiere iteración o recursión
- Construir funciones recursivas desde cero
- Entender la traza de ejecución de una función recursiva
- Identificar patrones de recursión compleja (backtracking)

## ¿Cómo?

Implementación de [ejercicios ya identificados](../estructuracion/README.md): el código se escribe luego de haber hecho el trabajo de estructuración

<div align=center>

|Paso|Concepto|Objetivo|
|-|-|-|
|[00](./00-topologia.md)|Topología de una función recursiva|Entender el efecto de la posición de cada componente|
|[01](./01-metodo-iterativo.md)|Método iterativo|Anclar lo que NO es recursivo|
|[02](./02-recursion-sin-caso-base.md)|Recursión sin caso base|Experimentar el stack overflow|
|[03](./03-un-caso-base.md)|Un caso base|Primera función recursiva funcional|
|[04](./04-multiples-casos-base.md)|Múltiples casos base|Granularidad en los casos base|
|[05](./05-multiples-llamadas-condicional.md)|Múltiples llamadas (condicional)|Bifurcación controlada|
|[06](./06-multiples-llamadas-ambas.md)|Múltiples llamadas (ambas)|Recursión ramificada (árbol)|
|[07](./07-interrupcion-recursiva.md)|Interrupción de caso recursivo|Preparación para backtracking|
|[08](./08-el-estado.md)|El estado en la recursión|Comprender cómo viaja el estado por las llamadas|
|[09](./09-hacer-y-deshacer.md)|Hacer y deshacer|El movimiento fundamental del backtracking|
|[10](./10-el-arbol-de-decisiones.md)|El árbol de decisiones|El árbol de llamadas como espacio de búsqueda|
|[11](./11-una-solucion.md)|Una solución|Patrón find-first: propagar el éxito|
|[12](./12-todas-las-soluciones.md)|Todas las soluciones|Patrón find-all: explorar sin parar|
|[13](./13-poda.md)|Poda|No explorar lo que no puede funcionar|
|[14](./14-cierre.md)|Backtracking: síntesis|El patrón completo, sus variantes y dónde aparece|

</div>
