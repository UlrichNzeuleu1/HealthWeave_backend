package com.example.Medical.App.repositories;


import com.example.Medical.App.models.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Long> {
    List<Compte> findByEmailContainingIgnoreCase(String email);
}
