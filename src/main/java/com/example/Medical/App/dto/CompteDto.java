package com.example.Medical.App.dto;

import com.example.Medical.App.models.Compte;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompteDto {

    private Long id;
    private String email;
    private String username;
    private String password;
    private LocalDate dateCreation;

    // Mapping from Entity ----> to Dto
    public static CompteDto fromEntity(Compte compte){
        return CompteDto.builder()
                .id(compte.getId())
                .email(compte.getEmail())
                .username(compte.getUsername())
                .password(compte.getPassword())
                .dateCreation(compte.getDateCreation())
                .build();
    }

    // Mapping from Dto ----> to Entity
    public static Compte toEntity(CompteDto dto){
        return Compte.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .dateCreation(dto.getDateCreation())
                .build();
    }

}
