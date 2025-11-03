package classes;

import interfaces.Remunerable;

public class PostgraduateStudent extends Student implements Remunerable {

    private String thesisTitle;
    private String supervisor;
    private int workedDays;
    private double scholarshipAmount;

    public PostgraduateStudent(
        String name,
        int age,
        String id,
        String thesisTitle,
        String supervisor,
        int workedDays,
        double scholarshipAmount
    ) {
        super(name, age, id);
        this.thesisTitle = thesisTitle;
        this.supervisor = supervisor;
        this.workedDays = workedDays;
        this.scholarshipAmount = scholarshipAmount;
    }

    public String getThesisTitle() {
        return thesisTitle;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public int getWorkedDays() {
        return workedDays;
    }

    public void setWorkedDays(int workedDays) {
        this.workedDays = workedDays;
    }

    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    public void setScholarshipAmount(double scholarshipAmount) {
        this.scholarshipAmount = scholarshipAmount;
    }

    public double calculatePayment() {
        return workedDays * scholarshipAmount;
    }

    public String toString() {
        return (
            "Estudante de pós-graduação:\n\n" +
            "nome='" +
            getName() +
            '\'' +
            ", idade=" +
            getAge() +
            ", matricula='" +
            getStudentId() +
            '\'' +
            ", tese='" +
            thesisTitle +
            '\'' +
            ", supervisor='" +
            supervisor +
            '\''
        );
    }
}
