package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.CompteDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CompteValidateur {
    public static List<String> validate(CompteDto compteDto){
        List<String> erreurs = new ArrayList<>();

        if(compteDto == null){
            erreurs.add("L'email ne peut pas etre vide");
            erreurs.add("Vous devez renseigner un mot de passe");
            erreurs.add("Vous devez renseigner le username");


            return erreurs;
        }

        if (!StringUtils.hasLength(compteDto.getEmail()))
            erreurs.add("L'email ne peut pas etre vide");
        if (!StringUtils.hasLength(compteDto.getPassword()))
            erreurs.add("Vous devez renseigner un mot de passe");
        if (!StringUtils.hasLength(compteDto.getPassword()))
            erreurs.add("Vous devez renseigner le username");

        return erreurs;
    }
}
