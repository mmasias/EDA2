package casosDeUso.inmutabilidad.e001;

public class Person {
    private final String name;
    private final String lastName;
    private final int id;
    
    public Person(String name, String lastName, int id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public int getId() {
        return id;
    }
    
    public Person withName(String name) {
        return new Person(name, this.lastName, this.id);
    }
    
    public Person withLastName(String lastName) {
        return new Person(this.name, lastName, this.id);
    }
    
    public Person withId(int id) {
        return new Person(this.name, this.lastName, id);
    }
}