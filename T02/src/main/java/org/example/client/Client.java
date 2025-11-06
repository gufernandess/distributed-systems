package org.example.client;

import java.rmi.Naming;
import java.util.List;
import org.example.common.*;

public class Client {

    public static void main(String[] args) {
        try {
            StudentService service = (StudentService) Naming.lookup(
                "rmi://localhost/StudentService"
            );

            ScientificInitiationStudent student =
                new ScientificInitiationStudent(
                    "Ana Clara",
                    21,
                    "S123",
                    "Ciência da Computação",
                    20,
                    50.0
                );

            System.out.println("Adicionando estudantes ao programa...");
            service.addStudentToProgram("CC001", student);

            PostGraduateStudent postGrad = new PostGraduateStudent(
                "Carlos Eduardo",
                28,
                "P456",
                "IA Aplicada na Saúde",
                "Dr. João",
                15,
                100.0
            );

            service.addStudentToProgram("CC001", postGrad);

            double scholarship = service.calculateScholarship("P456");
            System.out.println(
                "\nBolsa do aluno de pós-graduação: R$ " + scholarship
            );

            List<Student> students = service.getAllStudents();
            for (Student s : students) {
                System.out.println(s);
            }

            System.out.println("\nCalculando bolsa do estudante S123...");
            double totalPayment = service.calculateScholarship("S123");
            System.out.println("Valor total da bolsa: R$ " + totalPayment);
        } catch (Exception e) {
            System.err.println("Erro no cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
