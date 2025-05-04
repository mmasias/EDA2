# Reduce

## ¿Por qué?

Se enfrenta el desafío de combinar múltiples elementos en uno solo. Los problemas incluyen:

1. **Sumar todos los números de una lista**: Necesitamos un resultado único desde múltiples valores
2. **Encontrar el máximo o mínimo**: Reducir una colección a un único valor representativo
3. **Concatenar cadenas**: Unir múltiples strings en uno solo
4. **Calcular totales**: Agregar valores de objetos complejos en un único resultado

Sin una operación de reducción, se requiere código imperativo con acumuladores manuales:

```java
// Código tradicional para suma
int sum = 0;
for (Integer number : numbers) {
    sum = sum + number;
}
```

## ¿Qué?

La operación `reduce()` combina todos los elementos de un stream en un único valor mediante una función acumuladora. La operación sigue el patrón:

```java
.reduce(valorInicial, (acumulador, elementoActual) -> nuevaAcumulación)
```

O sin valor inicial:
```java
.reduce((elementoA, elementoB) -> resultadoCombinado)
```

## ¿Para qué?

Esta operación resuelve diversos escenarios:

1. **Agregaciones matemáticas**: Suma, multiplicación, máximo, mínimo
2. **Combinación de strings**: Concatenación con reglas específicas
3. **Cálculos complejos**: Total de órdenes agregando valores anidados
4. **Reducción personalizada**: Implementar cualquier lógica de acumulación

La inmutabilidad se mantiene: las colecciones originales permanecen intactas mientras se genera un nuevo valor.

## ¿Cómo?

El ejemplo muestra diferentes usos de `reduce()`:

### 1. Suma con valor inicial
```java
int sum = numbers.stream()
    .reduce(0, (accumulated, current) -> accumulated + current);
// Inicia en 0, suma cada elemento: 0+1+2+3+4+5 = 15
```

### 2. Multiplicación con valor inicial
```java
int product = numbers.stream()
    .reduce(1, (accumulated, current) -> accumulated * current);
// Inicia en 1, multiplica cada elemento: 1*1*2*3*4*5 = 120
```

### 3. Máximo sin valor inicial
```java
Optional<Integer> max = numbers.stream()
    .reduce((a, b) -> a > b ? a : b);
// Compara pares, devuelve el mayor
// Retorna Optional porque la lista podría estar vacía
```

### 4. Concatenación de strings
```java
String sentence = words.stream()
    .reduce("", (partial, word) -> partial + " " + word)
    .trim();
// Empieza con "", concatena con espacio, quita espacios finales
```

### 5. Combinación con objetos complejos
```java
double totalAmount = orders.stream()
    .map(Order::calculateTotal)  // Stream<Double>
    .reduce(0.0, Double::sum);   // Reduce a un solo double
```

### Patrón de flujo:
1. **Stream de objetos Order** → 
2. **map() a totales** → Stream de doubles → 
3. **reduce() a suma total** → double único

La operación `reduce()` es una forma generalizada de reducir colecciones, similar a:

- `sum()` (caso específico de reduce para suma)
- `max()` (caso específico para máximo)
- `min()` (caso específico para mínimo)
- `count()` (caso específico para contar)

Pero `reduce()` permite implementar cualquier lógica de combinación personalizada.
