package com.example.Medical.App.dto;

import com.example.Medical.App.models.Compte;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompteDto {

    private Long id;
    private String email;
    private String password;

    // Mapping from Entity ----> to Dto
    public static CompteDto fromEntity(Compte compte){
        return CompteDto.builder()
                .id(compte.getId())
                .email(compte.getEmail())
                .build();
    }

    // Mapping from Dto ----> to Entity
    public static Compte toEntity(CompteDto dto){
        return Compte.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .build();
    }

}
