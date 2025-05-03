package com.rentacar.repository;

import com.rentacar.model.Payment;
import com.rentacar.model.Employee;
import com.rentacar.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByContract(Contract contract);
    List<Payment> findByPaymentType(String paymentType);
    List<Payment> findByEmployee(Employee employee);
    
    @Query("SELECT p FROM Payment p WHERE p.paymentDate BETWEEN ?1 AND ?2")
    List<Payment> findByPaymentDateBetween(Date startDate, Date endDate);
    
    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.contract.id = ?1")
    Double calculateTotalPaymentForContract(Long contractId);
    
    @Query("SELECT SUM(p.amount) FROM Payment p WHERE p.paymentDate BETWEEN ?1 AND ?2")
    Double calculateTotalPaymentBetweenDates(Date startDate, Date endDate);
    
    @Query("SELECT p FROM Payment p WHERE p.contract.vehicle.branch.id = ?1")
    List<Payment> findByBranchId(Long branchId);
    
    @Query("SELECT p FROM Payment p WHERE p.contract.customer.id = ?1")
    List<Payment> findByCustomerId(Long customerId);
} 