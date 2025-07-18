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
    private String allergies;
    private String adressePatient;
    private String nom;
    private String prenom;
    private String sexe;
    private LocalDate dateDeNaissance;
   // private Assurance assurance;


    public static PatientDto fromEntity(Patient patient){
        return PatientDto.builder()
                .adressePatient(patient.getAdressePatient())
                .antecedentsMedicaux(patient.getAntecedentsMedicaux())
                .allergies(patient.getAllergies())
                .nom(patient.getNom())
                .prenom(patient.getPrenom())
                .sexe(patient.getSexe())
                .adressePatient(patient.getAdressePatient())
                .dateDeNaissance(patient.getDateDeNaissance())

                .build();
    }

    public static Patient toEntity(PatientDto dto){
        return Patient.builder()
                .adressePatient(dto.getAdressePatient())
                .antecedentsMedicaux(dto.getAntecedentsMedicaux())
              //  .assurance(dto.getAssurance())
                .allergies(dto.getAllergies())
                .prenom(dto.getPrenom())
                .nom(dto.getNom())
                .sexe(dto.getSexe())
                .dateDeNaissance(dto.getDateDeNaissance())
                .build();
    }
}
