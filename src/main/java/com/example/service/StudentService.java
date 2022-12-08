package com.example.service;

import com.example.model.Student;
import com.example.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentRepository repository;
    public Student create(Student student) {
        log.info( "=========> {} add new student", student.getName());
        return repository.save(student);
    }

    public Student get(Long id) throws Exception {
        log.info( "=========> trigger get student by id {}", id);
        Student student = repository.findById(id).
                orElseThrow(()-> new Exception("resource not found"));
        return student;
    }

    public List<Student> getAll() {
        log.info( "=========> trigger get all students");
        return repository.findAll();
    }

    public Student update(Long id, Student student) throws Exception {
        log.info( "=========> trigger update student");
        repository.findById(id).
                orElseThrow(()-> new Exception("resource not found"));
        student.setId(id);
        return repository.save(student);
    }

    public void delete(Long id) {
        log.info( "=========> trigger delete student");
        repository.deleteById(id);
    }
}
