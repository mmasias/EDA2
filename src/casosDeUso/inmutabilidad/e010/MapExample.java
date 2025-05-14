package casosDeUso.inmutabilidad.e010;

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
                                new Person("Carlos", "López", 22));

                // Extraer solo los nombres
                List<String> names = people.stream()
                                .map(Person -> Person.getName())
                                .collect(Collectors.toList());

                System.out.println("Nombres de personas: " + names);

                // Crear nuevos objetos basados en los existentes
                List<PersonDto> personDtos = people.stream()
                                .map(person -> new PersonDto(
                                                person.getName() + " " + person.getLastName(),
                                                person.getAge()))
                                .collect(Collectors.toList());

                personDtos.forEach(
                                dto -> System.out.println("DTO: " + dto.getFullName() + ", " + dto.getAge() + " años"));

        }
}