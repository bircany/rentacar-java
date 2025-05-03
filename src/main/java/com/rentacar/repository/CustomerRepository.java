package com.rentacar.repository;

import com.rentacar.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByNationalId(String nationalId);
    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);
    
    @Query("SELECT c FROM Customer c WHERE LOWER(c.firstName) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(c.lastName) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Customer> findByFirstNameOrLastNameContaining(String keyword);
    
    @Query("SELECT c FROM Customer c WHERE c.phone = ?1")
    Customer findByPhone(String phone);
    
    @Query("SELECT c FROM Customer c WHERE c.email = ?1")
    Customer findByEmail(String email);
    
    @Query("SELECT DISTINCT c FROM Customer c JOIN Contract s ON c.id = s.customer.id WHERE s.status = 'ACTIVE'")
    List<Customer> findActiveCustomers();
} 