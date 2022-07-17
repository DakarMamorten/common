package com.wsh.service;

import com.wsh.domain.City;
import com.wsh.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {
    private final CityRepository cityRepository;
    private final CountryService countryService;

    public void add(final String cityTitle, final Long countryId) {
        City city = new City(cityTitle);
        city.setCountry(countryService.findById(countryId));
        cityRepository.save(city);
    }
    @Transactional
    public void update(final Long cityId, final String cityTitle, final Long countryId) {
        cityRepository.findById(cityId).ifPresent(city -> {
                    city.setCityTitle(cityTitle);
                    city.setCountry(countryService.findById(countryId));
                }
        );
    }

    public City findById(final Long cityId){
        return cityRepository.findById(cityId).orElseThrow(EntityNotFoundException::new);    }

    public void delete(final Long cityId) {
        cityRepository.deleteById(cityId);
    }

    public List<City> findAll() {
        return cityRepository.findAll();
    }

    public Page<City> findAll(final Pageable pageable) {
        return cityRepository.findAll(pageable);
    }

}
