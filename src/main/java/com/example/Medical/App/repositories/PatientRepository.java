package com.example.Medical.App.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.Medical.App.dto.PatientDto;
import com.example.Medical.App.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Optional<Patient> findByNom(String nom);

    List<Patient> findByNomContainingIgnoreCase(String nom);
}
