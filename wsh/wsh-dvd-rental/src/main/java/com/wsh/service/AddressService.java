package com.wsh.service;

import com.wsh.domain.Address;
import com.wsh.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final CityService cityService;


    public void add(final String address, final String address2, final String district, final Long cityId,
                    final String postalCode, final String phone) {
        Address addressObj = new Address(address, address2, district, postalCode, phone);
        addressObj.setCity(cityService.findById(cityId));
        addressRepository.save(addressObj);
    }

    @Transactional
    public void update(final Long addressId, final String address, final String address2, final String district, final Long cityId,
                       final String postalCode, final String phone) {
        addressRepository.findById(addressId).ifPresent(a -> {
            a.setAddress(address);
            a.setAddress2(address2);
            a.setDistrict(district);
            a.setCity(cityService.findById(cityId));
            a.setPostalCode(postalCode);
            a.setPhone(phone);
        });
    }

    public void delete(final Long addressId) {
        addressRepository.deleteById(addressId);
    }

    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    public Page<Address> findAll(final Pageable pageable) {
        return addressRepository.findAll(pageable);
    }

    public void findById(final Long addressId) {
        addressRepository.findById(addressId).orElseThrow(EntityNotFoundException::new);
    }
}
