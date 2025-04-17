package com.example.Medical.App.repositories;

import com.example.Medical.App.models.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
}
