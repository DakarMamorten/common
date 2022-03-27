package com.wsh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Vladyslav Paun"
 */
@RestController
public class RequestHeaderController {

    @GetMapping("/RequestHeader")
    @ResponseBody
    public String exampleRequestHeader(@RequestHeader("User-Agent") String client,
                                       @RequestHeader("Accept-Language") String language,
                                       @RequestHeader("Cookie") String cookie,
                                       @RequestHeader("Host") String host) {
        return "client: " + client + " , " + "language: " + language + " , " + "cookie: " + cookie + " , " + "host: " + host;

    }

}
