package com.wsh.service;

import com.wsh.repository.CityCodeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CityCodeService {
    private final CityCodeRepository repository;
    private final AdminCodeService adminCodeService;

    //TODO: create method: input param List<CodeDto>, output param: void

}
