package com.rentacar.service;

import com.rentacar.model.Model;
import com.rentacar.model.Make;
import com.rentacar.repository.ModelRepository;
import com.rentacar.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    private final ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    /**
     * Lists all models
     * @return Model list
     */
    public List<Model> findAll() {
        return modelRepository.findAll();
    }

    /**
     * Lists all models sorted by name
     * @return Sorted model list
     */
    public List<Model> findAllSorted() {
        return modelRepository.findAllSorted();
    }

    /**
     * Finds model by ID
     * @param id Model ID
     * @return Model (Optional)
     */
    public Optional<Model> findById(Long id) {
        return modelRepository.findById(id);
    }

    /**
     * Lists models by make
     * @param make Make
     * @return Model list
     */
    public List<Model> findByMake(Make make) {
        return modelRepository.findByMake(make);
    }

    /**
     * Lists models by make ID sorted by name
     * @param makeId Make ID
     * @return Sorted model list
     */
    public List<Model> findByMakeIdSorted(Long makeId) {
        return modelRepository.findByMakeIdSorted(makeId);
    }

    /**
     * Finds model by name
     * @param name Model name
     * @return Model
     */
    public Model findByName(String name) {
        return modelRepository.findByName(name);
    }

    /**
     * Saves a new model
     * @param model Model to save
     * @return Saved model
     */
    @Transactional
    public Model save(Model model) {
        LogUtils.info("Adding new model: " + model.getName());
        return modelRepository.save(model);
    }

    /**
     * Updates a model
     * @param model Model to update
     * @return Updated model
     */
    @Transactional
    public Model update(Model model) {
        LogUtils.info("Updating model: " + model.getName());
        return modelRepository.save(model);
    }

    /**
     * Deletes a model
     * @param id Model ID to delete
     */
    @Transactional
    public void delete(Long id) {
        Optional<Model> model = modelRepository.findById(id);
        if (model.isPresent()) {
            LogUtils.info("Deleting model: " + model.get().getName());
            modelRepository.deleteById(id);
        } else {
            LogUtils.warning("Model to delete not found. ID: " + id);
        }
    }
} 