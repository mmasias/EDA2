package casosDeUso.inmutabilidad.e050;

class Student {
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

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSubject() {
        return subject;
    }

    public int getGrade() {
        return grade;
    }
}