<div align=right>

|[ArrayList](arraylist.md)|[LinkedList](linkedlist.md)|[Vector](vector.md)|[Stack](stack.md)|[ArrayDeque](arraydeque.md)|[PriorityQueue](priorityqueue.md)|[EnumSet](enumset.md)|
|-|-|-|-|-|-|-|

</div>

# Vector

## ¿Por qué?

La clase `Vector` se introduce en Java como una alternativa a los arrays para almacenar colecciones de objetos. A diferencia de los arrays, `Vector` puede cambiar su tamaño dinámicamente para acomodar la adición o eliminación de elementos. Aunque similar a `ArrayList`, `Vector` es sincronizado, lo que significa que es seguro para su uso en entornos multihilo donde varios hilos modifican el `Vector` simultáneamente. Sin embargo, esta sincronización introduce una sobrecarga y penalizan su rendimiento en comparación con `ArrayList`.

## ¿Qué?

`Vector` es una clase que implementa la interfaz `List` y forma parte del Java Collection Framework. Ofrece una colección dinámica de objetos, similar a un array, pero con la capacidad de ajustar su tamaño automáticamente cuando se agregan o eliminan elementos. Todos los métodos que modifican el `Vector` están sincronizados, lo que lo hace thread-safe. Aunque `Vector` y `ArrayList` comparten muchas funcionalidades, `Vector` se utiliza en contextos donde la seguridad en entornos multihilo es una prioridad.

## ¿Para qué?

El `Vector` se utiliza para almacenar y acceder a colecciones de objetos de manera dinámica y segura en entornos multihilo. Sus principales ventajas incluyen:

- **Sincronización:** `Vector` es seguro para el uso concurrente sin necesidad de sincronización adicional.
- **Capacidad ajustable:** Al igual que `ArrayList`, `Vector` ajusta su tamaño automáticamente según sea necesario.
- **Acceso a elementos:** Permite el acceso directo a cualquier elemento basado en un índice.

Es ideal para aplicaciones que requieren acceso y modificación seguros de listas en entornos multihilo, pero puede ser menos eficiente en términos de rendimiento que `ArrayList` debido a su naturaleza sincronizada.

## ¿Cómo?

### Creación

```java
Vector<String> vector = new Vector<>();
```

### Añadir elementos

```java
vector.add("Elemento 1");
vector.addElement("Elemento 2");
```

### Acceder a elementos

```java
String elemento = vector.get(0);
```

### Modificar elementos

```java
vector.set(0, "Nuevo Elemento");
```

### Eliminar elementos

```java
vector.remove("Elemento 1");
vector.remove(0);
```

### Tamaño del vector

```java
int size = vector.size();
```

### Iterar sobre elementos

```java
for (String item : vector) {
    System.out.println(item);
}
```

### Métodos adicionales para investigación

A continuación, se presenta una tabla con algunos métodos de Vector que no se han explicado en detalle, para fomentar la investigación adicional:

|Método|Descripción|
|-|-|
|`addElement(E obj)`|Añade el elemento especificado al final de este Vector.
|`capacity()`|Devuelve la capacidad actual de este Vector.
|`contains(Object elem)`|Comprueba si el Vector contiene el elemento especificado.
|`copyInto(Object[] anArray)`|Copia los componentes de este Vector en el array especificado.
|`elementAt(int index)`|Devuelve el componente en el índice especificado.
|`elements()`|Devuelve un enumeration de los componentes de este Vector.
|`ensureCapacity(int minCapacity)`|Aumenta la capacidad de este Vector, si es necesario, para asegurar que pueda contener al menos el número de componentes especificado en el argumento minCapacity.
|`firstElement()`|Devuelve el primer componente (el elemento en el índice 0) de este Vector.
|`lastElement()`|Devuelve el último componente del Vector.
|`removeElement(Object obj)`|Elimina la primera (más baja) ocurrencia del argumento del Vector.
|`removeElementAt(int index)`|Elimina el componente en el índice especificado.
|`setElementAt(E obj, int index)`|Establece el componente en el índice especificado de este Vector para ser el elemento especificado.
|`trimToSize()`|Recorta la capacidad de este Vector al tamaño actual del Vector.
