package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.MedecinDto;
import com.example.Medical.App.dto.MedicamentDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.repositories.MedicamentRepository;
import com.example.Medical.App.services.interfaces.MedicamentService;
import com.example.Medical.App.validateurs.MedicamentValidateur;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class MedicamentServiceImpl implements MedicamentService {

    private final MedicamentRepository medicamentRepository;

    @Autowired
    public MedicamentServiceImpl(MedicamentRepository medicamentRepository) {
        this.medicamentRepository = medicamentRepository;
    }

    @Override
    @Transactional
    public MedicamentDto save(MedicamentDto medicamentDto) {

        List<String> errors = MedicamentValidateur.validate(medicamentDto);

        if (!errors.isEmpty()){
            log.error("Medicament is not valid {} ",medicamentDto);
            throw new InvalidEntityException("L'entite Medicament n'est pas valide ",ErrorCodes.MEDECIN_NOT_VALID,errors);
        }
        return MedicamentDto.fromEntity(medicamentRepository.save(MedicamentDto.toEntity(medicamentDto)));
    }

    @Override
    public MedicamentDto findById(Long id) {
        if (id == null){
            log.error("ID is null");
            return null;
        }
        return medicamentRepository.findById(id)
                .map(MedicamentDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun medicament trouve avec l'id "+id+" dans la bdd", ErrorCodes.MEDICAMENT_NOT_FOUND));
    }

    @Override
    public MedicamentDto findByNom(String nom) {
        if (!StringUtils.hasLength(nom)){
            log.error("Nom is null");
            return null;
        }
        return medicamentRepository.findByNom(nom)
                .map(MedicamentDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun medicament trouve avec le nom "+nom+" dans la bdd", ErrorCodes.MEDICAMENT_NOT_FOUND));

    }

    @Override
    public List<MedicamentDto> findAll() {
        return medicamentRepository.findAll()
                .stream()
                .map(MedicamentDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public MedicamentDto update(Long id, MedicamentDto updatedMedicamentDto) {
        MedicamentDto dto = medicamentRepository.findById(id)
                .map(MedicamentDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun medecin trouve avec l'id " +id+" en bdd",ErrorCodes.MEDICAMENT_NOT_FOUND));


        dto.setDosage(updatedMedicamentDto.getDosage());
        dto.setNom(updatedMedicamentDto.getNom());

        return MedicamentDto.fromEntity(medicamentRepository.save(MedicamentDto.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        if (id == null)
            log.error("ID is null");
        medicamentRepository.deleteById(id);
    }
}
