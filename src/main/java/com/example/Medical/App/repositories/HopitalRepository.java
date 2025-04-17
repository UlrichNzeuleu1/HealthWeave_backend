package com.example.Medical.App.repositories;

import com.example.Medical.App.models.Hopital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HopitalRepository extends JpaRepository<Hopital,Long> {
}
