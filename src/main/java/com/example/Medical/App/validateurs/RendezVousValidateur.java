package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.RendezVousDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class RendezVousValidateur {
    public static List<String> validate(RendezVousDto dto){

        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veuillez renseigner la date du rendez-vous");
            erreurs.add("Veuillez renseigner l'heure' du rendez-vous");
            erreurs.add("Veuillez renseigner le statut du rendez-vous");
            erreurs.add("Veuillez renseigner le nom du patient qui souhaite un rendez-vous");
            erreurs.add("Veuillez renseigner le prenom du patient qui souhaite un rendez-vous");
            erreurs.add("Veuillez renseigner le medecin dont vous souhaitez rencontrer");

            return erreurs;
        }

        if (dto.getDateRendezVous() == null)
            erreurs.add("Veuillez renseigner la date du rendez-vous");

        if (!StringUtils.hasLength(dto.getHeure()))
            erreurs.add("Veuillez renseigner l'heure' du rendez-vous");

        if (!StringUtils.hasLength(dto.getStatut()))
            erreurs.add("Veuillez renseigner le statut du rendez-vous");

        if (!StringUtils.hasLength(dto.getNomPatient()))
            erreurs.add("Veuillez renseigner le nom du patient qui souhaite un rendez-vous");

        if (!StringUtils.hasLength(dto.getPrenomPatient()))
            erreurs.add("Veuillez renseigner le prenom du patient qui souhaite un rendez-vous");

        if (!StringUtils.hasLength(dto.getMedecinSouhaite()))
            erreurs.add("Veuillez renseigner le medecin dont vous souhaitez rencontrer");

        return erreurs;
    }
}
