package com.example.Medical.App.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.Medical.App.models.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RendezVousRepository extends JpaRepository<RendezVous,Long> {
    Optional<RendezVous> findByStatut(String statut);
}
