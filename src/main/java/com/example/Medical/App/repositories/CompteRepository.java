package com.example.Medical.App.repositories;


import com.example.Medical.App.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Long> {
}
