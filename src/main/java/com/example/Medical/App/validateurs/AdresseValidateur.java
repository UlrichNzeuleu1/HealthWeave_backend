package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.AdresseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class AdresseValidateur {
    public static List<String> validate(AdresseDto adresseDto){

        List<String> erreurs = new ArrayList<>();

        if (adresseDto == null){
            erreurs.add("Veillez renseigner la rue svp");
            erreurs.add("Veillez renseigner le numero de maison svp");
            erreurs.add("Veillez renseigner le zipCode svp");
            erreurs.add("Veillez renseigner la ville svp");
            erreurs.add("Veuillez renseigner le pays svp");

            return erreurs;
        }

        if (!StringUtils.hasLength(adresseDto.getStreet()))
            erreurs.add("Veillez renseigner la rue svp");
        if (adresseDto.getNumeroMaison() == null)
            erreurs.add("Veillez renseigner le numero de maison svp");
        if (adresseDto.getZipCode() == null)
            erreurs.add("Veillez renseigner le zipCode svp");
        if (!StringUtils.hasLength(adresseDto.getVille()))
            erreurs.add("Veillez renseigner la ville svp");
        if (!StringUtils.hasLength(adresseDto.getPays()))
            erreurs.add("Veuillez renseigner le pays svp");

        return erreurs;
    }
}
