package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.UtilisateurDto;
import com.example.Medical.App.dto.UtilisateurDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.repositories.UtilisateurRepository;
import com.example.Medical.App.services.interfaces.UtilisateurService;
import com.example.Medical.App.validateurs.RendezVousValidateur;
import com.example.Medical.App.validateurs.UtilisateurValidateur;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {
    
    private final UtilisateurRepository repository;

    @Autowired
    public UtilisateurServiceImpl(UtilisateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public UtilisateurDto save(UtilisateurDto dto) {
        List<String> errors = UtilisateurValidateur.validate(dto);

        if (!errors.isEmpty()){
            log.error("Utilisateur is not valid {} ", dto);
            throw new InvalidEntityException("L'Utilisateur n'est pas valide ", ErrorCodes.UTILISATEUR_NOT_VALID,errors);
        }
        return UtilisateurDto.fromEntity(repository.save(UtilisateurDto.toEntity(dto)));

    }

    @Override
    public UtilisateurDto findById(Long id) {
        if (id == null) {
            log.error("ID is null");
            return null;
        }
        return repository.findById(id)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun Utilisateur trouve avec l'id "+id+" dans la bdd", ErrorCodes.UTILISATEUR_NOT_FOUND));

    }

    @Override
    public List<UtilisateurDto> findByNom(String nom) {
        if (!StringUtils.hasLength(nom)) {
            log.error("ID is null");
            return null;
        }
        return repository.findByNom(nom).stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UtilisateurDto> findAll() {
        return repository.findAll().stream()
                .map(UtilisateurDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public UtilisateurDto update(Long id, UtilisateurDto updatedUtilisateurDto) {
        UtilisateurDto dto = repository.findById(id)
                .map(UtilisateurDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun utilisateur trouve avec l'id "+id+" dans la bdd", ErrorCodes.UTILISATEUR_NOT_FOUND));

        dto.setNom(updatedUtilisateurDto.getNom());
        dto.setPrenom(updatedUtilisateurDto.getPrenom());
        dto.setEmail(updatedUtilisateurDto.getEmail());
        dto.setMotDePasse(updatedUtilisateurDto.getMotDePasse());
        dto.setTypeUtilisateur(updatedUtilisateurDto.getTypeUtilisateur());

        return UtilisateurDto.fromEntity(repository.save(UtilisateurDto.toEntity(dto)));

    }

    @Override
    public void delete(Long id) {
        if (id == null)
            log.error("ID is null");

        repository.deleteById(id);
    }
}
