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
@Table(name = "makes")
public class Make {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, unique = true)
    private String name;
    
    @Column
    private String country;
    
    @OneToMany(mappedBy = "make", fetch = FetchType.LAZY)
    private List<Model> models;
    
    @OneToMany(mappedBy = "make", fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;

    @Override
    public String toString() {
        return name;
    }
} 