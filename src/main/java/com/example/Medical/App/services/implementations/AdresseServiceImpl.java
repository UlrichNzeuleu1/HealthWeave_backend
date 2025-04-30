package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.AdresseDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.models.Adresse;
import com.example.Medical.App.repositories.AdresseRepository;
import com.example.Medical.App.services.interfaces.AdresseService;
import com.example.Medical.App.validateurs.AdresseValidateur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class AdresseServiceImpl implements AdresseService {

    private final AdresseRepository adresseRepository;

    @Autowired
    public AdresseServiceImpl(AdresseRepository adresseRepository) {
        this.adresseRepository = adresseRepository;
    }

    @Override
    public AdresseDto save(AdresseDto dto) {
        List<String> errors = AdresseValidateur.validate(dto);

        if (!errors.isEmpty()){
            log.error("L'adresse n'est pas valide {} ", dto);
            throw new InvalidEntityException("L'adresse n'est pas valide ", ErrorCodes.ADRESSE_NOT_VALIDE, errors);
        }
        return AdresseDto.fromEntity(adresseRepository.save(AdresseDto.toEntity(dto)));
    }

    @Override
    public AdresseDto findById(Long id) {
        if (id == null){
            log.error("L'id de l'addresse est null");
            return  null;
        }
        return adresseRepository.findById(id)
                .map(AdresseDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune adresse trouve avec l'id " +id+ "dans la base de donnnees", ErrorCodes.ADRESSE_NOT_FOUND));
    }

    @Override
    public List<AdresseDto> findAll(){
        return adresseRepository.findAll().stream()
                .map(AdresseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AdresseDto update(Long id, AdresseDto updatedAdresse) {

        AdresseDto adresseDto = adresseRepository.findById(id)
                .map(AdresseDto::fromEntity)
                .orElseThrow( ()-> new EntityNotFoundException("Aucune adresse trouivee avec l'id " +id));


        Adresse adresse = new Adresse();

        adresse.setPays(updatedAdresse.getPays());
        adresse.setNumeroMaison(updatedAdresse.getNumeroMaison());
        adresse.setVille(updatedAdresse.getVille());
        adresse.setStreet(updatedAdresse.getStreet());
        adresse.setZipCode(updatedAdresse.getZipCode());

        return AdresseDto.fromEntity(adresseRepository.save(AdresseDto.toEntity(adresseDto)));
    }

    @Override
    public void delete(Long id) {

        if (id == null){
            log.error("L'id de l'addresse est null");
        }
        adresseRepository.findById(id);
    }

}
