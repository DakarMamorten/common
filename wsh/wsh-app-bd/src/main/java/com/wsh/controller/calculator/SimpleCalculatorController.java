package com.wsh.controller.calculator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Vladyslav Paun"
 */
@RestController
@RequestMapping("/calculator")
public class SimpleCalculatorController {

    @GetMapping(value = "/simple/{operation}/{num1}/{num2}")
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
