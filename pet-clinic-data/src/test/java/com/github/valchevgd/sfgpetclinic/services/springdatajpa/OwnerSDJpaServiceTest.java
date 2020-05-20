package com.github.valchevgd.sfgpetclinic.services.springdatajpa;

import com.github.valchevgd.sfgpetclinic.model.Owner;
import com.github.valchevgd.sfgpetclinic.repositories.OwnerRepository;
import com.github.valchevgd.sfgpetclinic.repositories.PetRepository;
import com.github.valchevgd.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerService;

    Owner owner;

    @BeforeEach
    void setUp() {
        owner = new Owner();
        owner.setId(1L);
        owner.setLastName(LAST_NAME);
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(owner);

        Owner smith = ownerService.findByLastName(LAST_NAME);

        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAll() {

        Set<Owner> returnOwnersSet = new HashSet<>();
        returnOwnersSet.add(Owner.builder().build());
        returnOwnersSet.add(Owner.builder().build());

        when(ownerRepository.findAll()).thenReturn(returnOwnersSet);

        Set<Owner> owners = ownerService.findAll();

        assertNotNull(owners);
        assertEquals(2, owners.size());
    }

    @Test
    void findById() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(owner));

        Owner owner1 = ownerService.findById(1L);
        assertNotNull(owner1);
    }

    @Test
    void findByIdNoFound() {

        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner1 = ownerService.findById(1L);
        assertNull(owner1);
    }

    @Test
    void save() {

        Owner ownerToSave = Owner.builder().build();

        when(ownerRepository.save(any())).thenReturn(owner);

        Owner savedOwner = ownerService.save(ownerToSave);

        assertNotNull(savedOwner);
    }

    @Test
    void delete() {
        ownerService.delete(owner);

        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {

        ownerService.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }
}