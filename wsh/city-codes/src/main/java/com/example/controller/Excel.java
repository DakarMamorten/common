package com.example.controller;

import com.example.domain.CityCode;
import com.example.service.AdminCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/excel")
public class Excel {
  private AdminCodeService  adminCodeService;
    @GetMapping
    private List<CityCode> show(){
       return adminCodeService.get();
    }
}
