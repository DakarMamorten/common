package com.wsh.service;

import com.wsh.domain.Inventory;
import com.wsh.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author "Vladyslav Paun"
 */
@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;
    private final FilmService filmService;
    private final StoreService storeService;

    public void addInventory(Long filmId, Long storeId) {
        Inventory inventory = new Inventory();
        inventory.setFilm(filmService.findById(filmId));
        inventory.setStore(storeService.findById(storeId).orElseThrow());
        inventory.setLastUpdate(LocalDateTime.now());
        inventoryRepository.save(inventory);
    }

    @Transactional
    public void updateInventory(Long inventoryId, Long filmId, Long storeId) {
        inventoryRepository.findById(inventoryId).ifPresent(inventory -> {
            inventory.setFilm(filmService.findById(filmId));
            inventory.setStore(storeService.findById(storeId).orElseThrow());
            inventory.setLastUpdate(LocalDateTime.now());
        });
    }

    public List<Inventory> findAllInventories() {
        return inventoryRepository.findAll();
    }

    public Page<Inventory> findAllInventories(Pageable pageable) {
        return inventoryRepository.findAll(pageable);
    }

    public void deleteInventory(Long id) {
        inventoryRepository.deleteById(id);
    }

}
