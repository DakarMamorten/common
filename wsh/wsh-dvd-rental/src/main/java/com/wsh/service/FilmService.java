package com.wsh.service;

import com.wsh.domain.Actor;
import com.wsh.domain.Category;
import com.wsh.domain.Film;
import com.wsh.domain.dto.FilmDto;
import com.wsh.repository.FilmRepository;
import java.util.List;
import java.util.stream.Collectors;
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
  private final ActorService actorService;

  public Film findById(final Long id) {
    return filmRepository.findById(id)
        .orElseThrow(EntityNotFoundException::new);
  }

  public Page<Film> findAll(final Pageable pageable) {
    final Page<Film> films = filmRepository.findAll(pageable);
    films
        .getContent()
        .forEach(f -> {
          f.getSelectedCategories().addAll(f.getCategories().stream().map(Category::getCategoryId).collect(Collectors.toSet()));
          f.getSelectedActors().addAll(f.getActors().stream().map(Actor::getActorId).collect(Collectors.toSet()));
        });
    return films;
  }

  public void delete(final Long filmId) {
    filmRepository.deleteById(filmId);
  }

  public void update(final FilmDto dto) {
    filmRepository.findById(dto.getFilmId())
        .ifPresent(film -> {
          film.setTitle(dto.getTitle());
          film.setDescription(dto.getDescription());
          film.setReleaseYear(dto.getReleaseYear());
          film.setRentalDuration(dto.getRentalDuration());
          film.setRentalRate(dto.getRentalRate());
          film.setFilmLength(dto.getFilmLength());
          film.setReplacementCost(dto.getReplacementCost());
          final List<Category> categories = categoryService.findAllById(dto.getCategoryIds());
          film.addCategories(categories);
          final List<Actor> actors = actorService.findAllById(dto.getActorIds());
          film.getActors().clear();
          film.getActors().addAll(actors);
          filmRepository.save(film);
        });
  }

  public void add(final FilmDto dto) {
    final Film film = Film.of(dto);
    final List<Category> categories = categoryService.findAllById(dto.getCategoryIds());
    final List<Actor> actors = actorService.findAllById(dto.getActorIds());
    film.getCategories()
        .addAll(categories);
    film.getActors()
        .addAll(actors);
    filmRepository.save(film);

  }

}
