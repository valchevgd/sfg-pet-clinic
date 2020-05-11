package com.github.valchevgd.sfgpetclinic.services;

import com.github.valchevgd.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
