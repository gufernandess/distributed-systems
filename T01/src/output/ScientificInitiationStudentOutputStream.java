package output;

import classes.ScientificInitiationStudent;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ScientificInitiationStudentOutputStream extends OutputStream {

    private ScientificInitiationStudent[] students;
    private int amount;
    private OutputStream outputStream;

    public ScientificInitiationStudentOutputStream(
        ScientificInitiationStudent[] students,
        int amount,
        OutputStream outputStream
    ) {
        this.students = students;
        this.amount = amount;
        this.outputStream = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        outputStream.write(b);
    }

    public void send() throws IOException {
        DataOutputStream dataOut = new DataOutputStream(outputStream);

        for (int i = 0; i < amount; i++) {
            ByteArrayOutputStream temp = new ByteArrayOutputStream();
            DataOutputStream tempOut = new DataOutputStream(temp);

            ScientificInitiationStudent student = students[i];

            tempOut.writeUTF(student.getName());
            tempOut.writeInt(student.getAge());
            tempOut.writeUTF(student.getStudentId());
            tempOut.writeUTF(student.getMajor());
            tempOut.writeInt(student.getWorkedDays());
            tempOut.writeDouble(student.getScholarshipAmount());

            byte[] studentData = temp.toByteArray();

            dataOut.writeInt(studentData.length);
            dataOut.write(studentData);
        }

        dataOut.flush();
    }
}
