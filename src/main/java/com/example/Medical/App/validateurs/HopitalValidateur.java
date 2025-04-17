package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.HopitalDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class HopitalValidateur {

    public static List<String> validate(HopitalDto dto){
        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veuillez renseigner le nom");
            erreurs.add("Veuillez renseigner le numero de telephone");

            return erreurs;
        }

        if (!StringUtils.hasLength(dto.getNom()))
            erreurs.add("Veuillez renseigner le nom");
        if (!StringUtils.hasLength(dto.getNumeroTelephone()))
            erreurs.add("Veuillez renseigner le numero de telephone");

        return erreurs;
    }
}
