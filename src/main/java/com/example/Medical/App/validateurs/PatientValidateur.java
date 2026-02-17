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
            erreurs.add("Veuillez renseigner le sexe");
            erreurs.add("Veuillez renseigner votre date de naissance");
            return erreurs;
        }

        if (!StringUtils.hasLength(dto.getAntecedentsMedicaux()))
            erreurs.add("Veuillez renseigner vos antecedents medidaux");
        if (!StringUtils.hasLength(dto.getNom()))
            erreurs.add("Veuillez renseigner votre nom");
        if (!StringUtils.hasLength(dto.getPrenom()))
            erreurs.add("Veuillez renseigner votre prenom");
        if (!StringUtils.hasLength(dto.getSexe()))
            erreurs.add("Veuillez renseigner le sexe");
        if (dto.getDateDeNaissance() == null)
            erreurs.add("Veuillez renseigner votre date de naissance");

        return erreurs;

    }
}
