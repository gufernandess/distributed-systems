package communication;

import java.io.*;

public class ScientificInitiationStudent {

    public String name;
    public String id;
    public double scholarship;

    public ScientificInitiationStudent(
        String name,
        String id,
        double scholarship
    ) {
        this.name = name;
        this.id = id;
        this.scholarship = scholarship;
    }

    public byte[] empacotar() throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(baos);

        out.writeUTF(name);
        out.writeUTF(id);
        out.writeDouble(scholarship);

        return baos.toByteArray();
    }

    public static ScientificInitiationStudent desempacotar(byte[] dados)
        throws IOException {
        DataInputStream in = new DataInputStream(
            new ByteArrayInputStream(dados)
        );

        String name = in.readUTF();
        String id = in.readUTF();
        double scholarship = in.readDouble();

        return new ScientificInitiationStudent(name, id, scholarship);
    }
}
