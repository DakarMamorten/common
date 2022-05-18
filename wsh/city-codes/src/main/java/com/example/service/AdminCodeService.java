package com.example.service;

import com.example.repository.AdminCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminCodeService {

    private AdminCodeRepository adminCodeRepository;
    private ExcelService excelService;

    public void get(){
        excelService.read();
    }
}