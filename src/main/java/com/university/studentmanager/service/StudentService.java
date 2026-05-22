package com.university.studentmanager.service;

import com.university.studentmanager.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    public Student updateStudent(Long id, Student updatedStudent) {

        Student student = getStudentById(id);

        student.setName(updatedStudent.getName());
        student.setAge(updatedStudent.getAge());
        student.setEmail(updatedStudent.getEmail());

        return student;
    }

    public void deleteStudent(Long id) {

        Student student = getStudentById(id);

        students.remove(student);
    }
}