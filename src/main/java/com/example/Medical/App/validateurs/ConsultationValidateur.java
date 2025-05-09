package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.ConsultationDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsultationValidateur {

    public static List<String> validate(ConsultationDto dto){
        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veuillez renseignez le type de consultation");
            erreurs.add("Veuillez renseignez la date de consultation");
            erreurs.add("Veuillez renseignez l'heure");
            erreurs.add("Veuillez renseignez le statut");

            return erreurs;
        }

        if (!StringUtils.hasLength(dto.getType()))
            erreurs.add("Veuillez renseignez le type de consultation");
        if (dto.getDate() == null)
            erreurs.add("Veuillez renseignez la date de consultation");
        if (!StringUtils.hasLength(dto.getHeure()))
            erreurs.add("Veuillez renseignez l'heure");
        if (!StringUtils.hasLength(dto.getStatut()))
            erreurs.add("Veuillez renseignez le statut");

        return erreurs;
    }
}
