package com.example.Medical.App.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Hopital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String numeroTelephone;

    @OneToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @OneToMany(mappedBy = "hopital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Medecin> medecins;

    @OneToMany(mappedBy = "hopital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RendezVous> rendezVousList;

    @OneToMany(mappedBy = "hopital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PersonnelAdministratif> personnelAdministratifs;

    @OneToMany(mappedBy = "hopital", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Medicament> medicaments;
}
