package com.example.demo.Services;

import com.example.demo.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();
    private int nextId = 4; // Next available ID

    public StudentService() {
        // Initialize with sample data
        students.add(new Student(1, "Chantal", 23));
        students.add(new Student(2, "Daella", 22));
        students.add(new Student(3, "pascale", 24));
    }

    // READ - Get all students
    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    // READ - Get student by ID
    public Student getStudent(int id) {
        return students.stream()
                .filter(student -> student.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // CREATE - Add new student
    public Student createStudent(Student student) {
        student.setId(nextId++);
        students.add(student);
        return student;
    }

    // UPDATE - Update existing student
    public Student updateStudent(int id, Student updatedStudent) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                updatedStudent.setId(id);
                students.set(i, updatedStudent);
                return updatedStudent;
            }
        }
        return null; // Student not found
    }

    // DELETE - Delete student by ID
    public boolean deleteStudent(int id) {
        return students.removeIf(student -> student.getId() == id);
    }
}
