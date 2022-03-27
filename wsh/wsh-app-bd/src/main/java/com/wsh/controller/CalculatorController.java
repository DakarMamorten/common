package com.wsh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Vladyslav Paun"
 */
@RestController
public class CalculatorController {

    @GetMapping(value = "/{operation}/{num1}/{num2}")
    public double calculate(@PathVariable String operation,
                            @PathVariable double num1,
                            @PathVariable double num2) {
        double res = 0;
        switch (operation) {
            case "add":
                res = num1 + num2;
                break;
            case "substract":
                res = num1 - num2;
                break;
            case "multiply":
                res = num1 * num2;
                break;
            case "divide":
                if (num2 == 0) {
                    res = 0;
                } else {
                    res = num1 / num2;
                }
                break;
            default:
        }
        return res;
    }

}
