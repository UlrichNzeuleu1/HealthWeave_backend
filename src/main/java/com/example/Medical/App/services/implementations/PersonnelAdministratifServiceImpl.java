package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.MedicamentDto;
import com.example.Medical.App.dto.PersonnelAdministratifDto;
import com.example.Medical.App.dto.PersonnelAdministratifDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.models.PersonnelAdministratif;
import com.example.Medical.App.repositories.PersonnelAdministratifRepository;
import com.example.Medical.App.services.interfaces.PersonnelAdministratifService;
import com.example.Medical.App.validateurs.MedicamentValidateur;
import com.example.Medical.App.validateurs.PersonnelAdministratifValidateur;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PersonnelAdministratifServiceImpl implements PersonnelAdministratifService {
    
    private final PersonnelAdministratifRepository repository;

    @Autowired
    public PersonnelAdministratifServiceImpl(PersonnelAdministratifRepository repository) {
        this.repository = repository;
    }

    @Override
    public PersonnelAdministratifDto save(PersonnelAdministratifDto dto) {
        List<String> errors = PersonnelAdministratifValidateur.validate(dto);

        if (!errors.isEmpty()){
            log.error("PersonnelAdministratif is not valid {} ",dto);
            throw new InvalidEntityException("L'entite PersonnelAdministratif n'est pas valide ", ErrorCodes.PERSONNEL_ADMINISTRATIF_NOT_VALID,errors);
        }
        return PersonnelAdministratifDto.fromEntity(repository.save(PersonnelAdministratifDto.toEntity(dto)));

    }

    @Override
    public PersonnelAdministratifDto findById(Long id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }
        return repository.findById(id)
                .map(PersonnelAdministratifDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun patient trouve avec l'id "+id+" dans la bdd", ErrorCodes.PERSONNEL_ADMINISTRATIF_NOT_FOUND));

    }

    @Override
    public List<PersonnelAdministratifDto> findByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("Nom is empty");
            return null;
        }
        return repository.findByNomContainingIgnoreCase(nom).stream()
                .map(PersonnelAdministratifDto::fromEntity)
                .collect(Collectors.toList());
        //.orElseThrow(()-> new EntityNotFoundException("Aucun patient trouve avec le nom "+nom+" dans la bdd", ErrorCodes.PERSONNEL_ADMINISTRATIF_NOT_FOUND));

    }

    @Override
    public List<PersonnelAdministratifDto> findByRole(String role) {
        if (!StringUtils.hasLength(role)) {
            log.error("role is empty");
            return null;
        }
        return repository.findByRoleContainingIgnoreCase(role)
                .stream()
                .map(PersonnelAdministratifDto::fromEntity)
                .collect(Collectors.toList());
                //.orElseThrow(()-> new EntityNotFoundException("Aucun personnel administratif trouve avec le nom "+role+" dans la bdd", ErrorCodes.PATIENT_NOT_FOUND));

    }

    @Override
    public List<PersonnelAdministratifDto> findAll() {
        return repository.findAll().stream()
                .map(PersonnelAdministratifDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PersonnelAdministratifDto update(Long id, PersonnelAdministratifDto updatedDto) {
        
        PersonnelAdministratifDto dto = repository.findById(id)
                .map(PersonnelAdministratifDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun patient trouve avec l'id "+id+" dans la bdd", ErrorCodes.PATIENT_NOT_FOUND));

        dto.setNom(updatedDto.getNom());
        dto.setRole(updatedDto.getRole());
        dto.setPrenom(updatedDto.getPrenom());
        dto.setAdresse(updatedDto.getAdresse());
        dto.setTelephone(updatedDto.getTelephone());


        return PersonnelAdministratifDto.fromEntity(repository.save(PersonnelAdministratifDto.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        if (id == null)
            log.error("ID is null");
        repository.deleteById(id);

    }
}
