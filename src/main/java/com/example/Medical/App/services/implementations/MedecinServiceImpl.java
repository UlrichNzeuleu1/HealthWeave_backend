package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.HopitalDto;
import com.example.Medical.App.dto.MedecinDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.repositories.MedecinRepository;
import com.example.Medical.App.services.interfaces.MedecinService;
import com.example.Medical.App.validateurs.MedecinValidateur;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MedecinServiceImpl implements MedecinService {

    private final MedecinRepository medecinRepository;

    @Autowired
    public MedecinServiceImpl(MedecinRepository medecinRepository) {
        this.medecinRepository = medecinRepository;
    }

    @Override
    public MedecinDto save(MedecinDto medecinDto) {

        List<String> errors = MedecinValidateur.validate(medecinDto);

        if(!errors.isEmpty()){
            log.error("Medecin is not valid {} ",medecinDto);
            throw new InvalidEntityException("L'entite medecin n'est pas valide ", ErrorCodes.MEDECIN_NOT_VALID,errors);
        }
        return MedecinDto.fromEntity(medecinRepository.save(MedecinDto.toEntity(medecinDto)));
    }

    @Override
    public MedecinDto findById(Long id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }
        return medecinRepository.findById(id)
                .map(MedecinDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun medecin trouve avec l'id "+id+" dans la bdd", ErrorCodes.MEDECIN_NOT_FOUND));
    }

    @Override
    public MedecinDto findByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("Nom is null");
            return null;
        }
        return medecinRepository.findByNom(nom)
                .map(MedecinDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun medecin trouve avec le nom "+nom+" dans la bdd", ErrorCodes.MEDECIN_NOT_FOUND));

    }

    @Override
    public MedecinDto findBySpecialite(String specialite) {
        if (!StringUtils.hasLength(specialite)) {
            log.error("Specialite is null");
            return null;
        }
        return medecinRepository.findBySpecialite(specialite)
                .map(MedecinDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun medecin trouve avec le nom "+specialite+" dans la bdd", ErrorCodes.MEDECIN_NOT_FOUND));

    }

    @Override
    public List<MedecinDto> findAll() {
        return medecinRepository.findAll().stream()
                .map(MedecinDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MedecinDto update(Long id, MedecinDto updatedMedecinDto) {

        MedecinDto dto = medecinRepository.findById(id)
                .map(MedecinDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun medecin trouve avec l'id " +id+" en bdd",ErrorCodes.MEDECIN_NOT_FOUND));

        dto.setAdresse(updatedMedecinDto.getAdresse());
        dto.setSpecialite(updatedMedecinDto.getSpecialite());
        dto.setRendezVousList(updatedMedecinDto.getRendezVousList());

        return MedecinDto.fromEntity(medecinRepository.save(MedecinDto.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        medecinRepository.deleteById(id);
    }
}
