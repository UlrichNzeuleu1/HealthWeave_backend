package com.example.Medical.App.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer numeroMaison;
    private Integer zipCode;
    private String ville;
    private String pays;

    @OneToOne(mappedBy = "adresse", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Hopital hopital;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToMany(mappedBy = "adresse")
    private List<Medecin> medecins;

    @OneToMany(mappedBy = "adresse")
    private List<Patient> patients;

    @OneToMany(mappedBy = "adresse")
    private List<PersonnelAdministratif> personnelAdministratifs;

}
