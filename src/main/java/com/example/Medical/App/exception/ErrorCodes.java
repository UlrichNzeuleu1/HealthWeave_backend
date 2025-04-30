package com.example.Medical.App.exception;

public enum ErrorCodes {

    ADRESSE_NOT_FOUND(1000),
    ADRESSE_NOT_VALIDE(1001),
    //TODO complete the rest of error code

    ASSURANCE_NOT_FOUND(2000),
    ASSURANCE_NOT_VALID(2001),
    //TODO complete the rest of error code

    COMPTE_NOT_FOUND(3000),
    COMPTE_NOT_VALID(3001),
    //TODO complete the rest of error code

    CONSULTATION_NOT_FOUND(4000),
    CONSULTATION_NOT_VALID(4001),
    //TODO complete the rest of error code

    DOSSIER_MEDICAL_NOT_FOUND(5000),
    DOSSIER_MEDICAL_NOT_VALID(5001),
    //TODO complete the rest of error code

    FACTURE_NOT_FOUND(6000),
    FACTURE_NOT_VALID(6001),
    //TODO complete the rest of error code

    HOPITAL_NOT_FOUND(7000),
    HOPITAL_NOT_VALID(7001),
    //TODO complete the rest of error code

    MEDECIN_NOT_FOUND(8000),
    MEDECIN_NOT_VALID(8001),
    //TODO complete the rest of error code

    MEDICAMENT_NOT_FOUND(9000),
    MEDICAMENT_NOT_VALID(9001),
    //TODO complete the rest of error code

    PATIENT_NOT_FOUND(10000),
    PATIENT_NOT_VALID(10001),
    //TODO complete the rest of error code

    PERSONNEL_ADMINISTRATIF_NOT_FOUND(11000),
    PERSONNEL_ADMINISTRATIF_NOT_VALID(11001),
    //TODO complete the rest of error code

    RENDEZ_VOUS_NOT_FOUND(12000),
    RENDEZ_VOUS_NOT_VALID(12001),
    //TODO complete the rest of error code

    UTILISATEUR_NOT_FOUND(13000),
    UTILISATEUR_NOT_VALID(13001);
    //TODO complete the rest of error code


    private int code;
    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
