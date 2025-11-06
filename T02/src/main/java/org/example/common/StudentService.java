package org.example.common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface StudentService extends Remote {
    List<Student> getAllStudents() throws RemoteException;

    Student getStudentById(String studentId) throws RemoteException;

    void addStudentToProgram(String programCode, Student student)
        throws RemoteException;

    double calculateScholarship(String studentId) throws RemoteException;
}
