<div align=right>

|[ArrayList](arraylist.md)|[LinkedList](linkedlist.md)|[Vector](vector.md)|[Stack](stack.md)|[ArrayDeque](arraydeque.md)|[PriorityQueue](priorityqueue.md)|[EnumSet](enumset.md)|
|-|-|-|-|-|-|-|

</div>

# LinkedList

## ¿Por qué?

La clase `LinkedList` se introduce como parte del Java Collection Framework para proporcionar una implementación de lista enlazada de elementos. A diferencia de `ArrayList`, `LinkedList` está diseñada para optimizar la inserción, eliminación y acceso a elementos en cualquier parte de la list. Esto se debe a que, en una lista enlazada, los elementos no están almacenados en ubicaciones de memoria contiguas, permitiendo inserciones y eliminaciones rápidas al no requerir el desplazamiento de otros elementos.

## ¿Qué?

`LinkedList` es una clase en Java que implementa la interfaz `List` y proporciona una lista doblemente enlazada. Esto significa que cada elemento en la lista mantiene una referencia al elemento anterior y al siguiente en la lista, permitiendo una navegación eficiente en ambas direcciones. `LinkedList` puede contener elementos duplicados y permite la inserción de elementos nulos.

## ¿Para qué?

El `LinkedList` se utiliza principalmente cuando se necesita un rendimiento óptimo en operaciones como inserción, eliminación y recorrido de elementos, especialmente en aplicaciones donde estas operaciones son más frecuentes que el acceso aleatorio a los elementos. Sus principales ventajas incluyen:

- **Inserciones y eliminaciones eficientes:** Ideal para aplicaciones que requieren frecuentes operaciones de inserción y eliminación.
- **Implementa tanto `List` como `Deque`:** Ofrece métodos adicionales para actuar como una cola doblemente terminada (deque), permitiendo su uso como una pila (stack) o una cola (queue).
- **Soporte para operaciones de lista enlazada:** Proporciona métodos específicos para operaciones de lista enlazada, como `getFirst()`, `getLast()`, `addFirst(E e)`, y `addLast(E e)`.

Es menos adecuado para escenarios con acceso aleatorio intensivo, ya que el acceso a un elemento específico requiere un recorrido desde el inicio de la lista, lo que puede ser menos eficiente que en un `ArrayList`.

## ¿Cómo?

### Creación

```java
LinkedList<String> list = new LinkedList<>();
```

### Añadir elementos

```java
list.add("Elemento 1");
list.addFirst("Elemento al inicio");
list.addLast("Elemento al final");
```

### Acceder a elementos

```java
String primerElemento = list.getFirst();
String ultimoElemento = list.getLast();
```

### Modificar elementos

No hay un método directo para reemplazar un elemento en una posición específica sin usar el método set(int index, E element), similar al ArrayList.

```java
list.set(1, "Nuevo Elemento");
```

### Eliminar elementos

```java
list.removeFirst();
list.removeLast();
list.remove("Elemento");
```

> El último ejemplo elimina **la primera ocurrencia** de "Elemento"

### Tamaño de la lista

```java
int size = list.size();
```

### Iterar sobre elementos

```java
for (String item : list) {
    System.out.println(item);
}
```

### Métodos adicionales para investigación

A continuación, se presenta una tabla con algunos métodos de LinkedList que no se han explicado en detalle, para fomentar la investigación adicional:

|Método|Descripción|
|-|-|
|add(int index, E element)`|Inserta el elemento especificado en la posición indicada en esta list.
|get(int index)`|Devuelve el elemento en la posición especificada en esta list.
|remove(int index)`|Elimina el elemento en la posición especificada en esta list.
|indexOf(Object o)`|Devuelve el índice de la primera aparición del elemento especificado en esta lista, o -1 si esta lista no contiene el elemento.
|clear()`|Elimina todos los elementos de esta list.
|contains(Object o)`|Verifica si la lista contiene el elemento especificado.
|listIterator(int index)`|Devuelve un list iterator sobre los elementos en esta lista (en secuencia correcta), comenzando en la posición especificada en la list.
|toArray()`|Convierte la lista en un array.
