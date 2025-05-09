package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.PatientDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.models.Patient;
import com.example.Medical.App.repositories.PatientRepository;
import com.example.Medical.App.services.interfaces.PatientService;
import com.example.Medical.App.validateurs.PatientValidateur;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDto save(PatientDto patientDto) {
        List<String> errors = PatientValidateur.validate(patientDto);

        if (!errors.isEmpty()){
            log.error("Patient is not valid {}",patientDto);
            throw new InvalidEntityException("Patient n'est pas valide", ErrorCodes.PATIENT_NOT_VALID,errors);
        }
        return PatientDto.fromEntity(patientRepository.save(PatientDto.toEntity(patientDto)));
    }

    @Override
    public PatientDto findById(Long id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }
        return patientRepository.findById(id)
                .map(PatientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun patient trouve avec l'id "+id+" dans la bdd", ErrorCodes.PATIENT_NOT_FOUND));
    }

    @Override
    public PatientDto findByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("Nom is empty");
            return null;
        }
        return patientRepository.findByNom(nom)
                .map(PatientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun patient trouve avec le nom "+nom+" dans la bdd", ErrorCodes.PATIENT_NOT_FOUND));

    }

    @Override
    public List<PatientDto> findAll() {
        return patientRepository.findAll().stream()
                .map(PatientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto update(Long id, PatientDto updatedPatientDto) {

        PatientDto dto = patientRepository.findById(id)
                .map(PatientDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun patient trouve avec l'id "+id+" dans la bdd", ErrorCodes.PATIENT_NOT_FOUND));


        dto.setAllergies(updatedPatientDto.getAllergies());
        dto.setAntecedentsMedicaux(updatedPatientDto.getAntecedentsMedicaux());
        dto.setAdresse(updatedPatientDto.getAdresse());
        dto.setAssurance(updatedPatientDto.getAssurance());

        return PatientDto.fromEntity(patientRepository.save(PatientDto.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        if (id == null)
            log.error("ID is null");
        patientRepository.findById(id);
    }
}
