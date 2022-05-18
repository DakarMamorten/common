package com.example.controller;

import com.example.service.AdminCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/excel")
public class Excel {
  private AdminCodeService  adminCodeService;
    @GetMapping
    private void show(){
        adminCodeService.get();
    }
}
