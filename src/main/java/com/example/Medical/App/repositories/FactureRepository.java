package com.example.Medical.App.repositories;


import com.example.Medical.App.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture,Long> {
}
