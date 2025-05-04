# Streams numéricos

## ¿Por qué?

Se presentan necesidades específicas de procesamiento de datos numéricos donde los streams genéricos no son óptimos:

```java
// Ineficiente: múltiples conversiones Integer <-> int
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
int sum = numbers.stream()
    .mapToInt(Integer::intValue)
    .sum();
```

1. **Operaciones matemáticas frecuentes**: Realizar sumas, promedios, y estadísticas requiere código adicional con Stream<Integer>
2. **Evitar boxing/unboxing**: Los wrappers como Integer consumen memoria extra y ralentizan operaciones
3. **Generación de secuencias**: Crear rangos de números es común pero verboso con listas
4. **Cálculos especializados**: Factoriales, totales con impuestos, estadísticas requieren precisión

## ¿Qué?

Los streams numéricos primitivos son versiones especializadas para tipos primitivos (int, long, double) que proporcionan:

1. **IntStream**: Para enteros
2. **LongStream**: Para enteros largos  
3. **DoubleStream**: Para números de punto flotante

Cada uno ofrece operaciones optimizadas sin boxing/unboxing:

```java
// Métodos especializados disponibles:
IntStream.range(start, end)    // Secuencias
IntStream.sum()               // Suma directa
IntStream.average()           // Promedio
IntStream.summaryStatistics() // Estadísticas completas
```

## ¿Para qué?

Estos streams resuelven los problemas mencionados:

1. **Eficiencia**: Sin conversión entre primitivos y objetos
2. **Operaciones built-in**: Métodos especializados para operaciones comunes
3. **Generación de rangos**: Crear secuencias numéricas fácilmente
4. **Estadísticas integradas**: Recolectar múltiples métricas en una sola pasada

## ¿Cómo?

El ejemplo muestra diferentes casos de uso:

### 1. Generar rangos y sumar

```java
IntStream rangeStream = IntStream.rangeClosed(1, 10);
int sum = rangeStream.sum();
// Genera 1,2,3,4,5,6,7,8,9,10 y suma: 55
```

### 2. Estadísticas completas

```java
IntSummaryStatistics stats = Arrays.stream(values).summaryStatistics();
// Obtiene count, min, max, sum, average en una sola pasada
```

### 3. Cálculo de factorial

```java
long factorial = LongStream.rangeClosed(1, 15)
    .reduce(1L, (a, b) -> a * b);
// Multiplica 1 × 2 × 3 × ... × 15
```

### 4. Mapeo de doubles

```java
double totalWithTax = DoubleStream.of(prices)
    .map(price -> price * 1.21)
    .sum();
// Aplica 21% de impuesto a cada precio y suma
```

### 5. Conversión entre streams

```java
IntStream.rangeClosed(1, 5)
    .mapToObj(i -> "Número " + i)  // int → String
    .forEach(System.out::println);
```

### Métodos clave de streams numéricos

**IntStream/LongStream/DoubleStream**:

- `sum()`: Suma todos los elementos
- `average()`: Calcula el promedio
- `max()/min()`: Encuentra extremos
- `count()`: Cuenta elementos
- `summaryStatistics()`: Todas las estadísticas

**Generadores**:

- `IntStream.range(start, end)`: [start, end)
- `IntStream.rangeClosed(start, end)`: [start, end]
- `IntStream.of(values...)`: De valores específicos

**Conversiones**:

- `.boxed()`: primitivo → wrapper
- `.mapToInt/.mapToLong/.mapToDouble`: primitivo → primitivo
- `.mapToObj()`: primitivo → objeto

La ventaja es clara: en lugar de usar Stream<Integer> con boxing/unboxing, estos streams trabajan directamente con primitivos para mejor performance y código más limpio.
