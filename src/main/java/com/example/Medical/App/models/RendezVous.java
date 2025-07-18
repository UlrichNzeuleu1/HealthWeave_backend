package com.example.Medical.App.models;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateRendezVous;
    private String heure;
    private String statut;
    private String medecinSouhaite;
    private String nomPatient;
    private String prenomPatient;


//    @ManyToOne
//    @JoinColumn(name = "consultation_id")
//    private Consultation consultation;

//    @ManyToOne
//    @JoinColumn(name = "hopital_id")
//    private Hopital hopital;

//    @ManyToOne
//    @JoinColumn(name = "medecin_id")
//    private Medecin medecin;
//
//    @ManyToOne
//    @JoinColumn(name = "patient_id")
//    private Patient patient;

}
