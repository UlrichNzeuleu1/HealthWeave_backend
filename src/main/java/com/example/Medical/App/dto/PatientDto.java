package com.example.Medical.App.dto;

import com.example.Medical.App.models.Adresse;
import com.example.Medical.App.models.Assurance;
import com.example.Medical.App.models.Patient;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PatientDto {

    private Long id;
    private String antecedentsMedicaux;
    private String nom;
    private String prenom;
    private String sexe;
    private LocalDate dateDeNaissance;
   // private Assurance assurance;


    public static PatientDto fromEntity(Patient patient){
        return PatientDto.builder()
                .id(patient.getId())
                .antecedentsMedicaux(patient.getAntecedentsMedicaux())
                .nom(patient.getNom())
                .prenom(patient.getPrenom())
                .sexe(patient.getSexe())
                .dateDeNaissance(patient.getDateDeNaissance())

                .build();
    }

    public static Patient toEntity(PatientDto dto){
        return Patient.builder()
                .id(dto.getId())
                .antecedentsMedicaux(dto.getAntecedentsMedicaux())
              //.assurance(dto.getAssurance())
                .prenom(dto.getPrenom())
                .nom(dto.getNom())
                .sexe(dto.getSexe())
                .dateDeNaissance(dto.getDateDeNaissance())
                .build();
    }
}
