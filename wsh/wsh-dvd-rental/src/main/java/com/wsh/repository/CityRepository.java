package com.wsh.repository;

import com.wsh.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *@author "Vladyslav Paun"
 */
public interface CityRepository extends JpaRepository<City,Long> {
}
