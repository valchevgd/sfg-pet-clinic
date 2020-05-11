package com.github.valchevgd.sfgpetclinic.services;

import com.github.valchevgd.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
