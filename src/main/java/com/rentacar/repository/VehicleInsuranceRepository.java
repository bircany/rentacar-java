package com.rentacar.repository;

import com.rentacar.model.Vehicle;
import com.rentacar.model.Insurance;
import com.rentacar.model.VehicleInsurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VehicleInsuranceRepository extends JpaRepository<VehicleInsurance, Long> {
    List<VehicleInsurance> findByVehicle(Vehicle vehicle);
    List<VehicleInsurance> findByInsurance(Insurance insurance);
    VehicleInsurance findByPolicyNumber(String policyNumber);
    
    @Query("SELECT vi FROM VehicleInsurance vi WHERE vi.active = true AND vi.endDate > CURRENT_DATE")
    List<VehicleInsurance> findAllActiveInsurances();
    
    @Query("SELECT vi FROM VehicleInsurance vi WHERE vi.endDate < ?1")
    List<VehicleInsurance> findExpiredInsurances(Date date);
} 