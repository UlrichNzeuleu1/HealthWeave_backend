package com.example.Medical.App.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class Adresse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String street;
    private Integer numeroMaison;
    private Integer zipCode;
    private String ville;
    private String pays;

    private List<Hopital> hopitals;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @OneToOne
    @JoinColumn(name = "hopital_id")
    private Hopital hopital;

    @OneToMany(mappedBy = "adresse")
    private List<Medecin> medecins;

    @OneToMany(mappedBy = "adresse")
    private List<Patient> patients;

    @OneToMany(mappedBy = "adresse")
    private List<PersonnelAdministratif> personnelAdministratifs;

}
