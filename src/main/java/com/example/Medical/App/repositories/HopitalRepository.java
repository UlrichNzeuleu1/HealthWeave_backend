package com.example.Medical.App.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.Medical.App.dto.HopitalDto;
import com.example.Medical.App.models.Hopital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HopitalRepository extends JpaRepository<Hopital,Long> {
    Optional<Hopital> findByNom(String nom);
}
