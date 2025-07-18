package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.AssuranceDto;
import com.example.Medical.App.dto.CompteDto;

import java.util.List;

public interface CompteService {
    CompteDto save (CompteDto compteDto);
    CompteDto findById (Long id);
    List<CompteDto> findAll ();
    List<CompteDto> findByEmail(String email);
    CompteDto update (Long id, CompteDto compteDto);
    void delete (Long id);
}
