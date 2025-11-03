package communication;

import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {
        String host = "localhost";
        int door = 7896;

        try (Socket socket = new Socket(host, door)) {
            DataOutputStream out = new DataOutputStream(
                socket.getOutputStream()
            );
            DataInputStream in = new DataInputStream(socket.getInputStream());

            ScientificInitiationStudent student =
                new ScientificInitiationStudent(
                    "Beatriz Silva",
                    "2023012345",
                    800.00
                );
            byte[] data = student.empacotar();

            out.writeInt(data.length);
            out.write(data);

            int responseSize = in.readInt();
            byte[] byteResponse = new byte[responseSize];
            in.readFully(byteResponse);
            String response = new String(byteResponse, "UTF-8");

            System.out.println(response);
        } catch (IOException e) {
            System.out.println("Erro no cliente: " + e.getMessage());
        }
    }
}
