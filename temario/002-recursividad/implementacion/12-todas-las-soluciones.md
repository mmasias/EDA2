<div align=right>

<sub>[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [**12**](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)</sub>

</div>

# 12. Todas las soluciones

## ¿Por qué?

El Paso 11 detenía la exploración en cuanto encontraba la primera solución. Pero ¿qué pasa si el problema pide encontrar todas?

El árbol de decisiones es el mismo. El código es casi idéntico. Solo cambia una cosa: en vez de propagar `true` hacia arriba al encontrar una solución, se guarda y se sigue explorando.

## ¿Qué?

El patrón find-all: explorar el árbol completo, acumulando cada solución válida encontrada en una colección, sin interrumpir la exploración al encontrar la primera.

## ¿Para qué?

- Resolver problemas donde se necesitan todas las soluciones posibles
- Contar el número de soluciones
- Entender la diferencia entre "buscar" y "enumerar"

## ¿Cómo?

### El mismo problema, diferente objetivo

Dado el array `[1, 2, 3, 4, 5]` y un objetivo `7`, encontrar **todos** los subconjuntos cuya suma sea exactamente `7`.

### Implementación

```java
class TodasLasSoluciones {

    static void buscarTodas(int[] nums, int indice, int restante, Camino actual) {
        if (restante == 0) {
            System.out.println("Solución: " + actual);
            return;                                    // Continuar explorando
        }
        if (indice == nums.length) {
            return;
        }

        // Rama 1: incluir nums[indice]
        actual.agregar(nums[indice]);
        buscarTodas(nums, indice + 1, restante - nums[indice], actual);
        actual.quitar();                               // Siempre deshacer

        // Rama 2: no incluir nums[indice]
        buscarTodas(nums, indice + 1, restante, actual);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        buscarTodas(nums, 0, 7, new Camino(nums.length));
    }
}
```

```
Solución: [1, 2, 4]
Solución: [2, 5]
Solución: [3, 4]
```

<div align=center>

|![Árbol find-all](../images/modelosUML/12-todas-las-soluciones.svg)
|-:
|[*Codigo fuente*](/modelosUML/12-todas-las-soluciones.puml)

</div>

### La diferencia crítica respecto al Paso 11

<div align=center>

||Paso 11 (una solución)|Paso 12 (todas las soluciones)|
|-|-|-|
|Al encontrar solución|`return true`|`println` + `return`|
|El `return` al encontrar|Colapsa el árbol hacia arriba|Solo sale de esta rama; la exploración continúa|
|El `quitar` tras la rama 1|Solo si fracasa|**Siempre**|
|Árbol explorado|Hasta la primera hoja válida|Completo|

</div>

En el Paso 11, el `quitar` era condicional: solo ocurría si la llamada devolvía `false`. Aquí el `quitar` es **siempre incondicional**: después de explorar la rama de incluir, se deshace sin excepción antes de explorar la rama de excluir.

### Estructura general del patrón find-all

```java
void explorar(estado, parametros) {
    if (esSolucion(estado)) {
        mostrar(estado);            // Procesar la solución encontrada
        return;                     // Volver (no propagar nada)
    }
    if (sinSalida(estado)) {
        return;
    }

    para (cada opcion) {
        estado.agregar(opcion);     // HACER
        explorar(estado, ...);      // EXPLORAR
        estado.quitar();            // DESHACER (siempre)
    }
}
```

> [Siguiente: Poda](13-poda.md)
