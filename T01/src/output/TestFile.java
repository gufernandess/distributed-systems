package output;

import classes.ScientificInitiationStudent;
import input.ScientificInitiationStudentInputStream;
import java.io.*;

public class TestFile {

    public static void main(String[] args) {
        try (FileInputStream fileIn = new FileInputStream("students.dat")) {
            ScientificInitiationStudentInputStream input =
                new ScientificInitiationStudentInputStream(fileIn);

            while (true) {
                ScientificInitiationStudent aluno = input.readStudent();
                System.out.println(aluno);
            }
        } catch (EOFException e) {
            System.out.println("End of file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
