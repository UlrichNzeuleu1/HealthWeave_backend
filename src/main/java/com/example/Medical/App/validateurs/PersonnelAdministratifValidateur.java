package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.PersonnelAdministratifDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PersonnelAdministratifValidateur {
    public static List<String> validate(PersonnelAdministratifDto dto){

        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veuillez renseigner votre role");
            erreurs.add("Veuillez renseigner votre adresse");
            erreurs.add("Veuillez renseigner votre telephone");
            erreurs.add("Veuillez renseigner votre nom");
            erreurs.add("Veuillez renseigner votre prenom");
            return erreurs;
        }

        if (!StringUtils.hasLength(dto.getTelephone()))
            erreurs.add("Veuillez renseigner votre telephone");
        if (!StringUtils.hasLength(dto.getAdresse()))
            erreurs.add("Veuillez renseigner votre adresse");
        if (!StringUtils.hasLength(dto.getRole()))
            erreurs.add("Veuillez renseigner votre role ");
        if (!StringUtils.hasLength(dto.getNom()))
            erreurs.add("Veuillez renseigner votre nom ");
        if (!StringUtils.hasLength(dto.getPrenom()))
            erreurs.add("Veuillez renseigner votre prenom");

        return erreurs;
    }
}
