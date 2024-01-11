package com.wsh.service;

import com.wsh.domain.Country;
import com.wsh.repository.CountryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author "Vladyslav Paun"
 */
@RequiredArgsConstructor
@Service
public class CountryService {
    private final CountryRepository countryRepository;

    public void add(final String countryTitle) {
        Country country = new Country(countryTitle);
        countryRepository.save(country);
    }
    @Transactional
    public void update(final Long countryId, final String countryTitle) {
        countryRepository.findById(countryId).ifPresent(c -> c.setCountryTitle(countryTitle));
    }

    public Country findById(final Long countryId) {
        return countryRepository.findById(countryId).orElseThrow(EntityNotFoundException::new);
    }

    public void delete(final Long countryId) {
        countryRepository.deleteById(countryId);
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Page<Country> findAll(final Pageable pageable) {
        return countryRepository.findAll(pageable);
    }


}
