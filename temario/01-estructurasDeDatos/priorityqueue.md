<div align=right>

|[ArrayList](arraylist.md)|[LinkedList](linkedlist.md)|[Vector](vector.md)|[Stack](stack.md)|[ArrayDeque](arraydeque.md)|[PriorityQueue](priorityqueue.md)|[EnumSet](enumset.md)|
|-|-|-|-|-|-|-|

</div>

# PriorityQueue

## ¿Por qué?

La clase `PriorityQueue` se introduce en Java para proporcionar una estructura de datos de cola con prioridad, donde los elementos de la cola son ordenados según su orden natural o por un `Comparator` proporcionado en el momento de la creación de la cola. Esto es útil en situaciones donde se desea procesar los elementos no en el orden en que fueron agregados, sino según su prioridad.

## ¿Qué?

`PriorityQueue` es una clase del Java Collection Framework que implementa la interfaz `Queue`. Ofrece una implementación específica de una cola (FIFO) que ordena sus elementos según su prioridad. A diferencia de una cola estándar, no necesariamente accede a los elementos en el orden en que fueron insertados, sino basándose en su prioridad. Si no se especifica un comparador, los elementos se ordenan según su orden natural.

## ¿Para qué?

El `PriorityQueue` se utiliza para casos en los que es importante procesar objetos no en el orden en que fueron agregados, sino de acuerdo a algún criterio de prioridad. Sus principales ventajas incluyen:

- **Ordenación automática de elementos:** Al insertar, los elementos se ordenan automáticamente según su prioridad.
- **Acceso eficiente al elemento de mayor prioridad:** Permite acceder rápidamente al elemento de mayor prioridad sin necesidad de ordenar la colección manualmente.
- **Flexibilidad en la definición de prioridades:** La prioridad puede basarse en el orden natural de los elementos o en un `Comparator` definido por el usuario.

Es ideal para tareas de programación como la planificación de tareas, algoritmos de camino más corto, y en cualquier lugar donde el procesamiento de prioridad sea crítico.

## ¿Cómo?

### Creación

```java
PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
```

### Añadir elementos

```java
priorityQueue.add(10);
priorityQueue.offer(5);
```

### Acceder al elemento de mayor prioridad

```java
Integer highestPriority = priorityQueue.peek();
```

### Sacar el elemento de mayor prioridad

```java
Integer removedElement = priorityQueue.poll();
```

### Tamaño de la cola

```java
int size = priorityQueue.size();
```

### Iterar sobre elementos
Es importante notar que el iterador no garantiza recorrer los elementos en el orden de prioridad.

```java
for (Integer item : priorityQueue) {
    System.out.println(item);
}
```

### Métodos adicionales para investigación

A continuación, se presenta una tabla con algunos métodos de PriorityQueue que pueden ser útiles para investigar:

|Método|Descripción|
|-|-|
|`offer(E e)`|Inserta el elemento especificado en esta cola si es posible hacerlo inmediatamente sin violar las restricciones de capacidad.
|`poll()`|Recupera y elimina la cabeza de esta cola, o devuelve null si esta cola está vacía.
|`peek()`|Recupera, pero no elimina, la cabeza de esta cola, o devuelve null si esta cola está vacía.
|`comparator()`|Devuelve el comparador utilizado para ordenar los elementos en esta cola, o null si se usa el ordenamiento natural.
|`clear()`|Elimina todos los elementos de la cola.
|`contains(Object o)`|Comprueba si esta cola contiene el elemento especificado.
|`toArray()`|Devuelve un array que contiene todos los elementos en esta cola.
|`remove(Object o)`|Elimina una única instancia del elemento especificado de esta cola, si está presente.
|`size()`|Devuelve el número de elementos en esta cola.
