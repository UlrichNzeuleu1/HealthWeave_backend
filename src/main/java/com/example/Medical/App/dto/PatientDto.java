package com.example.Medical.App.dto;

import com.example.Medical.App.models.Adresse;
import com.example.Medical.App.models.Assurance;
import com.example.Medical.App.models.Patient;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private String antecedentsMedicaux;
    private String allergies;
    private Adresse adresse;
    private Assurance assurance;


    public static PatientDto fromEntity(Patient patient){
        return PatientDto.builder()
                .adresse(patient.getAdresse())
                .antecedentsMedicaux(patient.getAntecedentsMedicaux())
                .assurance(patient.getAssurance())
                .allergies(patient.getAllergies())
                .build();
    }

    public static Patient toEntity(PatientDto dto){
        return Patient.builder()
                .adresse(dto.getAdresse())
                .antecedentsMedicaux(dto.getAntecedentsMedicaux())
                .assurance(dto.getAssurance())
                .allergies(dto.getAllergies())
                .build();
    }
}
