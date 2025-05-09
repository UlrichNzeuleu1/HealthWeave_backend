package com.example.Medical.App.dto;

import com.example.Medical.App.models.Facture;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FactureDto {

    private Long id;
    private double montant;
    private LocalDate dateEmission;
    private String statutPaiement;

    // Mapping entity ----> to Dto
    public static Facture toEntity(FactureDto dto){
        return Facture.builder()
                .id(dto.getId())
                .dateEmission(dto.getDateEmission())
                .montant(dto.getMontant())
                .statutPaiement(dto.getStatutPaiement())
                .build();
    }

    // Mapping from Dto ----> to Entity
    public static FactureDto fromEntity(Facture facture){
        return FactureDto.builder()
                .id(facture.getId())
                .dateEmission(facture.getDateEmission())
                .montant(facture.getMontant())
                .statutPaiement(facture.getStatutPaiement())
                .build();
    }


}
