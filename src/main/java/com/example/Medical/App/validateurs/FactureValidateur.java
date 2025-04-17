package com.example.Medical.App.validateurs;

import com.example.Medical.App.dto.FactureDto;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.ObjectUtils.isEmpty;

public class FactureValidateur {

    public static List<String> validate(FactureDto factureDto){
        List<String> erreurs = new ArrayList<>();

        if (factureDto == null){
            erreurs.add("Veuillez renseigner le montant");
            erreurs.add("Veuillez renseigner la date d'emission");
            erreurs.add("Veuillez renseigner le statut du paiement");

            return erreurs;
        }

        if (factureDto.getMontant() == 0 || isEmpty(factureDto.getMontant()))
            erreurs.add("Veuillez renseigner le montant");
        if (factureDto.getDateEmission() == null)
            erreurs.add("Veuillez renseigner la date d'emission");
        if (!StringUtils.hasLength(factureDto.getStatutPaiement()))
            erreurs.add("Veuillez renseigner le statut du paiement");

        return erreurs;
    }
}
