package com.wsh.controller.student;

import com.wsh.domain.Student;
import com.wsh.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    @GetMapping("/view")
    public String getPerson(Model model) {
        model.addAttribute("student", new Student());
        return "student/student";
    }

    @PostMapping("/view")
    public String addPerson(@Valid @ModelAttribute Student student, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "student/student";
        }
        model.addAttribute("student", student);
        studentService.add(student);
        return "student/student";
    }
}
