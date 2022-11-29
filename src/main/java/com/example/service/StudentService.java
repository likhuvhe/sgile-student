package com.example.service;

import com.example.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentService {
    private List<Student> studentList = new ArrayList<>();

    public Student create(Student student) {
        studentList.add(student);
        log.info( "=========> {} added", student.getName());
        return student;
    }

    public Student get(String name) {
        log.info( "=========> trigger get student by name {}", name);
        return studentList.stream()
                .filter(student -> name.equals(student.getName()))
                .findAny()
                .orElse(null);
    }

    public List<Student> getAll() {
        log.info( "=========> trigger get all students");
        return studentList;
    }

    public Student update(String name, Student student) {
        Student updatedStudent = new Student();
        for (Student student1 : studentList) {
            if (student1.getName().equals(name)){
                student1.setAge(student.getAge());
                student1.setSubject(student.getSubject());
                updatedStudent = student1;
            }
        }
        log.info( "=========> {} updated", student.getName());
        return updatedStudent;
    }

    public void delete(String name) {
        Student student = studentList.stream()
                .filter(student1 -> name.equals(student1.getName()))
                .findAny()
                .orElse(null);
        assert student != null;
        log.info( "=========> {} removed", student.getName());
        studentList.remove(student);

    }
}
