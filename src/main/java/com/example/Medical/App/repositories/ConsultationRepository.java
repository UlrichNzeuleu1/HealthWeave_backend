package com.example.Medical.App.repositories;

import com.example.Medical.App.models.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ConsultationRepository extends JpaRepository<Consultation, Long>{
}
