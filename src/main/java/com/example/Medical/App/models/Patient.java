package com.example.Medical.App.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Le nom est obligatoire")
    private String nom;

    @NotBlank(message = "Le prénom est obligatoire")
    private String prenom;

    @Email(message = "Format d'email invalide")
    @NotBlank(message = "L'email est obligatoire")
    private String email;

    private String sexe;
    private String phone;
    private LocalDate dateDeNaissance;
    private String antecedentsMedicaux;
    private String address;
    private String bloodGroup;
    private String weight;
    private String photoUrl;  // On conserve uniquement le nom du fichier ou le chemin relatif de l'image

//    @ManyToOne
//    @JoinColumn(name = "adresse_id")
//    private Adresse adresse;
//
//    @ManyToOne
//    @JoinColumn(name = "assurance_id")
//    private Assurance assurance;
//
//    @ManyToOne
//    @JoinColumn(name = "medecin_id")
//    private Medecin medecin;

//    @OneToMany(mappedBy = "patient", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Facture> factures;

//    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<DossierMedical> dossierMedicalList;

//    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<RendezVous> rendezVousList;


}
