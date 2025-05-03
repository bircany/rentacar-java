package com.rentacar.ui.employee;

import com.rentacar.model.Employee;
import com.rentacar.model.Branch;
import com.rentacar.service.EmployeeService;
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
 * Personel işlemleri için panel
 */
@Component
public class EmployeePanel extends JPanel {

    private final EmployeeService employeeService;
    private final BranchService branchService;
    
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;
    private JComboBox<Branch> branchComboBox;
    
    @Autowired
    public EmployeePanel(EmployeeService employeeService, BranchService branchService) {
        this.employeeService = employeeService;
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
        loadEmployees();
    }
    
    private void createSearchPanel() {
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        
        JLabel searchLabel = new JLabel("Ara:");
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Ara");
        
        JLabel branchLabel = new JLabel("Şube:");
        branchComboBox = new JComboBox<>();
        branchComboBox.addItem(null); // For "All branches" option
        
        // Load branches
        try {
            List<Branch> branches = branchService.findAll();
            for (Branch branch : branches) {
                branchComboBox.addItem(branch);
            }
        } catch (Exception e) {
            LogUtils.error("Şubeler yüklenirken hata oluştu", e);
        }
        
        branchComboBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                java.awt.Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                if (value == null) {
                    setText("Tüm Şubeler");
                } else {
                    setText(value.toString());
                }
                return component;
            }
        });
        
        searchButton.addActionListener(e -> searchEmployees());
        branchComboBox.addActionListener(e -> searchEmployees());
        
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(branchLabel);
        searchPanel.add(branchComboBox);
        searchPanel.add(searchButton);
        
        add(searchPanel, BorderLayout.NORTH);
    }
    private void createTablePanel() {
        // Create table model with column names
        String[] columnNames = {"ID", "TC Kimlik No", "Ad", "Soyad", "Pozisyon", "Şube", "Telefon", "E-posta"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        employeeTable = new JTable(tableModel);
        employeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        // Add table to scroll pane
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        scrollPane.setPreferredSize(new Dimension(800, 400));
        
        add(scrollPane, BorderLayout.CENTER);
    }
    
    private void createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        
        JButton addButton = new JButton("Yeni Personel Ekle");
        JButton editButton = new JButton("Personel Düzenle");
        JButton deleteButton = new JButton("Personel Sil");
        JButton refreshButton = new JButton("Yenile");
        
        addButton.addActionListener(e -> addEmployee());
        editButton.addActionListener(e -> editEmployee());
        deleteButton.addActionListener(e -> deleteEmployee());
        refreshButton.addActionListener(e -> loadEmployees());
        
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(refreshButton);
        
        add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void loadEmployees() {
        try {
            // Clear existing data
            tableModel.setRowCount(0);
            
            // Load all employees
            List<Employee> employees = employeeService.findAll();
            
            // Add data to table model
            for (Employee employee : employees) {
                Object[] rowData = {
                    employee.getId(),
                    employee.getNationalId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getPosition(),
                    employee.getBranch() != null ? employee.getBranch().toString() : "",
                    employee.getPhone(),
                    employee.getEmail()
                };
                tableModel.addRow(rowData);
            }
            
            LogUtils.info(employees.size() + " personel yüklendi");
        } catch (Exception e) {
            LogUtils.error("Personeller yüklenirken hata oluştu", e);
            JOptionPane.showMessageDialog(this, 
                    "Personeller yüklenirken hata oluştu: " + e.getMessage(), 
                    "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void searchEmployees() {
        try {
            String keyword = searchField.getText().trim();
            Branch selectedBranch = (Branch) branchComboBox.getSelectedItem();
            
            if (keyword.isEmpty() && selectedBranch == null) {
                loadEmployees();
                return;
            }
            
            // Clear existing data
            tableModel.setRowCount(0);
            
            // Search functionality would be implemented here
            // For now, just show a message
            JOptionPane.showMessageDialog(this, 
                    "Arama fonksiyonu yakında eklenecek", 
                    "Bilgi", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (Exception e) {
            LogUtils.error("Personel araması sırasında hata oluştu", e);
            JOptionPane.showMessageDialog(this, 
                    "Personel araması sırasında hata oluştu: " + e.getMessage(), 
                    "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void addEmployee() {
        // Will be implemented with a dialog for adding new employee
        JOptionPane.showMessageDialog(this, 
                "Personel ekleme fonksiyonu yakında eklenecek", 
                "Bilgi", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void editEmployee() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, 
                    "Lütfen düzenlenecek personeli seçin", 
                    "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Will be implemented with a dialog for editing employee
        JOptionPane.showMessageDialog(this, 
                "Personel düzenleme fonksiyonu yakında eklenecek", 
                "Bilgi", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void deleteEmployee() {
        int selectedRow = employeeTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, 
                    "Lütfen silinecek personeli seçin", 
                    "Uyarı", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Long employeeId = (Long) tableModel.getValueAt(selectedRow, 0);
        String employeeName = tableModel.getValueAt(selectedRow, 2) + " " + tableModel.getValueAt(selectedRow, 3);
        
        int response = JOptionPane.showConfirmDialog(this, 
                employeeName + " isimli personeli silmek istediğinizden emin misiniz?", 
                "Silme Onayı", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            try {
                employeeService.delete(employeeId);
                tableModel.removeRow(selectedRow);
                LogUtils.info(employeeName + " isimli personel silindi");
            } catch (Exception e) {
                LogUtils.error("Personel silinirken hata oluştu", e);
                JOptionPane.showMessageDialog(this, 
                        "Personel silinirken hata oluştu: " + e.getMessage(), 
                        "Hata", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
} 