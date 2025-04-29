package casosDeUso.inmutabilidad.e000;

public class Ejemplo {
    public static void main(String[] args) {

        Person originalPerson = new Person("Bob", "Brown", 5005);
     
        System.out.println("Persona original:");
        printPerson(originalPerson);

        Person aliasPerson = originalPerson;

        System.out.println("'Otra' persona:");
        printPerson(aliasPerson);

        aliasPerson.setName("Robert");
        aliasPerson.setLastName("White");
        aliasPerson.setId(6006);

        System.out.println("Después de modificar a 'otra' persona:");

        System.out.println("Persona original:");
        printPerson(originalPerson);

        System.out.println("'Otra' persona:");
        printPerson(aliasPerson);
    }

    private static void printPerson(Person person) {
        System.out.println("> Name: " + person.getName());
        System.out.println("> Last Name: " + person.getLastName());
        System.out.println("> ID: " + person.getId());
        System.out.println("-".repeat(20));
    }
}
