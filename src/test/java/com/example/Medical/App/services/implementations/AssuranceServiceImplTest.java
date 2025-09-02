package com.example.Medical.App.services.implementations;

import com.example.Medical.App.dto.AssuranceDto;
import com.example.Medical.App.exception.EntityNotFoundException;
import com.example.Medical.App.exception.ErrorCodes;
import com.example.Medical.App.exception.InvalidEntityException;
import com.example.Medical.App.services.interfaces.AssuranceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest

public class AssuranceServiceImplTest {

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Autowired
    private AssuranceService assuranceService;

    @Test
    public void shouldSaveAssuranceWithSuccessTest(){
       AssuranceDto expectedAssurance = AssuranceDto.builder()
                .numeroPolice("CAM125")
                .nom("La Maseillaise Assurance")
                .typeCouverture("Mixte")
                .id(1L)
                .build();

       AssuranceDto savedAssurance = assuranceService.save(expectedAssurance);

        assertNotNull(savedAssurance);
        assertNotNull(savedAssurance.getId());
        assertEquals(expectedAssurance.getId(), savedAssurance.getId());
        assertEquals(expectedAssurance.getNom(), savedAssurance.getNom());
        assertEquals(expectedAssurance.getNumeroPolice(), savedAssurance.getNumeroPolice());
        assertEquals(expectedAssurance.getTypeCouverture(), savedAssurance.getTypeCouverture());

    }

    @Test
    public void shouldUpdateAssuranceWithSuccessTest(){
        AssuranceDto expectedAssurance = AssuranceDto.builder()
                .numeroPolice("CAM125")
                .nom("La Maseillaise Assurance")
                .typeCouverture("Mixte")
                .id(1L)
                .build();

        AssuranceDto savedAssurance = assuranceService.save(expectedAssurance);

        AssuranceDto assuranceToUpdate = savedAssurance;
        assuranceToUpdate.setNumeroPolice("CAM555");

        savedAssurance = assuranceService.save(assuranceToUpdate);
        assertNotNull(assuranceToUpdate);
        assertNotNull(assuranceToUpdate.getId());
        assertEquals(assuranceToUpdate.getId(), savedAssurance.getId());
        assertEquals(assuranceToUpdate.getNom(), savedAssurance.getNom());
        assertEquals(assuranceToUpdate.getNumeroPolice(), savedAssurance.getNumeroPolice());
        assertEquals(assuranceToUpdate.getTypeCouverture(), savedAssurance.getTypeCouverture());
    }

    @Test
    public void shouldThrowInvalidEntityExceptionTest(){
        AssuranceDto expectedAssurance = AssuranceDto.builder().build();

        InvalidEntityException expectedException = assertThrows(InvalidEntityException.class, () ->{
            assuranceService.save(expectedAssurance);
        });

        assertEquals(ErrorCodes.ASSURANCE_NOT_VALID, expectedException.getErrorCode());
        assertEquals(3,expectedException.getErrors().size());
        assertEquals("Veuillez renseigner le nom de l'assureur",expectedException.getErrors().get(0) );
    }

    @Test
    public void shouldThrowEntityNotFoundExceptionTest(){

        EntityNotFoundException expectedException = assertThrows(EntityNotFoundException.class, () -> assuranceService.findById(0L));

        assertEquals(ErrorCodes.ASSURANCE_NOT_FOUND, expectedException.getErrorCode());
        assertEquals("Aucune assurance n'existe dans la base de donnees avec l'ID 0",expectedException.getMessage());
    }

    @Test(expected = EntityNotFoundException.class)
    public void shouldThrowEntityNotFoundException2Test(){
        assuranceService.findById(0L);
    }
}