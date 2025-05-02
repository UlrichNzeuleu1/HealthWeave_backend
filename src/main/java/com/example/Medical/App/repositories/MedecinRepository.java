package com.example.Medical.App.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.Medical.App.dto.MedecinDto;
import com.example.Medical.App.models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Optional<Medecin> findByNom(String nom);

    Optional<Medecin>findBySpecialite(String specialite);
}
