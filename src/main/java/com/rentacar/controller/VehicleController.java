package com.rentacar.controller;

import com.rentacar.model.Vehicle;
import com.rentacar.model.VehicleType;
import com.rentacar.model.Make;
import com.rentacar.model.Model;
import com.rentacar.service.VehicleService;
import com.rentacar.service.VehicleTypeService;
import com.rentacar.service.MakeService;
import com.rentacar.service.ModelService;
import com.rentacar.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Vehicle controller class
 * This controller provides REST API endpoints for vehicle operations.
 */
@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    // Services to be injected by Spring
    private final VehicleService vehicleService;
    private final MakeService makeService;
    private final ModelService modelService;
    private final VehicleTypeService vehicleTypeService;

    /**
     * Constructor
     */
    @Autowired
    public VehicleController(VehicleService vehicleService, MakeService makeService, 
                          ModelService modelService, VehicleTypeService vehicleTypeService) {
        this.vehicleService = vehicleService;
        this.makeService = makeService;
        this.modelService = modelService;
        this.vehicleTypeService = vehicleTypeService;
    }

    /**
     * Lists all vehicles
     * @return Vehicle list
     */
    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.findAll();
        LogUtils.info("All vehicles listed. Total: " + vehicles.size());
        return ResponseEntity.ok(vehicles);
    }

    /**
     * Gets vehicle by ID
     * @param id Vehicle ID
     * @return Vehicle
     */
    @GetMapping("/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleService.findById(id);
        if (vehicle.isPresent()) {
            LogUtils.info("Vehicle viewed: " + vehicle.get().getPlate());
            return ResponseEntity.ok(vehicle.get());
        } else {
            LogUtils.warning("Vehicle not found. ID: " + id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Gets vehicle by plate
     * @param plate Vehicle plate
     * @return Vehicle
     */
    @GetMapping("/plate/{plate}")
    public ResponseEntity<Vehicle> getVehicleByPlate(@PathVariable String plate) {
        Vehicle vehicle = vehicleService.findByPlate(plate);
        if (vehicle != null) {
            LogUtils.info("Vehicle viewed by plate: " + plate);
            return ResponseEntity.ok(vehicle);
        } else {
            LogUtils.warning("Vehicle not found by plate: " + plate);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Lists vehicles by status
     * @param status Vehicle status
     * @return Vehicle list
     */
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Vehicle>> getVehiclesByStatus(@PathVariable String status) {
        List<Vehicle> vehicles = vehicleService.findByStatus(status);
        LogUtils.info("Vehicles with status " + status + " listed. Total: " + vehicles.size());
        return ResponseEntity.ok(vehicles);
    }

    /**
     * Lists vehicles by make and model
     * @param makeId Make ID
     * @param modelId Model ID
     * @return Vehicle list
     */
    @GetMapping("/make/{makeId}/model/{modelId}")
    public ResponseEntity<List<Vehicle>> getVehiclesByMakeAndModel(
            @PathVariable Long makeId, 
            @PathVariable Long modelId) {
        
        Optional<Make> make = makeService.findById(makeId);
        Optional<Model> model = modelService.findById(modelId);
        
        if (make.isPresent() && model.isPresent()) {
            List<Vehicle> vehicles = vehicleService.findByMakeAndModel(make.get(), model.get());
            LogUtils.info(make.get().getName() + " " + model.get().getName() + 
                    " vehicles listed. Total: " + vehicles.size());
            return ResponseEntity.ok(vehicles);
        } else {
            LogUtils.warning("Make or model not found. MakeID: " + makeId + ", ModelID: " + modelId);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Lists vehicles by price range
     * @param minPrice Minimum price
     * @param maxPrice Maximum price
     * @return Vehicle list
     */
    @GetMapping("/price")
    public ResponseEntity<List<Vehicle>> getVehiclesByPriceRange(
            @RequestParam Double minPrice, 
            @RequestParam Double maxPrice) {
        
        List<Vehicle> vehicles = vehicleService.findByPriceRange(minPrice, maxPrice);
        LogUtils.info("Vehicles listed by price range (" + minPrice + " - " + maxPrice + 
                "). Total: " + vehicles.size());
        return ResponseEntity.ok(vehicles);
    }

    /**
     * Adds a new vehicle
     * @param vehicle Vehicle
     * @return Added vehicle
     */
    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody Vehicle vehicle) {
        // Plate check
        Vehicle existingVehicle = vehicleService.findByPlate(vehicle.getPlate());
        if (existingVehicle != null) {
            LogUtils.warning("A vehicle with this plate already exists: " + vehicle.getPlate());
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        
        Vehicle savedVehicle = vehicleService.save(vehicle);
        LogUtils.info("New vehicle added: " + savedVehicle.getPlate());
        return ResponseEntity.status(HttpStatus.CREATED).body(savedVehicle);
    }

    /**
     * Updates a vehicle
     * @param id Vehicle ID
     * @param vehicle Vehicle information to update
     * @return Updated vehicle
     */
    @PutMapping("/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable Long id, @RequestBody Vehicle vehicle) {
        Optional<Vehicle> existingVehicle = vehicleService.findById(id);
        if (existingVehicle.isEmpty()) {
            LogUtils.warning("Vehicle to update not found. ID: " + id);
            return ResponseEntity.notFound().build();
        }
        
        // Set ID
        vehicle.setId(id);
        
        // Plate check (if plate has changed)
        if (!existingVehicle.get().getPlate().equals(vehicle.getPlate())) {
            Vehicle plateCheck = vehicleService.findByPlate(vehicle.getPlate());
            if (plateCheck != null) {
                LogUtils.warning("Another vehicle with this plate already exists: " + vehicle.getPlate());
                return ResponseEntity.status(HttpStatus.CONFLICT).build();
            }
        }
        
        Vehicle updatedVehicle = vehicleService.update(vehicle);
        LogUtils.info("Vehicle updated: " + updatedVehicle.getPlate());
        return ResponseEntity.ok(updatedVehicle);
    }

    /**
     * Deletes a vehicle
     * @param id Vehicle ID
     * @return Status
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long id) {
        Optional<Vehicle> vehicle = vehicleService.findById(id);
        if (vehicle.isEmpty()) {
            LogUtils.warning("Vehicle to delete not found. ID: " + id);
            return ResponseEntity.notFound().build();
        }
        
        vehicleService.delete(id);
        LogUtils.info("Vehicle deleted: " + vehicle.get().getPlate());
        return ResponseEntity.noContent().build();
    }

    /**
     * Updates vehicle status
     * @param id Vehicle ID
     * @param status New status
     * @return Updated vehicle
     */
    @PatchMapping("/{id}/status")
    public ResponseEntity<Vehicle> updateVehicleStatus(
            @PathVariable Long id, 
            @RequestParam String status) {
        
        Vehicle updatedVehicle = vehicleService.updateStatus(id, status);
        if (updatedVehicle != null) {
            LogUtils.info("Vehicle status updated: " + updatedVehicle.getPlate() + " -> " + status);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            LogUtils.warning("Vehicle to update status not found. ID: " + id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Updates vehicle mileage
     * @param id Vehicle ID
     * @param mileage New mileage
     * @return Updated vehicle
     */
    @PatchMapping("/{id}/mileage")
    public ResponseEntity<Vehicle> updateVehicleMileage(
            @PathVariable Long id, 
            @RequestParam Integer mileage) {
        
        Vehicle updatedVehicle = vehicleService.updateMileage(id, mileage);
        if (updatedVehicle != null) {
            LogUtils.info("Vehicle mileage updated: " + updatedVehicle.getPlate() + " -> " + mileage);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            LogUtils.warning("Vehicle to update mileage not found. ID: " + id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Updates vehicle price
     * @param id Vehicle ID
     * @param dailyRate New daily rate
     * @return Updated vehicle
     */
    @PatchMapping("/{id}/price")
    public ResponseEntity<Vehicle> updateVehiclePrice(
            @PathVariable Long id, 
            @RequestParam Double dailyRate) {
        
        Vehicle updatedVehicle = vehicleService.updateDailyRate(id, dailyRate);
        if (updatedVehicle != null) {
            LogUtils.info("Vehicle price updated: " + updatedVehicle.getPlate() + " -> " + dailyRate);
            return ResponseEntity.ok(updatedVehicle);
        } else {
            LogUtils.warning("Vehicle to update price not found. ID: " + id);
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Lists available vehicles by branch
     * @param branchId Branch ID
     * @return Vehicle list
     */
    @GetMapping("/available/branch/{branchId}")
    public ResponseEntity<List<Vehicle>> getAvailableVehiclesByBranchId(@PathVariable Long branchId) {
        List<Vehicle> vehicles = vehicleService.findAvailableVehiclesByBranchId(branchId);
        LogUtils.info("Available vehicles by branch listed. BranchID: " + branchId + 
                ", Total: " + vehicles.size());
        return ResponseEntity.ok(vehicles);
    }

    /**
     * Lists available vehicles by vehicle type
     * @param vehicleTypeId Vehicle type ID
     * @return Vehicle list
     */
    @GetMapping("/available/type/{vehicleTypeId}")
    public ResponseEntity<List<Vehicle>> getAvailableVehiclesByVehicleTypeId(@PathVariable Long vehicleTypeId) {
        List<Vehicle> vehicles = vehicleService.findAvailableVehiclesByVehicleTypeId(vehicleTypeId);
        
        Optional<VehicleType> vehicleType = vehicleTypeService.findById(vehicleTypeId);
        String typeName = vehicleType.isPresent() ? vehicleType.get().getName() : "Unknown Type";
        
        LogUtils.info("Available vehicles by vehicle type listed. Type: " + typeName + 
                ", Total: " + vehicles.size());
        return ResponseEntity.ok(vehicles);
    }

    /**
     * Marks a vehicle as sold
     * @param id Vehicle ID
     * @return Updated vehicle
     */
    @PatchMapping("/{id}/sale")
    public ResponseEntity<Vehicle> markVehicleAsSold(@PathVariable Long id) {
        Vehicle updatedVehicle = vehicleService.markAsSold(id, new Date());
        if (updatedVehicle != null) {
            LogUtils.info("Vehicle marked as sold: " + updatedVehicle.getPlate());
            return ResponseEntity.ok(updatedVehicle);
        } else {
            LogUtils.warning("Vehicle to mark as sold not found. ID: " + id);
            return ResponseEntity.notFound().build();
        }
    }
} 