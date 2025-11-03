package classes;

public abstract class Student {

    private String name;
    private int age;
    private String id;

    public Student(String name, int age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getStudentId() {
        return id;
    }

    @Override
    public String toString() {
        return (
            "Estudante:\n\n" +
            "nome='" +
            name +
            '\'' +
            ", idade=" +
            age +
            ", matricula='" +
            id +
            '\''
        );
    }
}
