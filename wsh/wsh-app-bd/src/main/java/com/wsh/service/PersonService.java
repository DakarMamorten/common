package com.wsh.service;

import com.wsh.domain.Person;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author Vladyslav Paun
 */
@Service
public class PersonService {

  private final List<Person> persons = new ArrayList<>();

  public void add(Person person) {
    persons.add(person);
  }

  public List<Person> findAll() {
    persons.add(new Person(UUID.randomUUID().toString(),
        "Jan",
        "Kowalski",
        "2379479279",
        "600-123-456",
        "przykladowy@mail.com"));
    persons.add(new Person(UUID.randomUUID().toString(),
        "Anna",
        "Nowak",
        "03928409328",
        "600-987-654",
        "anna@mail.com"));
    return persons;
  }
}