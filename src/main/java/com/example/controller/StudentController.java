package com.example.controller;

import com.example.model.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> create(@RequestBody(required = true) Student student){
        return new ResponseEntity<>(service.create(student), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> get(@PathVariable(name = "id", required = true) Long id) throws Exception {
        return new ResponseEntity<>(service.get(id), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> update(@PathVariable(name = "id", required = true) Long id, @RequestBody(required = true) Student student) throws Exception {
        return new ResponseEntity<>(service.update(id, student), HttpStatus.OK);

    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<Object> delete(@PathVariable(name = "id", required = true) Long id){
        service.delete(id);
        return new ResponseEntity<>("{\"deletedSuccess\":true}", HttpStatus.OK);
    }
}
