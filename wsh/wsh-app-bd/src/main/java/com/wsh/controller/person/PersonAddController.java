package com.wsh.controller.person;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author "Vladyslav Paun"
 */
@Controller
public class PersonAddController {

    @GetMapping("/person")
    public String getPerson(RedirectAttributes redirectAttributes) {
        Person person1 = new Person("1",
                                    "Jan",
                                    "Kowalski",
                                    "600-123-456",
                                    "przykladowy@mail.com");
        Person person2 = new Person("2",
                                    "Anna",
                                    "Nowak",
                                    "600-987-654",
                                    "anna@mail.com");
        redirectAttributes.addAttribute("person1",
                                        person1);
        redirectAttributes.addAttribute("person2",
                                        person2);
        return "person";
    }

    public boolean isFormNotEmpty(Person person) {
        return !StringUtils.isAllBlank(
                person.getId(),
                person.getName(),
                person.getSurname(),
                person.getEmail(),
                person.getPhoneNumber());
    }

}
