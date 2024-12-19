package com.wsh.service;

import com.wsh.domain.Language;
import com.wsh.repository.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author "Vladyslav Paun"
 */
@Service
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageRepository languageRepository;

    public void addLanguage(String name) {
        Language language = new Language();
        language.setName(name);
        language.setLastUpdate(LocalDateTime.now());
        languageRepository.save(language);
    }

    @Transactional
    public void updateLanguage(Long languageId, String name) {
        languageRepository.findById(languageId).ifPresent(language -> {
            language.setName(name);
            language.setLastUpdate(LocalDateTime.now());
        });
    }

    public List<Language> findAllLanguages() {
        return languageRepository.findAll();
    }

    public void deleteLanguage(Long id) {
        languageRepository.deleteById(id);
    }
}
