package com.wsh.controller;

import com.wsh.domain.CityCode;
import com.wsh.service.AdminCodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/excel")
@RequiredArgsConstructor
public class Excel {
    private final AdminCodeService adminCodeService;

    @GetMapping
    private List<CityCode> show() {
        return adminCodeService.get();
    }
}
