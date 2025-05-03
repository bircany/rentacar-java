package com.rentacar.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ServiceCenters")
public class ServiceCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column
    private String address;
    
    @Column(nullable = false)
    private String phone;
    
    @Column(name = "contact_person")
    private String contactPerson;
    
    @Column
    private String email;
    
    @Column(name = "tax_number")
    private String taxNumber;
    
    @Column(name = "is_active", nullable = false)
    private Boolean active = true;
    
    @OneToMany(mappedBy = "serviceCenter")
    private List<VehicleServiceRecord> serviceRecords;
} 