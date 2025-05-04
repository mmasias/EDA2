# +Complejo

## ¿Por qué?

Se presenta la necesidad de realizar análisis complejos de datos académicos que involucran múltiples pasos de procesamiento. Los desafíos principales son:

1. **Filtrar datos relevantes**: Solo estudiantes con notas >= 80
2. **Agrupar información**: Organizar datos por asignaturas
3. **Realizar cálculos agregados**: Promedios, máximos, conteos
4. **Clasificar datos**: Categorizar por rangos de calificación

Sin pipelines de procesamiento, cada operación requeriría:
- Bucles anidados separados
- Variables intermedias para cada resultado
- Lógica dispersa y difícil de seguir

## ¿Qué?

Un pipeline de stream representa una cadena de operaciones de procesamiento de datos que se ejecutan en flujo continuo. Consiste en:

1. **Fuente**: La colección inicial (lista de estudiantes)
2. **Operaciones intermedias**: Transformaciones y filtrados
3. **Operación terminal**: Recolección o agregación final

```java
fuente.stream()
    .operaciónIntermedia1()
    .operaciónIntermedia2()
    .operaciónTerminal()
```

## ¿Para qué?

Este enfoque pipeline resuelve los problemas planteados de forma elegante:

1. **Procesamiento fluido**: Las operaciones se encadenan de forma natural
2. **Código declarativo**: Describe QUÉ hacer, no CÓMO hacerlo
3. **Composición lógica**: Los pasos son análogos a SQL: filtrar → agrupar → agregar
4. **Resultado inmutable**: Las operaciones no modifican la data original

## ¿Cómo?

El ejemplo muestra tres pipelines distintos:

### 1. Promedio por asignatura (filtrado)

```java
Map<String, Double> averageBySubject = students.stream()
    .filter(student -> student.getGrade() >= 80)  // Filtra estudiantes
    .collect(Collectors.groupingBy(               // Agrupa por asignatura
        Student::getSubject,
        Collectors.averagingDouble(Student::getGrade)  // Calcula promedio
    ));
```

Este pipeline:

- Filtra estudiantes con notas >= 80
- Agrupa por asignatura
- Calcula promedio de cada grupo
- Produce un Map<String, Double>

### 2. Mejor estudiante por asignatura

```java
Map<String, Optional<Student>> topStudentBySubject = students.stream()
    .collect(Collectors.groupingBy(
        Student::getSubject,
        Collectors.maxBy(Comparator.comparing(Student::getGrade))
    ));
```

Este pipeline:

- No filtra (procesa todos los estudiantes)
- Agrupa por asignatura
- Encuentra el máximo en cada grupo por nota
- Produce un Map<String, Optional<Student>>

### 3. Conteo por rangos de calificación

```java
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
```

Este pipeline:

- Clasifica cada estudiante por rango
- Agrupa por categoría
- Cuenta elementos en cada grupo
- Produce un Map<String, Long>

### Estructura de collector complejos

Los `Collectors.groupingBy()` utilizan downstream collectors:

```java
groupingBy(
    clasificador,    // Función para determinar la clave
    downstream      // Collector para procesar cada grupo
)
```

Downstream collectors comunes:

- `Collectors.counting()`: Cuenta elementos
- `Collectors.averagingDouble()`: Calcula promedio
- `Collectors.maxBy()`: Encuentra máximo
- `Collectors.toList()`: Convierte a lista

Este enfoque permite operaciones de estilo SQL en memoria de forma funcional, inmutable y expresiva.