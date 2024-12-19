package com.wsh.service;

import com.wsh.domain.Staff;
import com.wsh.repository.StaffRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
public class StaffService {

    private final StaffRepository staffRepository;
    private final AddressService addressService;

    public void addStaff(String firstName, String lastName, Long addressId,
                         String email, Long storeId, Boolean active, String username, String password) {
        Staff staff = new Staff();
        setStaff(firstName, lastName, addressId, email, storeId, active, username, password, staff);
        staffRepository.save(staff);
    }

    public Page<Staff> getStaffPage(int page) {
        int pageSize = 100;
        Pageable pageable = PageRequest.of(page, pageSize);
        return staffRepository.findAll(pageable);
    }

    private void setStaff(String firstName, String lastName, Long addressId, String email, Long storeId, Boolean active, String username, String password, Staff staff) {
        staff.setFirstName(firstName);
        staff.setLastName(lastName);
        staff.setAddressId(addressService.findById(addressId).getAddressId());
        staff.setEmail(email);
        staff.setStoreId(storeId);
        staff.setActive(active);
        staff.setUsername(username);
        staff.setPassword(password);
        staff.setLastUpdate(LocalDateTime.now());
    }

    @Transactional
    public void updateStaff(Long staffId, String firstName, String lastName, Long addressId, byte[] picture,
                            String email, Long storeId, Boolean active, String username, String password) {
        staffRepository.findById(staffId).ifPresent(staff -> {
            setStaff(firstName, lastName, addressId, email, storeId, active, username, password, staff);
        });
    }

    public List<Staff> findAllStaff() {
        return staffRepository.findAll();
    }

    public Page<Staff> findAllStaff(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }

    public Optional<Staff> findById(Long staffId) {
        return staffRepository.findById(staffId);
    }

    public void deleteStaff(Long id) {
        staffRepository.deleteById(id);
    }
}

