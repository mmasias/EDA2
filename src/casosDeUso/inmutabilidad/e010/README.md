## ¿Por qué?

Para este ejemplo, se requiere transformar datos de manera fundamental para diferentes necesidades en el desarrollo de software. En el caso presentado, se observan varios escenarios problemáticos:

- Los enteros necesitan ser transformados en sus cuadrados para cálculos específicos
- Es necesario convertir números en representaciones textuales para mostrarlos al usuario
- Las personas almacenadas como objetos complejos necesitan simplificarse para diferentes propósitos (extraer solo nombres, combinar nombres completos)
- La transformación de objetos completos a DTOs es común para capas de presentación o comunicación entre servicios

## ¿Qué?

Se aplica el patrón de mapeo (map) de colecciones, utilizando streams de Java para transformar elementos de una colección en otros elementos, creando nuevas colecciones sin modificar las originales. El mapeo permite establecer una función de transformación que se aplica a cada elemento de la colección.

```java
// Ejemplo básico de mapeo
Collection.stream().map(elementoOriginal -> elementoTransformado)
```

## ¿Para qué?

Este enfoque resuelve los problemas mencionados de la siguiente manera:

1. **Transformaciones matemáticas**: Cada número se eleva al cuadrado sin modificar la lista original
2. **Conversiones de tipo**: Los enteros se convierten en cadenas con formato específico
3. **Extracción de propiedades**: Se extraen nombres de objetos Person sin alterar los objetos originales
4. **Transformación de objetos**: Los objetos Person se convierten en PersonDto combinando y simplificando sus propiedades

Los resultados mantienen la inmutabilidad: las colecciones originales permanecen inalteradas mientras se crean nuevas estructuras de datos con las transformaciones aplicadas.

## ¿Cómo?

El ejemplo utiliza streams de Java con el método `map()` para realizar diferentes transformaciones:

```java
// 1. Transformación simple de números
List<Integer> squaredNumbers = numbers.stream()
        .map(number -> number * number)
        .collect(Collectors.toList());

// 2. Transformación de tipo
List<String> numberStrings = numbers.stream()
        .map(number -> "Número: " + number)
        .collect(Collectors.toList());

// 3. Extracción de propiedades con referencias de método
List<String> names = people.stream()
        .map(Person::getName)
        .collect(Collectors.toList());

// 4. Transformación compleja a DTOs
List<PersonDto> personDtos = people.stream()
        .map(person -> new PersonDto(
                person.getName() + " " + person.getLastName(),
                person.getAge()))
        .collect(Collectors.toList());
```

El flujo básico es:

1. Se obtiene un stream de la colección
1. Se aplica la transformación con `map()`
1. Se recolectan los resultados en una nueva lista

> [2Think](2Think.md)