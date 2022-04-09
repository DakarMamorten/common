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
  @NotEmpty(message = "User's name cannot be empty.")
  private String name;
  private String surname;
  private String pesel;
  private String email;
  private String phoneNumber;

}
