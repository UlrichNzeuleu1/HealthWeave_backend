package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.MedecinDto;
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
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PatientServiceImpl implements PatientService {

    @Autowired
    private final PatientRepository patientRepository;

    private final String uploadDir = "uploads/patients";

    @Override
    public PatientDto savePatientWithPhoto(PatientDto patientDto, MultipartFile file) {
        if (file != null && !file.isEmpty()) {
            try {
                // creer le dossier s'il nexiste pas
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                // Générer un nom de fichier unique pour éviter les doublons
                String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
                // combinons maintenant le chemin du dossier d'upload et le nom unique du fichier pour obtenir un chemin complet et precis ou le fichier sera stocke sur le disque dur
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

                // Maintenaant enregistrons le chemin relatif ou l'URL dans l'entité
                patientDto.setPhotoUrl("/images/" + fileName);

            } catch (IOException e) {
                throw new RuntimeException("Erreur lors de l'enregistrement de l'image");
            }
        }

        return PatientDto.fromEntity(patientRepository.save(PatientDto.toEntity(patientDto)));

    }

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public PatientDto save(PatientDto dto) {


        List<String> errors = PatientValidateur.validate(dto);

        if (!errors.isEmpty()) {
            log.error("Patient is not valid {}", dto);
            throw new InvalidEntityException("Patient n'est pas valide", ErrorCodes.PATIENT_NOT_VALID, errors);
        }
        return PatientDto.fromEntity(patientRepository.save(PatientDto.toEntity(dto)));
    }

    @Override
    public PatientDto findById(Long id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }
        return patientRepository.findById(id)
                .map(PatientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun patient trouve avec l'id " + id + " dans la bdd", ErrorCodes.PATIENT_NOT_FOUND));
    }

    @Override
    public List<PatientDto> findByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("Nom is empty");
            return null;
        }
        return patientRepository.findByNomContainingIgnoreCase(nom).stream()
                .map(PatientDto::fromEntity)
                .collect(Collectors.toList());

        //.orElseThrow(()-> new EntityNotFoundException("Aucun patient trouve avec le nom "+nom+" dans la bdd", ErrorCodes.PATIENT_NOT_FOUND));

    }

    @Override
    public List<PatientDto> findAll() {
        return patientRepository.findAll().stream()
                .map(PatientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public PatientDto update(Long id, PatientDto updatedPatient) {

        PatientDto dto = patientRepository.findById(id)
                .map(PatientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("Aucun patient trouve avec l'id " + id + " dans la bdd", ErrorCodes.PATIENT_NOT_FOUND));

        //dto.setId(id);
        dto.setAntecedentsMedicaux(updatedPatient.getAntecedentsMedicaux());
        dto.setNom(updatedPatient.getNom());
        dto.setPrenom(updatedPatient.getPrenom());
        dto.setPhone(updatedPatient.getPhone());
        dto.setDateDeNaissance(updatedPatient.getDateDeNaissance());
        dto.setSexe(updatedPatient.getSexe());

        dto.setAddress(updatedPatient.getAddress());
        dto.setEmail(updatedPatient.getEmail());
        dto.setBloodGroup(updatedPatient.getBloodGroup());
        dto.setWeight(updatedPatient.getWeight());
        dto.setPhotoUrl(updatedPatient.getPhotoUrl());


        //dto.setAssurance(updatedPatientDto.getAssurance());

        return PatientDto.fromEntity(patientRepository.save(PatientDto.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        if (id == null)
            log.error("ID is null");
        patientRepository.deleteById(id);
    }


}
