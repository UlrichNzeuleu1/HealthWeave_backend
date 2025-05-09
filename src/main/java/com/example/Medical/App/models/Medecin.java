package com.example.Medical.App.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@SuperBuilder

public class Medecin extends Utilisateur{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String specialite;

    @OneToOne
    @JoinColumn(name = "compte_id")
    private Compte compte;

    @ManyToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DossierMedical> dossierMedicalList;

    @ManyToOne
    @JoinColumn(name = "hopital_id")
    private Hopital hopital;


    @OneToMany(mappedBy = "medecin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RendezVous> rendezVousList;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "medecin_medicament",
            joinColumns = @JoinColumn(name = "medecin_id"),
            inverseJoinColumns = @JoinColumn(name = "medicament_id")
    )
    private List<Medicament> medicaments;

}
