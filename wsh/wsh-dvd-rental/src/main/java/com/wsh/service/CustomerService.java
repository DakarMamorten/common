package com.wsh.service;

import com.wsh.domain.Customer;
import com.wsh.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    public void add(final String firstName, final String lastName, final String email,
                    final Long addressId) {
        Customer customer = new Customer(firstName, lastName, email);
        customer.setAddress(addressService.findById(addressId));
        customerRepository.save(customer);
    }

    @Transactional
    public void update(final Long customerId,final String firstName, final String lastName, final String email) {
        customerRepository.findById(customerId).ifPresent(c -> {
            c.setFirstName(firstName);
            c.setLastName(lastName);
            c.setEmail(email);
        });

    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }

    public Page<Customer> findAll(final Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    public void delete(final Long id){
        customerRepository.deleteById(id);
    }
}
