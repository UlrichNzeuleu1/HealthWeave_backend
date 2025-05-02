package com.example.Medical.App.services.interfaces;

import com.example.Medical.App.dto.HopitalDto;
import org.springframework.boot.autoconfigure.AbstractDependsOnBeanFactoryPostProcessor;

import java.util.List;

public interface HopitalService {
    HopitalDto save (HopitalDto hopitalDto);
    HopitalDto findById (Long id);
    HopitalDto findByNom (String nom);
    List<HopitalDto> findAll ();
    HopitalDto update (Long id, HopitalDto hopitalDto);
    void delete (Long id);
}
