import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
       
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