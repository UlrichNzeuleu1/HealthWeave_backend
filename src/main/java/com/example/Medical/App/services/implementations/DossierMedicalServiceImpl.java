package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.DossierMedicalDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.models.DossierMedical;
import com.example.Medical.App.repositories.DossierMedicalRepository;
import com.example.Medical.App.services.interfaces.DossierMedicalService;
import com.example.Medical.App.validateurs.DossierMedicalValidateur;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DossierMedicalServiceImpl implements DossierMedicalService {

    private final DossierMedicalRepository repository;

    @Autowired
    public DossierMedicalServiceImpl(DossierMedicalRepository repository) {
        this.repository = repository;
    }

    @Override
    public DossierMedicalDto save(DossierMedicalDto dtoDto) {

        List<String> errors = DossierMedicalValidateur.validate(dtoDto);

        if (!errors.isEmpty()) {
            log.error("Dossier Medical is not valid {}", dtoDto);
            throw new InvalidEntityException("Le dossier medical nest pas valide ", ErrorCodes.DOSSIER_MEDICAL_NOT_VALID, errors);
        }

        return DossierMedicalDto.fromEntity(repository.save(DossierMedicalDto.toEntity(dtoDto)));
    }

    @Override
    public DossierMedicalDto findById(Long id) {
        if (id == null){
            log.error("DossierMedical ID is null");
            return null;
        }
        return repository.findById(id)
                .map(DossierMedicalDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun dossier medical trouve avec l'ID " +id+ " dans la base de donnees", ErrorCodes.DOSSIER_MEDICAL_NOT_FOUND));
    }

    @Override
    public List<DossierMedicalDto> findAll() {
        return repository.findAll()
                .stream()
                .map(DossierMedicalDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public DossierMedicalDto update(Long id, DossierMedicalDto updatedDossierMedical) {


        DossierMedicalDto dto = repository.findById(id)
                .map(DossierMedicalDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun dossier medical trouve avec l'ID " +id+ " dans la base de donnees", ErrorCodes.DOSSIER_MEDICAL_NOT_FOUND));

        dto.setHistoriqueMedical(updatedDossierMedical.getHistoriqueMedical());
        dto.setPrescriptions(updatedDossierMedical.getPrescriptions());
        dto.setTraitements(updatedDossierMedical.getTraitements());
        return DossierMedicalDto.fromEntity(repository.save(DossierMedicalDto.toEntity(dto)));
    }

    @Override
    public void delete(Long id) {
        if (id == null){
            log.error("ID is null");
        }
        repository.deleteById(id);

    }
}
