package com.haotian9850.sfpetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import com.haotian9850.sfpetclinic.model.Owner;


public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String name);

}
