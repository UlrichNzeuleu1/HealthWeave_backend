package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.HopitalDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.models.Hopital;
import com.example.Medical.App.repositories.HopitalRepository;
import com.example.Medical.App.services.interfaces.HopitalService;
import com.example.Medical.App.validateurs.HopitalValidateur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class HopitalServiceImpl implements HopitalService {

    private final HopitalRepository hopitalRepository;

    @Autowired
    public HopitalServiceImpl(HopitalRepository hopitalRepository) {
        this.hopitalRepository = hopitalRepository;
    }

    @Override
    public HopitalDto save(HopitalDto hopitalDto) {
        List<String> errors = HopitalValidateur.validate(hopitalDto);

        if (!errors.isEmpty()){
            log.error("Hopital is not valid {}",hopitalDto);
            throw new InvalidEntityException("L'hopital n'est pas valide ", ErrorCodes.HOPITAL_NOT_VALID,errors);
        }
        return HopitalDto.fromEntity(hopitalRepository.save(HopitalDto.toEntity(hopitalDto)));
    }

    @Override
    public HopitalDto findById(Long id) {

        if (id == null){
            log.error("ID is null");
            return null;
        }
        return hopitalRepository.findById(id)
                .map(HopitalDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun hopital trouve avec l'id "+id+" dans la base de donnees", ErrorCodes.HOPITAL_NOT_FOUND));
    }

    @Override
    public HopitalDto findByNom(String nom) {

        if (!StringUtils.hasLength(nom)){
            log.error("Hopital name is null");
            return null;
        }
        return hopitalRepository.findByNom(nom)
                .map(HopitalDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun hopital trouve avec le nom "+nom+" dans la base de donnees", ErrorCodes.HOPITAL_NOT_FOUND));
    }

    @Override
    public List<HopitalDto> findAll() {
        return hopitalRepository.findAll()
                .stream()
                .map(HopitalDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public HopitalDto update(Long id, HopitalDto updatedHopitalDto) {

        HopitalDto dto = hopitalRepository.findById(id)
                .map(HopitalDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun hopital trouve avec l'id " +id+" en bdd",ErrorCodes.HOPITAL_NOT_FOUND));

        HopitalDto hopitalToUpdate = new HopitalDto();

        hopitalToUpdate.setAdresse(updatedHopitalDto.getAdresse());
        hopitalToUpdate.setNom(updatedHopitalDto.getNom());
        hopitalToUpdate.setNumeroTelephone(updatedHopitalDto.getNumeroTelephone());

        return HopitalDto.fromEntity(hopitalRepository.save(HopitalDto.toEntity(hopitalToUpdate)));
    }

    @Override
    public void delete(Long id) {

    }
}
