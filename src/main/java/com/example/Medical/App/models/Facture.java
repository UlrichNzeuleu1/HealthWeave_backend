package com.example.Medical.App.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Builder
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montant;
    private LocalDate dateEmission;
    private String statutPaiement;

//    @ManyToOne
//    @JoinColumn(name = "patient_id")
//    private Patient patient;

}
