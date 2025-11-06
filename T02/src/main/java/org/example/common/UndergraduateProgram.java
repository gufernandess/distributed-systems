package org.example.common;

import java.util.ArrayList;
import java.util.List;

public class UndergraduateProgram {

    private String name;
    private String code;
    private int durationInYears;
    private List<Student> students;

    public UndergraduateProgram(String name, String code, int durationInYears) {
        this.name = name;
        this.code = code;
        this.durationInYears = durationInYears;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public int getDurationInYears() {
        return durationInYears;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if (student != null) {
            students.add(student);
        } else {
            throw new IllegalArgumentException("Estudante não pode ser nulo.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
            .append("\nPrograma de Graduação:\n\n")
            .append("Nome='")
            .append(name)
            .append('\'')
            .append(",Código='")
            .append(code)
            .append('\'')
            .append(",Duração (anos)=")
            .append(durationInYears)
            .append(",Estudantes=")
            .append(students);

        return sb.toString();
    }
}
