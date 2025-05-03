package com.rentacar.repository;

import com.rentacar.model.Model;
import com.rentacar.model.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModelRepository extends JpaRepository<Model, Long> {
    List<Model> findByMake(Make make);
    Model findByName(String name);
    
    @Query("SELECT m FROM Model m ORDER BY m.name ASC")
    List<Model> findAllSorted();
    
    @Query("SELECT m FROM Model m WHERE m.make.id = ?1 ORDER BY m.name ASC")
    List<Model> findByMakeIdSorted(Long makeId);
} 