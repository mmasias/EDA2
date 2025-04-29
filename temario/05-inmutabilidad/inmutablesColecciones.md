# Operaciones funcionales sobre colecciones inmutables

## ¿Por qué?

La programación tradicional con colecciones en Java se basa en modificar el estado interno de estas estructuras mediante métodos como `add()`, `remove()` o `set()`. Este enfoque mutable, aunque familiar, genera dificultades en entornos de programación paralela donde múltiples hilos pueden intentar modificar las mismas colecciones simultáneamente.

Las colecciones mutables requieren sincronización explícita para evitar inconsistencias, lo que a menudo resulta en código complejo propenso a errores como condiciones de carrera, deadlocks, o inconsistencias en los datos. Además, la depuración de estos problemas se vuelve particularmente desafiante debido a su naturaleza no determinista.

A nivel conceptual, la mutabilidad de las colecciones también dificulta el razonamiento sobre el comportamiento del programa, especialmente cuando se comparten referencias a estas colecciones entre diferentes componentes del sistema. Un cambio en una colección puede tener efectos secundarios inesperados en partes distantes del código, complicando el mantenimiento y la evolución del software.

## ¿Qué?

Las operaciones funcionales sobre colecciones inmutables representan un paradigma alternativo donde las colecciones, una vez creadas, no se modifican. En lugar de alterar una colección existente, cada operación genera una nueva colección que refleja el cambio deseado, manteniendo la colección original intacta.

Java, desde su versión 8, introduce la API de Stream como mecanismo principal para trabajar con colecciones de manera funcional. Un Stream representa una secuencia de elementos que soporta diversas operaciones agregadas de forma secuencial o paralela. Estas operaciones se clasifican en:

- **Operaciones intermedias**: Como mapeo, filtrado o aplanamiento, que transforman un stream en otro.
- **Operaciones terminales**: Como reducción o recolección, que procesan el stream para producir un resultado final.

Este enfoque permite expresar transformaciones complejas de datos como composiciones de operaciones más simples, siguiendo los principios de la programación funcional: transparencia referencial, ausencia de efectos secundarios y uso de funciones como ciudadanos de primera clase.

## ¿Para qué?

La adopción de operaciones funcionales sobre colecciones inmutables soluciona directamente los problemas mencionados anteriormente:

Al trabajar con colecciones que no cambian después de su creación, se elimina la posibilidad de condiciones de carrera relacionadas con modificaciones concurrentes. Esto simplifica drásticamente el desarrollo de sistemas paralelos, permitiendo aprovechar eficientemente la capacidad de procesamiento de arquitecturas multicore sin la sobrecarga de mecanismos de sincronización complejos.

El estilo declarativo de las operaciones funcionales expresa claramente la intención del programador, centrándose en el "qué" debe hacerse en lugar del "cómo" hacerlo. Esto resulta en código más legible, mantenible y menos propenso a errores, facilitando la comprensión de transformaciones complejas de datos.

La composición de operaciones permite construir pipelines de procesamiento que pueden aplicarse de forma eficiente tanto secuencial como paralelamente, simplemente cambiando la naturaleza del stream utilizado, lo que proporciona una escalabilidad natural conforme aumentan los recursos computacionales disponibles.

## ¿Cómo?

La API de Stream de Java ofrece un conjunto rico de operaciones para trabajar con colecciones de manera funcional. A continuación, se explorarán las principales operaciones con ejemplos detallados.

|Mapeo de colecciones|Mapeo y aplanamiento de colecciones|Filtrado de colecciones|Reducción de colecciones|
|-|-|-|-|
|map|flatMap|filter|reduce
|Transforma cada elemento de una colección aplicando una función definida|permite transformar cada elemento en múltiples elementos y aplanar el resultado|Selecciona elementos que cumplen con un predicado específico|Combina los elementos de una colección para producir un único resultado|

### Operaciones fundamentales

#### Mapeo de colecciones (map)

El mapeo transforma cada elemento de una colección aplicando una función definida:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {
        // Colección inicial de enteros
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Mapeo para obtener el cuadrado de cada número
        List<Integer> squaredNumbers = numbers.stream()
                .map(number -> number * number)
                .collect(Collectors.toList());
        
        System.out.println("Números originales: " + numbers);
        System.out.println("Números al cuadrado: " + squaredNumbers);
        
        // Mapeo para convertir números en cadenas
        List<String> numberStrings = numbers.stream()
                .map(number -> "Número: " + number)
                .collect(Collectors.toList());
        
        System.out.println("Representación textual: " + numberStrings);
        
        // Mapeo de objetos complejos
        List<Person> people = Arrays.asList(
                new Person("Juan", "Pérez", 25),
                new Person("Ana", "García", 30),
                new Person("Carlos", "López", 22)
        );
        
        // Extraer solo los nombres
        List<String> names = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        
        System.out.println("Nombres de personas: " + names);
        
        // Crear nuevos objetos basados en los existentes
        List<PersonDto> personDtos = people.stream()
                .map(person -> new PersonDto(
                        person.getName() + " " + person.getLastName(),
                        person.getAge()))
                .collect(Collectors.toList());
        
        personDtos.forEach(dto -> 
                System.out.println("DTO: " + dto.getFullName() + ", " + dto.getAge() + " años"));
    }
    
    static class Person {
        private final String name;
        private final String lastName;
        private final int age;
        
        public Person(String name, String lastName, int age) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
        }
        
        public String getName() { return name; }
        public String getLastName() { return lastName; }
        public int getAge() { return age; }
    }
    
    static class PersonDto {
        private final String fullName;
        private final int age;
        
        public PersonDto(String fullName, int age) {
            this.fullName = fullName;
            this.age = age;
        }
        
        public String getFullName() { return fullName; }
        public int getAge() { return age; }
    }
}
```

#### Mapeo y aplanamiento de colecciones (flatMap)

La operación flatMap permite transformar cada elemento en múltiples elementos y aplanar el resultado:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        // Lista de frases
        List<String> phrases = Arrays.asList(
                "Hola mundo", 
                "Programación funcional", 
                "Java Stream API"
        );
        
        // Obtener todas las palabras únicas
        List<String> allWords = phrases.stream()
                .flatMap(phrase -> Arrays.stream(phrase.toLowerCase().split(" ")))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        
        System.out.println("Palabras únicas: " + allWords);
        
        // Ejemplo con estructuras anidadas
        List<List<Integer>> numberLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );
        
        // Aplanar en una única lista
        List<Integer> allNumbers = numberLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        
        System.out.println("Todos los números: " + allNumbers);
        
        // Ejemplo con objetos complejos
        List<Department> departments = Arrays.asList(
                new Department("Ingeniería", Arrays.asList(
                        new Employee("Juan", "Desarrollador"),
                        new Employee("Ana", "QA Analyst"),
                        new Employee("Pedro", "DevOps")
                )),
                new Department("Marketing", Arrays.asList(
                        new Employee("Lucía", "Content Manager"),
                        new Employee("Carlos", "SEO Specialist")
                ))
        );
        
        // Obtener todos los empleados de todos los departamentos
        List<Employee> allEmployees = departments.stream()
                .flatMap(dept -> dept.getEmployees().stream())
                .collect(Collectors.toList());
        
        System.out.println("Todos los empleados:");
        allEmployees.forEach(emp -> 
                System.out.println(emp.getName() + " - " + emp.getPosition()));
    }
    
    static class Department {
        private final String name;
        private final List<Employee> employees;
        
        public Department(String name, List<Employee> employees) {
            this.name = name;
            this.employees = employees;
        }
        
        public String getName() { return name; }
        public List<Employee> getEmployees() { return employees; }
    }
    
    static class Employee {
        private final String name;
        private final String position;
        
        public Employee(String name, String position) {
            this.name = name;
            this.position = position;
        }
        
        public String getName() { return name; }
        public String getPosition() { return position; }
    }
}
```

#### Filtrado de colecciones (filter)

El filtrado selecciona elementos que cumplen con un predicado específico:

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterExample {
    public static void main(String[] args) {
        // Lista de números
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        
        // Filtrar números pares
        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        
        System.out.println("Números pares: " + evenNumbers);
        
        // Filtrar números primos
        List<Integer> primeNumbers = numbers.stream()
                .filter(FilterExample::isPrime)
                .collect(Collectors.toList());
        
        System.out.println("Números primos: " + primeNumbers);
        
        // Lista de productos
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200.0, 10),
                new Product("Smartphone", 800.0, 0),
                new Product("Tablet", 400.0, 5),
                new Product("Monitor", 300.0, 15),
                new Product("Teclado", 50.0, 0)
        );
        
        // Filtrar productos disponibles en stock
        List<Product> inStockProducts = products.stream()
                .filter(product -> product.getStock() > 0)
                .collect(Collectors.toList());
        
        System.out.println("Productos en stock:");
        inStockProducts.forEach(p -> 
                System.out.println(p.getName() + " - Stock: " + p.getStock()));
        
        // Filtrar productos premium (precio > 500)
        List<Product> premiumProducts = products.stream()
                .filter(p -> p.getPrice() > 500)
                .collect(Collectors.toList());
        
        System.out.println("Productos premium:");
        premiumProducts.forEach(p -> 
                System.out.println(p.getName() + " - Precio: $" + p.getPrice()));
    }
    
    // Método para verificar si un número es primo
    private static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;
        
        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0)
                return false;
        }
        return true;
    }
    
    static class Product {
        private final String name;
        private final double price;
        private final int stock;
        
        public Product(String name, double price, int stock) {
            this.name = name;
            this.price = price;
            this.stock = stock;
        }
        
        public String getName() { return name; }
        public double getPrice() { return price; }
        public int getStock() { return stock; }
    }
}
```

#### Reducción de colecciones (reduce)

La reducción combina los elementos de una colección para producir un único resultado:

```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        // Lista de números
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Suma utilizando reduce
        int sum = numbers.stream()
                .reduce(0, (accumulated, current) -> accumulated + current);
        
        System.out.println("Suma: " + sum);
        
        // Multiplicación utilizando reduce
        int product = numbers.stream()
                .reduce(1, (accumulated, current) -> accumulated * current);
        
        System.out.println("Producto: " + product);
        
        // Máximo utilizando reduce
        Optional<Integer> max = numbers.stream()
                .reduce((a, b) -> a > b ? a : b);
        
        max.ifPresent(value -> System.out.println("Máximo: " + value));
        
        // Concatenación de strings
        List<String> words = Arrays.asList("Programación", "funcional", "con", "Java");
        
        String sentence = words.stream()
                .reduce("", (partial, word) -> partial + " " + word)
                .trim();
        
        System.out.println("Frase: " + sentence);
        
        // Ejemplo con objetos complejos - calcular total de ventas
        List<Order> orders = Arrays.asList(
                new Order("A001", Arrays.asList(
                        new OrderItem("Producto1", 10.0, 2),
                        new OrderItem("Producto2", 15.0, 1)
                )),
                new Order("A002", Arrays.asList(
                        new OrderItem("Producto3", 20.0, 3),
                        new OrderItem("Producto4", 5.0, 4)
                ))
        );
        
        // Calcular importe total de todas las órdenes
        double totalAmount = orders.stream()
                .map(Order::calculateTotal)
                .reduce(0.0, Double::sum);
        
        System.out.println("Importe total de ventas: $" + totalAmount);
    }
    
    static class Order {
        private final String orderNumber;
        private final List<OrderItem> items;
        
        public Order(String orderNumber, List<OrderItem> items) {
            this.orderNumber = orderNumber;
            this.items = items;
        }
        
        public double calculateTotal() {
            return items.stream()
                    .mapToDouble(item -> item.getPrice() * item.getQuantity())
                    .sum();
        }
        
        public String getOrderNumber() { return orderNumber; }
        public List<OrderItem> getItems() { return items; }
    }
    
    static class OrderItem {
        private final String productName;
        private final double price;
        private final int quantity;
        
        public OrderItem(String productName, double price, int quantity) {
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }
        
        public String getProductName() { return productName; }
        public double getPrice() { return price; }
        public int getQuantity() { return quantity; }
    }
}
```

### Operaciones derivadas

#### Combinando operaciones: Pipelines de transformación

Las operaciones pueden encadenarse para formar pipelines de transformación completos:

```java
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPipelineExample {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Juan", "García", "Matemáticas", 85),
                new Student("Ana", "Martínez", "Física", 92),
                new Student("Carlos", "López", "Matemáticas", 78),
                new Student("Lucía", "Rodríguez", "Química", 95),
                new Student("Pedro", "Fernández", "Física", 88),
                new Student("Elena", "Díaz", "Química", 73),
                new Student("Miguel", "González", "Matemáticas", 90)
        );
        
        // Pipeline complejo de operaciones:
        // 1. Filtrar estudiantes con calificación >= 80
        // 2. Agrupar por asignatura
        // 3. Calcular el promedio por asignatura
        Map<String, Double> averageBySubject = students.stream()
                .filter(student -> student.getGrade() >= 80)
                .collect(Collectors.groupingBy(
                        Student::getSubject,
                        Collectors.averagingDouble(Student::getGrade)
                ));
        
        System.out.println("Promedio por asignatura (estudiantes con nota >= 80):");
        averageBySubject.forEach((subject, average) -> 
                System.out.println(subject + ": " + String.format("%.2f", average)));
        
        // Obtener los mejores estudiantes de cada asignatura
        Map<String, Optional<Student>> topStudentBySubject = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getSubject,
                        Collectors.maxBy(Comparator.comparing(Student::getGrade))
                ));
        
        System.out.println("Mejor estudiante por asignatura:");
        topStudentBySubject.forEach((subject, studentOpt) -> 
                studentOpt.ifPresent(student -> 
                        System.out.println(subject + ": " + 
                                student.getName() + " " + 
                                student.getLastName() + " - " + 
                                student.getGrade()))
        );
        
        // Contar estudiantes por rango de calificación
        Map<String, Long> gradeRangeCount = students.stream()
                .collect(Collectors.groupingBy(
                        student -> {
                            int grade = student.getGrade();
                            if (grade >= 90) return "Excelente (90-100)";
                            else if (grade >= 80) return "Bueno (80-89)";
                            else if (grade >= 70) return "Regular (70-79)";
                            else return "Insuficiente (<70)";
                        },
                        Collectors.counting()
                ));
        
        System.out.println("Estudiantes por rango de calificación:");
        gradeRangeCount.forEach((range, count) -> 
                System.out.println(range + ": " + count));
    }
    
    static class Student {
        private final String name;
        private final String lastName;
        private final String subject;
        private final int grade;
        
        public Student(String name, String lastName, String subject, int grade) {
            this.name = name;
            this.lastName = lastName;
            this.subject = subject;
            this.grade = grade;
        }
        
        public String getName() { return name; }
        public String getLastName() { return lastName; }
        public String getSubject() { return subject; }
        public int getGrade() { return grade; }
    }
}
```

#### Streams numéricos especializados

Java proporciona variantes especializadas para valores primitivos numéricos:

```java
import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class NumericStreamExample {
    public static void main(String[] args) {
        // IntStream - generar un rango de enteros
        IntStream rangeStream = IntStream.rangeClosed(1, 10);
        
        System.out.println("Suma de números del 1 al 10: " + rangeStream.sum());
        
        // Estadísticas de un IntStream
        int[] values = {45, 38, 92, 67, 55, 23, 71, 89};
        IntSummaryStatistics stats = Arrays.stream(values).summaryStatistics();
        
        System.out.println("Estadísticas de valores:");
        System.out.println("Cantidad: " + stats.getCount());
        System.out.println("Mínimo: " + stats.getMin());
        System.out.println("Máximo: " + stats.getMax());
        System.out.println("Suma: " + stats.getSum());
        System.out.println("Promedio: " + stats.getAverage());
        
        // LongStream - factorial
        long factorial = LongStream.rangeClosed(1, 15)
                .reduce(1L, (a, b) -> a * b);
        
        System.out.println("Factorial de 15: " + factorial);
        
        // DoubleStream - procesar valores con punto flotante
        double[] prices = {29.99, 9.99, 5.49, 3.99, 6.99};
        double totalWithTax = DoubleStream.of(prices)
                .map(price -> price * 1.21) // Añadir 21% de IVA
                .sum();
        
        System.out.println("Total con IVA: $" + String.format("%.2f", totalWithTax));
        
        // Conversión entre tipos de stream
        IntStream.rangeClosed(1, 5)
                .mapToObj(i -> "Número " + i)
                .forEach(System.out::println);
    }
}
```

#### Recolección de resultados

La API Collectors proporciona diversas formas de recolectar resultados:

```java
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electrónica", 1200.0),
                new Product("Smartphone", "Electrónica", 800.0),
                new Product("Auriculares", "Electrónica", 100.0),
                new Product("Mesa", "Hogar", 300.0),
                new Product("Silla", "Hogar", 120.0),
                new Product("Libro", "Libros", 25.0),
                new Product("Juguete", "Infantil", 40.0)
        );
        
        // Recolectar en diferentes tipos de colecciones
        List<String> productNames = products.stream()
                .map(Product::getName)
                .collect(Collectors.toList());
        
        Set<String> categories = products.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());
        
        System.out.println("Productos: " + productNames);
        System.out.println("Categorías: " + categories);
        
        // Agrupamiento
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        
        System.out.println("Productos por categoría:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(p -> System.out.println("  - " + p.getName() + 
                    " ($" + p.getPrice() + ")"));
        });
        
        // Particionamiento
        Map<Boolean, List<Product>> partitionedByPrice = products.stream()
                .collect(Collectors.partitioningBy(p -> p.getPrice() > 200));
        
        System.out.println("Productos premium (>$200):");
        partitionedByPrice.get(true).forEach(p -> 
                System.out.println("- " + p.getName() + " ($" + p.getPrice() + ")"));
        
        System.out.println("Productos económicos (≤$200):");
        partitionedByPrice.get(false).forEach(p -> 
                System.out.println("- " + p.getName() + " ($" + p.getPrice() + ")"));
        
        // Strings
        String categoriesString = categories.stream()
                .collect(Collectors.joining(", ", "Categorías: [", "]"));
        
        System.out.println("" + categoriesString);
        
        // Estadísticas
        DoubleSummaryStatistics priceStats = products.stream()
                .collect(Collectors.summarizingDouble(Product::getPrice));
        
        System.out.println("Estadísticas de precios:");
        System.out.println("Cantidad: " + priceStats.getCount());
        System.out.println("Total: $" + priceStats.getSum());
        System.out.println("Mínimo: $" + priceStats.getMin());
        System.out.println("Máximo: $" + priceStats.getMax());
        System.out.println("Promedio: $" + priceStats.getAverage());
    }
    
    static class Product {
        private final String name;
        private final String category;
        private final double price;
        
        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }
        
        public String getName() { return name; }
        public String getCategory() { return category; }
        public double getPrice() { return price; }
    }
}
```
