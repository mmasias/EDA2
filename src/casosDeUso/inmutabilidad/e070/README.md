# Recolección especializada

## ¿Por qué?

Se enfrentan diversas necesidades de colectar y organizar datos procesados por streams. Los problemas clave incluyen:

1. **Convertir resultados a colecciones específicas**: List, Set, Map según necesidades
2. **Agrupar elementos bajo criterios**: Organizar productos por categoría
3. **Particionar datos binariamente**: Separar por condición true/false
4. **Concatenar cadenas con formato**: Unir categorías con delimitadores
5. **Recolectar estadísticas resumidas**: Obtener métricas sin múltiples iteraciones

Sin collectors especializados:

```java
// Manual, propenso a errores
Map<String, List<Product>> manual = new HashMap<>();
for (Product p : products) {
    String cat = p.getCategory();
    if (!manual.containsKey(cat)) {
        manual.put(cat, new ArrayList<>());
    }
    manual.get(cat).add(p);
}
```

## ¿Qué?

Los Collectors son componentes especializados para la operación terminal `collect()` que definen:

1. **Cómo acumular resultados**: supplier, accumulator, combiner
2. **Qué estructura producir**: List, Set, Map, String, estadísticas
3. **Operaciones downstream**: collectors anidados para grupos

```java
.collect(Collectors.toCollection(tipo))
.collect(Collectors.groupingBy(clasificador))
.collect(Collectors.partitioningBy(predicado))
```

## ¿Para qué?

Los collectors resuelven múltiples escenarios:

1. **Recolección simple**: Convertir streams a colecciones
2. **Agrupamiento**: Organizar por claves
3. **Particionamiento**: Dividir en dos grupos
4. **Unión de strings**: Formateo y concatenación
5. **Estadísticas**: Métricas agregadas

Todo manteniendo inmutabilidad e integración fluida con pipelines.

## ¿Cómo?

### 1. Conversión a colecciones

```java
List<String> productNames = products.stream()
    .map(Product::getName)
    .collect(Collectors.toList());

Set<String> categories = products.stream()
    .map(Product::getCategory)
    .collect(Collectors.toSet());
```

### 2. Agrupamiento

```java
Map<String, List<Product>> productsByCategory = products.stream()
    .collect(Collectors.groupingBy(Product::getCategory));

// Resultado: {
//   "Electrónica": [Laptop, Smartphone, Auriculares],
//   "Hogar": [Mesa, Silla],
//   "Libros": [Libro],
//   "Infantil": [Juguete]
// }
```

### 3. Particionamiento

```java
Map<Boolean, List<Product>> partitionedByPrice = products.stream()
    .collect(Collectors.partitioningBy(p -> p.getPrice() > 200));

// Resultado: {
//   true: [productos caros],
//   false: [productos económicos]
// }
```

### 4. Concatenación de strings

```java
String categoriesString = categories.stream()
    .collect(Collectors.joining(", ", "Categorías: [", "]"));

// Resultado: "Categorías: [Electrónica, Hogar, Libros, Infantil]"
```

### 5. Estadísticas resumidas

```java
DoubleSummaryStatistics priceStats = products.stream()
    .collect(Collectors.summarizingDouble(Product::getPrice));
```

### Collectors principales

**Recolección simple**

- `toList()`: ArrayList mutable
- `toSet()`: HashSet mutable
- `toMap()`: HashMap mutable
- `toCollection(Supplier)`: Colección específica

**Agrupamiento y particionamiento**

- `groupingBy(Function)`: Agrupa por clasificador
- `partitioningBy(Predicate)`: Divide en true/false
- `groupingBy(Function, Collector)`: Agrupamiento con downstream

**Reducción y estadísticas**

- `counting()`: Cuenta elementos
- `summingInt/Long/Double()`: Suma valores
- `averagingInt/Long/Double()`: Promedio
- `summarizingInt/Long/Double()`: Estadísticas completas

**Concatenación**

- `joining()`: Une strings
- `joining(delimiter)`: Con separador
- `joining(delimiter, prefix, suffix)`: Con formato

El patrón clave es que `collect()` transforma un stream en un resultado específico, manteniendo la naturaleza inmutable del procesamiento e integrándose en pipelines fluidos.