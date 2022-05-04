package com.wsh.service;

import com.wsh.domain.Category;
import com.wsh.domain.Film;
import com.wsh.domain.dto.FilmDto;
import com.wsh.repository.FilmRepository;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmService {

  private final FilmRepository filmRepository;
  private final CategoryService categoryService;

  public Film findById(final Long id) {
    return filmRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public Page<Film> findAll(final Pageable pageable) {
    return filmRepository.findAll(pageable);
  }

  public void delete(final Long filmId) {
    filmRepository.deleteById(filmId);
  }

  public void add(final FilmDto dto) {
    final Film film = Film.of(dto);
    final List<Category> categories = categoryService.findAllById(dto.getCategoryIds());
    film.getCategories().addAll(categories);
    filmRepository.save(film);

  }
}
