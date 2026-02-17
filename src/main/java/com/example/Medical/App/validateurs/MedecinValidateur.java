package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.MedecinDto;
import jakarta.persistence.Column;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MedecinValidateur {

    public static List<String> validate(MedecinDto dto){

        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veuillez renseigner votre specialite");
            erreurs.add("Veuillez renseigner votre nom");
            erreurs.add("Veuillez renseigner votre prenom");
            erreurs.add("Veuillez renseigner votre sexe");
            erreurs.add("Veuillez renseigner votre date de naissance");
            erreurs.add("Veuillez renseigner votre email");
            return erreurs;
        }

        if(!StringUtils.hasLength(dto.getSpecialite()))
            erreurs.add("Veuillez renseigner votre specialite");
        if(!StringUtils.hasLength(dto.getNom()))
            erreurs.add("Veuillez renseigner votre nom");
        if(!StringUtils.hasLength(dto.getPrenom()))
            erreurs.add("Veuillez renseigner votre prenom");
        if(!StringUtils.hasLength(dto.getSexe()))
            erreurs.add("Veuillez renseigner votre sexe");
        if (dto.getDateDeNaissance() == null) {
            erreurs.add("Veuillez renseigner votre date de naissance");
        } else if (dto.getDateDeNaissance().isAfter(LocalDate.now())) {
            erreurs.add("La date de naissance ne peut pas être dans le futur");
        }
        if(!StringUtils.hasLength(dto.getEmail()))
            erreurs.add("Veuillez renseigner votre email");

        return erreurs;
    }
}
