package com.example.Medical.App.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.Medical.App.models.PersonnelAdministratif;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonnelAdministratifRepository extends JpaRepository<PersonnelAdministratif,Long> {
    Optional<PersonnelAdministratif> findByNom(String nom);

    Optional<PersonnelAdministratif> findByRole(String role);
}
