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

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DossierMedicalServiceImpl implements DossierMedicalService {

    private final DossierMedicalRepository dossierMedicalRepository;

    @Autowired
    public DossierMedicalServiceImpl(DossierMedicalRepository dossierMedicalRepository) {
        this.dossierMedicalRepository = dossierMedicalRepository;
    }

    @Override
    public DossierMedicalDto save(DossierMedicalDto dossierMedicalDto) {

        List<String> errors = DossierMedicalValidateur.validate(dossierMedicalDto);

        if (!errors.isEmpty()) {
            log.error("Dossier Medical is not valid {}", dossierMedicalDto);
            throw new InvalidEntityException("Le dossier medical nest pas valide ", ErrorCodes.DOSSIER_MEDICAL_NOT_VALID, errors);
        }

        return DossierMedicalDto.fromEntity(dossierMedicalRepository.save(DossierMedicalDto.toEntity(dossierMedicalDto)));
    }

    @Override
    public DossierMedicalDto findById(Long id) {
        if (id == null){
            log.error("DossierMedical ID is null");
            return null;
        }
        return dossierMedicalRepository.findById(id)
                .map(DossierMedicalDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun dossier medical trouve avec l'ID " +id+ " dans la base de donnees", ErrorCodes.DOSSIER_MEDICAL_NOT_FOUND));
    }

    @Override
    public List<DossierMedicalDto> findAll() {
        return dossierMedicalRepository.findAll()
                .stream()
                .map(DossierMedicalDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public DossierMedicalDto update(Long id, DossierMedicalDto updatedDossierMedical) {


        DossierMedicalDto dto = dossierMedicalRepository.findById(id)
                .map(DossierMedicalDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun dossier medical trouve avec l'ID " +id+ " dans la base de donnees", ErrorCodes.DOSSIER_MEDICAL_NOT_FOUND));

        DossierMedicalDto dossierMedical = new DossierMedicalDto();

        dossierMedical.setHistoriqueMedical(updatedDossierMedical.getHistoriqueMedical());
        dossierMedical.setPrescriptions(updatedDossierMedical.getPrescriptions());
        dossierMedical.setTraitements(updatedDossierMedical.getTraitements());
        return DossierMedicalDto.fromEntity(dossierMedicalRepository.save(DossierMedicalDto.toEntity(dossierMedical)));
    }

    @Override
    public void delete(Long id) {
        if (id == null){
            log.error("ID is null");
        }
        dossierMedicalRepository.deleteById(id);

    }
}
