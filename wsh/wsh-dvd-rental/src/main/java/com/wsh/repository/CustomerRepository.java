package com.wsh.repository;

import com.wsh.domain.Customer;
import com.wsh.domain.dto.CustomerDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    String QUERY = """
    SELECT new com.wsh.domain.dto.CustomerDTO(
        c.customerId,
        c.firstName,
        c.lastName,
        c.email,
        c.active,
        a.address,
        a.address2,
        a.district,
        a.postalCode,
        ct.cityTitle,
        c.lastUpdate
    ) FROM com.wsh.do main.Customer c
    JOIN c.address a
    JOIN a.city ct
""";
    @Query(QUERY)
    Page<CustomerDTO> findCustomersWithAddress(Pageable pageable);

//    String QUERYPAYMENT = """
//    SELECT new com.wsh.domain.dto.PaymentDTO(
//        p.paymentId,
//        p.amount,
//        p.paymentDate,
//        p.lastUpdate,
//        c.customerId
//    ) FROM com.wsh.domain.Payment p
//    JOIN p.customer c
//    GROUP BY
//        p.paymentId,
//        p.amount,
//        p.paymentDate,
//        p.lastUpdate,
//        c.customerId
//""";
//    @Query(QUERYPAYMENT)
//    Page<PaymentDTO> findPaymentsByCustomer(Pageable pageable);

}
