package com.rentacar.model;

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
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "identity_number", nullable = false, unique = true)
    private String nationalId;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private String position;
    
    @Column
    private String phone;
    
    @Column
    private String email;
    
    @Column
    private String password;
    
    @Column
    private String salt;
    
    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;
    
    @Column(name = "is_active", nullable = false)
    private boolean active = true;
    
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Contract> contracts;
    
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
    private List<Payment> payments;
} 