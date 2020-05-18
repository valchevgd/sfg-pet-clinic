package com.github.valchevgd.sfgpetclinic.repositories;

import com.github.valchevgd.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
