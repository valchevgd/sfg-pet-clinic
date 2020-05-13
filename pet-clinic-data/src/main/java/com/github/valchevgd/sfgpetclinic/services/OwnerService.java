package com.github.valchevgd.sfgpetclinic.services;

import com.github.valchevgd.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName();
}
