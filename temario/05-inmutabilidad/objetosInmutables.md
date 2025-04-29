# Fundamentos de objetos inmutables

## ¿Por qué?

En la programación orientada a objetos tradicional, los objetos se crean con un estado inicial que puede ser modificado a lo largo de su ciclo de vida mediante métodos setter. Esta mutabilidad, aunque intuitiva y ampliamente utilizada, introduce complejidad cuando se trabaja en entornos concurrentes donde múltiples hilos pueden intentar modificar el mismo objeto simultáneamente.

El código mutable requiere mecanismos de sincronización como locks, semáforos o monitores para evitar condiciones de carrera. Estas sincronizaciones no solo reducen el rendimiento al forzar a los hilos a esperar, sino que también aumentan la complejidad del código y son susceptibles a problemas como deadlocks o starvation. Adicionalmente, la depuración de estos errores resulta extremadamente compleja debido a su naturaleza no determinista y difícilmente reproducible.

La mutabilidad también dificulta el razonamiento sobre el comportamiento del programa, ya que el estado de un objeto puede cambiar en cualquier momento desde cualquier parte del código que tenga acceso a él, lo que complica el seguimiento de las transformaciones y la identificación del origen de los errores.

## ¿Qué?

La inmutabilidad es un principio fundamental del paradigma de programación funcional que establece que, una vez creado un objeto, su estado no puede ser modificado. En lugar de alterar el estado existente, cualquier operación que aparentemente "modifica" el objeto realmente crea y devuelve una nueva instancia con los cambios aplicados, manteniendo el objeto original intacto.

En Java, un objeto inmutable se implementa mediante una clase cuyos atributos se declaran como `final` y que no proporciona métodos que modifiquen su estado interno. En lugar de los tradicionales setters, se implementan métodos alternativos llamados "withers" que, en vez de modificar el objeto actual, devuelven una nueva instancia que incorpora el cambio solicitado.

Este enfoque trasciende la simple ausencia de setters: implica un diseño completo orientado a la inmutabilidad que abarca todos los niveles de la clase, incluyendo sus atributos, relaciones y comportamientos.

## ¿Para qué?

La adopción de objetos inmutables ofrece múltiples beneficios que resuelven directamente los problemas mencionados:

- En entornos concurrentes, la inmutabilidad elimina por completo las condiciones de carrera relacionadas con el estado de los objetos, ya que estos no pueden ser modificados después de su creación. Esto permite prescindir de mecanismos de sincronización complejos, resultando en programas más eficientes que aprovechan mejor el paralelismo de los procesadores modernos.
- La inmutabilidad también mejora significativamente la facilidad de comprensión y mantenimiento del código, ya que garantiza que un objeto mantendrá su estado desde su creación, simplificando el rastreo de valores y el análisis del flujo de datos. Los objetos inmutables son inherentemente thread-safe, lo que elimina toda una categoría de errores potenciales relacionados con la concurrencia.
- Adicionalmente, los objetos inmutables pueden compartirse con seguridad entre diferentes partes del programa sin riesgo de efectos secundarios inesperados, lo que facilita la implementación de patrones como el caching o el flyweight para optimizar el uso de memoria.

## ¿Cómo?

La implementación de objetos inmutables en Java requiere seguir ciertos principios y técnicas que se detallan a continuación:

### Atributos finales y privados

Todos los campos de la clase deben declararse como `final` y preferiblemente `private` para evitar su modificación después de la inicialización:

```java
public class Person {
    private final String name;
    private final String lastName;
    private final int id;
    private final LocalDate birthDate;
    private final Address address;
    
    // Resto de la clase...
}
```

### Constructor completo

El constructor debe inicializar todos los atributos y realizar validaciones necesarias:

```java
public Person(String name, String lastName, int id, LocalDate birthDate, Address address) {
    // Validaciones
    if (name == null || name.trim().isEmpty()) {
        throw new IllegalArgumentException("Name cannot be null or empty");
    }
    if (lastName == null || lastName.trim().isEmpty()) {
        throw new IllegalArgumentException("Last name cannot be null or empty");
    }
    if (id <= 0) {
        throw new IllegalArgumentException("ID must be positive");
    }
    if (birthDate == null) {
        throw new IllegalArgumentException("Birth date cannot be null");
    }
    if (address == null) {
        throw new IllegalArgumentException("Address cannot be null");
    }
    
    // Asignación
    this.name = name;
    this.lastName = lastName;
    this.id = id;
    this.birthDate = birthDate;
    this.address = address;
}
```

### Métodos *withers* en lugar de *setters*

En vez de modificar el objeto, se crean nuevas instancias con los cambios aplicados:

```java
// En lugar de setName(String name)
public Person withName(String name) {
    return new Person(name, this.lastName, this.id, this.birthDate, this.address);
}

public Person withLastName(String lastName) {
    return new Person(this.name, lastName, this.id, this.birthDate, this.address);
}

public Person withId(int id) {
    return new Person(this.name, this.lastName, id, this.birthDate, this.address);
}

public Person withBirthDate(LocalDate birthDate) {
    return new Person(this.name, this.lastName, this.id, birthDate, this.address);
}

public Person withAddress(Address address) {
    return new Person(this.name, this.lastName, this.id, this.birthDate, address);
}
```

### Manejo adecuado de atributos compuestos

Si la clase contiene referencias a objetos mutables, es necesario asegurarse de que no se expongan directamente:

```java
// La clase Address también debe ser inmutable
public class Address {
    private final String street;
    private final String city;
    private final String zipCode;
    private final String country;

    public Address(String street, String city, String zipCode, String country) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
    }

    // Getters y withers para Address
    public String getStreet() {
        return street;
    }

    public Address withStreet(String street) {
        return new Address(street, this.city, this.zipCode, this.country);
    }

    // Otros getters y withers...
}
```

### Gestión de colecciones

Para mantener la inmutabilidad cuando se tienen colecciones como atributos:

```java
public class Team {
    private final String name;
    private final List<Person> members;
    
    public Team(String name, List<Person> members) {
        this.name = name;
        // Crear copia defensiva de la colección
        this.members = Collections.unmodifiableList(new ArrayList<>(members));
    }
    
    public String getName() {
        return name;
    }
    
    public List<Person> getMembers() {
        return members; // Ya es inmutable gracias a unmodifiableList
    }
    
    // Método para añadir un miembro creando un nuevo equipo
    public Team withAdditionalMember(Person newMember) {
        List<Person> newMembers = new ArrayList<>(members);
        newMembers.add(newMember);
        return new Team(name, newMembers);
    }
    
    // Método para eliminar un miembro creando un nuevo equipo
    public Team withoutMember(Person memberToRemove) {
        List<Person> newMembers = new ArrayList<>(members);
        newMembers.remove(memberToRemove);
        return new Team(name, newMembers);
    }
    
    // Método para reemplazar un miembro creando un nuevo equipo
    public Team withReplacedMember(Person oldMember, Person newMember) {
        List<Person> newMembers = new ArrayList<>(members);
        int index = newMembers.indexOf(oldMember);
        if (index != -1) {
            newMembers.set(index, newMember);
        }
        return new Team(name, newMembers);
    }
}
```

### Implementación correcta de equals y hashCode

Para que los objetos inmutables funcionen correctamente en colecciones y comparaciones:

```java
@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    
    Person person = (Person) o;
    
    if (id != person.id) return false;
    if (!name.equals(person.name)) return false;
    if (!lastName.equals(person.lastName)) return false;
    if (!birthDate.equals(person.birthDate)) return false;
    return address.equals(person.address);
}

@Override
public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + lastName.hashCode();
    result = 31 * result + id;
    result = 31 * result + birthDate.hashCode();
    result = 31 * result + address.hashCode();
    return result;
}
```

### Ejemplo completo de uso

```java
// Creación inicial
Address address = new Address("Main St", "Springfield", "12345", "USA");
Person person = new Person("John", "Doe", 12345, LocalDate.of(1980, 5, 15), address);

// Cambio de apellido (crea una nueva instancia)
Person marriedPerson = person.withLastName("Smith");

// Cambio de dirección (crea una nueva instancia)
Address newAddress = address.withCity("Boston").withZipCode("67890");
Person movedPerson = person.withAddress(newAddress);

// Creación de un equipo
List<Person> teamMembers = Arrays.asList(person, marriedPerson);
Team team = new Team("Dream Team", teamMembers);

// Añadir un nuevo miembro al equipo (crea un nuevo equipo)
Person newMember = new Person("Jane", "Wilson", 67890, LocalDate.of(1985, 8, 20), address);
Team expandedTeam = team.withAdditionalMember(newMember);

// El equipo original sigue teniendo solo 2 miembros
System.out.println("Original team size: " + team.getMembers().size()); // Output: 2
// El nuevo equipo tiene 3 miembros
System.out.println("Expanded team size: " + expandedTeam.getMembers().size()); // Output: 3
```

> [***Operaciones sobre colecciones inmutables***](inmutablesColecciones.md)
