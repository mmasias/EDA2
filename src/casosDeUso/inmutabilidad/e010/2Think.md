# *2Think*

## ¿Por qué?

Necesitamos procesar colecciones de datos de forma segura, transformable y expresiva. Los problemas clave son:

1. **Modificar datos originales accidentalmente**: Cambiar colecciones compartidas genera efectos secundarios indeseados
2. **Operaciones desconectadas**: Realizar múltiples transformaciones requiere variables intermedias
3. **Código verboso**: Las transformaciones simples requieren mucho boilerplate
4. **Falta de expresividad**: Difícil comunicar la intención del procesamiento

```java
// Código problemático tradicional
List<String> results = new ArrayList<>();
for (Integer number : numbers) {
    int squared = number * number;
    results.add("Número: " + squared);
}
// ¿Qué pasa si alguien modifica 'numbers' mientras lo procesamos?
```

## ¿Qué?

Los streams de Java combinan tres conceptos poderosos:

1. **Inmutabilidad**: Los streams no modifican las colecciones originales
2. **Flujo de datos**: Representan una secuencia de elementos que pueden transformarse
3. **Interfaz fluida (Fluent API)**: Cada operación retorna un stream, permitiendo encadenar llamadas

```java
// Conceptualmente, un stream es:
secuencia_de_datos
    .operación1() → nuevo_stream
    .operación2() → nuevo_stream
    .operación3() → resultado_final
```

## ¿Para qué?

Esta integración resuelve todos los problemas mencionados:

1. **Garantiza inmutabilidad**: Las colecciones originales nunca cambian
2. **Simplifica el encadenamiento**: Cada operación prepara para la siguiente
3. **Reduce boilerplate**: Las transformaciones son declarativas
4. **Mejora legibilidad**: El flujo de operaciones es como leer una receta

```java
// Solución elegante
List<String> results = numbers.stream()
    .map(number -> number * number)
    .map(squared -> "Número: " + squared)
    .collect(Collectors.toList());
```

## ¿Cómo?

El patrón funciona mediante tres principios:

### 1. Inmutabilidad garantizada

```java
List<Integer> original = Arrays.asList(1, 2, 3);
List<Integer> transformed = original.stream()
    .map(n -> n * 2)
    .collect(Collectors.toList());

// original sigue siendo [1, 2, 3]
// transformed es [2, 4, 6]
```

### 2. Cadena de operaciones

```java
people.stream()
    .filter(person -> person.getAge() >= 18)  // Stream<Person>
    .map(Person::getName)                     // Stream<String>
    .map(String::toUpperCase)                 // Stream<String>
    .collect(Collectors.toList());            // List<String>
```

### 3. Fluent API estructurada

|Operaciones intermedias|Operaciones terminales|
|-|-|
|Retornan un stream (lazy, no se ejecutan hasta terminal)|Retornan un resultado final (eager, disparan el procesamiento)|
|`map()`, `filter()`, `sorted()`, `distinct()`|`collect()`, `forEach()`, `reduce()`, `findFirst()`|

```java
// Ejemplo completo del patrón
List<PersonDto> results = people.stream()
    // Operaciones intermedias (lazy)
    .filter(p -> p.getAge() >= 21)
    .map(p -> new PersonDto(
        p.getName() + " " + p.getLastName(),
        p.getAge()
    ))
    .sorted((a, b) -> a.getAge() - b.getAge())
    // Operación terminal (eager)
    .collect(Collectors.toUnmodifiableList());
```

Esta arquitectura permite escribir código que:

- No modifica datos originales (inmutable)
- Se lee como una secuencia de pasos (stream)
- Se escribe de forma fluida (encadenable)
- Es eficiente (evaluación lazy)
