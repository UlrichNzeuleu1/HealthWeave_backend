package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.PersonnelAdministratifDto;

import java.util.ArrayList;
import java.util.List;

public class PersonnelAdministratifValidateur {
    public static List<String> validate(PersonnelAdministratifDto dto){

        List<String> erreurs = new ArrayList<>();

        if (dto == null){
            erreurs.add("Veuillez renseigner votre role");
            return erreurs;
        }
        return erreurs;
    }
}
