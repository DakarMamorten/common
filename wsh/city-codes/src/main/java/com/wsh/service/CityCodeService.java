package com.wsh.service;

import com.wsh.domain.CityCode;
import com.wsh.dto.CodeDto;
import com.wsh.repository.CityCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityCodeService {
    private final CityCodeRepository repository;
    private final AdminCodeService adminCodeService;

    public void entityToDTO(List<CodeDto> codeDtoList){
        List<CityCode> cityCodeList = new ArrayList<>();
        for (CodeDto codeDto : codeDtoList) {
            CityCode cityCode = new CityCode();
            cityCode.setCode(cityCode.getCode());
            cityCode.setAdminCode(adminCodeService.findCode(codeDto.getAdminCode()));
            cityCodeList.add(cityCode);
            }
        log.info(String.valueOf(cityCodeList.size()));
//        repository.saveAll(cityCodeList);
        }
    }

