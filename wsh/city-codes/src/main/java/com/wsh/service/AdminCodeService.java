package com.wsh.service;

import com.wsh.domain.AdminCode;
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

    public AdminCode findCode(final String adminCode) {
        return adminCodeRepository.findAdminCodeByCode(adminCode);
    }

    public List<String> getAdminCode(){
        return adminCodeRepository.getAdminCodeByCode();
    }

}
