package com.wsh.repository;

import com.wsh.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *@author "Vladyslav Paun"
 */
public interface AddressRepository extends JpaRepository<Address,Long> {
}
