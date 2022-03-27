package com.wsh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Vladyslav Paun"
 */
@RestController
public class PathParamController {

    @GetMapping("/path-param/{text1}/{number1}/{text2}/{number2}")
    public String getParams(@PathVariable String text1,
                            @PathVariable Long number1,
                            @PathVariable String text2,
                            @PathVariable Long number2) {
        return "Z adresu pozyskałem następujące dane:\n text1:" + text1 + " przekazana liczba to:" + number1 +
               "\n text2:" + text2 + " przekazana liczba to:" + number2;
    }

}
