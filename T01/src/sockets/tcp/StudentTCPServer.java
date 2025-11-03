package sockets.tcp;

import java.io.*;
import java.net.*;

public class StudentTCPServer {

    public static void main(String args[]) {
        try {
            System.out.println("Servidor inicializado.");
            int serverPort = 7896;
            ServerSocket listenSocket = new ServerSocket(serverPort);
            while (true) {
                Socket clientSocket = listenSocket.accept();
                System.out.println(
                    "Cliente conectado: " + clientSocket.getInetAddress()
                );
                new StudentConnection(clientSocket);
            }
        } catch (IOException e) {
            System.out.println("Ouvindo socket:" + e.getMessage());
        }
    }
}

class StudentConnection extends Thread {

    DataInputStream in;
    Socket clientSocket;

    public StudentConnection(Socket aClientSocket) {
        try {
            clientSocket = aClientSocket;
            in = new DataInputStream(clientSocket.getInputStream());
            this.start();
        } catch (IOException e) {
            System.out.println("Conexão:" + e.getMessage());
        }
    }

    public void run() {
        try {
            while (true) {
                int size = in.readInt();
                byte[] data = new byte[size];
                in.readFully(data);

                DataInputStream dataIn = new DataInputStream(
                    new ByteArrayInputStream(data)
                );
                String name = dataIn.readUTF();
                int age = dataIn.readInt();
                String id = dataIn.readUTF();
                String major = dataIn.readUTF();
                int workedDays = dataIn.readInt();
                double scholarship = dataIn.readDouble();

                System.out.println("\nAluno recebido:\n");
                System.out.println("Nome: " + name);
                System.out.println("Idade: " + age);
                System.out.println("Matrícula: " + id);
                System.out.println("Curso: " + major);
                System.out.println("Dias trabalhados: " + workedDays);
                System.out.println("Bolsa: R$" + scholarship);
            }
        } catch (EOFException e) {
            System.out.println("Conexão encerrada pelo cliente.");
        } catch (IOException e) {
            System.out.println("Error na leitura:" + e.getMessage());
        } finally {
            try {
                clientSocket.close();
                System.out.println("Conexão encerrada.");
            } catch (IOException e) {
                System.out.println(
                    "Erro ao encerrar a conexão: " + e.getMessage()
                );
            }
        }
    }
}
