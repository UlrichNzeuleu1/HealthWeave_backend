package com.example.Medical.App.dto;

import com.example.Medical.App.models.Assurance;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AssuranceDto {

    private Integer id;
    private String nomAssureur;
    private String numeroPolice;
    private String typeCouverture;

    // Mapping from Entity ----> to Dto

    public static AssuranceDto fromEntity(Assurance assurance){
        return AssuranceDto.builder()
                .id(assurance.getId())
                .nomAssureur(assurance.getNomAssureur())
                .numeroPolice(assurance.getNumeroPolice())
                .typeCouverture(assurance.getTypeCouverture())
                .build();
    }

    // Mapping from Dto ----> to Entity

    public static Assurance toEntity(AssuranceDto dto){
        return Assurance.builder()
                .id(dto.getId())
                .nomAssureur(dto.getNomAssureur())
                .numeroPolice(dto.getNumeroPolice())
                .typeCouverture(dto.getTypeCouverture())
                .build();
    }
}
