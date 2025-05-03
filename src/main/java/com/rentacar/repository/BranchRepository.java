package com.rentacar.repository;

import com.rentacar.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<Branch, Long> {
    Branch findByName(String name);
    List<Branch> findByCity(String city);
    List<Branch> findByActive(boolean active);
    
    @Query("SELECT b FROM Branch b ORDER BY b.name ASC")
    List<Branch> findAllSorted();
} 