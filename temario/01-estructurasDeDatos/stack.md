<div align=right>

|[ArrayList](arraylist.md)|[LinkedList](linkedlist.md)|[Vector](vector.md)|[Stack](stack.md)|[ArrayDeque](arraydeque.md)|[PriorityQueue](priorityqueue.md)|[EnumSet](enumset.md)|
|-|-|-|-|-|-|-|

</div>

# Stack

## ¿Por qué?

La clase `Stack` en Java se introduce para proporcionar una estructura de datos que siga el principio de último en entrar, primero en salir (LIFO, por sus siglas en inglés). Esto es útil en numerosas aplicaciones de programación donde se requiere este tipo de comportamiento, como en la implementación de algoritmos de navegación (por ejemplo, navegadores web para la gestión del historial de páginas), algoritmos de recorrido de árboles y grafos, y en el manejo de llamadas a funciones.

## ¿Qué?

`Stack` es una clase que extiende `Vector` e introduce operaciones que permiten tratar a un vector como una pila. Permite operaciones como mirar el objeto superior de la pila sin sacarlo (`peek`), sacar un objeto de la pila (`pop`), y empujar un objeto a la cima de la pila (`push`). Aunque `Stack` hereda de `Vector`, sus métodos están específicamente diseñados para aprovechar el comportamiento LIFO.

## ¿Para qué?

El `Stack` se utiliza principalmente para realizar operaciones en una colección de elementos donde el último elemento agregado es el primero en ser eliminado. Sus principales ventajas incluyen:

- **Simplicidad en el manejo de datos:** Proporciona una manera fácil de implementar algoritmos o funciones que requieren una estructura LIFO.
- **Fácil de usar:** Al extender `Vector`, `Stack` hereda sus métodos y propiedades, haciendo que sea fácil de utilizar y entender.
- **Aplicaciones en la vida real:** Desde el análisis sintáctico (parsing) en compiladores hasta el manejo de llamadas a funciones, `Stack` tiene numerosas aplicaciones prácticas.

Es ideal para escenarios donde se necesita acceso rápido y controlado al elemento más reciente.

## ¿Cómo?

### Creación

```java
Stack<String> stack = new Stack<>();
```

### Empujar (agregar) elementos

```java
stack.push("Elemento 1");
stack.push("Elemento 2");
```

### Mirar el elemento superior (sin sacarlo)

```java
String topElement = stack.peek();
```

### Sacar elementos

```java
String poppedElement = stack.pop();
```

### Comprobar si la pila está vacía

```java
boolean isEmpty = stack.isEmpty();
```

### Buscar elementos

```java
int position = stack.search("Elemento 1"); 
```

> Devuelve su posición basada en 1 (o -1 si no se encuentra)

### Métodos adicionales para investigación

A continuación, se presenta una tabla con los métodos de Stack que se han explicado y otros heredados de Vector que pueden ser útiles para investigar:

|Método|Descripción|
|-|-|
|`push(E item)`|Empuja un elemento hacia la cima de la pila.
|`pop()`|Elimina el objeto en la cima de esta pila y lo devuelve como el valor de esta función.
|`peek()`|Mira el objeto en la cima de esta pila sin sacarlo de la pila.
|`isEmpty()`|Comprueba si la pila está vacía.
|`search(Object o)`|Busca el objeto en la pila y devuelve su posición basada en 1 desde la cima de la pila.
|`size()`|Devuelve el tamaño de la pila (heredado de Vector).
|`capacity()`|Devuelve la capacidad actual de esta pila (heredado de Vector).
|`contains(Object o)`|Verifica si la pila contiene el elemento especificado (heredado de Vector).
|`elementAt(int index)`|Devuelve el componente en el índice especificado (heredado de Vector).
|`ensureCapacity(int minCapacity)`|Aumenta la capacidad de esta pila, si es necesario (heredado de Vector).
|`clear()`|Elimina todos los elementos de la pila (equivalente a removeAllElements heredado de Vector).
