package com.wsh.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  private String id = UUID.randomUUID().toString();
  @NotEmpty(message = "Person's name cannot be empty.")
  @Size(min = 2)
  private String name;
  @NotEmpty(message = "Person's surname cannot be empty.")
  @Size(min = 2)
  private String surname;
  @NotEmpty(message = "Person's PESEL cannot be empty.")
  @Size(min = 5)
  private String pesel;
  @NotEmpty(message = "Person's email cannot be empty.")
  @Email
  private String email;
  @NotEmpty(message = "Person's phone cannot be empty.")
  private String phoneNumber;

}
