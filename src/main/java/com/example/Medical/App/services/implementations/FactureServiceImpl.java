package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.FactureDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.models.Facture;
import com.example.Medical.App.repositories.FactureRepository;
import com.example.Medical.App.services.interfaces.FactureService;
import com.example.Medical.App.validateurs.FactureValidateur;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FactureServiceImpl implements FactureService {

    private final FactureRepository factureRepository;

    @Autowired
    public FactureServiceImpl(FactureRepository factureRepository) {
        this.factureRepository = factureRepository;
    }

    @Override
    public FactureDto save(FactureDto factureDto) {
        List<String> errors = FactureValidateur.validate(factureDto);

        if (!errors.isEmpty()){
            log.error("Facture is not valid {}", factureDto);
            throw new InvalidEntityException("La facture n'est pas valide ", ErrorCodes.DOSSIER_MEDICAL_NOT_VALID,errors);
        }
        return FactureDto.fromEntity(factureRepository.save(FactureDto.toEntity(factureDto)));
    }

    @Override
    public FactureDto findById(Long id) {
        if (id == null){
            log.error("ID is null");
            return null;
        }
        return factureRepository.findById(id)
                .map(FactureDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune facture trouvee avec l'id " +id+ " en bdd",ErrorCodes.FACTURE_NOT_FOUND));
    }

    @Override
    public List<FactureDto> findAll() {
        return factureRepository.findAll()
                .stream()
                .map(FactureDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public FactureDto update(Long id, FactureDto updatedFactureDto) {

        FactureDto dto = factureRepository.findById(id)
                .map(FactureDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune facture trouvee avec l'id "+id+" dans la bdd", ErrorCodes.FACTURE_NOT_FOUND));

        Facture factureToUpdate = new Facture();
        factureToUpdate.setDateEmission(updatedFactureDto.getDateEmission());
        factureToUpdate.setMontant(updatedFactureDto.getMontant());
        factureToUpdate.setStatutPaiement(updatedFactureDto.getStatutPaiement());

        return FactureDto.fromEntity(factureRepository.save(FactureDto.toEntity(updatedFactureDto)));
    }

    @Override
    public void delete(Long id) {
        if (id == null)
            log.error("ID is null");

        factureRepository.findById(id);
    }
}
