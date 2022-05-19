package com.wsh.service;

import com.wsh.domain.Student;
import com.wsh.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(final String name,final Long age){
        Student student = new Student(name,age);
        return studentRepository.save(student);
    }
}
