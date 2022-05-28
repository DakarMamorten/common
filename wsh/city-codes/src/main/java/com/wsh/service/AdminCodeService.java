package com.wsh.service;

import com.wsh.domain.AdminCode;
import com.wsh.repository.AdminCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminCodeService {

    private final AdminCodeRepository adminCodeRepository;

    public AdminCode findCode(final String adminCode) {
        return adminCodeRepository.findAdminCodeByCode(adminCode);
    }

    public List<String> getAdminCode(){
        return adminCodeRepository.getAdminCodeByCode();
    }

    public Map<String,AdminCode> codes(){
        List<AdminCode> adminCodes = adminCodeRepository.findAll();
        Map<String,AdminCode> adminCodeMap = new HashMap<>();
        for (AdminCode code : adminCodes) {
            adminCodeMap.put(code.getCode(),code);
        }
        return adminCodeMap;
    }
}
