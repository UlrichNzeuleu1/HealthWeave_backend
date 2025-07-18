package com.example.Medical.App.repositories;

import com.example.Medical.App.dto.ConsultationDto;
import com.example.Medical.App.models.Compte;
import com.example.Medical.App.models.Consultation;
import org.antlr.v4.runtime.atn.SemanticContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
    List<Consultation> findByTypeContainingIgnoreCase(String type);

    @Query("SELECT c FROM Consultation c WHERE (:type IS NULL OR c.type LIKE %:type%) AND (:statut IS NULL OR c.statut LIKE %:statut%)")
    List<Consultation> findByTypeAndStatut(@Param("type") String type, @Param("statut") String statut);
}
