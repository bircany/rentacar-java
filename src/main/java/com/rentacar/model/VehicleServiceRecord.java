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
@Table(name = "VehicleServiceRecords")
public class VehicleServiceRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "vehicle_id", nullable = false)
    private Vehicle vehicle;
    
    @ManyToOne
    @JoinColumn(name = "service_center_id", nullable = false)
    private ServiceCenter serviceCenter;
    
    @Column(name = "service_type", nullable = false)
    private String serviceType;
    
    @Column(name = "entry_date", nullable = false)
    private Date entryDate;
    
    @Column(name = "exit_date")
    private Date exitDate;
    
    @Column(name = "mileage", nullable = false)
    private Integer mileage;
    
    @Column(name = "cost")
    private Double cost;
    
    @Column
    private String description;
    
    @Column(name = "performed_operations")
    private String performedOperations;
    
    @Column(name = "status", nullable = false)
    private String status;
} 