package com.example.Medical.App.repositories;

import com.example.Medical.App.models.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {

    List<DossierMedical> findByTraitementsContainingIgnoreCase(String traitements);
}
