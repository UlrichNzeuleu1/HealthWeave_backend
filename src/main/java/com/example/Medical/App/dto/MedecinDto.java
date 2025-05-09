package com.example.Medical.App.dto;

import com.example.Medical.App.models.Adresse;
import com.example.Medical.App.models.Medecin;
import com.example.Medical.App.models.RendezVous;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MedecinDto {

    private Long id;
    private String specialite;
    private List<RendezVous> rendezVousList;
    private Adresse adresse;

    public static MedecinDto fromEntity(Medecin medecin){
        return MedecinDto.builder()
                .adresse(medecin.getAdresse())
                .specialite(medecin.getSpecialite())
                .rendezVousList(medecin.getRendezVousList())
                .build();
    }

    public static Medecin toEntity(MedecinDto dto){
        return Medecin.builder()
                .adresse(dto.getAdresse())
                .specialite(dto.getSpecialite())
                .rendezVousList(dto.getRendezVousList())
                .build();
    }
}
