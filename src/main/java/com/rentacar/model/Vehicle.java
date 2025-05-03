package com.rentacar.model;

import com.rentacar.util.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String plate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "make_id", nullable = false)
    private Make make;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_type_id", nullable = false)
    private VehicleType vehicleType;

    @Column(nullable = false)
    private int manufactureYear;

    @Column(nullable = false)
    private String color;

    @Column(name = "fuel_type", nullable = false)
    private String fuelType;

    @Column(name = "transmission_type", nullable = false)
    private String transmissionType;

    @Column(name = "engine_capacity")
    private Integer engineCapacity;

    @Column(name = "engine_power")
    private Integer enginePower;

    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @Column(name = "daily_rate", nullable = false)
    private double dailyRate;

    @Column(name = "purchase_date")
    @Temporal(TemporalType.DATE)
    private Date purchaseDate;

    @Column(name = "sale_date")
    @Temporal(TemporalType.DATE)
    private Date saleDate;

    @Column(nullable = false)
    private String status;
    
    @Column(name = "chassis_no", unique = true)
    private String chassisNo;
    
    @Column(name = "registration_no", unique = true)
    private String registrationNo;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;
    
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleServiceRecord> serviceRecords;
    
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VehicleInsurance> insuranceRecords;
    
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Contract> contracts;
    
    /**
     * Checks if the vehicle has valid insurance
     * @return true if it has valid insurance, false otherwise
     */
    @Transient
    public boolean hasValidInsurance() {
        if (insuranceRecords == null || insuranceRecords.isEmpty()) {
            return false;
        }
        
        Date now = new Date();
        for (VehicleInsurance insurance : insuranceRecords) {
            if (insurance.isValid()) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Checks if the vehicle is available for rental
     * @return true if available, false otherwise
     */
    @Transient
    public boolean isAvailable() {
        return Constants.VEHICLE_STATUS_AVAILABLE.equals(status);
    }
} 