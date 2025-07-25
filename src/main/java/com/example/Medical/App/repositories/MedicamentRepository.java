package com.example.Medical.App.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.Medical.App.models.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MedicamentRepository extends JpaRepository<Medicament,Long> {
    List<Medicament> findByNomContainingIgnoreCase(String nom);
}
