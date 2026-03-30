package com.bst.service;

import java.util.List;
import com.bst.model.Student;

public interface StudentService {

    Student register(Student student);

    Student login(String email, String password);
    
    List<Student> getAllStudents();

    Student getStudentById(Long id);

    void deleteStudent(Long id);

	Student updateStudent(Long id, Student student);

}