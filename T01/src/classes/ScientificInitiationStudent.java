package classes;

import interfaces.Remunerable;

public class ScientificInitiationStudent
    extends UndergraduateStudent
    implements Remunerable {

    private int workedDays;
    private double scholarshipAmount;

    public ScientificInitiationStudent(
        String name,
        int age,
        String id,
        String course,
        int workedDays,
        double scholarshipAmount
    ) {
        super(name, age, id, course);
        this.workedDays = workedDays;
        this.scholarshipAmount = scholarshipAmount;
    }

    @Override
    public int getWorkedDays() {
        return workedDays;
    }

    @Override
    public void setWorkedDays(int days) {
        this.workedDays = days;
    }

    @Override
    public double getScholarshipAmount() {
        return scholarshipAmount;
    }

    @Override
    public void setScholarshipAmount(double amount) {
        this.scholarshipAmount = amount;
    }

    @Override
    public double calculatePayment() {
        return workedDays * scholarshipAmount;
    }

    @Override
    public String toString() {
        return (
            "Estudante de iniciacao cientifica" +
            "nome='" +
            getName() +
            '\'' +
            ", idade=" +
            getAge() +
            ", matricula='" +
            getStudentId() +
            '\'' +
            ", dias trabalhados=" +
            workedDays +
            ",total da bolsa=" +
            scholarshipAmount
        );
    }
}
