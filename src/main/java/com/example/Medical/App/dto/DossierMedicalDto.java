package com.example.Medical.App.dto;

import com.example.Medical.App.models.DossierMedical;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class DossierMedicalDto {

    private Long id;
    private String historiqueMedical;
    private List<String> traitements;
    private List<String> prescriptions;

    // Mapping from Dto ----> to Entity
    public static DossierMedicalDto fromEntity(DossierMedical dossierMedical){
        return DossierMedicalDto.builder()
                .id(dossierMedical.getId())
                .historiqueMedical(dossierMedical.getHistoriqueMedical())
                .prescriptions(dossierMedical.getPrescriptions())
                .traitements(dossierMedical.getTraitements())
                .build();
    }

    // Mapping from Entity ---->> to Dto
    public static DossierMedical toEntity(DossierMedicalDto dto){
        return DossierMedical.builder()
                .id(dto.getId())
                .historiqueMedical(dto.getHistoriqueMedical())
                .traitements(dto.getTraitements())
                .prescriptions(dto.getPrescriptions())
                .build();
    }
}
