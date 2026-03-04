<div align=right>

<sub>[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [09](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [**13**](13-poda.md) / [14](14-cierre.md)</sub>

</div>

# 13. Poda

## ¿Por qué?

El Paso 12 explora el árbol completo. Con `[1, 2, 3, 4, 5]` y objetivo `7`, eso significa visitar las 32 hojas del árbol (2^5). Muchas de esas ramas nunca podrían llevar a una solución válida, pero se exploran igualmente.

El Paso 07 ya introdujo la idea de interrumpir una rama antes de llegar al caso base. Aquí se aplica esa misma idea al contexto de la exploración: si se puede detectar que una rama no puede llevar a ninguna solución, no hay que entrar en ella.

## ¿Qué?

La poda consiste en añadir condiciones que descartan ramas enteras del árbol de decisiones **antes de explorarlas**, en cuanto se detecta que no pueden producir ninguna solución válida.

## ¿Para qué?

- Reducir el número de llamadas recursivas
- Hacer viable la exploración de espacios que sin poda serían demasiado grandes
- Entender que la corrección y la eficiencia son preocupaciones separadas

## ¿Cómo?

### La condición de poda

En el problema de suma de subconjuntos con números positivos, si `restante` se vuelve negativo significa que la suma ya superó el objetivo. Dado que todos los números son positivos, ninguna decisión futura puede reducir la suma. Esa rama está muerta.

Sin poda, se entra en ella igualmente y se exploran todas sus hojas hasta agotar los índices.

### Implementación sin poda vs con poda

<div align=center>

<table>
<tr><th>Sin poda (Paso 12)</th><th>Con poda</th></tr>
<tr><td>

```java
static void buscarTodas(int[] nums, int indice,
        int restante, Camino actual) {

    if (restante == 0) {
        System.out.println("Solución: " + actual);
        return;
    }
    if (indice == nums.length) {
        return;
    }

    actual.agregar(nums[indice]);
    buscarTodas(nums, indice + 1,
        restante - nums[indice], actual);
    actual.quitar();

    buscarTodas(nums, indice + 1,
        restante, actual);
}
```

</td><td>

```java
static void buscarTodas(int[] nums, int indice,
        int restante, Camino actual) {

    if (restante == 0) {
        System.out.println("Solución: " + actual);
        return;
    }
    if (indice == nums.length) {
        return;
    }
    if (restante < 0) {
        return;               // PODA
    }

    actual.agregar(nums[indice]);
    buscarTodas(nums, indice + 1,
        restante - nums[indice], actual);
    actual.quitar();

    buscarTodas(nums, indice + 1,
        restante, actual);
}
```

</td></tr>
</table>

</div>

El resultado es idéntico: `[1, 2, 4]`, `[2, 5]`, `[3, 4]`. La poda no cambia lo que se encuentra, solo cuánto trabajo se hace para encontrarlo.

### Qué ramas se podan

El mismo árbol, antes y después de aplicar la poda:

<div align=center>

|Sin poda
|:-:|
|![Sin poda](../images/modelosUML/12-todas-las-soluciones.svg) 
|**Con poda**
|![Con poda](../images/modelosUML/13-con-poda.svg)

</div>

Los nodos naranjas son las ramas cortadas. En el árbol sin poda, cada uno de esos nodos tiene dos hijos que siempre devuelven `false`. La poda los elimina antes de entrar.

### Corrección vs eficiencia

La poda no afecta a la corrección porque la condición que poda es una condición de imposibilidad real: con números positivos, una suma que ya excedió el objetivo no puede reducirse añadiendo más números. La rama podada no contiene ninguna solución válida.

<div align=center>

|Aspecto|Sin poda|Con poda|
|-|-|-|
|Salida|`[1,2,4]`, `[2,5]`, `[3,4]`|`[1,2,4]`, `[2,5]`, `[3,4]`|
|Corrección|Sí|Sí|
|Ramas exploradas|Más|Menos|
|Complejidad en el peor caso|O(2^n)|O(2^n) — solo mejora en casos favorables|

</div>

La poda mejora el caso promedio, no el peor caso teórico. Su impacto real depende del problema y de los datos concretos.

### Estructura general con poda

```java
void explorar(estado, parametros) {
    if (esSolucion(estado)) {
        mostrar(estado);
        return;
    }
    if (sinSalida(estado)) {
        return;
    }
    if (esImposible(estado)) {       // ← PODA
        return;
    }

    para (cada opcion) {
        estado.agregar(opcion);
        explorar(estado, ...);
        estado.quitar();
    }
}
```

La condición de poda va después de los casos base y antes de la exploración. Es una aseveración: "si esto es cierto, nada de lo que haga a partir de aquí puede producir una solución válida".

## Recapitulación de los pasos 08–13

<div align=center>

|Paso|Concepto|Qué aporta|
|-|-|-|
|08|El estado|Los objetos mutables son compartidos por todas las llamadas|
|09|Hacer y deshacer|Añadir antes de llamar, quitar al volver: el estado se restaura|
|10|El árbol de decisiones|La pila de llamadas ES el árbol; `actual` ES el camino actual|
|11|Una solución|`return true` colapsa el árbol en cuanto encuentra la primera hoja válida|
|12|Todas las soluciones|Guardar y continuar; el `quitar` es siempre incondicional|
|13|Poda|Descartar ramas imposibles antes de explorarlas|

</div>

El patrón completo —explorar un espacio de decisiones, construyendo y deshaciendo estado, con posibilidad de cortar ramas— tiene nombre: **backtracking**. No es una técnica separada de la recursión: es recursión aplicada a problemas con múltiples decisiones encadenadas.

> [Síntesis](14-cierre.md)
