package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.MedecinDto;
import com.example.Medical.App.dto.PatientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class PatientValidateur {
    public static List<String> validate(PatientDto dto){

        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veuillez renseigner vos antecedents medidaux");
            erreurs.add("Veuillez renseigner vos allergies");
            return erreurs;
        }

        if (!StringUtils.hasLength(dto.getAntecedentsMedicaux()))
            erreurs.add("Veuillez renseigner vos antecedents medidaux");
        if (!StringUtils.hasLength(dto.getAllergies()))
            erreurs.add("Veuillez renseigner vos allergies");

        return erreurs;
    }
}
