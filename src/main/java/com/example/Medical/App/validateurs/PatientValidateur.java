package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.MedecinDto;
import com.example.Medical.App.dto.PatientDto;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PatientValidateur {
    public static List<String> validate(PatientDto dto){

        List<String> erreurs = new ArrayList<>();


        if (dto == null){
            erreurs.add("Veuillez renseigner vos antecedents medidaux");
            erreurs.add("Veuillez renseigner votre nom");
            erreurs.add("Veuillez renseigner votre prenom");
            erreurs.add("Veuillez renseigner votre numero de telephone");
            erreurs.add("Veuillez renseigner le sexe");
            erreurs.add("Veuillez renseigner votre date de naissance");
            erreurs.add("Veuillez renseigner le poids");
            erreurs.add("Veuillez renseigner l'email");
            erreurs.add("Veuillez renseigner le groupe sanguin");
            erreurs.add("Veuillez renseigner le adresse");

            return erreurs;
        }

        if (!StringUtils.hasLength(dto.getAntecedentsMedicaux()))
            erreurs.add("Veuillez renseigner vos antecedents medidaux");
        if (!StringUtils.hasLength(dto.getNom()))
            erreurs.add("Veuillez renseigner votre nom");
        if (!StringUtils.hasLength(dto.getPrenom()))
            erreurs.add("Veuillez renseigner votre prenom");
        if (!StringUtils.hasLength(dto.getPhone()))
            erreurs.add("Veuillez renseigner votre numero de telephone");
        if (!StringUtils.hasLength(dto.getSexe()))
            erreurs.add("Veuillez renseigner le sexe");
        if (dto.getDateDeNaissance() == null)
            erreurs.add("Veuillez renseigner votre date de naissance");
        if (!StringUtils.hasLength(dto.getWeight()))
            erreurs.add("Veuillez renseigner le poids");
        if (!StringUtils.hasLength(dto.getEmail()))
            erreurs.add("Veuillez renseigner l'email");
        if (!StringUtils.hasLength(dto.getBloodGroup()))
            erreurs.add("Veuillez renseigner le groupe sanguin");
        if (!StringUtils.hasLength(dto.getAddress()))
            erreurs.add("Veuillez renseigner le adresse");

        return erreurs;

    }
}
