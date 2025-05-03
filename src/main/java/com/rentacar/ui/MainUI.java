package com.rentacar.ui;

import com.rentacar.ui.arac.AddVehiclePanel;
import com.rentacar.ui.customer.CustomerPanel;
import com.rentacar.ui.employee.EmployeePanel;
import com.rentacar.ui.branch.BranchPanel;
import com.rentacar.ui.contract.ContractPanel;
import com.rentacar.util.LogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.swing.*;
import javax.swing.WindowConstants;
import javax.swing.SwingConstants;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * RentACar main user interface
 */
@Component
public class MainUI extends JFrame implements PropertyChangeListener {

    private JPanel mainPanel;
    private JPanel contentPanel;
    private CardLayout cardLayout;
    
    @Autowired
    private AddVehiclePanel addVehiclePanel;
    
    @Autowired
    private CustomerPanel customerPanel;
    
    @Autowired
    private EmployeePanel employeePanel;
    
    @Autowired
    private BranchPanel branchPanel;
    
    @Autowired
    private ContractPanel contractPanel;

    /**
     * Constructor
     */
    public MainUI() {
        super("RentACar Vehicle Rental Automation");
        
        // Disable headless mode
        System.setProperty("java.awt.headless", "false");
        
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setSize(1024, 768);
        setLocationRelativeTo(null);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exit();
            }
        });
    }

    /**
     * Called by Spring as PostConstruct
     */
    @PostConstruct
    public void init() {
        try {
            // Set UI appearance
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            // Main panel
            mainPanel = new JPanel(new BorderLayout());
            setContentPane(mainPanel);
            
            // Create menu and toolbar
            createMenuBar();
            createToolBar();
            
            // Content panel with card layout
            cardLayout = new CardLayout();
            contentPanel = new JPanel(cardLayout);
            mainPanel.add(contentPanel, BorderLayout.CENTER);
            
            // Welcome panel
            JPanel welcomePanel = new JPanel(new BorderLayout());
            JLabel welcomeLabel = new JLabel("Welcome to RentACar Vehicle Rental Automation", SwingConstants.CENTER);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
            welcomePanel.add(welcomeLabel, BorderLayout.CENTER);
            
            // Add panels to card layout
            contentPanel.add(welcomePanel, "welcome");
            contentPanel.add(addVehiclePanel, "addVehicle");
            contentPanel.add(customerPanel, "customer");
            contentPanel.add(employeePanel, "employee");
            contentPanel.add(branchPanel, "branch");
            contentPanel.add(contractPanel, "contract");
            
            // Show welcome panel initially
            cardLayout.show(contentPanel, "welcome");
            
            // Listen for property changes
            addPropertyChangeListener(this);
            
            LogUtils.info("Main user interface created");
        } catch (Exception e) {
            LogUtils.error("Error occurred while creating user interface", e);
            JOptionPane.showMessageDialog(this, 
                    "Error creating interface: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates the menu bar
     */
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        
        // File menu
        JMenu fileMenu = new JMenu("File");
        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> exit());
        fileMenu.add(exitItem);
        
        // Vehicle menu
        JMenu vehicleMenu = new JMenu("Vehicles");
        JMenuItem addVehicleItem = new JMenuItem("Add Vehicle");
        JMenuItem listVehiclesItem = new JMenuItem("List Vehicles");
        JMenuItem vehicleTypesItem = new JMenuItem("Vehicle Types");
        JMenuItem makesModelsItem = new JMenuItem("Makes and Models");
        
        // Connect items to actions
        addVehicleItem.addActionListener(e -> firePropertyChange("view", "main", "addVehicle"));
        
        vehicleMenu.add(addVehicleItem);
        vehicleMenu.add(listVehiclesItem);
        vehicleMenu.addSeparator();
        vehicleMenu.add(vehicleTypesItem);
        vehicleMenu.add(makesModelsItem);
        
        // Customer menu
        JMenu customerMenu = new JMenu("Customers");
        JMenuItem addCustomerItem = new JMenuItem("Add Customer");
        JMenuItem listCustomersItem = new JMenuItem("List Customers");
        
        // Connect customer items to actions
        listCustomersItem.addActionListener(e -> firePropertyChange("view", "main", "customer"));
        
        customerMenu.add(addCustomerItem);
        customerMenu.add(listCustomersItem);
        
        // Staff menu
        JMenu staffMenu = new JMenu("Staff");
        JMenuItem addStaffItem = new JMenuItem("Add Staff");
        JMenuItem listStaffItem = new JMenuItem("List Staff");
        JMenuItem addBranchItem = new JMenuItem("Add Branch");
        JMenuItem listBranchesItem = new JMenuItem("List Branches");
        
        // Connect staff items to actions
        listStaffItem.addActionListener(e -> firePropertyChange("view", "main", "employee"));
        listBranchesItem.addActionListener(e -> firePropertyChange("view", "main", "branch"));
        
        staffMenu.add(addStaffItem);
        staffMenu.add(listStaffItem);
        staffMenu.addSeparator();
        staffMenu.add(addBranchItem);
        staffMenu.add(listBranchesItem);
        
        // Contract menu
        JMenu contractMenu = new JMenu("Contracts");
        JMenuItem createContractItem = new JMenuItem("Create Contract");
        JMenuItem listContractsItem = new JMenuItem("List Contracts");
        JMenuItem addPaymentItem = new JMenuItem("Add Payment");
        JMenuItem listPaymentsItem = new JMenuItem("List Payments");
        
        // Connect contract items to actions
        listContractsItem.addActionListener(e -> firePropertyChange("view", "main", "contract"));
        
        contractMenu.add(createContractItem);
        contractMenu.add(listContractsItem);
        contractMenu.addSeparator();
        contractMenu.add(addPaymentItem);
        contractMenu.add(listPaymentsItem);
        
        // Report menu
        JMenu reportMenu = new JMenu("Reports");
        JMenuItem dailyReportItem = new JMenuItem("Daily Report");
        JMenuItem monthlyReportItem = new JMenuItem("Monthly Report");
        JMenuItem yearlyReportItem = new JMenuItem("Yearly Report");
        JMenuItem customReportItem = new JMenuItem("Custom Report");
        reportMenu.add(dailyReportItem);
        reportMenu.add(monthlyReportItem);
        reportMenu.add(yearlyReportItem);
        reportMenu.add(customReportItem);
        
        // Help menu
        JMenu helpMenu = new JMenu("Help");
        JMenuItem aboutItem = new JMenuItem("About");
        JMenuItem helpItem = new JMenuItem("Help");
        helpMenu.add(helpItem);
        helpMenu.add(aboutItem);
        
        // Add menus to menu bar
        menuBar.add(fileMenu);
        menuBar.add(vehicleMenu);
        menuBar.add(customerMenu);
        menuBar.add(staffMenu);
        menuBar.add(contractMenu);
        menuBar.add(reportMenu);
        menuBar.add(helpMenu);
        
        setJMenuBar(menuBar);
    }

    /**
     * Creates the toolbar
     */
    private void createToolBar() {
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(e -> cardLayout.show(contentPanel, "welcome"));
        
        JButton addVehicleButton = new JButton("Add Vehicle");
        addVehicleButton.addActionListener(e -> firePropertyChange("view", "main", "addVehicle"));
        
        JButton addCustomerButton = new JButton("Add Customer");
        addCustomerButton.addActionListener(e -> firePropertyChange("view", "main", "customer"));
        
        JButton contractButton = new JButton("Contracts");
        contractButton.addActionListener(e -> firePropertyChange("view", "main", "contract"));
        
        JButton employeeButton = new JButton("Employees");
        employeeButton.addActionListener(e -> firePropertyChange("view", "main", "employee"));
        
        JButton branchButton = new JButton("Branches");
        branchButton.addActionListener(e -> firePropertyChange("view", "main", "branch"));
        
        toolBar.add(homeButton);
        toolBar.add(addVehicleButton);
        toolBar.add(addCustomerButton);
        toolBar.add(contractButton);
        toolBar.add(employeeButton);
        toolBar.add(branchButton);
        
        mainPanel.add(toolBar, BorderLayout.NORTH);
    }

    /**
     * Exit the application
     */
    private void exit() {
        int response = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to exit the application?", 
                "Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (response == JOptionPane.YES_OPTION) {
            LogUtils.info("User exited the application");
            dispose();
            System.exit(0);
        }
    }

    /**
     * Display the main screen
     */
    public void display() {
        SwingUtilities.invokeLater(() -> setVisible(true));
    }
    
    /**
     * Handle property change events
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("view".equals(evt.getPropertyName())) {
            String view = (String) evt.getNewValue();
            cardLayout.show(contentPanel, view);
            LogUtils.info("Changed view to: " + view);
        }
    }
} 