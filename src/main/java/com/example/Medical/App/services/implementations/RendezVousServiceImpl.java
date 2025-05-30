package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.RendezVousDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.repositories.RendezVousRepository;
import com.example.Medical.App.services.interfaces.RendezVousService;
import com.example.Medical.App.validateurs.RendezVousValidateur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RendezVousServiceImpl implements RendezVousService {

    private final RendezVousRepository repository;

    @Autowired
    public RendezVousServiceImpl(RendezVousRepository repository) {
        this.repository = repository;
    }

    @Override
    public RendezVousDto save(RendezVousDto dto) {
        List<String> errors = RendezVousValidateur.validate(dto);

        if (!errors.isEmpty()){
           log.error("RendezVous is not valid {} ", dto);
           throw new InvalidEntityException("Le rendez-vous n'est pas valide ", ErrorCodes.RENDEZ_VOUS_NOT_VALID,errors);
        }
        return RendezVousDto.fromEntity(repository.save(RendezVousDto.toEntity(dto)));
    }

    @Override
    public RendezVousDto findById(Long id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }
        return repository.findById(id)
                .map(RendezVousDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun RendezVous trouve avec l'id "+id+" dans la bdd", ErrorCodes.RENDEZ_VOUS_NOT_FOUND));

    }

    @Override
    public List<RendezVousDto> findAllByStatut(String statut) {
        if (!StringUtils.hasLength(statut)) {
            log.error("Statut is empty");
            return null;
        }
        return repository.findAllByStatut(statut).stream()
                .map(RendezVousDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<RendezVousDto> findAll() {
        return repository.findAll().stream()
                .map(RendezVousDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public RendezVousDto update(Long id, RendezVousDto updatedDto) {
        RendezVousDto rdv = repository.findById(id)
                .map(RendezVousDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun patient trouve avec l'id "+id+" dans la bdd", ErrorCodes.PATIENT_NOT_FOUND));


        rdv.setDateRendezVous(updatedDto.getDateRendezVous());
        rdv.setHeure(updatedDto.getHeure());
        rdv.setStatut(updatedDto.getStatut());
        rdv.setMedecinSouhaite(updatedDto.getMedecinSouhaite());
        rdv.setNomPatient(updatedDto.getNomPatient());
        rdv.setPrenomPatient(updatedDto.getPrenomPatient());

        return RendezVousDto.fromEntity(repository.save(RendezVousDto.toEntity(rdv)));

    }

    @Override
    public void delete(Long id) {
        if (id == null)
            log.error("ID is null");
        repository.deleteById(id);
    }
}
