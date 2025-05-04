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
}