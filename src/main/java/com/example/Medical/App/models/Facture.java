package com.example.Medical.App.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double montant;
    private LocalDateTime dateEmission;
    private String statutPaiement;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

}
