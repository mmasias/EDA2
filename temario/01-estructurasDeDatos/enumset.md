<div align=right>

|[ArrayList](arraylist.md)|[LinkedList](linkedlist.md)|[Vector](vector.md)|[Stack](stack.md)|[ArrayDeque](arraydeque.md)|[PriorityQueue](priorityqueue.md)|[EnumSet](enumset.md)|
|-|-|-|-|-|-|-|

</div>

# EnumSet

## ¿Por qué?

`EnumSet` se introduce en Java para proporcionar una implementación eficiente de conjuntos (sets) específicamente para su uso con tipos de enumeración (`enum`). Las enumeraciones definen un conjunto de constantes nombradas, y `EnumSet` aprovecha esta característica inherente para realizar operaciones de conjunto altamente eficientes y optimizadas en términos de rendimiento. A diferencia de otras implementaciones de `Set`, `EnumSet` utiliza un vector de bits internamente, lo que significa que es mucho más eficiente que usar `HashSet` o `TreeSet` para tipos enum.

## ¿Qué?

`EnumSet` es una clase especializada en el paquete `java.util` que se utiliza para crear conjuntos de elementos de un tipo de enumeración especificado. Es una implementación de la interfaz `Set` que proporciona todas las operaciones de conjuntos como adición, eliminación y verificación de pertenencia, pero solo puede contener elementos de un único tipo enum. `EnumSet` garantiza que los elementos estén en el orden en que se declararon en la enumeración, y no permite elementos nulos.

## ¿Para qué?

`EnumSet` es ideal para casos de uso donde se necesita manejar conjuntos de valores enum de manera eficiente. Sus principales ventajas incluyen:

- **Alto rendimiento:** Al utilizar una representación de vector de bits, las operaciones como adición, eliminación y consulta son extremadamente rápidas.
- **Uso de memoria optimizado:** Al ser altamente optimizado para tipos enum, `EnumSet` utiliza significativamente menos memoria en comparación con otros `Set`.
- **Orden de elementos:** Mantiene los elementos en el orden en que se declaran en la enumeración, lo que puede ser útil para ciertos algoritmos o interfaces de usuario.

Es especialmente útil en contextos donde se requieren operaciones intensivas de conjunto sobre enumeraciones, como filtros de configuración, opciones de aplicación, y más.

## ¿Cómo?

### Creación

```java
EnumSet<DayOfWeek> days = EnumSet.noneOf(DayOfWeek.class);
```

### Añadir elementos

```java
days.add(DayOfWeek.MONDAY);
days.addAll(EnumSet.of(DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY));
```

### Eliminar elementos

```java
days.remove(DayOfWeek.MONDAY);
days.removeAll(EnumSet.of(DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY));
```

### Acceso y consulta

```java
boolean contains = days.contains(DayOfWeek.MONDAY);
boolean isEmpty = days.isEmpty();
```

### Iterar sobre elementos

```java
for (DayOfWeek day : days) {
    System.out.println(day);
}
```

### Métodos adicionales para investigación

A continuación, se presenta una tabla con algunos métodos de EnumSet para investigar:

|Método|Descripción|
|-|-|
|`allOf(Class<E> elementType)`|Crea un EnumSet que contiene todos los elementos del tipo enum especificado.
|`complementOf(EnumSet<E> s)`|Crea un EnumSet que contiene todos los elementos del tipo enum especificado que no están en el conjunto especificado.
|`copyOf(EnumSet<E> s)`|Crea una copia del EnumSet especificado.
|`copyOf(Collection<E> c)`|Crea un EnumSet que contiene los elementos especificados, determinando el tipo enum a partir de los elementos de la primera colección.
|`range(E from, E to)`|Crea un EnumSet que contiene un rango de elementos del tipo enum especificado.
|`noneOf(Class<E> elementType)`|Crea un EnumSet vacío para el tipo enum especificado.
