package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.MedecinDto;
import com.example.Medical.App.dto.MedicamentDto;
import com.example.Medical.App.models.Medicament;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MedicamentValidateur {

    public static List<String> validate(MedicamentDto dto){

        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veuillez renseigner le nom");
            erreurs.add("Veuillez renseigner le dosage");
            erreurs.add("Veuillez renseigner la date de peremption");

            return erreurs;
        }
        if (!StringUtils.hasLength(dto.getNom()))
            erreurs.add("Veuillez renseigner le nom");
        if (!StringUtils.hasLength(dto.getDosage()))
            erreurs.add("Veuillez renseigner le dosage");
        if (!StringUtils.hasLength(dto.getDosage()))
            erreurs.add("Veuillez renseigner la date de peremption");


        return erreurs;
    }
}
