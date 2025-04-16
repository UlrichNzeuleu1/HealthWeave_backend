package com.example.Medical.App.dto;

import com.example.Medical.App.models.Facture;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class FactureDto {

    private Long id;
    private double montant;
    private LocalDateTime dateEmission;
    private String statutPaiement;

    // Mapping entity ----> to Dto
    public static FactureDto toEntity(FactureDto dto){
        return FactureDto.builder()
                .id(dto.getId())
                .dateEmission(dto.getDateEmission())
                .montant(dto.getMontant())
                .statutPaiement(dto.getStatutPaiement())
                .build();
    }

    // Mapping from Dto ----> to Entity
    public static Facture fromEntity(Facture facture){
        return Facture.builder()
                .id(facture.getId())
                .dateEmission(facture.getDateEmission())
                .montant(facture.getMontant())
                .statutPaiement(facture.getStatutPaiement())
                .build();
    }


}
