package com.example.Medical.App.dto;

import com.example.Medical.App.models.Assurance;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssuranceDto {

    private Long id;
    private String nom;
    private String numeroPolice;
    private String typeCouverture;


    // Mapping from Entity ----> to Dto

    public static AssuranceDto fromEntity(Assurance assurance){
        return AssuranceDto.builder()
                .id(assurance.getId())
                .nom(assurance.getNom())
                .numeroPolice(assurance.getNumeroPolice())
                .typeCouverture(assurance.getTypeCouverture())
                .build();
    }

    // Mapping from Dto ----> to Entity

    public static Assurance toEntity(AssuranceDto dto){
        return Assurance.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .numeroPolice(dto.getNumeroPolice())
                .typeCouverture(dto.getTypeCouverture())
                .build();
    }
}
