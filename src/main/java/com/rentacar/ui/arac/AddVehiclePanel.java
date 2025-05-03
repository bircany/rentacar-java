package com.rentacar.ui.arac;

import com.rentacar.model.Vehicle;
import com.rentacar.model.VehicleType;
import com.rentacar.model.Make;
import com.rentacar.model.Model;
import com.rentacar.model.Branch;
import com.rentacar.service.VehicleService;
import com.rentacar.service.VehicleTypeService;
import com.rentacar.service.MakeService;
import com.rentacar.service.ModelService;
import com.rentacar.service.BranchService;
import com.rentacar.util.Constants;
import com.rentacar.util.LogUtils;
import com.rentacar.util.ValidationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Date;
import java.util.List;

import static javax.swing.SwingConstants.CENTER;

/**
 * Vehicle Add Panel
 */
@Component
public class AddVehiclePanel extends JPanel {

    private static final String ERROR_TITLE = "Error";
    private static final String SUCCESS_TITLE = "Success";

    private final VehicleService vehicleService;
    private final MakeService makeService;
    private final ModelService modelService;
    private final VehicleTypeService vehicleTypeService;
    private final BranchService branchService;

    private JTextField licensePlateField;
    private JTextField colorField;
    private JTextField engineCapacityField;
    private JTextField enginePowerField;
    private JTextField mileageField;
    private JTextField dailyRateField;
    private JTextField chassisNoField;
    private JTextField registrationNoField;
    private JComboBox<String> fuelTypeCombo;
    private JComboBox<String> transmissionTypeCombo;
    private JComboBox<Make> makeCombo;
    private JComboBox<Model> modelCombo;
    private JComboBox<VehicleType> vehicleTypeCombo;
    private JComboBox<Branch> branchCombo;
    private JSpinner yearSpinner;

    /**
     * Constructor
     */
    @Autowired
    public AddVehiclePanel(VehicleService vehicleService, MakeService makeService, ModelService modelService,
                         VehicleTypeService vehicleTypeService, BranchService branchService) {
        this.vehicleService = vehicleService;
        this.makeService = makeService;
        this.modelService = modelService;
        this.vehicleTypeService = vehicleTypeService;
        this.branchService = branchService;
        
        initComponents();
    }

    /**
     * Initialize and layout components
     */
    private void initComponents() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new BorderLayout());
        
        JPanel formPanel = createFormPanel();
        JScrollPane scrollPane = new JScrollPane(formPanel);
        add(scrollPane, BorderLayout.CENTER);
        
        // Fill combo boxes
        fillComboBoxes();
    }
    
    /**
     * Creates and returns the form panel with all input fields
     */
    private JPanel createFormPanel() {
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        
        addTitleToPanel(formPanel, gbc);
        addInputFieldsToPanel(formPanel, gbc);
        addButtonsToPanel(formPanel, gbc);
        
        return formPanel;
    }
    
    /**
     * Adds title to the form panel
     */
    private void addTitleToPanel(JPanel panel, GridBagConstraints gbc) {
        JLabel titleLabel = new JLabel("Add New Vehicle", CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);
    }
    
    /**
     * Adds all input fields to the form panel
     */
    private void addInputFieldsToPanel(JPanel panel, GridBagConstraints gbc) {
        // License Plate
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(new JLabel("License Plate:"), gbc);
        
        gbc.gridx = 1;
        licensePlateField = new JTextField(20);
        licensePlateField.setToolTipText("Example: 34ABC123");
        panel.add(licensePlateField, gbc);
        
        // Make and Model
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Make:"), gbc);
        
        gbc.gridx = 1;
        makeCombo = new JComboBox<>();
        panel.add(makeCombo, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(new JLabel("Model:"), gbc);
        
        gbc.gridx = 1;
        modelCombo = new JComboBox<>();
        panel.add(modelCombo, gbc);
        
        // Vehicle Type
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(new JLabel("Vehicle Type:"), gbc);
        
        gbc.gridx = 1;
        vehicleTypeCombo = new JComboBox<>();
        panel.add(vehicleTypeCombo, gbc);
        
        // Year
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(new JLabel("Year:"), gbc);
        
        gbc.gridx = 1;
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        SpinnerModel yearModel = new SpinnerNumberModel(currentYear, 1990, currentYear, 1);
        yearSpinner = new JSpinner(yearModel);
        panel.add(yearSpinner, gbc);
        
        // Color
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(new JLabel("Color:"), gbc);
        
        gbc.gridx = 1;
        colorField = new JTextField(20);
        panel.add(colorField, gbc);
        
        // Fuel Type
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(new JLabel("Fuel Type:"), gbc);
        
        gbc.gridx = 1;
        fuelTypeCombo = new JComboBox<>(new String[]{"Gasoline", "Diesel", "LPG", "Hybrid", "Electric"});
        panel.add(fuelTypeCombo, gbc);
        
        // Transmission Type
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(new JLabel("Transmission:"), gbc);
        
        gbc.gridx = 1;
        transmissionTypeCombo = new JComboBox<>(new String[]{"Manual", "Automatic", "Semi-Automatic"});
        panel.add(transmissionTypeCombo, gbc);
        
        // Engine Capacity
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(new JLabel("Engine Capacity (cc):"), gbc);
        
        gbc.gridx = 1;
        engineCapacityField = new JTextField(20);
        panel.add(engineCapacityField, gbc);
        
        // Engine Power
        gbc.gridx = 0;
        gbc.gridy = 10;
        panel.add(new JLabel("Engine Power (HP):"), gbc);
        
        gbc.gridx = 1;
        enginePowerField = new JTextField(20);
        panel.add(enginePowerField, gbc);
        
        // Mileage
        gbc.gridx = 0;
        gbc.gridy = 11;
        panel.add(new JLabel("Mileage:"), gbc);
        
        gbc.gridx = 1;
        mileageField = new JTextField(20);
        panel.add(mileageField, gbc);
        
        // Daily Rate
        gbc.gridx = 0;
        gbc.gridy = 12;
        panel.add(new JLabel("Daily Rate ($):"), gbc);
        
        gbc.gridx = 1;
        dailyRateField = new JTextField(20);
        panel.add(dailyRateField, gbc);
        
        // Chassis Number
        gbc.gridx = 0;
        gbc.gridy = 13;
        panel.add(new JLabel("Chassis No:"), gbc);
        
        gbc.gridx = 1;
        chassisNoField = new JTextField(20);
        panel.add(chassisNoField, gbc);
        
        // Registration Number
        gbc.gridx = 0;
        gbc.gridy = 14;
        panel.add(new JLabel("Registration No:"), gbc);
        
        gbc.gridx = 1;
        registrationNoField = new JTextField(20);
        panel.add(registrationNoField, gbc);
        
        // Branch
        gbc.gridx = 0;
        gbc.gridy = 15;
        panel.add(new JLabel("Branch:"), gbc);
        
        gbc.gridx = 1;
        branchCombo = new JComboBox<>();
        panel.add(branchCombo, gbc);
    }
    
    /**
     * Creates and adds button panel to form panel
     */
    private void addButtonsToPanel(JPanel panel, GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 16;
        gbc.gridwidth = 2;
        
        panel.add(createButtonPanel(), gbc);
        
        // Combo box event listeners
        makeCombo.addActionListener(e -> {
            Make selectedMake = (Make) makeCombo.getSelectedItem();
            if (selectedMake != null) {
                updateModelCombo(selectedMake);
            }
        });
    }
    
    /**
     * Creates panel with action buttons
     */
    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> save());
        
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(e -> clearForm());
        
        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> this.firePropertyChange("panel", "addVehicle", "home"));
        
        buttonPanel.add(saveButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(cancelButton);
        
        return buttonPanel;
    }

    /**
     * Fill combo boxes with data from database
     */
    private void fillComboBoxes() {
        try {
            // Makes
            List<Make> makes = makeService.findAll();
            for (Make make : makes) {
                makeCombo.addItem(make);
            }
            
            // Vehicle types
            List<VehicleType> vehicleTypes = vehicleTypeService.findAll();
            for (VehicleType vehicleType : vehicleTypes) {
                vehicleTypeCombo.addItem(vehicleType);
            }
            
            // Branches
            List<Branch> branches = branchService.findAllActive();
            for (Branch branch : branches) {
                branchCombo.addItem(branch);
            }
            
            // If a make is selected in combo box, fill the model combo box
            if (makeCombo.getItemCount() > 0) {
                makeCombo.setSelectedIndex(0);
                Make selectedMake = (Make) makeCombo.getSelectedItem();
                if (selectedMake != null) {
                    updateModelCombo(selectedMake);
                }
            }
        } catch (Exception e) {
            LogUtils.error("Error occurred while loading combo boxes", e);
            JOptionPane.showMessageDialog(this, 
                    "Error loading data: " + e.getMessage(), 
                    ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Update model combo box based on selected make
     * @param make Selected make
     */
    private void updateModelCombo(Make make) {
        try {
            modelCombo.removeAllItems();
            List<Model> models = modelService.findByMake(make);
            for (Model model : models) {
                modelCombo.addItem(model);
            }
        } catch (Exception e) {
            LogUtils.error("Error updating model combo box", e);
            JOptionPane.showMessageDialog(this, 
                    "Error loading models: " + e.getMessage(), 
                    ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Validate form fields and save vehicle
     */
    private void save() {
        try {
            // Validate fields
            if (!validateForm()) {
                return;
            }
            
            // Create new vehicle
            Vehicle vehicle = createVehicleFromForm();
            
            // Save vehicle
            vehicleService.save(vehicle);
            
            LogUtils.info("New vehicle saved: " + vehicle.getPlate());
            JOptionPane.showMessageDialog(this, 
                    "Vehicle saved successfully.", 
                    SUCCESS_TITLE, JOptionPane.INFORMATION_MESSAGE);
            
            // Clear form
            clearForm();
        } catch (Exception e) {
            LogUtils.error("Error occurred while saving vehicle", e);
            JOptionPane.showMessageDialog(this, 
                    "Error saving vehicle: " + e.getMessage(), 
                    ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Creates a vehicle object from form data
     */
    private Vehicle createVehicleFromForm() {
        Vehicle vehicle = new Vehicle();
        
        // Set values
        vehicle.setPlate(licensePlateField.getText().trim().toUpperCase());
        vehicle.setMake((Make) makeCombo.getSelectedItem());
        vehicle.setModel((Model) modelCombo.getSelectedItem());
        vehicle.setVehicleType((VehicleType) vehicleTypeCombo.getSelectedItem());
        vehicle.setManufactureYear((Integer) yearSpinner.getValue());
        vehicle.setColor(colorField.getText().trim());
        vehicle.setFuelType((String) fuelTypeCombo.getSelectedItem());
        vehicle.setTransmissionType((String) transmissionTypeCombo.getSelectedItem());
        
        if (!engineCapacityField.getText().trim().isEmpty()) {
            vehicle.setEngineCapacity(Integer.parseInt(engineCapacityField.getText().trim()));
        }
        
        if (!enginePowerField.getText().trim().isEmpty()) {
            vehicle.setEnginePower(Integer.parseInt(enginePowerField.getText().trim()));
        }
        
        vehicle.setMileage(Integer.parseInt(mileageField.getText().trim()));
        vehicle.setDailyRate(Double.parseDouble(dailyRateField.getText().trim()));
        vehicle.setChassisNo(chassisNoField.getText().trim());
        vehicle.setRegistrationNo(registrationNoField.getText().trim());
        vehicle.setBranch((Branch) branchCombo.getSelectedItem());
        
        // Set default values
        vehicle.setStatus(Constants.VEHICLE_STATUS_AVAILABLE);
        vehicle.setPurchaseDate(new Date());
        
        return vehicle;
    }

    /**
     * Validate form fields
     * @return true if all fields are valid, false otherwise
     */
    private boolean validateForm() {
        if (!validateLicensePlate()) return false;
        if (!validateMakeAndModel()) return false;
        if (!validateVehicleType()) return false;
        if (!validateColor()) return false;
        if (!validateMileage()) return false;
        if (!validateDailyRate()) return false;
        if (!validateBranch()) return false;
        return validateEngineValues();
    }
    
    /**
     * Validates license plate field
     */
    private boolean validateLicensePlate() {
        String licensePlate = licensePlateField.getText().trim().toUpperCase();
        if (licensePlate.isEmpty()) {
            showErrorMessage("License plate field cannot be empty", licensePlateField);
            return false;
        }
        
        if (!ValidationUtils.isValidPlate(licensePlate)) {
            showErrorMessage("Invalid license plate format", licensePlateField);
            return false;
        }
        
        // Check if license plate already exists
        Vehicle existingVehicle = vehicleService.findByPlate(licensePlate);
        if (existingVehicle != null) {
            showErrorMessage("A vehicle with this license plate already exists", licensePlateField);
            return false;
        }
        
        return true;
    }
    
    /**
     * Shows error message and sets focus to provided component
     */
    private void showErrorMessage(String message, java.awt.Component component) {
        JOptionPane.showMessageDialog(this, message, ERROR_TITLE, JOptionPane.ERROR_MESSAGE);
        component.requestFocus();
    }
    
    /**
     * Validates make and model fields
     */
    private boolean validateMakeAndModel() {
        if (makeCombo.getSelectedItem() == null) {
            showErrorMessage("Please select a make", makeCombo);
            return false;
        }
        
        if (modelCombo.getSelectedItem() == null) {
            showErrorMessage("Please select a model", modelCombo);
            return false;
        }
        
        return true;
    }
    
    /**
     * Validates vehicle type field
     */
    private boolean validateVehicleType() {
        if (vehicleTypeCombo.getSelectedItem() == null) {
            showErrorMessage("Please select a vehicle type", vehicleTypeCombo);
            return false;
        }
        
        return true;
    }
    
    /**
     * Validates color field
     */
    private boolean validateColor() {
        if (colorField.getText().trim().isEmpty()) {
            showErrorMessage("Color field cannot be empty", colorField);
            return false;
        }
        
        return true;
    }
    
    /**
     * Validates mileage field
     */
    private boolean validateMileage() {
        try {
            int mileage = Integer.parseInt(mileageField.getText().trim());
            if (mileage < 0) {
                showErrorMessage("Mileage cannot be negative", mileageField);
                return false;
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Please enter a numeric value for mileage", mileageField);
            return false;
        }
        
        return true;
    }
    
    /**
     * Validates daily rate field
     */
    private boolean validateDailyRate() {
        try {
            double dailyRate = Double.parseDouble(dailyRateField.getText().trim());
            if (dailyRate <= 0) {
                showErrorMessage("Daily rate must be greater than zero", dailyRateField);
                return false;
            }
        } catch (NumberFormatException e) {
            showErrorMessage("Please enter a numeric value for daily rate", dailyRateField);
            return false;
        }
        
        return true;
    }
    
    /**
     * Validates branch field
     */
    private boolean validateBranch() {
        if (branchCombo.getSelectedItem() == null) {
            showErrorMessage("Please select a branch", branchCombo);
            return false;
        }
        
        return true;
    }
    
    /**
     * Validates engine capacity and power fields
     */
    private boolean validateEngineValues() {
        // Engine capacity validation (optional)
        if (!engineCapacityField.getText().trim().isEmpty()) {
            try {
                int engineCapacity = Integer.parseInt(engineCapacityField.getText().trim());
                if (engineCapacity <= 0) {
                    showErrorMessage("Engine capacity must be greater than zero", engineCapacityField);
                    return false;
                }
            } catch (NumberFormatException e) {
                showErrorMessage("Please enter a numeric value for engine capacity", engineCapacityField);
                return false;
            }
        }
        
        // Engine power validation (optional)
        if (!enginePowerField.getText().trim().isEmpty()) {
            try {
                int enginePower = Integer.parseInt(enginePowerField.getText().trim());
                if (enginePower <= 0) {
                    showErrorMessage("Engine power must be greater than zero", enginePowerField);
                    return false;
                }
            } catch (NumberFormatException e) {
                showErrorMessage("Please enter a numeric value for engine power", enginePowerField);
                return false;
            }
        }
        
        return true;
    }

    /**
     * Clear form fields
     */
    private void clearForm() {
        licensePlateField.setText("");
        colorField.setText("");
        engineCapacityField.setText("");
        enginePowerField.setText("");
        mileageField.setText("");
        dailyRateField.setText("");
        chassisNoField.setText("");
        registrationNoField.setText("");
        
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        yearSpinner.setValue(currentYear);
        fuelTypeCombo.setSelectedIndex(0);
        transmissionTypeCombo.setSelectedIndex(0);
        
        if (makeCombo.getItemCount() > 0) {
            makeCombo.setSelectedIndex(0);
        }
        
        if (vehicleTypeCombo.getItemCount() > 0) {
            vehicleTypeCombo.setSelectedIndex(0);
        }
        
        if (branchCombo.getItemCount() > 0) {
            branchCombo.setSelectedIndex(0);
        }
        
        licensePlateField.requestFocus();
    }
} 