package com.example.Medical.App.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Assurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomAssureur;
    private String numeroPolice;
    private String typeCouverture;

    @OneToMany(mappedBy = "assurance" ,cascade = CascadeType.ALL)
    private List<Patient> patients;



}
