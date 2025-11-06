package org.example.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import org.example.common.*;

public class StudentServiceImpl
    extends UnicastRemoteObject
    implements StudentService {

    private final Map<String, UndergraduateProgram> programs;
    private final Map<String, Student> studentRegistry;

    public StudentServiceImpl() throws RemoteException {
        super();
        this.programs = new HashMap<>();
        this.studentRegistry = new HashMap<>();

        UndergraduateProgram csProgram = new UndergraduateProgram(
            "Ciência da Computação",
            "CC001",
            4
        );
        programs.put(csProgram.getCode(), csProgram);

        System.out.println("Servidor inicializado.");
        System.out.println(
            "Programa 'Ciência da Computação' (CC001) carregado."
        );
        System.out.println();
    }

    @Override
    public List<Student> getAllStudents() throws RemoteException {
        List<Student> students = new ArrayList<>(studentRegistry.values());

        System.out.println("Retornando " + students.size() + " alunos:");

        for (Student s : students) {
            System.out.println(s.toString());
        }

        System.out.println();
        return students;
    }

    @Override
    public Student getStudentById(String studentId) throws RemoteException {
        Student student = studentRegistry.get(studentId);

        if (student != null) {
            System.out.println("Aluno encontrado. Dados:");
            System.out.println(student.toString());
        } else {
            System.out.println(
                "Aluno com matrícula " + studentId + " não encontrado."
            );
        }

        System.out.println();
        return student;
    }

    @Override
    public void addStudentToProgram(String programCode, Student student)
        throws RemoteException {
        if (student != null) {
            System.out.println(
                "Tentando adicionar Aluno: " +
                    student.getName() +
                    " (Matrícula: " +
                    student.getStudentId() +
                    ")"
            );
            System.out.println("Ao Programa: " + programCode);
        } else {
            System.out.println(
                "Tentativa de adicionar um aluno nulo ao programa " +
                    programCode
            );
        }

        UndergraduateProgram program = programs.get(programCode);
        if (program != null && student != null) {
            program.addStudent(student);
            studentRegistry.put(student.getStudentId(), student);

            System.out.println(
                "Aluno " + student.getStudentId() + " adicionado."
            );
        } else {
            System.err.println(
                "Programa (" + programCode + ") ou estudante é inválido."
            );
            System.out.println();
            throw new IllegalArgumentException(
                "Programa ou estudante inválido."
            );
        }
        System.out.println();
    }

    @Override
    public double calculateScholarship(String studentId)
        throws RemoteException {
        Student student = studentRegistry.get(studentId);

        if (student == null) {
            System.err.println(
                "Aluno com matrícula " +
                    studentId +
                    " não encontrado no registro."
            );
            System.out.println();
            throw new IllegalArgumentException(
                "Estudante com matrícula " + studentId + " não foi encontrado."
            );
        }

        if (student instanceof Remunerable remunerable) {
            double payment = remunerable.calculatePayment();

            System.out.println(
                "Aluno é remunerado. Bolsa calculada: R$ " + payment
            );
            System.out.println();
            return payment;
        } else {
            System.err.println(
                "Aluno " +
                    student.getName() +
                    " (Matrícula: " +
                    studentId +
                    ") não é remunerado."
            );
            System.out.println();
            throw new IllegalArgumentException(
                "Estudante " + student.getName() + " não é bolsista."
            );
        }
    }
}
