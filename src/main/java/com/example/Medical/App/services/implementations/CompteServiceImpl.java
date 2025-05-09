package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.CompteDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.repositories.CompteRepository;
import com.example.Medical.App.services.interfaces.CompteService;
import com.example.Medical.App.validateurs.CompteValidateur;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;

    @Autowired
    public CompteServiceImpl(CompteRepository compteRepository) {
        this.compteRepository = compteRepository;
    }

    @Override
    public CompteDto save(CompteDto compteDto) {

        List<String> errors = CompteValidateur.validate(compteDto);

        if(!errors.isEmpty()){
            log.error("Compte is not valid",compteDto);
            throw new InvalidEntityException("Le compte n'est pas valide ", ErrorCodes.COMPTE_NOT_VALID,errors);
        }
        return CompteDto.fromEntity(compteRepository.save(CompteDto.toEntity(compteDto)));
    }

    @Override
    public CompteDto findById(Long id) {
        if (id == null){
            log.error("Compte id is null");
            return null;
        }
        return compteRepository.findById(id)
                .map(CompteDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun compte trouve avec l'id "+id+ " dans la base de donnees",ErrorCodes.COMPTE_NOT_FOUND));
    }

    @Override
    public List<CompteDto> findAll() {
        return compteRepository.findAll().stream()
                .map(CompteDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public CompteDto findByEmail(String email) {
        if (!StringUtils.hasLength(email)){
            log.error("Email is null");
            return null;
        }
        return compteRepository.findByEmail(email)
                .map(CompteDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun article trouve avec l'email "+email+" dans la base de donnees", ErrorCodes.COMPTE_NOT_FOUND));
    }

    @Override
    public CompteDto update(Long id, CompteDto updatedCompte) {

        CompteDto compteDto = compteRepository.findById(id)
                .map(CompteDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucun compte trouve avec l'id "+id+" dans la base de donnees ",ErrorCodes.COMPTE_NOT_FOUND));

        compteDto.setEmail(updatedCompte.getEmail());
        compteDto.setPassword(updatedCompte.getPassword());

        return CompteDto.fromEntity(compteRepository.save(CompteDto.toEntity(compteDto)));
    }

    @Override
    public void delete(Long id) {
        if (id == null){
            log.error("Id is null");
        }
        compteRepository.deleteById(id);
    }
}
