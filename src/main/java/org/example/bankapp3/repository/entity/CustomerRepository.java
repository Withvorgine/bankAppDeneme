package org.example.bankapp3.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer getByCustomerIdAndDeletedFalse(Long CustomerId);

    List<Customer> getAllByDeletedFalse();
}
