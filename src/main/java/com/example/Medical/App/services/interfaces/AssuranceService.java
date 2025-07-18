package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.AssuranceDto;

import java.util.List;

public interface AssuranceService {

    AssuranceDto save (AssuranceDto assuranceDto);

    AssuranceDto findById (Long id);

    List<AssuranceDto> findAll ();

    AssuranceDto update (Long id, AssuranceDto assuranceDto);
    void delete (Long id);

    List<AssuranceDto> findByNom(String nom);
}
