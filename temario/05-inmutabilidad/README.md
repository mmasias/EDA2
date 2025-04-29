# Estructuras de datos inmutables

## ¿Por qué?

En el desarrollo de software tradicional basado en el paradigma imperativo, las estructuras de datos permiten modificaciones después de su creación. Los objetos pueden cambiar sus atributos mediante métodos setter, y las colecciones admiten operaciones de adición, eliminación y modificación de elementos. Esta mutabilidad, aunque conveniente, se convierte en problemática en entornos de ejecución concurrente donde múltiples hilos acceden y modifican las mismas estructuras de datos.

La ejecución paralela de código mutable requiere mecanismos de sincronización para evitar condiciones de carrera, donde un hilo puede estar leyendo un valor mientras otro lo modifica simultáneamente. Estas sincronizaciones generan bloqueos que reducen el rendimiento y añaden complejidad al código, además de ser propensas a errores difíciles de depurar como interbloqueos o inanición.

Por otra parte, la identificación de secciones críticas y la implementación correcta de los mecanismos de sincronización suponen una carga cognitiva adicional para los desarrolladores, quienes deben anticipar y prevenir posibles escenarios problemáticos en la ejecución concurrente.

## ¿Qué?

La **inmutabilidad** es un principio fundamental del paradigma de programación funcional que establece que, una vez creados, los datos no pueden ser modificados. En lugar de alterar los objetos existentes, se crean nuevas instancias que reflejan los cambios deseados, manteniendo intactos los objetos originales.

Este enfoque se aplica tanto a objetos individuales como a estructuras de datos complejas.

## ¿Para qué?

La adopción del paradigma inmutable resuelve de forma elegante los problemas asociados a la concurrencia.

Al trabajar con estructuras que no cambian después de su creación, se elimina la posibilidad de condiciones de carrera, ya que los objetos que un hilo está procesando no pueden ser modificados por otros hilos.

Esta característica elimina la necesidad de mecanismos de sincronización complejos, permitiendo que los hilos operen de forma independiente sin esperas ni bloqueos, lo que optimiza el rendimiento en sistemas multicore. De esta forma, se libera al programador de la tarea de identificar secciones críticas y gestionar la sincronización entre hilos.

Adicionalmente, el código inmutable resulta más predecible, comprensible y menos propenso a errores, facilitando tanto el desarrollo como el mantenimiento de aplicaciones. La inmutabilidad también favorece la aplicación de patrones funcionales que promueven la composición de operaciones y el razonamiento matemático sobre el código.

## ¿Cómo?

En Java, desde su versión 8, este paradigma se implementa mediante el uso de 

- Atributos finales en clases.
- Métodos "wither" en lugar de "setter".
- Operaciones sobre colecciones que generan nuevas instancias en vez de modificar las existentes.

Los Streams de Java permiten trabajar con colecciones inmutables a través de operaciones funcionales como mapeo, filtrado, reducción y aplanamiento, facilitando la transformación de datos sin efectos secundarios.

### [Objetos inmutables](objetosInmutables.md)

Para crear clases cuyos objetos sean inmutables, se deben aplicar estos principios:

```java
public class Person {
    private final String name;
    private final String lastName;
    private final int id;
    
    // Constructor
    public Person(String name, String lastName, int id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getId() {
        return id;
    }
    
    // Withers (reemplazan a los setters)
    public Person withName(String name) {
        return new Person(name, this.lastName, this.id);
    }
    
    public Person withLastName(String lastName) {
        return new Person(this.name, lastName, this.id);
    }
    
    public Person withId(int id) {
        return new Person(this.name, this.lastName, id);
    }
}
```

Los atributos se declaran como `final`, impidiendo su modificación tras la inicialización. En lugar de métodos setter, se implementan métodos "wither" que retornan una nueva instancia con el cambio aplicado.

