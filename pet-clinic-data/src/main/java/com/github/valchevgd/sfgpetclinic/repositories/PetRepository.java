package com.github.valchevgd.sfgpetclinic.repositories;

import com.github.valchevgd.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
