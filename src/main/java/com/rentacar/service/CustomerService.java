package com.rentacar.service;

import com.rentacar.model.Customer;
import com.rentacar.repository.CustomerRepository;
import com.rentacar.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * Lists all customers
     * @return List of customers
     */
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    /**
     * Finds customer by ID
     * @param id Customer ID
     * @return Customer (Optional)
     */
    public Optional<Customer> findById(Long id) {
        return customerRepository.findById(id);
    }

    /**
     * Finds customer by national identity number
     * @param nationalId National identity number
     * @return Customer
     */
    public Customer findByNationalId(String nationalId) {
        return customerRepository.findByNationalId(nationalId);
    }

    /**
     * Lists customers by first name and last name
     * @param firstName Customer first name
     * @param lastName Customer last name
     * @return Customer list
     */
    public List<Customer> findByFirstNameAndLastName(String firstName, String lastName) {
        return customerRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    /**
     * Finds customers containing the keyword in first name or last name
     * @param keyword Search keyword
     * @return List of customers
     */
    public List<Customer> searchCustomers(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return customerRepository.findAll();
        }
        return customerRepository.findByFirstNameOrLastNameContaining(keyword);
    }

    /**
     * Finds customer by phone number
     * @param phone Phone number
     * @return Customer
     */
    public Customer findByPhone(String phone) {
        return customerRepository.findByPhone(phone);
    }

    /**
     * Finds customer by email address
     * @param email Email address
     * @return Customer
     */
    public Customer findByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    /**
     * Lists customers with active rental contracts
     * @return List of customers
     */
    public List<Customer> findActiveCustomers() {
        return customerRepository.findActiveCustomers();
    }

    /**
     * Saves a new customer
     * @param customer Customer to be saved
     * @return Saved customer
     */
    @Transactional
    public Customer save(Customer customer) {
        try {
            Customer savedCustomer = customerRepository.save(customer);
            LogUtils.info("Customer saved: " + savedCustomer.getFirstName() + " " + savedCustomer.getLastName());
            return savedCustomer;
        } catch (Exception e) {
            LogUtils.error("Error saving customer", e);
            throw e;
        }
    }

    /**
     * Updates an existing customer
     * @param customer Customer to be updated
     * @return Updated customer
     */
    @Transactional
    public Customer update(Customer customer) {
        try {
            Customer updatedCustomer = customerRepository.save(customer);
            LogUtils.info("Customer updated: " + updatedCustomer.getFirstName() + " " + updatedCustomer.getLastName());
            return updatedCustomer;
        } catch (Exception e) {
            LogUtils.error("Error updating customer", e);
            throw e;
        }
    }

    /**
     * Deletes a customer
     * @param id Customer ID
     */
    @Transactional
    public void delete(Long id) {
        try {
            customerRepository.deleteById(id);
            LogUtils.info("Customer deleted with ID: " + id);
        } catch (Exception e) {
            LogUtils.error("Error deleting customer", e);
            throw e;
        }
    }

    /**
     * Checks if a customer exists with the given national identity number
     * @param nationalId National identity number
     * @return true if exists, false otherwise
     */
    public boolean existsByNationalId(String nationalId) {
        return customerRepository.findByNationalId(nationalId) != null;
    }

    /**
     * Checks if a customer exists with the given phone number
     * @param phone Phone number
     * @return true if exists, false otherwise
     */
    public boolean existsByPhone(String phone) {
        return customerRepository.findByPhone(phone) != null;
    }

    /**
     * Checks if a customer exists with the given email address
     * @param email Email address
     * @return true if exists, false otherwise
     */
    public boolean existsByEmail(String email) {
        return customerRepository.findByEmail(email) != null;
    }
} 