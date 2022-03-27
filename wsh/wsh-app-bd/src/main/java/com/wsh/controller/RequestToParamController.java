package com.wsh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;

/**
 * @author "Vladyslav Paun"
 */
@RestController
public class RequestToParamController {

    @GetMapping("/req-to-param")
    public String requestToParam(@RequestParam String name,
                                 @RequestParam String surname,
                                 @RequestParam String pesel,
                                 @RequestParam(required = false) String email,
                                 @RequestParam(required = false) String phone) {
        return makeResponse(name,
                            surname,
                            pesel,
                            email,
                            phone);
    }

    private String makeResponse(String name,
                                String surname,
                                String pesel,
                                String email,
                                String phone) {
        String result = " Name: " + name +
                        ",\n " +
                        "Surname: " + surname +
                        ",\n " +
                        "Pesel: " + pesel;
        if (nonNull(email)) {
            result += ",\n Email: " + email;
        } else {
            result += ",\n Email: nie znamy Twojego adresu e-mail";
        }
        if (nonNull(phone)) {
            result += ",\n Phone: " + phone;
        } else {
            result += ",\n Phone: nie znamy Twojego telefonu";
        }
        return result;
    }

}
