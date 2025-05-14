package casosDeUso.inmutabilidad.e010;

class PersonDto {
    private final String fullName;
    private final int age;

    public PersonDto(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }
}