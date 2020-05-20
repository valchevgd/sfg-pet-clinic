package com.github.valchevgd.sfgpetclinic.services.map;

import com.github.valchevgd.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    final Long ownerId = 2L;
    final String lastName = "Valchev";

    @BeforeEach
    void setUp() {

        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        Owner owner = Owner.builder().build();
        owner.setLastName(lastName);
        ownerServiceMap.save(owner);
        Owner owner2 = Owner.builder().build();
        owner2.setLastName("Lastname");
        ownerServiceMap.save(owner2);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(owners.size(), 2);
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);

        assertEquals(ownerServiceMap.findAll().size(), 1);
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertEquals(ownerServiceMap.findAll().size(), 1);
    }

    @Test
    void saveExistingId() {
        Long id = 3L;

        Owner owner = new Owner();
        owner.setId(id);
        Owner savedOwner = ownerServiceMap.save(owner);

        assertEquals(savedOwner.getId(), id);
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findById() {
        Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(owner.getId(), ownerId);
    }

    @Test
    void findByLastName() {

        Owner owner = ownerServiceMap.findById(ownerId);
        owner.setLastName(lastName);

        Owner findOwner = ownerServiceMap.findByLastName(lastName);

        assertNotNull(findOwner);
        assertEquals(findOwner.getId(), ownerId);
    }

    @Test
    void findByLastNameNotFound() {
        Owner findOwner = ownerServiceMap.findByLastName("foo");

        assertNull(findOwner);
    }
}