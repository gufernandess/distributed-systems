package communication;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        int door = 7896;
        try (ServerSocket serverSocket = new ServerSocket(door)) {
            System.out.println("Esperando conexões na porta " + door + "...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado!");

                new Thread(() -> {
                    try {
                        DataInputStream in = new DataInputStream(
                            socket.getInputStream()
                        );
                        DataOutputStream out = new DataOutputStream(
                            socket.getOutputStream()
                        );

                        int size = in.readInt();
                        byte[] data = new byte[size];
                        in.readFully(data);

                        ScientificInitiationStudent student =
                            ScientificInitiationStudent.desempacotar(data);
                        System.out.println("Recebido do cliente:\n");
                        System.out.println("Nome: " + student.name);
                        System.out.println("Matricula: " + student.id);
                        System.out.println("Bolsa: R$" + student.scholarship);

                        String response =
                            "Recebido com sucesso, " + student.name + "!";
                        byte[] byteResponse = response.getBytes("UTF-8");

                        out.writeInt(byteResponse.length);
                        out.write(byteResponse);

                        socket.close();
                    } catch (IOException e) {
                        System.out.println(
                            "Erro no servidor: " + e.getMessage()
                        );
                    }
                })
                    .start();
            }
        } catch (IOException e) {
            System.out.println("Erro no servidor: " + e.getMessage());
        }
    }
}
