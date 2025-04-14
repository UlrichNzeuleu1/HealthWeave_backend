package com.example.Medical.App.dto;

import com.example.Medical.App.models.Adresse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class AdresseDto {

    private Long id;
    private String street;
    private Integer numeroMaison;
    private Integer zipCode;
    private String ville;
    private String pays;


    // Mapping from Entity ----> to Dto

    public  static AdresseDto fromEntity(Adresse adresse){
        return AdresseDto.builder()
                .id(adresse.getId())
                .pays(adresse.getPays())
                .numeroMaison(adresse.getNumeroMaison())
                .street(adresse.getStreet())
                .ville(adresse.getVille())
                .zipCode(adresse.getZipCode())
                .build();
    }

    // Mapping from Dto ----> to Entity

    public static Adresse toEntity(AdresseDto adresseDto){
         return Adresse.builder()
                 .id(adresseDto.getId())
                 .pays(adresseDto.getPays())
                 .street(adresseDto.getStreet())
                 .ville(adresseDto.getVille())
                 .zipCode(adresseDto.getZipCode())
                 .numeroMaison(adresseDto.getNumeroMaison())
                 .build();
    }

}
