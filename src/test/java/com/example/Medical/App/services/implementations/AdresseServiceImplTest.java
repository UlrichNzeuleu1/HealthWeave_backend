package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.AdresseDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.models.Adresse;
import com.example.Medical.App.repositories.AdresseRepository;
import com.example.Medical.App.validateurs.AdresseValidateur;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AdresseServiceImplTest {

    @InjectMocks
    private AdresseServiceImpl adresseService;

    @Mock
    private AdresseRepository adresseRepository;

    @Mock
    private AdresseValidateur adresseValidateur;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave_ValidAdresse(){
        //valeurs valides
        AdresseDto dto = new AdresseDto(1L, "Rue chapelle Ngock", 204,237,"Yaounde","Cameroun");

        //valeurs correspondantes
        Adresse adresse = new Adresse();
        adresse.setId(dto.getId());
        adresse.setStreet(dto.getStreet());
        adresse.setNumeroMaison(dto.getNumeroMaison());
        adresse.setZipCode(dto.getZipCode());
        adresse.setVille(dto.getVille());
        adresse.setPays(dto.getPays());

        when(adresseRepository.save(any())).thenReturn(adresse);

        AdresseDto result = adresseService.save(dto);

        assertNotNull(result);
        verify(adresseRepository).save(any());
    }

    @Test
    public void testSave_InvalidAdresse() {

        AdresseDto dto = new AdresseDto(2L, "", 204,237,"","Cameroun");
        // Remplissez dto avec des valeurs invalides

        when(AdresseValidateur.validate(dto)).thenReturn(Collections.singletonList("Invalid"));

        Exception exception = assertThrows(InvalidEntityException.class, ()-> {
            adresseService.save(dto);
        });

        assertEquals("L'adresse n'est pas valide ", exception.getMessage());
        verify(adresseRepository, never()).save(any());
    }

    @Test
    public void testFindById_ExistingId(){
        Long id = 1L;
        Adresse adresse = new Adresse(1L,"Rue Ancien riche",124,237,"Yaounde","Cameroun");
        when(adresseRepository.findById(id)).thenReturn(Optional.of(adresse));
        AdresseDto result = adresseService.findById(id);
        assertNotNull(result);
        verify(adresseRepository).findById(id);
    }

    @Test
    public void testFindById_NonExistingId(){

        Long id = 1L;
        when(adresseRepository.findById(id)).thenReturn(Optional.empty());
        Exception exception = assertThrows(EntityNotFoundException.class, () ->{
            adresseService.findById(id);
        });
        assertEquals("Aucune adresse trouve avec l'id 1 dans la base de donnees", exception.getMessage());
    }

    @Test
    public void testDelete_ExistingId(){

        Long id = 1L;
        doNothing().when(adresseRepository).deleteById(id);
        assertDoesNotThrow(()->{
            adresseService.delete(id);
        });

        verify(adresseRepository).deleteById(id);
    }

    @Test
    public void testFindByStreet_ValidStreet() {
        String street = "Rue Atangana";
        // Liste d'adresses simulées
        List<Adresse> adresses = Arrays.asList(
                new Adresse(1L,"Rue Atangana",122,237,"yaounde","Cameroun"),
                new Adresse(2L,"Rue Kribi",254,237,"yaounde","Cameroun"),
                new Adresse(3L,"Rue Damas",592,237,"yaounde","Cameroun")
        );

        when(adresseRepository.findByStreetContainingIgnoreCase(street)).thenReturn(Collections.emptyList());
        var result = adresseService.findByStreet(street);
        assertNotNull(result);
        verify(adresseRepository).findByStreetContainingIgnoreCase(street);
    }

    @Test
    public void testFindByStreet_NullStreet() {
        String street = null;

        var result = adresseService.findByStreet(street);

        assertNull(result);
        verify(adresseRepository, never()).findByStreetContainingIgnoreCase(any());
    }

}
