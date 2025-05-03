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
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "contract_number", nullable = false, unique = true)
    private String contractNumber;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;
    
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    
    @Column(name = "return_date")
    @Temporal(TemporalType.DATE)
    private Date returnDate;
    
    @Column(name = "daily_rate", nullable = false)
    private double dailyRate;
    
    @Column(name = "total_amount", nullable = false)
    private double totalAmount;
    
    @Column(name = "deposit_amount")
    private double depositAmount;
    
    @Column(name = "km_start", nullable = false)
    private Integer kmStart;
    
    @Column(name = "km_end")
    private Integer kmEnd;
    
    @Column(name = "status", nullable = false)
    private String status;
    
    @Column(name = "notes")
    private String notes;
    
    @Column(name = "is_active", nullable = false)
    private boolean active = true;
    
    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Payment> payments;

    /**
     * Checks if the contract is active
     * @return true if active, false otherwise
     */
    @Transient
    public boolean isActive() {
        return Constants.CONTRACT_STATUS_ACTIVE.equals(status);
    }
} 