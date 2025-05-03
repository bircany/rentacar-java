package com.rentacar.repository;

import com.rentacar.model.ServiceCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long> {
    ServiceCenter findByName(String name);
    List<ServiceCenter> findByActive(Boolean active);
    
    @Query("SELECT sc FROM ServiceCenter sc WHERE sc.active = true ORDER BY sc.name")
    List<ServiceCenter> findAllActiveServiceCenters();
} 