package com.rentacar.ui.branch;

import com.rentacar.model.Branch;
import com.rentacar.service.BranchService;
import com.rentacar.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

/**
 * Panel for branch operations
 */
@Component
public class BranchPanel extends JPanel {

    private final BranchService branchService;
    
    private JTable branchTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    
    @Autowired
    public BranchPanel(BranchService branchService) {
        this.branchService = branchService;
        setLayout(new BorderLayout());
    }
    
    @PostConstruct
    private void init() {
        // Create components
        createSearchPanel();
        createTablePanel();
        createButtonPanel();
        
        // Load initial data
        loadBranches();
    }
    
    private void createSearchPanel() {
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel searchLabel = new JLabel("Search:");
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        
        searchButton.addActionListener(e -> searchBranches());
        
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
        add(searchPanel, BorderLayout.NORTH);
    }
    
    private void createTablePanel() {
        // Create table model with column names
        String[] columnNames = {"ID", "Name", "City", "Address", "Phone", "Manager"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        branchTable = new JTable(tableModel);
        branchTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(branchTable);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton addButton = new JButton("Add New Branch");
        JButton editButton = new JButton("Edit Branch");
        JButton deleteButton = new JButton("Delete Branch");
        JButton refreshButton = new JButton("Refresh");
        
        addButton.addActionListener(e -> addBranch());
        editButton.addActionListener(e -> editBranch());
        deleteButton.addActionListener(e -> deleteBranch());
        refreshButton.addActionListener(e -> loadBranches());
        
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void loadBranches() {
        try {
            // Clear existing data
            tableModel.setRowCount(0);
            
            // Load all branches
            List<Branch> branches = branchService.findAll();
            
            // Add data to table model
            for (Branch branch : branches) {
                Object[] rowData = {
                    branch.getId(),
                    branch.getName(),
                    branch.getCity(),
                    branch.getAddress(),
                    branch.getPhone(),
                    branch.getManager() != null ? branch.getManager().getFirstName() + " " + branch.getManager().getLastName() : ""
                };
                tableModel.addRow(rowData);
            }
            
            LogUtils.info("Loaded " + branches.size() + " branches");
        } catch (Exception e) {
            LogUtils.error("Error loading branches", e);
            JOptionPane.showMessageDialog(this, 
                    "Error loading branches: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void searchBranches() {
        try {
            String keyword = searchField.getText().trim();
            if (keyword.isEmpty()) {
                loadBranches();
                return;
            }
            
            // Clear existing data
            tableModel.setRowCount(0);
            
            // Search branches by name or city
            List<Branch> branches = branchService.findByNameOrCityContaining(keyword);
            
            // Add data to table model
            for (Branch branch : branches) {
                Object[] rowData = {
                    branch.getId(),
                    branch.getName(),
                    branch.getCity(),
                    branch.getAddress(),
                    branch.getPhone(),
                    branch.getManager() != null ? branch.getManager().getFirstName() + " " + branch.getManager().getLastName() : ""
                };
                tableModel.addRow(rowData);
            }
            
            LogUtils.info("Found " + branches.size() + " branches for keyword: " + keyword);
        } catch (Exception e) {
            LogUtils.error("Error searching branches", e);
            JOptionPane.showMessageDialog(this, 
                    "Error searching branches: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void addBranch() {
        // Will be implemented with a dialog for adding new branch
        JOptionPane.showMessageDialog(this, 
                "Add branch functionality will be implemented soon", 
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void editBranch() {
        int selectedRow = branchTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, 
                    "Please select a branch to edit", 
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Will be implemented with a dialog for editing branch
        JOptionPane.showMessageDialog(this, 
                "Edit branch functionality will be implemented soon", 
                "Information", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void deleteBranch() {
        int selectedRow = branchTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, 
                    "Please select a branch to delete", 
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Long branchId = (Long) tableModel.getValueAt(selectedRow, 0);
        String branchName = (String) tableModel.getValueAt(selectedRow, 1);
        
        int response = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete branch: " + branchName + "?", 
                "Confirm Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            try {
                branchService.delete(branchId);
                tableModel.removeRow(selectedRow);
                LogUtils.info("Deleted branch: " + branchName);
            } catch (Exception e) {
                LogUtils.error("Error deleting branch", e);
                JOptionPane.showMessageDialog(this, 
                        "Error deleting branch: " + e.getMessage(), 
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
} 