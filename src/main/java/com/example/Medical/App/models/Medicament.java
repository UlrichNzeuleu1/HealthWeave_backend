package com.example.Medical.App.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String dosage;

    @ManyToMany(mappedBy = "medicaments", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DossierMedical> dossierMedicalList;

    @ManyToMany(mappedBy = "medicaments",cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Medecin> medecins;

    @ManyToOne
    @JoinColumn(name = "hopital_id")
    private Hopital hopital;

}
