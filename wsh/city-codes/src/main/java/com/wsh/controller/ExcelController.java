package com.wsh.controller;

import com.wsh.service.CityCodeService;
import com.wsh.service.ExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/excel")
@RequiredArgsConstructor
public class ExcelController {
    private final CityCodeService cityCodeService;
    private final ExcelService excelService;

    @GetMapping
    private void show() {
        cityCodeService.entityToDTO(excelService.read());
    }
}
