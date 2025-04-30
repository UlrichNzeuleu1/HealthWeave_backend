package com.example.Medical.App.controlleurs;

import com.example.Medical.App.controlleurs.api.AssuranceApi;
import com.example.Medical.App.dto.AssuranceDto;
import com.example.Medical.App.services.interfaces.AssuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssuranceControlleur implements AssuranceApi {

    private final AssuranceService assuranceService;

    @Autowired
    public AssuranceControlleur(AssuranceService assuranceService) {
        this.assuranceService = assuranceService;
    }

    @Override
    public AssuranceDto save(AssuranceDto assuranceDto) {
        return assuranceService.save(assuranceDto);
    }

    @Override
    public AssuranceDto findById(Long id) {
        return assuranceService.findById(id);
    }

    @Override
    public List<AssuranceDto> findAll() {
        return assuranceService.findAll();
    }

    @Override
    public AssuranceDto findByNomAssureur(String nomAssureur) {
        return assuranceService.findByNomAssureur(nomAssureur);
    }

    @Override
    public AssuranceDto update(Long id, AssuranceDto assuranceDto) {
        return assuranceService.update(id,assuranceDto);
    }

    @Override
    public void delete(Long id) {
        assuranceService.delete(id);
    }
}
