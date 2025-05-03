package com.rentacar.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "VehicleInsurances")
public class VehicleInsurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
    
    @ManyToOne
    @JoinColumn(name = "insurance_id", nullable = false)
    private Insurance insurance;
    
    @Column(name = "policy_number", nullable = false, unique = true)
    private String policyNumber;
    
    @Column(name = "start_date", nullable = false)
    private Date startDate;
    
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    
    @Column(name = "cost", nullable = false)
    private Double cost;
    
    @Column
    private String description;
    
    @Column(name = "is_active", nullable = false)
    private Boolean active = true;
    
    /**
     * Checks if the insurance is valid
     * @return true if valid, false if expired
     */
    @Transient
    public boolean isValid() {
        Date now = new Date();
        return now.before(endDate) && active;
    }
    
    /**
     * Calculates the number of days remaining until the insurance expires
     * @return remaining days
     */
    @Transient
    public long getRemainingDays() {
        return (endDate.getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24);
    }
} 