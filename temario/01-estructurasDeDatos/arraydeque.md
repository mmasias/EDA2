<div align=right>

|[ArrayList](arraylist.md)|[LinkedList](linkedlist.md)|[Vector](vector.md)|[Stack](stack.md)|[ArrayDeque](arraydeque.md)|[PriorityQueue](priorityqueue.md)|[EnumSet](enumset.md)|
|-|-|-|-|-|-|-|

</div>

# ArrayDeque

## ¿Por qué?

La clase `ArrayDeque` se introduce en Java para proporcionar una forma eficiente de implementar colas doblemente terminadas (deque). A diferencia de otras estructuras de datos como `Stack` y `LinkedList`, `ArrayDeque` está optimizada para un rendimiento más eficiente al insertar, eliminar y acceder a elementos desde ambos extremos de la cola. Al no estar sincronizada, ofrece un rendimiento más rápido en comparación con `Vector` o `Stack` cuando se usa en entornos de un solo hilo.

## ¿Qué?

`ArrayDeque` es una clase que implementa la interfaz `Deque`, ofreciendo la funcionalidad de una cola doblemente terminada usando un arreglo dinámico. Esto significa que los elementos pueden ser añadidos o eliminados desde cualquiera de los dos extremos de la colección, funcionando tanto como pila (LIFO) como cola (FIFO). `ArrayDeque` no permite el almacenamiento de elementos nulos y es más eficiente que `Stack` cuando se utiliza como pila.

## ¿Para qué?

El `ArrayDeque` se utiliza para:

- **Implementar colas y pilas:** Ofrece métodos para su uso como cola (FIFO) o como pila (LIFO), proporcionando una alternativa más eficiente a `LinkedList`.
- **Operaciones de alto rendimiento en ambos extremos:** Es ideal para algoritmos que requieren inserciones, eliminaciones o acceso frecuente a elementos desde ambos extremos de la colección.
- **Uso en aplicaciones de un solo hilo:** Al no estar sincronizado, es adecuado para situaciones donde no se requiere acceso concurrente, ofreciendo un mejor rendimiento que otras estructuras de datos sincronizadas.

## ¿Cómo?

### Creación

```java
ArrayDeque<String> deque = new ArrayDeque<>();
```

### Añadir elementos

```java
deque.addFirst("Elemento al inicio");
deque.addLast("Elemento al final");
```

### Eliminar elementos

```java
deque.removeFirst();
deque.removeLast();
```

### Acceder a elementos

```java
String firstElement = deque.peekFirst();
String lastElement = deque.peekLast();
```

### Uso como pila

```java
deque.push("Nuevo Elemento");
String poppedElement = deque.pop();
```

> Primero se agrega un elemento al inicio de la pila, luego se quita y se retorna.

### Comprobar si está vacío

```java
boolean isEmpty = deque.isEmpty();
```

### Métodos adicionales para investigación

A continuación, se presenta una tabla con algunos métodos de ArrayDeque que se han explicado y otros que pueden ser útiles para investigar:

|Método|Descripción|
|-|-|
|`add(E e)`|Añade el elemento especificado al final de esta deque.
|`offerFirst(E e)`|Inserta el elemento especificado al frente de esta deque.
|`offerLast(E e)`|Inserta el elemento especificado al final de esta deque.
|`getFirst()`|Devuelve el primer elemento de esta deque.
|`getLast()`|Devuelve el último elemento de esta deque.
|`pollFirst()`|Recupera y elimina el primer elemento de esta deque, o retorna null si esta deque está vacía.
|`pollLast()`|Recupera y elimina el último elemento de esta deque, o retorna null si esta deque está vacía.
|`contains(Object o)`|Retorna true si esta deque contiene el elemento especificado.
|`size()`|Devuelve el número de elementos en esta deque.
|`clear()`|Elimina todos los elementos de esta deque.
|`iterator()`|Devuelve un iterador sobre los elementos en esta deque en secuencia correcta.
|`descendingIterator()`|Devuelve un iterador sobre los elementos en esta deque en secuencia inversa.
