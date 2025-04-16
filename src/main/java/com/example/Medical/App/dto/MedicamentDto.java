package com.example.Medical.App.dto;

import com.example.Medical.App.models.Medicament;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class MedicamentDto {

    private Long id;
    private String nom;
    private String dosage;

    public static MedicamentDto fromEntity(Medicament medicament){
        return MedicamentDto.builder()
                .id(medicament.getId())
                .nom(medicament.getNom())
                .dosage(medicament.getDosage())
                .build();
    }
    public static Medicament toEntity(MedicamentDto  dto){
        return Medicament.builder()
                .id(dto.getId())
                .dosage(dto.getDosage())
                .nom(dto.getNom())
                .build();
    }
}
