package com.wsh.service;

import com.wsh.domain.CityCode;
import com.wsh.repository.AdminCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminCodeService {

    private final AdminCodeRepository adminCodeRepository;
    private final ExcelService excelService;

    public List<CityCode> get(){
        return excelService.read();
    }
}
