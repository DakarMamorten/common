package com.wsh.service;

import com.wsh.domain.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final List<Student> students = new ArrayList<>();
    public void add(Student student) {
        students.add(student);
    }
}
