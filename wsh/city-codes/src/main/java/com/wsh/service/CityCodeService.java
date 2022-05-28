package com.wsh.service;

import com.wsh.domain.AdminCode;
import com.wsh.domain.CityCode;
import com.wsh.dto.CodeDto;
import com.wsh.repository.CityCodeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
@RequiredArgsConstructor
public class CityCodeService {
    private final CityCodeRepository repository;
    private final AdminCodeService adminCodeService;

    public void entityToDTO(List<CodeDto> codeDtoList) {
        List<CityCode> cityCodeList = new ArrayList<>();
        Map<String, AdminCode> codes = adminCodeService.codes();
        for (CodeDto codeDto : codeDtoList) {
            CityCode cityCode = new CityCode();
            cityCode.setCode(cityCode.getCode());
            if (codes.containsKey(codeDto.getAdminCode())){
                cityCodeList.add(cityCode);
            }
        }
        log.info(String.valueOf(cityCodeList.size()));
//        repository.saveAll(cityCodeList);
    }


}


