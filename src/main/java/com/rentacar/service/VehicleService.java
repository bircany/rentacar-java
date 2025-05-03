package com.rentacar.service;

import com.rentacar.model.Vehicle;
import com.rentacar.model.VehicleType;
import com.rentacar.model.Make;
import com.rentacar.model.Model;
import com.rentacar.model.Branch;
import com.rentacar.repository.VehicleRepository;
import com.rentacar.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Lists all vehicles
     * @return Vehicle list
     */
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    /**
     * Finds vehicle by ID
     * @param id Vehicle ID
     * @return Vehicle (Optional)
     */
    public Optional<Vehicle> findById(Long id) {
        return vehicleRepository.findById(id);
    }

    /**
     * Finds vehicle by plate
     * @param plate Vehicle plate
     * @return Vehicle
     */
    public Vehicle findByPlate(String plate) {
        return vehicleRepository.findByPlate(plate);
    }

    /**
     * Lists vehicles by status
     * @param status Vehicle status (AVAILABLE, RENTED, IN_SERVICE, SOLD)
     * @return Vehicle list
     */
    public List<Vehicle> findByStatus(String status) {
        return vehicleRepository.findByStatus(status);
    }

    /**
     * Lists vehicles by make and model
     * @param make Vehicle make
     * @param model Vehicle model
     * @return Vehicle list
     */
    public List<Vehicle> findByMakeAndModel(Make make, Model model) {
        return vehicleRepository.findByMakeAndModel(make, model);
    }

    /**
     * Lists vehicles by branch
     * @param branch Branch
     * @return Vehicle list
     */
    public List<Vehicle> findByBranch(Branch branch) {
        return vehicleRepository.findByBranch(branch);
    }

    /**
     * Lists vehicles by vehicle type
     * @param vehicleType Vehicle type
     * @return Vehicle list
     */
    public List<Vehicle> findByVehicleType(VehicleType vehicleType) {
        return vehicleRepository.findByVehicleType(vehicleType);
    }

    /**
     * Lists vehicles by price range
     * @param minPrice Minimum price
     * @param maxPrice Maximum price
     * @return Vehicle list
     */
    public List<Vehicle> findByPriceRange(double minPrice, double maxPrice) {
        return vehicleRepository.findByPriceRange(minPrice, maxPrice);
    }

    /**
     * Lists available vehicles by branch
     * @param branchId Branch ID
     * @return Vehicle list
     */
    public List<Vehicle> findAvailableVehiclesByBranchId(Long branchId) {
        return vehicleRepository.findAvailableVehiclesByBranchId(branchId);
    }

    /**
     * Lists available vehicles by vehicle type
     * @param vehicleTypeId Vehicle type ID
     * @return Vehicle list
     */
    public List<Vehicle> findAvailableVehiclesByVehicleTypeId(Long vehicleTypeId) {
        return vehicleRepository.findAvailableVehiclesByVehicleTypeId(vehicleTypeId);
    }

    /**
     * Saves new vehicle
     * @param vehicle Vehicle to save
     * @return Saved vehicle
     */
    @Transactional
    public Vehicle save(Vehicle vehicle) {
        LogUtils.info("Adding new vehicle: " + vehicle.getPlate());
        return vehicleRepository.save(vehicle);
    }

    /**
     * Updates vehicle
     * @param vehicle Vehicle to update
     * @return Updated vehicle
     */
    @Transactional
    public Vehicle update(Vehicle vehicle) {
        LogUtils.info("Updating vehicle: " + vehicle.getPlate() + " (" + vehicle.getMake().getName() + " " + 
                vehicle.getModel().getName() + " " + vehicle.getManufactureYear() + ")");
        return vehicleRepository.save(vehicle);
    }

    /**
     * Deletes vehicle
     * @param id Vehicle ID to delete
     */
    @Transactional
    public void delete(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            LogUtils.info("Deleting vehicle: " + vehicle.get().getPlate());
            vehicleRepository.deleteById(id);
        } else {
            LogUtils.warning("Vehicle to delete not found. ID: " + id);
        }
    }

    /**
     * Updates vehicle status
     * @param id Vehicle ID
     * @param status New status
     * @return Updated vehicle
     */
    @Transactional
    public Vehicle updateStatus(Long id, String status) {
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(id);
        if (vehicleOpt.isPresent()) {
            Vehicle vehicle = vehicleOpt.get();
            LogUtils.info("Updating vehicle status: " + vehicle.getPlate() + " -> " + status);
            vehicle.setStatus(status);
            return vehicleRepository.save(vehicle);
        } else {
            LogUtils.warning("Vehicle to update status not found. ID: " + id);
            return null;
        }
    }

    /**
     * Updates vehicle mileage
     * @param id Vehicle ID
     * @param mileage New mileage
     * @return Updated vehicle
     */
    @Transactional
    public Vehicle updateMileage(Long id, Integer mileage) {
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(id);
        if (vehicleOpt.isPresent()) {
            Vehicle vehicle = vehicleOpt.get();
            LogUtils.info("Updating vehicle mileage: " + vehicle.getPlate() + " -> " + mileage);
            vehicle.setMileage(mileage);
            return vehicleRepository.save(vehicle);
        } else {
            LogUtils.warning("Vehicle to update mileage not found. ID: " + id);
            return null;
        }
    }

    /**
     * Updates vehicle daily rate
     * @param id Vehicle ID
     * @param dailyRate New daily rate
     * @return Updated vehicle
     */
    @Transactional
    public Vehicle updateDailyRate(Long id, Double dailyRate) {
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(id);
        if (vehicleOpt.isPresent()) {
            Vehicle vehicle = vehicleOpt.get();
            LogUtils.info("Updating vehicle daily rate: " + vehicle.getPlate() + " -> " + dailyRate);
            vehicle.setDailyRate(dailyRate);
            return vehicleRepository.save(vehicle);
        } else {
            LogUtils.warning("Vehicle to update daily rate not found. ID: " + id);
            return null;
        }
    }

    /**
     * Marks vehicle as sold
     * @param id Vehicle ID
     * @param saleDate Sale date
     * @return Updated vehicle
     */
    @Transactional
    public Vehicle markAsSold(Long id, Date saleDate) {
        Optional<Vehicle> vehicleOpt = vehicleRepository.findById(id);
        if (vehicleOpt.isPresent()) {
            Vehicle vehicle = vehicleOpt.get();
            LogUtils.info("Marking vehicle as sold: " + vehicle.getPlate());
            vehicle.setStatus(com.rentacar.util.Constants.VEHICLE_STATUS_SOLD);
            vehicle.setSaleDate(saleDate);
            return vehicleRepository.save(vehicle);
        } else {
            LogUtils.warning("Vehicle to mark as sold not found. ID: " + id);
            return null;
        }
    }
} 