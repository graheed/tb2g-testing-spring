package org.springframework.samples.petclinic.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.samples.petclinic.model.PetType;
import org.springframework.samples.petclinic.repository.PetRepository;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@ExtendWith(MockitoExtension.class)
class ClinicServiceImplTest {

    @Mock
    PetRepository petRepository;

    @InjectMocks
    ClinicServiceImpl clinicService;
    @BeforeEach
    void setUp() {
        given(petRepository.findPetTypes()).willReturn(new ArrayList<>(){{
            add(new PetType());
        }});
    }

    @Test
    void findPetTypes() {
        //when
        Collection<PetType> petTypeCollection = clinicService.findPetTypes();

        //then
        then(petRepository).should().findPetTypes();
        assertThat(petTypeCollection.size() == 1);
    }
}