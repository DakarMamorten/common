package com.wsh.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false)
  private String isbn = UUID.randomUUID().toString();
  @Column(nullable = false)
  private String title;
  private BigDecimal recommendedPrice;
  @Column(nullable = false)
  private LocalDate datePublication;
  //add comments
}
