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
public class Patient extends Utilisateur{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String antecedentsMedicaux;
    private String allergies;

    @ManyToOne
    @JoinColumn(name = "adresse_id")
    private Adresse adresse;

    @ManyToOne
    @JoinColumn(name = "assurance_id")
    private Assurance assurance;

    @ManyToOne
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @OneToMany(mappedBy = "patient", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Facture> factures;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DossierMedical> dossierMedicalList;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RendezVous> rendezVousList;


}
