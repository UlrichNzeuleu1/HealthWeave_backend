package com.example.Medical.App.repositories;

import com.example.Medical.App.models.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssuranceRepository extends JpaRepository<Assurance, Long> {
    Optional<Assurance> findByNomAssureur(String nomAssureur);
}
