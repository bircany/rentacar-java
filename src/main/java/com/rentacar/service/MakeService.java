package com.rentacar.service;

import com.rentacar.model.Make;
import com.rentacar.repository.MakeRepository;
import com.rentacar.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MakeService {

    private final MakeRepository makeRepository;

    @Autowired
    public MakeService(MakeRepository makeRepository) {
        this.makeRepository = makeRepository;
    }

    /**
     * Lists all makes
     * @return Make list
     */
    public List<Make> findAll() {
        return makeRepository.findAll();
    }

    /**
     * Lists all makes sorted by name
     * @return Sorted make list
     */
    public List<Make> findAllSorted() {
        return makeRepository.findAllSorted();
    }

    /**
     * Finds make by ID
     * @param id Make ID
     * @return Make (Optional)
     */
    public Optional<Make> findById(Long id) {
        return makeRepository.findById(id);
    }

    /**
     * Finds make by name
     * @param name Make name
     * @return Make
     */
    public Make findByName(String name) {
        return makeRepository.findByName(name);
    }

    /**
     * Saves a new make
     * @param make Make to save
     * @return Saved make
     */
    @Transactional
    public Make save(Make make) {
        LogUtils.info("Adding new make: " + make.getName());
        return makeRepository.save(make);
    }

    /**
     * Updates a make
     * @param make Make to update
     * @return Updated make
     */
    @Transactional
    public Make update(Make make) {
        LogUtils.info("Updating make: " + make.getName());
        return makeRepository.save(make);
    }

    /**
     * Deletes a make
     * @param id Make ID to delete
     */
    @Transactional
    public void delete(Long id) {
        Optional<Make> make = makeRepository.findById(id);
        if (make.isPresent()) {
            LogUtils.info("Deleting make: " + make.get().getName());
            makeRepository.deleteById(id);
        } else {
            LogUtils.warning("Make to delete not found. ID: " + id);
        }
    }
} 