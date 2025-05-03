package com.rentacar.repository;

import com.rentacar.model.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MakeRepository extends JpaRepository<Make, Long> {
    Make findByName(String name);
    
    @Query("SELECT m FROM Make m ORDER BY m.name ASC")
    List<Make> findAllSorted();
} 