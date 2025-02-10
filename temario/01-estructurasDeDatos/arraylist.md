<div align=right>

|[ArrayList](arraylist.md)|[LinkedList](linkedlist.md)|[Vector](vector.md)|[Stack](stack.md)|[ArrayDeque](arraydeque.md)|[PriorityQueue](priorityqueue.md)|[EnumSet](enumset.md)|
|-|-|-|-|-|-|-|

</div>

# ArrayList

## ¿Por qué?

La clase `ArrayList` se introduce como una solución a la limitación de los arrays tradicionales en Java, los cuales tienen un tamaño fijo una vez creados. Esto significa que, si no se conoce el número exacto de elementos que se necesita almacenar, o si este número puede cambiar con el tiempo, los arrays tradicionales no serán una opción flexible o eficiente. Aquí es donde el `ArrayList` brilla, proporcionando una estructura de datos dinámica que puede crecer y encogerse en tiempo de ejecución según sea necesario.

## ¿Qué?

`ArrayList` es una clase del Java Collection Framework que implementa la interfaz `List`. Esencialmente, es una matriz redimensionable que permite almacenar elementos de cualquier tipo (incluidos objetos) en una lista ordenada. A diferencia de los arrays estándar, el `ArrayList` puede cambiar de tamaño automáticamente para acomodar la adición y eliminación de elementos, ofreciendo una gran flexibilidad para manejar colecciones de objetos.

## ¿Para qué?

El `ArrayList` se utiliza para almacenar datos de forma dinámica. Sus principales ventajas incluyen:

- **Flexibilidad en el tamaño:** A diferencia de los arrays estáticos, el `ArrayList` puede ajustar su tamaño en tiempo de ejecución.
- **Facilidad de manipulación:** Proporciona métodos para realizar operaciones comunes como insertar, actualizar, eliminar y buscar elementos con facilidad.
- **Almacenamiento de objetos:** Permite almacenar cualquier tipo de objeto (excepto tipos primitivos, que se pueden almacenar mediante clases envolventes).

Es ideal para situaciones donde se necesita una colección ordenada que pueda cambiar de tamaño y cuando se desea aprovechar los métodos integrados que simplifican la gestión de los datos almacenados.

## ¿Cómo?

### Creación

```java
ArrayList<String> myList = new ArrayList<>();
```

### Añadir elementos

```java
myList.add("Elemento 1");
myList.add("Elemento 2");
```

### Acceder a elementos

Accede al primer elemento

```java
String element = myList.get(0);
```

### Modificar elementos

Modifica el primer elemento

```java
myList.set(0, "Nuevo Elemento");
```

### Eliminar elementos

Por objeto y por índice

```java
myList.remove("Elemento 1"); 
myList.remove(0);
```

### Tamaño de la lista

```java
int size = myList.size();
```

### Iterar sobre elementos

```java
for (String item : myList) {
    System.out.println(item);
}
```

### Métodos adicionales para investigación

A continuación, se presenta una tabla con algunos métodos de ArrayList que no se han explicado en detalle, para fomentar la investigación adicional:

|Método|Descripción|
|-|-|
|`clear()`|Elimina todos los elementos de la lista.
|`contains(Object o)`|Verifica si la lista contiene el elemento especificado.
|`indexOf(Object o)`|Devuelve el índice de la primera aparición del elemento especificado, o -1 si la lista no contiene el elemento.
|`isEmpty()`|Comprueba si la lista está vacía.
|`lastIndexOf(Object o)`|Devuelve el índice de la última aparición del elemento especificado, o -1 si la lista no contiene el elemento.
|`toArray()`|Convierte la lista en un array.
|`addAll(Collection c)`|Añade todos los elementos de la colección especificada al final de la lista.
|`removeAll(Collection c)`|Elimina de la lista todos los elementos que están contenidos en la colección especificada.
|`retainAll(Collection c)`|Retiene solo los elementos en esta lista que están contenidos en la colección especificada.
|`subList(int fromIndex, int toIndex)`|Crea una vista de la porción de esta lista entre los índices especificados.
