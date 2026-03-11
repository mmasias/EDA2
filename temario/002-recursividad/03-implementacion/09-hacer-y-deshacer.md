<div align=right>

<sub>[RECURSIVIDAD](/temario/002-recursividad/README.md)  
[Inducción](/temario/002-recursividad/01-induccion/prePatrones.md) / [Estructuración](/temario/002-recursividad/02-estructuracion/README.md) / [**Implementación**](/temario/002-recursividad/03-implementacion/README.md) / [Aplicación](/temario/002-recursividad/04-aplicacion/README.md) / [PostRecursividad](/temario/002-recursividad/05-postrecursividad/README.md)</sub>  
[Inicio](README.md) / [00](00-topologia.md) / [01](01-metodo-iterativo.md) / [02](02-recursion-sin-caso-base.md) / [03](03-un-caso-base.md) / [04](04-multiples-casos-base.md) / [05](05-multiples-llamadas-condicional.md) / [06](06-multiples-llamadas-ambas.md) / [07](07-interrupcion-recursiva.md) / [08](08-el-estado.md) / [**09**](09-hacer-y-deshacer.md) / [10](10-el-arbol-de-decisiones.md) / [11](11-una-solucion.md) / [12](12-todas-las-soluciones.md) / [13](13-poda.md) / [14](14-cierre.md)

</div>

# 09. Hacer y deshacer

## ¿Por qué?

La topología (Paso 00) ya mostró que lo que va después de la llamada recursiva se ejecuta al volver. Y el Paso 08 mostró que los objetos mutables son compartidos por todas las llamadas.

Estos dos hechos combinados dan lugar a un patrón: si antes de llamar **añado** algo a un objeto mutable, al volver puedo **quitarlo**. El objeto queda exactamente como estaba. El estado se restaura.

Eso es todo lo que hay detrás del nombre "hacer y deshacer".

## ¿Qué?

El patrón de modificar un objeto mutable antes de la llamada recursiva y revertirlo después, de forma que al volver el estado sea idéntico al que había antes de llamar.

```java
actual.agregar(elemento);      // HACER
explorar(siguienteEstado);     // EXPLORAR
actual.quitar();               // DESHACER
```

## ¿Para qué?

- Explorar múltiples ramas desde el mismo punto de partida con el camino en el estado correcto
- Construir soluciones candidatas paso a paso y revertirlas cuando no sirven
- Garantizar que cada rama de exploración parte de un estado limpio

## ¿Cómo?

### El problema

Dado el array `[1, 2, 3]`, generar todos los subconjuntos posibles.

Los subconjuntos de `[1, 2, 3]` son ocho: para cada elemento hay exactamente dos decisiones posibles — incluirlo o no. Procesamos los elementos uno a uno por índice. Cuando hemos tomado una decisión sobre todos ellos (`indice == nums.length`), el camino `actual` contiene exactamente un subconjunto completo.

### La clase auxiliar Camino

Para que el estado del camino sea visible en cada paso, implementamos una clase propia: `Camino` es una secuencia de enteros con tres operaciones:

<div align=center>

|Método|Efecto|
|-|-|
|`agregar(x)`|Añade `x` al final|
|`quitar()`|Elimina el último elemento|
|`toString()`|Devuelve los elementos entre corchetes|

</div>

`new Camino(n)` crea un camino vacío con capacidad para `n` elementos.

### Implementación

```java
class FabricaDeSubconjuntos {

    static void fabricar(int[] nums, int indice, Camino actual) {
        if (indice == nums.length) {
            System.out.println(actual);
            return;
        }
        // Rama 1: incluir nums[indice]
        actual.agregar(nums[indice]);          // HACER
        fabricar(nums, indice + 1, actual);    // EXPLORAR
        actual.quitar();                       // DESHACER

        // Rama 2: no incluir nums[indice]
        fabricar(nums, indice + 1, actual);    // EXPLORAR (sin hacer ni deshacer)
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        fabricar(nums, 0, new Camino(nums.length));
    }
}
```

```
[1, 2, 3]
[1, 2]
[1, 3]
[1]
[2, 3]
[2]
[3]
[]
```

Los ocho subconjuntos, cada uno correcto.

## Análisis

### El invariante

El `quitar` garantiza que al salir de `fabricar`, el camino `actual` está exactamente igual que cuando se entró. Ese es el invariante del patrón: **la llamada no deja rastro**.

```
al entrar: actual = [...]
  actual.agregar(nums[indice])  → actual = [..., nums[indice]]
  fabricar(...)                 → puede pasar cualquier cosa dentro
  actual.quitar()               → actual = [...]
al salir:  actual = [...]       ← idéntico al entrar
```

Sin el `quitar`, la segunda rama arrancaría con el camino modificado por la primera. El Paso 08 ya explicó por qué: el objeto es compartido por todas las llamadas.

### La segunda rama no necesita deshacer

La rama "excluir" no modifica el camino antes de llamar, así que tampoco necesita revertir nada al volver.

<div align=center>

|Rama|Hace algo|Necesita deshacer|
|-|-|-|
|Incluir `nums[indice]`|Sí: `agregar`|Sí: `quitar`|
|Excluir `nums[indice]`|No (pero también explora)|No|

</div>

### Estructura general

```java
void explorar(estado, parámetros) {
    if (casoBase) {
        procesarSolucion(estado);
        return;
    }

    // Opción 1: usar el elemento actual
    estado.agregar(elemento);      // HACER
    explorar(estadoReducido);      // EXPLORAR
    estado.quitar();               // DESHACER

    // Opción 2: no usar el elemento actual
    explorar(estadoReducido);      // EXPLORAR (sin hacer ni deshacer)
}
```

¿Qué forma tiene el espacio que esto está recorriendo? Eso es el siguiente paso.

[Siguiente: El árbol de decisiones](10-el-arbol-de-decisiones.md)
