package com.rentacar.repository;

import com.rentacar.model.Vehicle;
import com.rentacar.model.ServiceCenter;
import com.rentacar.model.VehicleServiceRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface VehicleServiceRecordRepository extends JpaRepository<VehicleServiceRecord, Long> {
    List<VehicleServiceRecord> findByVehicle(Vehicle vehicle);
    List<VehicleServiceRecord> findByServiceCenter(ServiceCenter serviceCenter);
    List<VehicleServiceRecord> findByStatus(String status);
    
    @Query("SELECT vsr FROM VehicleServiceRecord vsr WHERE vsr.entryDate BETWEEN ?1 AND ?2")
    List<VehicleServiceRecord> findByEntryDateBetween(Date startDate, Date endDate);
    
    @Query("SELECT vsr FROM VehicleServiceRecord vsr WHERE vsr.exitDate IS NULL")
    List<VehicleServiceRecord> findActiveServices();
} 