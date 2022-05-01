package com.wsh.service;

import com.wsh.core.CategoryComparator;
import com.wsh.core.Column;
import com.wsh.core.Order;
import com.wsh.core.Page;
import com.wsh.core.PagingRequest;
import com.wsh.domain.Category;
import com.wsh.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {
    private final CategoryRepository categoryRepository;

    private static final Comparator<Category> EMPTY_COMPARATOR = (e1, e2) -> 0;

    public Page<Category> getCategories(PagingRequest pagingRequest) {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            return new Page<>();
        }
        return getPage(categories, pagingRequest);


    }

    private Page<Category> getPage(List<Category> categories, PagingRequest pagingRequest) {
        List<Category> filtered = categories.stream()
                                       .sorted(sortCategories(pagingRequest))
                                       .filter(filterCategories(pagingRequest))
                                       .skip(pagingRequest.getStart())
                                       .limit(pagingRequest.getLength())
                                       .collect(Collectors.toList());

        long count = categories.stream()
                            .filter(filterCategories(pagingRequest))
                            .count();

        Page<Category> page = new Page<>(filtered);
        page.setRecordsFiltered((int) count);
        page.setRecordsTotal((int) count);
        page.setDraw(pagingRequest.getDraw());

        return page;
    }

    private Predicate<Category> filterCategories(PagingRequest pagingRequest) {
        if (pagingRequest.getSearch() == null || StringUtils.isEmpty(pagingRequest.getSearch()
                                                                                  .getValue())) {
            return category -> true;
        }

        String value = pagingRequest.getSearch()
                                    .getValue();

        return category -> category.getName()
                               .toLowerCase()
                               .contains(value);
    }

    private Comparator<Category> sortCategories(PagingRequest pagingRequest) {
        if (pagingRequest.getOrder() == null) {
            return EMPTY_COMPARATOR;
        }

        try {
            Order order = pagingRequest.getOrder()
                                       .get(0);

            int columnIndex = order.getColumn();
            Column column = pagingRequest.getColumns()
                                         .get(columnIndex);

            Comparator<Category> comparator = CategoryComparator.getComparator(column.getData(), order.getDir());
            return Objects.requireNonNullElse(comparator,
                                              EMPTY_COMPARATOR);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return EMPTY_COMPARATOR;
    }

    public void add(String name) {
        Category category = new Category(name);
        categoryRepository.save(category);
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    public void update(Long categoryId, String categoryName) {
        categoryRepository.findById(categoryId).ifPresent(a -> a.setCategoryId(categoryId));
    }

    }
