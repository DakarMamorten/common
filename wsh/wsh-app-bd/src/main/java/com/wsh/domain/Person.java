package com.wsh.domain;

import java.util.UUID;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

  private String id = UUID.randomUUID().toString();
  @NotEmpty(message = "Person's name cannot be empty.")
  private String name;
  @NotEmpty(message = "Person's surname cannot be empty.")
  private String surname;
  @NotEmpty(message = "Person's PESEL cannot be empty.")
  private String pesel;
  @NotEmpty(message = "Person's email cannot be empty.")
  private String email;
  @NotEmpty(message = "Person's phone cannot be empty.")
  private String phoneNumber;

}
