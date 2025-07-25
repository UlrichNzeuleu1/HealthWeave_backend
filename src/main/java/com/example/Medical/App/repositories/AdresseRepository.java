package com.example.Medical.App.repositories;

import com.example.Medical.App.models.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdresseRepository extends JpaRepository<Adresse, Long> {
    List<Adresse> findByStreetContainingIgnoreCase(String street);
}
