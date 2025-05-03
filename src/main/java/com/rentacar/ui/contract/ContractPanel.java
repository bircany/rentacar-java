package com.rentacar.ui.contract;

import com.rentacar.model.Contract;
import com.rentacar.model.Customer;
import com.rentacar.model.Vehicle;
import com.rentacar.model.Employee;
import com.rentacar.repository.ContractRepository;
import com.rentacar.service.CustomerService;
import com.rentacar.service.VehicleService;
import com.rentacar.service.EmployeeService;
import com.rentacar.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Panel for contract operations
 */
@Component
public class ContractPanel extends JPanel {

    private final ContractRepository contractRepository;
    private final CustomerService customerService;
    private final VehicleService vehicleService;
    private final EmployeeService employeeService;
    
    private JTable contractTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private SimpleDateFormat dateFormat;
    
    @Autowired
    public ContractPanel(ContractRepository contractRepository, 
                        CustomerService customerService,
                        VehicleService vehicleService,
                        EmployeeService employeeService) {
        this.contractRepository = contractRepository;
        this.customerService = customerService;
        this.vehicleService = vehicleService;
        this.employeeService = employeeService;
        this.dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        setLayout(new BorderLayout());
    }
    
    @PostConstruct
    private void init() {
        // Create components
        createSearchPanel();
        createTablePanel();
        createButtonPanel();
        
        // Load initial data
        loadContracts();
    }
    
    private void createSearchPanel() {
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel searchLabel = new JLabel("Search:");
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        
        searchButton.addActionListener(e -> searchContracts());
        
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
        add(searchPanel, BorderLayout.NORTH);
    }
    
    private void createTablePanel() {
        // Create table model with column names
        String[] columnNames = {"ID", "Contract Number", "Customer", "Vehicle", "Start Date", "End Date", "Amount", "Status"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        contractTable = new JTable(tableModel);
        contractTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(contractTable);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton addButton = new JButton("New Contract");
        JButton editButton = new JButton("Edit Contract");
        JButton viewButton = new JButton("View Details");
        JButton paymentButton = new JButton("Add Payment");
        JButton refreshButton = new JButton("Refresh");
        
        addButton.addActionListener(e -> createContract());
        editButton.addActionListener(e -> editContract());
        viewButton.addActionListener(e -> viewContractDetails());
        paymentButton.addActionListener(e -> addPayment());
        refreshButton.addActionListener(e -> loadContracts());
        
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(paymentButton);
        buttonPanel.add(refreshButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void loadContracts() {
        try {
            // Clear existing data
            tableModel.setRowCount(0);
            
            // Load all contracts
            List<Contract> contracts = contractRepository.findAllWithCustomerAndVehicle();
            
            // Add data to table model
            for (Contract contract : contracts) {
                Customer customer = contract.getCustomer();
                Vehicle vehicle = contract.getVehicle();
                
                Object[] rowData = {
                    contract.getId(),
                    contract.getContractNumber(),
                    customer != null ? customer.toString() : "",
                    vehicle.getMake().getName() + " " + vehicle.getModel().getName() + " (" + vehicle.getPlate() + ")",
                    dateFormat.format(contract.getStartDate()),
                    dateFormat.format(contract.getEndDate()),
                    contract.getTotalAmount(),
                    contract.isActive() ? "Active" : "Closed"
                };
                tableModel.addRow(rowData);
            }
            
            LogUtils.info("Loaded " + contracts.size() + " contracts");
        } catch (Exception e) {
            LogUtils.error("Error loading contracts", e);
            JOptionPane.showMessageDialog(this, 
                    "Error loading contracts: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void searchContracts() {
        try {
            String keyword = searchField.getText().trim();
            if (keyword.isEmpty()) {
                loadContracts();
                return;
            }
            
            // Clear existing data
            tableModel.setRowCount(0);
            
            // Search functionality would be implemented here
            // For now, just show a message
            JOptionPane.showMessageDialog(this, 
                    "Search functionality will be implemented soon", 
                    "Information", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            LogUtils.error("Error searching contracts", e);
            JOptionPane.showMessageDialog(this, 
                    "Error searching contracts: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void createContract() {
        // Will be implemented with a dialog for creating new contract
        JOptionPane.showMessageDialog(this, 
                "Create contract functionality will be implemented soon", 
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void editContract() {
        int selectedRow = contractTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, 
                    "Please select a contract to edit", 
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Will be implemented with a dialog for editing contract
        JOptionPane.showMessageDialog(this, 
                "Edit contract functionality will be implemented soon", 
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void viewContractDetails() {
        int selectedRow = contractTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, 
                    "Please select a contract to view", 
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Will be implemented with a dialog for viewing contract details
        JOptionPane.showMessageDialog(this, 
                "View contract details functionality will be implemented soon", 
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void addPayment() {
        int selectedRow = contractTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, 
                    "Please select a contract to add payment", 
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Will be implemented with a dialog for adding payment
        JOptionPane.showMessageDialog(this, 
                "Add payment functionality will be implemented soon", 
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }
} 