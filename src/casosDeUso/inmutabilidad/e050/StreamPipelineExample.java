package casosDeUso.inmutabilidad.e050;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
}