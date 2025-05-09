package com.example.Medical.App.repositories;

import com.example.Medical.App.dto.ConsultationDto;
import com.example.Medical.App.models.Compte;
import com.example.Medical.App.models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
    List<Consultation> findByType(String type);

}
