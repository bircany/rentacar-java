package com.rentacar.repository;

import com.rentacar.model.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleTypeRepository extends JpaRepository<VehicleType, Long> {
    VehicleType findByName(String name);
    
    @Query("SELECT vt FROM VehicleType vt WHERE EXISTS (SELECT v FROM Vehicle v WHERE v.vehicleType = vt AND v.status = 'AVAILABLE')")
    List<VehicleType> findAllWithAvailableCars();
    
    @Query("SELECT vt FROM VehicleType vt ORDER BY vt.name ASC")
    List<VehicleType> findAllSorted();
    
    @Query("SELECT COUNT(v) FROM Vehicle v WHERE v.vehicleType.id = ?1")
    int countCarsByType(Long vehicleTypeId);
} 