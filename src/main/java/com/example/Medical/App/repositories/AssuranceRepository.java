package com.example.Medical.App.repositories;

import com.example.Medical.App.models.Assurance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssuranceRepository extends JpaRepository<Assurance, Long> {
    List<Assurance> findByNomContainingIgnoreCase(String nom);
}
