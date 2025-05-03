package com.rentacar.service;

import com.rentacar.model.VehicleType;
import com.rentacar.repository.VehicleTypeRepository;
import com.rentacar.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Vehicle type service class
 */
@Service
public class VehicleTypeService {

    private final VehicleTypeRepository vehicleTypeRepository;

    @Autowired
    public VehicleTypeService(VehicleTypeRepository vehicleTypeRepository) {
        this.vehicleTypeRepository = vehicleTypeRepository;
    }

    /**
     * Lists all vehicle types
     * @return Vehicle type list
     */
    public List<VehicleType> findAll() {
        return vehicleTypeRepository.findAll();
    }

    /**
     * Finds vehicle type by ID
     * @param id Vehicle type ID
     * @return Vehicle type (Optional)
     */
    public Optional<VehicleType> findById(Long id) {
        return vehicleTypeRepository.findById(id);
    }

    /**
     * Finds vehicle type by name
     * @param name Vehicle type name
     * @return Vehicle type
     */
    public VehicleType findByName(String name) {
        return vehicleTypeRepository.findByName(name);
    }

    /**
     * Saves a new vehicle type
     * @param vehicleType Vehicle type to save
     * @return Saved vehicle type
     */
    @Transactional
    public VehicleType save(VehicleType vehicleType) {
        LogUtils.info("Adding new vehicle type: " + vehicleType.getName());
        return vehicleTypeRepository.save(vehicleType);
    }

    /**
     * Updates a vehicle type
     * @param vehicleType Vehicle type to update
     * @return Updated vehicle type
     */
    @Transactional
    public VehicleType update(VehicleType vehicleType) {
        LogUtils.info("Updating vehicle type: " + vehicleType.getName());
        return vehicleTypeRepository.save(vehicleType);
    }

    /**
     * Deletes a vehicle type
     * @param id Vehicle type ID to delete
     */
    @Transactional
    public void delete(Long id) {
        Optional<VehicleType> vehicleType = vehicleTypeRepository.findById(id);
        if (vehicleType.isPresent()) {
            LogUtils.info("Deleting vehicle type: " + vehicleType.get().getName());
            vehicleTypeRepository.deleteById(id);
        } else {
            LogUtils.warning("Vehicle type to delete not found. ID: " + id);
        }
    }
} 