package com.example.Medical.App.dto;

import com.example.Medical.App.models.Adresse;
import com.example.Medical.App.models.PersonnelAdministratif;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PersonnelAdministratifDto {

    private Adresse adresse;
    private String role;

    public static PersonnelAdministratifDto fromEntity(PersonnelAdministratif personnelAdministratif){
        return PersonnelAdministratifDto.builder()
                .adresse(personnelAdministratif.getAdresse())
                .role(personnelAdministratif.getRole())
                .build();
    }

    public static PersonnelAdministratif toEntity(PersonnelAdministratifDto dto){
        return PersonnelAdministratif.builder()
                .adresse(dto.getAdresse())
                .role(dto.getRole())
                .build();
    }
}
