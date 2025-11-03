package output;

import classes.ScientificInitiationStudent;
import input.ScientificInitiationStudentInputStream;
import java.io.IOException;

public class TestStdin {

    public static void main(String[] args) {
        try {
            ScientificInitiationStudentInputStream input =
                new ScientificInitiationStudentInputStream(System.in);
            ScientificInitiationStudent student = input.readStudent();
            System.out.println(student);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
