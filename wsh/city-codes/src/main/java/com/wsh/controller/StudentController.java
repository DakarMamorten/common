package com.wsh.controller;

import com.wsh.domain.Student;
import com.wsh.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/add")
    public Student addStudent(String name, Long age){
       return studentService.save(name,age);
    }
}
