package com.wsh.repository;

import com.wsh.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *@author "Vladyslav Paun"
 */
public interface CountryRepository extends JpaRepository<Country,Long> {
}
