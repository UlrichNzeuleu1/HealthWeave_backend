package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.MedecinDto;

import java.util.ArrayList;
import java.util.List;

public class MedecinValidateur {

    public static List<String> validate(MedecinDto dto){

        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veuillez renseigner votre specialite");
            return erreurs;
        }

        return erreurs;
    }
}
