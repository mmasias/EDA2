<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [Estructuración](/temario/002-recursividad/02-estructuracion/README.md) / [**Implementación**](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [**11**](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)

</div>

# 11. Una solución

## ¿Por qué?

Hasta ahora la recursión exploraba **todo** el árbol de decisiones: cada hoja se procesaba, y la exploración continuaba hasta el final.

Pero muchos problemas no piden todas las soluciones. Piden una. Cuando se encuentra, el resto del árbol no interesa. La pregunta es: ¿cómo hace la recursión para detenerse en cuanto encuentra lo que busca?

## ¿Qué?

El patrón find-first: una función que devuelve `boolean` y propaga `true` hacia arriba en cuanto encuentra una solución válida, colapsando el resto del árbol de llamadas sin explorarlo.

## ¿Para qué?

- Resolver problemas donde basta con encontrar una solución (no todas)
- Detener la exploración en cuanto el objetivo se cumple
- Entender cómo el tipo de retorno cambia el comportamiento de la exploración

## ¿Cómo?

### El problema

Dado el array `[1, 2, 3, 4, 5]` y un objetivo `7`, encontrar **un** subconjunto cuya suma sea exactamente `7`.

### Implementación

```java
class UnaSolucion {

    static boolean buscar(int[] nums, int indice, int restante, Camino actual) {
        if (restante == 0) {
            System.out.println("Solución: " + actual);
            return true;
        }
        if (indice == nums.length) {
            return false;
        }

        // Rama 1: incluir nums[indice]
        actual.agregar(nums[indice]);
        if (buscar(nums, indice + 1, restante - nums[indice], actual)) {
            return true;                           // Propagar el éxito: no deshacer
        }
        actual.quitar();                           // Fracaso: deshacer y probar la otra rama

        // Rama 2: no incluir nums[indice]
        return buscar(nums, indice + 1, restante, actual);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        buscar(nums, 0, 7, new Camino(nums.length));
    }
}
```

```
Solución: [1, 2, 4]
```

### Traza: cómo llega a `[1, 2, 4]`

<div align=center>

|![Árbol find-first](/images/modelosUML/11-una-solucion.svg)
|-
|El `true` sube por todos los marcos sin que ninguno deshaga nada. Las ramas no exploradas (excluir 2, excluir 1...) quedan descartadas.
|<div align=right> [*Codigo fuente*](/modelosUML/11-una-solucion.puml)</div>

</div>

### Lo que cambia respecto al Paso 09

<div align=center>

||Paso 09 (todos los subconjuntos)|Paso 11 (una solución)|
|-|-|-|
|Tipo de retorno|`void`|`boolean`|
|Al encontrar solución|Imprime y continúa|`return true`|
|Al volver con éxito|(no aplicaba)|**No deshace** y propaga `true`|
|Al volver con fracaso|(no aplicaba)|Deshace y prueba la otra rama|
|Árbol explorado|Completo|Hasta la primera hoja válida|

</div>

### El momento crítico: éxito vs fracaso

```java
actual.agregar(nums[indice]);
if (buscar(nums, indice + 1, restante - nums[indice], actual)) {
    return true;              // ← Éxito: NO se deshace. La solución está en actual.
}
actual.quitar();              // ← Fracaso: se deshace. Se prueba la otra rama.
```

El `quitar` solo ocurre cuando la llamada devuelve `false`. Si devuelve `true`, el `if` corta la ejecución antes de llegar al `quitar`.

> [Siguiente: Todas las soluciones](12-todas-las-soluciones.md)
