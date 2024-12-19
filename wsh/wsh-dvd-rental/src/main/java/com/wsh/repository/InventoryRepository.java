package com.wsh.repository;

import com.wsh.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author "Vladyslav Paun"
 */
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
}
