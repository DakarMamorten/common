package com.wsh.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author "Vladyslav Paun"
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Actor {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long actorId;
  private String firstName;
  private String lastName;
  private LocalDateTime lastUpdate = LocalDateTime.now();

  public Actor(final String firstName, final String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

}
