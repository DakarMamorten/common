package com.wsh.repository;

import com.wsh.domain.FilmText;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmTextRepository extends JpaRepository<FilmText, Long> {
}
