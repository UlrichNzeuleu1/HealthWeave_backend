package com.example.Medical.App.dto;

import com.example.Medical.App.models.Adresse;
import com.example.Medical.App.models.Assurance;
import com.example.Medical.App.models.Patient;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PatientDto  {

    private Long id;
    private String antecedentsMedicaux;
    private String nom;
    private String prenom;
    private String phone;
    private String sexe;
    private LocalDate dateDeNaissance;
    private String address;
    private String email;
    private String bloodGroup;
    private String weight;

   // private Assurance assurance;


    public static PatientDto fromEntity(Patient patient){
        return PatientDto.builder()
                .id(patient.getId())
                .antecedentsMedicaux(patient.getAntecedentsMedicaux())
                .nom(patient.getNom())
                .prenom(patient.getPrenom())
                .phone(patient.getPhone())
                .sexe(patient.getSexe())
                .dateDeNaissance(patient.getDateDeNaissance())
                .address(patient.getAddress())
                .email(patient.getEmail())
                .weight(patient.getWeight())
                .bloodGroup(patient.getBloodGroup())

                .build();
    }

    public static Patient toEntity(PatientDto dto){
        return Patient.builder()
                .id(dto.getId())
                .antecedentsMedicaux(dto.getAntecedentsMedicaux())
              //.assurance(dto.getAssurance())
                .prenom(dto.getPrenom())
                .nom(dto.getNom())
                .phone((dto.getPhone()))
                .sexe(dto.getSexe())
                .dateDeNaissance(dto.getDateDeNaissance())
                .address(dto.getAddress())
                .weight(dto.getWeight())
                .bloodGroup(dto.getBloodGroup())
                .email(dto.getEmail())
                .build();
    }
}
