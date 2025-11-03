import classes.ScientificInitiationStudent;
import java.io.FileOutputStream;
import output.ScientificInitiationStudentOutputStream;

public class OutputStream {

    public static void main(String[] args) {
        ScientificInitiationStudent[] students = {
            new ScientificInitiationStudent(
                "Lucas",
                20,
                "123",
                "Computer Science",
                20,
                500.0
            ),
            new ScientificInitiationStudent(
                "Ana",
                22,
                "789",
                "Biology",
                15,
                450.0
            ),
        };

        try (FileOutputStream fos = new FileOutputStream("students.dat")) {
            ScientificInitiationStudentOutputStream fileOut =
                new ScientificInitiationStudentOutputStream(
                    students,
                    students.length,
                    fos
                );
            fileOut.send();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
