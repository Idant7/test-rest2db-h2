package ru.isakov.testrest2dbh2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.isakov.testrest2dbh2.entity.Student;
import ru.isakov.testrest2dbh2.service.StudentService;


import java.util.List;
@RestController
@RequestMapping("/api")
public class MyController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public List<Student> showAllStudents(){
        return studentService.getAllStudents();

    }

    @GetMapping("/students/{id}")
    private Student getStudent(@PathVariable("id") int id){
        return studentService.getStudent(id);
    }

    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }

    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return student;
    }

    @DeleteMapping
    public void updateStudent(@PathVariable("id") int id){
        studentService.deleteStudent(id);
    }
}
