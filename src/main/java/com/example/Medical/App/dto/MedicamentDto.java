package com.example.Medical.App.dto;

import com.example.Medical.App.models.Medicament;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentDto {

    private Long id;
    private String nom;
    private String dosage;
    private String datePeremption;

    public static MedicamentDto fromEntity(Medicament medicament){
        return MedicamentDto.builder()
                .id(medicament.getId())
                .nom(medicament.getNom())
                .datePeremption(medicament.getDatePeremption())
                .dosage(medicament.getDosage())
                .build();
    }
    public static Medicament toEntity(MedicamentDto  dto){
        return Medicament.builder()
                .id(dto.getId())
                .dosage(dto.getDosage())
                .nom(dto.getNom())
                .datePeremption(dto.getDatePeremption())
                .build();
    }
}
