package com.rentacar.repository;

import com.rentacar.model.Vehicle;
import com.rentacar.model.Make;
import com.rentacar.model.Model;
import com.rentacar.model.VehicleType;
import com.rentacar.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findByStatus(String status);
    List<Vehicle> findByMakeAndModel(Make make, Model model);
    Vehicle findByPlate(String plate);
    List<Vehicle> findByBranch(Branch branch);
    List<Vehicle> findByVehicleType(VehicleType vehicleType);
    
    @Query("SELECT v FROM Vehicle v WHERE v.status = 'AVAILABLE' AND v.branch.id = ?1")
    List<Vehicle> findAvailableVehiclesByBranchId(Long branchId);
    
    @Query("SELECT v FROM Vehicle v WHERE v.dailyRate BETWEEN ?1 AND ?2")
    List<Vehicle> findByPriceRange(double minPrice, double maxPrice);
    
    @Query("SELECT v FROM Vehicle v WHERE v.status = 'AVAILABLE' AND v.vehicleType.id = ?1")
    List<Vehicle> findAvailableVehiclesByVehicleTypeId(Long vehicleTypeId);
} 