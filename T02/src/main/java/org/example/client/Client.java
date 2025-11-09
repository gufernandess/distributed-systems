package org.example.client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;
import org.example.common.*;

public class Client {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentService service = (StudentService) Naming.lookup(
                "rmi://localhost/StudentService"
            );
            System.out.println("Cliente conectado ao servidor RMI.\n");

            while (true) {
                printMenu();
                String input = scanner.nextLine();
                int choice;

                try {
                    choice = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.err.println(
                        "Erro: Por favor, digite um número válido."
                    );
                    System.out.println();
                    continue;
                }

                System.out.println();

                switch (choice) {
                    case 1:
                        handleAddStudent(service, scanner);
                        break;
                    case 2:
                        handleCalculateScholarship(service, scanner);
                        break;
                    case 3:
                        handleGetStudentById(service, scanner);
                        break;
                    case 4:
                        handleGetAllStudents(service);
                        break;
                    case 0:
                        System.out.println("Encerrando o cliente...");
                        return;
                    default:
                        System.err.println("Opção inválida. Tente novamente.");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.err.println(
                "Erro fatal de conexão com o servidor: " + e.getMessage()
            );
            e.printStackTrace();
        }
    }

    private static void printMenu() {
        System.out.println("--- Menu de Gerenciamento de Alunos ---");
        System.out.println("1. Adicionar Estudante");
        System.out.println("2. Calcular Bolsa (por Matrícula)");
        System.out.println("3. Buscar Estudante (por Matrícula)");
        System.out.println("4. Listar Todos os Estudantes");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void handleAddStudent(
        StudentService service,
        Scanner scanner
    ) {
        try {
            System.out.println("--- Adicionar Novo Estudante ---");
            System.out.print(
                "Tipo (1 = Iniciação Científica, 2 = Pós-Graduação): "
            );
            int tipo = Integer.parseInt(scanner.nextLine());

            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());
            System.out.print("Matrícula (ex: S123 ou P456): ");
            String matricula = scanner.nextLine();
            System.out.print("Horas Semanais: ");
            int horas = Integer.parseInt(scanner.nextLine());
            System.out.print("Valor por Hora: ");
            double valorHora = Double.parseDouble(scanner.nextLine());

            Student student = null;
            if (tipo == 1) {
                System.out.print("Curso: ");
                String curso = scanner.nextLine();
                student = new ScientificInitiationStudent(
                    nome,
                    idade,
                    matricula,
                    curso,
                    horas,
                    valorHora
                );
            } else if (tipo == 2) {
                System.out.print("Área de Pesquisa: ");
                String area = scanner.nextLine();
                System.out.print("Orientador: ");
                String orientador = scanner.nextLine();
                student = new PostGraduateStudent(
                    nome,
                    idade,
                    matricula,
                    area,
                    orientador,
                    horas,
                    valorHora
                );
            } else {
                System.err.println("Tipo de estudante inválido.");
                return;
            }

            service.addStudentToProgram("CC001", student);
            System.out.println("Sucesso: Estudante '" + nome + "' adicionado!");
        } catch (NumberFormatException e) {
            System.err.println("Erro: Entrada numérica inválida.");
        } catch (RemoteException e) {
            System.err.println("Erro do servidor: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Erro inesperado: " + e.getMessage());
        }
    }

    private static void handleCalculateScholarship(
        StudentService service,
        Scanner scanner
    ) {
        try {
            System.out.print(
                "Digite a matrícula do aluno para calcular a bolsa: "
            );
            String matricula = scanner.nextLine();
            double scholarship = service.calculateScholarship(matricula);
            System.out.println(
                "Valor da bolsa para " + matricula + ": R$ " + scholarship
            );
        } catch (Exception e) {
            System.err.println("Erro ao calcular bolsa: " + e.getMessage());
        }
    }

    private static void handleGetStudentById(
        StudentService service,
        Scanner scanner
    ) {
        try {
            System.out.print("Digite a matrícula do aluno a buscar: ");
            String matricula = scanner.nextLine();
            Student student = service.getStudentById(matricula);
            if (student != null) {
                System.out.println("Aluno encontrado:");
                System.out.println(student.toString());
            } else {
                System.out.println(
                    "Aluno com matrícula " + matricula + " não encontrado."
                );
            }
        } catch (RemoteException e) {
            System.err.println("Erro do servidor: " + e.getMessage());
        }
    }

    private static void handleGetAllStudents(StudentService service) {
        try {
            List<Student> students = service.getAllStudents();
            if (students.isEmpty()) {
                System.out.println("Nenhum estudante cadastrado no momento.");
            } else {
                System.out.println(
                    "--- Lista de Todos os Estudantes (" +
                        students.size() +
                        ") ---"
                );
                for (Student s : students) {
                    System.out.println(s.toString());
                    System.out.println("-----");
                }
            }
        } catch (RemoteException e) {
            System.err.println("Erro do servidor: " + e.getMessage());
        }
    }
}
