package com.rentacar.service;

import com.rentacar.model.Employee;
import com.rentacar.model.Branch;
import com.rentacar.repository.EmployeeRepository;
import com.rentacar.util.LogUtils;
import com.rentacar.util.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Employee service class
 */
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Lists all employees
     * @return Employee list
     */
    public List<Employee> findAll() {
        return employeeRepository.findAllWithBranch();
    }

    /**
     * Finds employee by ID
     * @param id Employee ID
     * @return Employee (Optional)
     */
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    /**
     * Finds employee by national ID
     * @param nationalId Employee national ID
     * @return Employee
     */
    public Employee findByNationalId(String nationalId) {
        return employeeRepository.findByNationalId(nationalId);
    }

    /**
     * Lists employees by branch
     * @param branch Branch
     * @return Employee list
     */
    public List<Employee> findByBranch(Branch branch) {
        return employeeRepository.findByBranch(branch);
    }

    /**
     * Lists employees by position
     * @param position Employee position
     * @return Employee list
     */
    public List<Employee> findByPosition(String position) {
        return employeeRepository.findByPosition(position);
    }

    /**
     * Lists active employees by branch ID
     * @param branchId Branch ID
     * @return Employee list
     */
    public List<Employee> findActiveEmployeesByBranch(Long branchId) {
        return employeeRepository.findByBranchIdAndActiveTrue(branchId);
    }

    /**
     * Lists employees by first name and last name
     * @param firstName Employee first name
     * @param lastName Employee last name
     * @return Employee list
     */
    public List<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    /**
     * Saves new employee
     * @param employee Employee to save
     * @return Saved employee
     */
    @Transactional
    public Employee save(Employee employee) {
        // Generate salt and hash password if provided
        if (employee.getPassword() != null && !employee.getPassword().isEmpty()) {
            String salt = SecurityUtils.generateSalt();
            employee.setSalt(salt);
            employee.setPassword(SecurityUtils.hashPassword(employee.getPassword(), salt));
        }
        
        LogUtils.info("Adding new employee: " + employee.getFirstName() + " " + employee.getLastName());
        return employeeRepository.save(employee);
    }

    /**
     * Updates employee
     * @param employee Employee to update
     * @return Updated employee
     */
    @Transactional
    public Employee update(Employee employee) {
        Optional<Employee> existingEmp = employeeRepository.findById(employee.getId());
        
        // Only update password if it's provided
        if (existingEmp.isPresent() && 
            (employee.getPassword() == null || employee.getPassword().isEmpty())) {
            employee.setPassword(existingEmp.get().getPassword());
            employee.setSalt(existingEmp.get().getSalt());
        } else if (employee.getPassword() != null && !employee.getPassword().isEmpty()) {
            // Hash the new password
            String salt = SecurityUtils.generateSalt();
            employee.setSalt(salt);
            employee.setPassword(SecurityUtils.hashPassword(employee.getPassword(), salt));
        }
        
        LogUtils.info("Updating employee: " + employee.getFirstName() + " " + employee.getLastName());
        return employeeRepository.save(employee);
    }

    /**
     * Deletes employee
     * @param id Employee ID to delete
     */
    @Transactional
    public void delete(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            LogUtils.info("Deleting employee: " + employee.get().getFirstName() + " " + employee.get().getLastName());
            employeeRepository.deleteById(id);
        } else {
            LogUtils.warning("Employee to delete not found. ID: " + id);
        }
    }

    /**
     * Authenticates employee
     * @param email Email
     * @param password Password
     * @return Employee if authenticated, null otherwise
     */
    public Employee authenticate(String email, String password) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee != null) {
            String hashedPassword = SecurityUtils.hashPassword(password, employee.getSalt());
            if (hashedPassword.equals(employee.getPassword())) {
                return employee;
            }
        }
        return null;
    }
} 