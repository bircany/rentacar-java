package com.rentacar.repository;

import com.rentacar.model.Vehicle;
import com.rentacar.model.Customer;
import com.rentacar.model.Employee;
import com.rentacar.model.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
    Contract findByContractNumber(String contractNumber);
    List<Contract> findByCustomer(Customer customer);
    List<Contract> findByVehicle(Vehicle vehicle);
    List<Contract> findByEmployee(Employee employee);
    List<Contract> findByStatus(String status);
    
    @Query("SELECT c FROM Contract c WHERE c.startDate BETWEEN ?1 AND ?2")
    List<Contract> findByStartDateBetween(Date startDate, Date endDate);
    
    @Query("SELECT c FROM Contract c WHERE c.endDate BETWEEN ?1 AND ?2")
    List<Contract> findByEndDateBetween(Date startDate, Date endDate);
    
    @Query("SELECT c FROM Contract c WHERE c.status = 'ACTIVE' AND c.endDate < ?1")
    List<Contract> findOverdueContracts(Date currentDate);
    
    @Query("SELECT c FROM Contract c WHERE c.vehicle.branch.id = ?1 AND c.status = ?2")
    List<Contract> findByBranchIdAndStatus(Long branchId, String status);
    
    @Query("SELECT SUM(c.totalAmount) FROM Contract c WHERE c.status = 'COMPLETED' AND c.returnDate BETWEEN ?1 AND ?2")
    Double calculateTotalIncome(Date startDate, Date endDate);

    @Query("SELECT c FROM Contract c LEFT JOIN FETCH c.customer LEFT JOIN FETCH c.vehicle v LEFT JOIN FETCH v.make LEFT JOIN FETCH v.model")
    List<Contract> findAllWithCustomerAndVehicle();
} 