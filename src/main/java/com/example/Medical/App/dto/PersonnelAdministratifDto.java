package com.example.Medical.App.dto;

import com.example.Medical.App.models.Adresse;
import com.example.Medical.App.models.PersonnelAdministratif;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonnelAdministratifDto {

    private Long id;
    private String adresse;
    private String role;
    private String nom;
    private String prenom;
    private String telephone;

    public static PersonnelAdministratifDto fromEntity(PersonnelAdministratif personnelAdministratif){
        return PersonnelAdministratifDto.builder()
                .id(personnelAdministratif.getId())
                .nom(personnelAdministratif.getNom())
                .prenom(personnelAdministratif.getPrenom())
                .adresse(personnelAdministratif.getAdresse())
                .role(personnelAdministratif.getRole())
                .telephone(personnelAdministratif.getTelephone())
                .build();
    }

    public static PersonnelAdministratif toEntity(PersonnelAdministratifDto dto){
        return PersonnelAdministratif.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .adresse(dto.getAdresse())
                .role(dto.getRole())
                .telephone(dto.getTelephone())
                .build();
    }
}
