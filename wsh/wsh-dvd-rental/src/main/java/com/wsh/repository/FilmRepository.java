package com.wsh.repository;

import com.wsh.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *@author "Vladyslav Paun"
 */
public interface FilmRepository extends JpaRepository<Film, Long> {
}
