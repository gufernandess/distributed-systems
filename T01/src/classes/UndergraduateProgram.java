package classes;

import java.util.ArrayList;
import java.util.List;

public class UndergraduateProgram {

    private String name;
    private String code;
    private int duration;
    private List<Student> students;

    public UndergraduateProgram(String name, String code, int duration) {
        this.name = name;
        this.code = code;
        this.duration = duration;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getDurationInYears() {
        return duration;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        } else {
            throw new IllegalArgumentException("Student cannot be null");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
            .append("Programa de pós-graduação:\n\n")
            .append("Nome: ")
            .append(name)
            .append("\n")
            .append("Código: ")
            .append(code)
            .append("\n")
            .append("Duração: ")
            .append(duration)
            .append(", Alunos=")
            .append(students);
        return sb.toString();
    }
}
