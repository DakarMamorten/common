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
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FilmService {

  private final FilmRepository filmRepository;
  private final CategoryService categoryService;
  private final ActorService actorService;

  public Film findById(final Long id) {
    return filmRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  public Page<Film> findAll(final Pageable pageable) {
    return filmRepository.findAll(pageable);
  }

  public void delete(final Long filmId) {
    filmRepository.deleteById(filmId);
  }

  @Transactional
  public void update(final Long filmId, final String title,String description,String releaseYear,Integer rentalDuration,Double rentalRate,Integer filmLength,Double replacementCost) {
    filmRepository.findById(filmId).ifPresent(a -> {
      a.setTitle(title);
      a.setDescription(description);
      a.setReleaseYear(releaseYear);
      a.setRentalDuration(rentalDuration);
      a.setRentalRate(rentalRate);
      a.setFilmLength(filmLength);
      a.setReplacementCost(replacementCost);
    });
  }
  public void add(final FilmDto dto) {
    final Film film = Film.of(dto);
    final List<Category> categories = categoryService.findAllById(dto.getCategoryIds());
    film.getCategories().addAll(categories);
    filmRepository.save(film);

  }
}
