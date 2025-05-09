package com.example.Medical.App.repositories;

import aj.org.objectweb.asm.commons.Remapper;
import com.example.Medical.App.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Long> {
    List<Utilisateur> findByNom(String nom);
}
