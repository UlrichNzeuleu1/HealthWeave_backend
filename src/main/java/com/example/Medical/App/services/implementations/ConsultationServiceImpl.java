package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.CompteDto;
import com.example.Medical.App.dto.ConsultationDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.models.Consultation;
import com.example.Medical.App.repositories.ConsultationRepository;
import com.example.Medical.App.services.interfaces.ConsultationService;
import com.example.Medical.App.validateurs.ConsultationValidateur;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static org.hibernate.Hibernate.map;


@Service
@Slf4j
public class ConsultationServiceImpl implements ConsultationService {

    private final ConsultationRepository consultationRepository;

    @Autowired
    public ConsultationServiceImpl(ConsultationRepository consultationRepository) {
        this.consultationRepository = consultationRepository;
    }

    @Override
    public ConsultationDto save(ConsultationDto consultationDto) {

        List<String> errors = ConsultationValidateur.validate(consultationDto);

        if (!errors.isEmpty()){
            log.error("La consultation n'est pas valide ",consultationDto);
            throw new InvalidEntityException("La consultation n'est pas valide ", ErrorCodes.CONSULTATION_NOT_VALID, errors);
        }

        return ConsultationDto.fromEntity(consultationRepository.save(ConsultationDto.toEntity(consultationDto)));
    }

    @Override
    public ConsultationDto findById(Long id) {
        if (id == null){
            log.error("Consultation id null");
            return null;
        }
        return consultationRepository.findById(id)
                .map(ConsultationDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune consultation trouvee avec l'id "+id+ " dans la base de donnees", ErrorCodes.CONSULTATION_NOT_FOUND));
    }

    @Override
    public List<ConsultationDto> findAll() {
        return consultationRepository.findAll().stream()
                .map(ConsultationDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ConsultationDto findByType(String type) {
        if (!StringUtils.hasLength(type)) {
            log.error("Le type de consultation est vide");
            throw new IllegalArgumentException("Le type de consultation ne peut pas être vide.");
        }
        return consultationRepository.findByType(type);
                //.map(ConsultationDto::fromEntity)
                //.orElseThrow(()-> new EntityNotFoundException("Aucune consultation avec le type : "+type+" dans la bdd. " ,ErrorCodes.CONSULTATION_NOT_FOUND));
    }

    @Override
    public ConsultationDto update(Long id, ConsultationDto updatedConsultation) {
        ConsultationDto dto = consultationRepository.findById(id)
                .map(ConsultationDto::fromEntity)
                .orElseThrow(()-> new EntityNotFoundException("Aucune consultation trouvee avec l'id "+id+ " dans la base de donnees", ErrorCodes.CONSULTATION_NOT_FOUND));

        ConsultationDto consultationToUpdate = new ConsultationDto();

        consultationToUpdate.setDate(updatedConsultation.getDate());
        consultationToUpdate.setType(updatedConsultation.getType());
        consultationToUpdate.setHeure(updatedConsultation.getHeure());
        consultationToUpdate.setStatut(updatedConsultation.getStatut());

        return ConsultationDto.fromEntity(consultationRepository.save(ConsultationDto.toEntity(consultationToUpdate)));
    }

    @Override
    public void delete(Long id) {

        if (id == null)
            log.error("id is null");

        consultationRepository.deleteById(id);
    }
}
