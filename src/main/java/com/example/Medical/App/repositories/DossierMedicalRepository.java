package com.example.Medical.App.repositories;

import com.example.Medical.App.models.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long> {
}
