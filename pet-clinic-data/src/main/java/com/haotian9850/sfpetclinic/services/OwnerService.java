package com.haotian9850.sfpetclinic.services;

import com.haotian9850.sfpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {
    Owner findByLastName(String lastName);
}
