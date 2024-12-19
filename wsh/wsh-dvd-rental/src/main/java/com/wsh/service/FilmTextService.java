package com.wsh.service;

import com.wsh.domain.FilmText;
import com.wsh.repository.FilmTextRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @author "Vladyslav Paun"
 */
@Service
@RequiredArgsConstructor
public class FilmTextService {
    private final FilmTextRepository filmTextRepository;

    public void addFilmText(Long filmId, String title, String description) {
        FilmText filmText = new FilmText();
        filmText.setFilmId(filmId);
        filmText.setTitle(title);
        filmText.setDescription(description);
        filmTextRepository.save(filmText);
    }

    @Transactional
    public void updateFilmText(Long filmId, String title, String description) {
        filmTextRepository.findById(filmId).ifPresent(filmText -> {
            filmText.setTitle(title);
            filmText.setDescription(description);
        });
    }

    public List<FilmText> findAllFilmTexts() {
        return filmTextRepository.findAll();
    }

    public Optional<FilmText> findById(Long filmId) {
        return filmTextRepository.findById(filmId);
    }

    public void deleteFilmText(Long filmId) {
        filmTextRepository.deleteById(filmId);
    }
}
