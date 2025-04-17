package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.DossierMedicalDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DossierMedicalValidateur {

    public static List<String> validate(DossierMedicalDto dto){

        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veuillez renseigner l'historique medical");
            erreurs.add("Veillez renseigner le champ traitements");
            erreurs.add("Veuillez reneigner le champs prescriptions");

            return erreurs;
        }

        if (!StringUtils.hasLength(dto.getHistoriqueMedical()))
            erreurs.add("Veuillez renseigner l'historique medical");

    return erreurs;
    }
}
