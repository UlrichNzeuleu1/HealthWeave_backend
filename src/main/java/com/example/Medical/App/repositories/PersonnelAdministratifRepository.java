package com.example.Medical.App.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.Medical.App.models.PersonnelAdministratif;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonnelAdministratifRepository extends JpaRepository<PersonnelAdministratif,Long> {
    List<PersonnelAdministratif> findByNomContainingIgnoreCase(String nom);

    List<PersonnelAdministratif> findByRoleContainingIgnoreCase(String role);
}
