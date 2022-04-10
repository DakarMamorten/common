package com.wsh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @NotEmpty(message = "Student name cannot be empty. ")
    @Size(min = 2,max=15)
    private String name;
    @NotEmpty(message = "Student surname cannot be empty. ")
    @Size(min = 2,max=15)
    private String surname;
    @NotEmpty(message = "Student age cannot be empty. ")
    @Size(min = 18 ,message = "You can't vote ")
    private String age;

    public void add(Student student) {
    }

}
