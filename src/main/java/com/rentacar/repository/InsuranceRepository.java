package com.rentacar.repository;

import com.rentacar.model.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
    Insurance findByName(String name);
    List<Insurance> findByInsuranceType(String insuranceType);
    List<Insurance> findByCompanyName(String companyName);
    List<Insurance> findByActive(Boolean active);
    
    @Query("SELECT i FROM Insurance i WHERE i.active = true ORDER BY i.name")
    List<Insurance> findAllActiveInsurances();
} 