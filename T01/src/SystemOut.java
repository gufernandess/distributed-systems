import classes.*;
import interfaces.Remunerable;

public class SystemOut {

    public static void main(String[] args) throws Exception {
        UndergraduateProgram program = new UndergraduateProgram(
            "Computer Science",
            "CS101",
            4
        );

        Student firstStudent = new PostgraduateStudent(
            "Alice",
            25,
            "PG123",
            "AI Research",
            "Dr. Smith",
            20,
            1500.0
        );
        Student secondStudent = new ScientificInitiationStudent(
            "Bob",
            20,
            "UG456",
            "Data Science",
            15,
            1000.0
        );
        Student thirdStudent = new UndergraduateStudent(
            "Charlie",
            22,
            "UG789",
            "Computer Science"
        );

        program.addStudent(firstStudent);
        program.addStudent(secondStudent);
        program.addStudent(thirdStudent);

        for (Student student : program.getStudents()) {
            System.out.println();
            System.out.println(student);
            if (student instanceof Remunerable) {
                Remunerable remunerable = (Remunerable) student;
                System.out.println(
                    "Dias trabalhados: " + remunerable.getWorkedDays()
                );
                System.out.println(
                    "Total da bolsa: " + remunerable.getScholarshipAmount()
                );
                System.out.println(
                    "Pagamento: " + remunerable.calculatePayment()
                );
                System.out.println();
            }
        }
    }
}
