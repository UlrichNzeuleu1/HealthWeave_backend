package com.example.Medical.App.repositories;


import com.example.Medical.App.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FactureRepository extends JpaRepository<Facture,Long> {

    List<Facture> findByStatutPaiementContainingIgnoreCase(String statutPaiement);
}
