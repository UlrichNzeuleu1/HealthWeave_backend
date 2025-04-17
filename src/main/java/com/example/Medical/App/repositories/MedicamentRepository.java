package com.example.Medical.App.repositories;

import com.example.Medical.App.models.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament,Long> {
}
