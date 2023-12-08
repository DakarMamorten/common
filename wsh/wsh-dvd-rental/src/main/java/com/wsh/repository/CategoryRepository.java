package com.wsh.repository;

import com.wsh.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *@author "Vladyslav Paun"
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
