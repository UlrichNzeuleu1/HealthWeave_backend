package com.example.Medical.App.repositories;

import com.example.Medical.App.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
}
