package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.AssuranceDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.models.Assurance;
import com.example.Medical.App.repositories.AssuranceRepository;
import com.example.Medical.App.services.interfaces.AssuranceService;
import com.example.Medical.App.validateurs.AssuranceValidateur;
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
public class AssuranceServiceImpl implements AssuranceService {

    private final AssuranceRepository assuranceRepository;

    @Autowired
    public AssuranceServiceImpl(AssuranceRepository assuranceRepository) {
        this.assuranceRepository = assuranceRepository;
    }

    @Override
    public AssuranceDto save(AssuranceDto assuranceDto) {

        List<String> errors = AssuranceValidateur.validate(assuranceDto);

        if (!errors.isEmpty()){
            log.error("Assurance is not valid", assuranceDto);
            throw new InvalidEntityException("L'assurance n'est pas valide ", ErrorCodes.ASSURANCE_NOT_VALID, errors);
        }
        return AssuranceDto.fromEntity(assuranceRepository.save(AssuranceDto.toEntity(assuranceDto)));
    }

    @Override
    public AssuranceDto findById(Long id) {

        if (id == null){
            log.error("Assurance ID is null");
            return null;
        }
        return assuranceRepository.findById(id)
                .map(AssuranceDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune assurance n'existe dans la base de donnees avec l'ID " +id, ErrorCodes.ASSURANCE_NOT_FOUND));
    }

    @Override
    public List<AssuranceDto> findAll() {
        return assuranceRepository.findAll().stream()
                .map(AssuranceDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AssuranceDto findByNomAssureur(String nomAssureur) {
        if (!StringUtils.hasLength(nomAssureur)){
            log.error("Assurance name is null");
            return null;
        }
        return assuranceRepository.findByNomAssureur(nomAssureur)
                .map(AssuranceDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune assurance trouvee dans la base de donnees avec le nom "+nomAssureur, ErrorCodes.ASSURANCE_NOT_FOUND));
    }

    @Override
    public AssuranceDto update(Long id, AssuranceDto assuranceDto) {
        AssuranceDto assuranceDto1 = assuranceRepository.findById(id)
                .map(AssuranceDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune assurance trouve avec l'id "+id+ " dans la based de donnees"));

        Assurance assurance = new Assurance();

        assurance.setNomAssureur(assuranceDto.getNomAssureur());
        assurance.setNumeroPolice(assuranceDto.getNumeroPolice());
        assurance.setTypeCouverture(assuranceDto.getTypeCouverture());

        return AssuranceDto.fromEntity(assuranceRepository.save(AssuranceDto.toEntity(assuranceDto)));
    }

    @Override
    public void delete(Long id) {
        if (id ==  null) {
            log.error("L'id est null");
        }
        assuranceRepository.deleteById(id);
    }
}
