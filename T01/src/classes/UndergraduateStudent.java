package classes;

public class UndergraduateStudent extends Student {

    private String major;

    public UndergraduateStudent(String name, int age, String id, String major) {
        super(name, age, id);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    @Override
    public String toString() {
        return (
            "Estudante de graduação:\n\n" +
            "nome='" +
            getName() +
            '\'' +
            ", idade=" +
            getAge() +
            ", matricula='" +
            getStudentId() +
            '\'' +
            ", curso='" +
            major +
            '\''
        );
    }
}
