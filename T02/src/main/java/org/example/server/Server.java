package org.example.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import org.example.common.StudentService;

public class Server {

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            System.out.println("RMI iniciado na porta 1099.");

            StudentService studentService = new StudentServiceImpl();

            Naming.rebind("rmi://localhost/StudentService", studentService);

            System.out.println(
                "Serviço registrado e pronto para receber requisições."
            );
        } catch (Exception e) {
            System.err.println("Erro ao iniciar o servidor: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
