package com.example.Medical.App.dto;

import com.example.Medical.App.models.Adresse;
import com.example.Medical.App.models.Hopital;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class HopitalDto {
    private Long id;
    private String nom;
    private String numeroTelephone;
    private Adresse adresse;


    public static HopitalDto fromEntity(Hopital hopital){
        return HopitalDto.builder()
                .id(hopital.getId())
                .nom(hopital.getNom())
                .adresse(hopital.getAdresse())
                .numeroTelephone(hopital.getNumeroTelephone())
                .build();
    }

    public static Hopital toEntity(HopitalDto dto){
        return Hopital.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .adresse(dto.getAdresse())
                .numeroTelephone(dto.getNumeroTelephone())
                .build();
    }
}
