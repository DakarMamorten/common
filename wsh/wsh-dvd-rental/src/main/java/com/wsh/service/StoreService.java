package com.wsh.service;

import com.wsh.domain.Store;
import com.wsh.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author "Vladyslav Paun"
 */
@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    private StaffService staffService;
    private final AddressService addressService;

    public void addStore(Long managerStaffId, Long addressId) {
        Store store = new Store();
        store.setManagerStaffId(staffService.findById(managerStaffId).orElseThrow().getStaffId());
        store.setAddressId(addressService.findById(addressId).getAddressId());
        store.setLastUpdate(LocalDateTime.now());
        storeRepository.save(store);
    }
    @Transactional
    public void updateStore(Long storeId, Long managerStaffId, Long addressId) {
        storeRepository.findById(storeId).ifPresent(store -> {
            store.setManagerStaffId(staffService.findById(managerStaffId).orElseThrow().getStaffId());
            store.setAddressId(addressService.findById(addressId).getAddressId());
            store.setLastUpdate(LocalDateTime.now());
        });
    }
    public List<Store> findAllStores() {
        return storeRepository.findAll();
    }

    public Page<Store> findAllStores(Pageable pageable) {
        return storeRepository.findAll(pageable);
    }

    public Optional<Store> findById(Long storeId) {
        return storeRepository.findById(storeId);
    }

    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

    public void setStaffService(StaffService staffService) {
        this.staffService = staffService;
    }
}
