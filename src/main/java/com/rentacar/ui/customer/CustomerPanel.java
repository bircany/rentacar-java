package com.rentacar.ui.customer;

import com.rentacar.model.Customer;
import com.rentacar.service.CustomerService;
import com.rentacar.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Panel for customer operations
 */
@Component
public class CustomerPanel extends JPanel {

    private final CustomerService customerService;
    
    private JTable customerTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    
    @Autowired
    public CustomerPanel(CustomerService customerService) {
        this.customerService = customerService;
        setLayout(new BorderLayout());
    }
    
    @PostConstruct
    private void init() {
        // Create components
        createSearchPanel();
        createTablePanel();
        createButtonPanel();
        
        // Load initial data
        loadCustomers();
    }
    
    private void createSearchPanel() {
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel searchLabel = new JLabel("Search:");
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        
        searchButton.addActionListener(e -> searchCustomers());
        
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
        add(searchPanel, BorderLayout.NORTH);
    }
    
    private void createTablePanel() {
        // Create table model with column names
        String[] columnNames = {"ID", "National ID", "First Name", "Last Name", "Phone", "Email", "Address"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        customerTable = new JTable(tableModel);
        customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(customerTable);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton addButton = new JButton("Add New Customer");
        JButton editButton = new JButton("Edit Customer");
        JButton deleteButton = new JButton("Delete Customer");
        JButton refreshButton = new JButton("Refresh");
        
        addButton.addActionListener(e -> addCustomer());
        editButton.addActionListener(e -> editCustomer());
        deleteButton.addActionListener(e -> deleteCustomer());
        refreshButton.addActionListener(e -> loadCustomers());
        
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void loadCustomers() {
        try {
            // Clear existing data
            tableModel.setRowCount(0);
            
            // Load all customers
            List<Customer> customers = customerService.findAll();
            
            // Add data to table model
            for (Customer customer : customers) {
                Object[] rowData = {
                    customer.getId(),
                    customer.getNationalId(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getPhone(),
                    customer.getEmail(),
                    customer.getAddress()
                };
                tableModel.addRow(rowData);
            }
            
            LogUtils.info("Loaded " + customers.size() + " customers");
        } catch (Exception e) {
            LogUtils.error("Error loading customers", e);
            JOptionPane.showMessageDialog(this, 
                    "Error loading customers: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void searchCustomers() {
        String keyword = searchField.getText().trim();
        List<Customer> customers = customerService.searchCustomers(keyword);
        updateTable(customers);
    }
    
    private void updateTable(List<Customer> customers) {
        try {
            // Clear existing data
            tableModel.setRowCount(0);
            
            // Add data to table model
            for (Customer customer : customers) {
                Object[] rowData = {
                    customer.getId(),
                    customer.getNationalId(),
                    customer.getFirstName(),
                    customer.getLastName(),
                    customer.getPhone(),
                    customer.getEmail(),
                    customer.getAddress()
                };
                tableModel.addRow(rowData);
            }
            
            LogUtils.info("Found " + customers.size() + " customers for keyword: " + searchField.getText());
        } catch (Exception e) {
            LogUtils.error("Error searching customers", e);
            JOptionPane.showMessageDialog(this, 
                    "Error searching customers: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void addCustomer() {
        // Will be implemented with a dialog for adding new customer
        JOptionPane.showMessageDialog(this, 
                "Add customer functionality will be implemented soon", 
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void editCustomer() {
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, 
                    "Please select a customer to edit", 
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Will be implemented with a dialog for editing customer
        JOptionPane.showMessageDialog(this, 
                "Edit customer functionality will be implemented soon", 
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void deleteCustomer() {
        int selectedRow = customerTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, 
                    "Please select a customer to delete", 
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Long customerId = (Long) tableModel.getValueAt(selectedRow, 0);
        String customerName = tableModel.getValueAt(selectedRow, 2) + " " + tableModel.getValueAt(selectedRow, 3);
        
        int response = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete customer: " + customerName + "?", 
                "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            try {
                customerService.delete(customerId);
                tableModel.removeRow(selectedRow);
                LogUtils.info("Deleted customer: " + customerName);
            } catch (Exception e) {
                LogUtils.error("Error deleting customer", e);
                JOptionPane.showMessageDialog(this, 
                        "Error deleting customer: " + e.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
} 