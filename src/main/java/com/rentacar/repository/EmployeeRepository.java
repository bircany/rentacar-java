package com.rentacar.repository;

import com.rentacar.model.Employee;
import com.rentacar.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByNationalId(String nationalId);
    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);
    List<Employee> findByBranch(Branch branch);
    List<Employee> findByPosition(String position);
    List<Employee> findByActive(boolean active);
    
    @Query("SELECT e FROM Employee e WHERE e.branch.id = ?1 AND e.active = true")
    List<Employee> findActiveEmployeesByBranch(Long branchId);
    
    @Query("SELECT e FROM Employee e WHERE e.phone = ?1")
    Employee findByPhone(String phone);
    
    @Query("SELECT e FROM Employee e WHERE e.email = ?1")
    Employee findByEmail(String email);
    
    @Query("SELECT e FROM Employee e WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', ?1, '%')) OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', ?1, '%'))")
    List<Employee> findByNameOrSurnameContaining(String keyword);

    List<Employee> findByBranchIdAndActiveTrue(Long branchId);

    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.branch")
    List<Employee> findAllWithBranch();
} 