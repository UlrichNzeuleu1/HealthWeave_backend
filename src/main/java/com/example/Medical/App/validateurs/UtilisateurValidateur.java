package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidateur {

    public static List<String> validate(UtilisateurDto dto){

        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veuillez renseigner le nom");
            erreurs.add("Veuillez renseigner le prenom");
            erreurs.add("Veuillez renseigner le sexe");
            erreurs.add("Veuillez renseigner la date de naissance");
            erreurs.add("Veuillez renseigner le type d'utilisateur");

            return erreurs;
        }

        if (!StringUtils.hasLength(dto.getNom()))
            erreurs.add("Veuillez renseigner le nom");
        if (!StringUtils.hasLength(dto.getPrenom()))
            erreurs.add("Veuillez renseigner le prenom");
        if (!StringUtils.hasLength(dto.getSexe()))
            erreurs.add("Veuillez renseigner le sexe");
        if (dto.getDateDeNaissance() == null)
            erreurs.add("Veuillez renseigner la date de naissance");
        if (!StringUtils.hasLength(dto.getTypeUtilisateur()))
            erreurs.add("Veuillez renseigner le type d'utilisateur");

        return erreurs;
    }
}
