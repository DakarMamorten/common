package com.wsh.service;

import com.wsh.domain.Category;
import com.wsh.repository.CategoryRepository;
import java.util.List;
import java.util.Set;
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
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public void add(final String name) {
    Category category = new Category(name);
    categoryRepository.save(category);
  }

  public Category findById(final Long id) {
    return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
  }

  @Transactional
  public void update(final Long categoryId, final String categoryName) {
    categoryRepository.findById(categoryId).ifPresent(a -> a.setName(categoryName));
  }

  public Page<Category> findAll(final Pageable pageable) {
    return categoryRepository.findAll(pageable);
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public void delete(final Long categoryId) {
    categoryRepository.deleteById(categoryId);
  }

  public List<Category> findAllById(final Set<Long> categoryIds) {
    return categoryRepository.findAllById(categoryIds);
  }
}
