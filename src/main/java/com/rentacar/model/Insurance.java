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
@Table(name = "Insurances")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "insurance_type", nullable = false)
    private String insuranceType;
    
    @Column(name = "company_name", nullable = false)
    private String companyName;
    
    @Column
    private String phone;
    
    @Column
    private String email;
    
    @Column(name = "contact_person")
    private String contactPerson;
    
    @Column
    private String address;
    
    @Column
    private String description;
    
    @Column(name = "is_active", nullable = false)
    private Boolean active = true;
    
    @OneToMany(mappedBy = "insurance")
    private List<VehicleInsurance> vehicleInsurances;
} 