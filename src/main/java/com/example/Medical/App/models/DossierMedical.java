package com.example.Medical.App.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class DossierMedical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String historiqueMedical;
    private String traitements;
    private String prescriptions;

//    @ManyToOne
//    @JoinColumn(name = "patient_id")
//    private Patient patient;
//
//    @ManyToOne
//    @JoinColumn(name = "medecin_id")
//    private Medecin medecin;
//
//    @ManyToMany

//    private List<Medicament> medicaments;
}
