package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.AssuranceDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AssuranceValidateur {

    public static List<String> validate(AssuranceDto assuranceDto){
        List<String> erreurs = new ArrayList<>();

        if (assuranceDto == null){
            erreurs.add("Veuillez renseigner le nom de l'assureur");
            erreurs.add("Veuillez renseigner le numero de police");
            erreurs.add("Veuillez renseigner le type de couverture");

            return erreurs;
        }

        if (!StringUtils.hasLength(assuranceDto.getNomAssureur()))
            erreurs.add("Veuillez renseigner le nom de l'assureur");
        if (!StringUtils.hasLength(assuranceDto.getNumeroPolice()))
            erreurs.add("Veuillez renseigner le numero de police");
        if (!StringUtils.hasLength(assuranceDto.getTypeCouverture()))
            erreurs.add("Veuillez renseigner le type de couverture");

        return erreurs;
    }
}
