package com.rentacar.service;

import com.rentacar.model.Branch;
import com.rentacar.repository.BranchRepository;
import com.rentacar.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Branch service class
 */
@Service
public class BranchService {

    private final BranchRepository branchRepository;

    @Autowired
    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    /**
     * Lists all branches
     * @return Branch list
     */
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    /**
     * Lists all branches sorted by name
     * @return Sorted branch list
     */
    public List<Branch> findAllSorted() {
        return branchRepository.findAllSorted();
    }

    /**
     * Lists all active branches
     * @return Active branch list
     */
    public List<Branch> findAllActive() {
        return branchRepository.findByActive(true);
    }

    /**
     * Finds branch by ID
     * @param id Branch ID
     * @return Branch (Optional)
     */
    public Optional<Branch> findById(Long id) {
        return branchRepository.findById(id);
    }

    /**
     * Finds branch by name
     * @param name Branch name
     * @return Branch
     */
    public Branch findByName(String name) {
        return branchRepository.findByName(name);
    }

    /**
     * Lists branches by city
     * @param city City name
     * @return Branch list
     */
    public List<Branch> findByCity(String city) {
        return branchRepository.findByCity(city);
    }

    /**
     * Lists branches by name or city containing the keyword
     * @param keyword Search keyword
     * @return Branch list
     */
    public List<Branch> findByNameOrCityContaining(String keyword) {
        return branchRepository.findAll().stream()
                .filter(branch -> 
                    branch.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                    branch.getCity().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * Saves a new branch
     * @param branch Branch to save
     * @return Saved branch
     */
    @Transactional
    public Branch save(Branch branch) {
        LogUtils.info("Adding new branch: " + branch.getName());
        return branchRepository.save(branch);
    }

    /**
     * Updates a branch
     * @param branch Branch to update
     * @return Updated branch
     */
    @Transactional
    public Branch update(Branch branch) {
        LogUtils.info("Updating branch: " + branch.getName());
        return branchRepository.save(branch);
    }

    /**
     * Sets branch active status
     * @param id Branch ID
     * @param active Active status
     * @return Updated branch
     */
    @Transactional
    public Branch setActive(Long id, boolean active) {
        Optional<Branch> branchOpt = branchRepository.findById(id);
        if (branchOpt.isPresent()) {
            Branch branch = branchOpt.get();
            branch.setActive(active);
            LogUtils.info("Setting branch active status: " + branch.getName() + " -> " + active);
            return branchRepository.save(branch);
        }
        return null;
    }

    /**
     * Deletes a branch
     * @param id Branch ID to delete
     */
    @Transactional
    public void delete(Long id) {
        Optional<Branch> branch = branchRepository.findById(id);
        if (branch.isPresent()) {
            LogUtils.info("Deleting branch: " + branch.get().getName());
            branchRepository.deleteById(id);
        } else {
            LogUtils.warning("Branch to delete not found. ID: " + id);
        }
    }
} 