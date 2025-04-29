package casosDeUso.inmutabilidad.e001;

public class Ejemplo {
    public static void main(String[] args) {

        Person originalPerson = new Person("Alice", "Smith", 1001);

        System.out.println("Persona original:");
        printPerson(originalPerson);

        Person updatedNamePerson = originalPerson.withName("Alicia");
        Person updatedLastNamePerson = updatedNamePerson.withLastName("Johnson");
        Person updatedIdPerson = updatedLastNamePerson.withId(2002);

        System.out.println("Luego de cambiar el nombre:");
        printPerson(updatedNamePerson);

        System.out.println("Luego de cambiar el apellildo:");
        printPerson(updatedLastNamePerson);

        System.out.println("Luego de cambiar el ID:");
        printPerson(updatedIdPerson);

        System.out.println("Persona original:");
        printPerson(originalPerson);
    }

    private static void printPerson(Person person) {
        System.out.println("> Name: " + person.getName());
        System.out.println("> Last Name: " + person.getLastName());
        System.out.println("> ID: " + person.getId());
        System.out.println("-".repeat(20));
    }
}
