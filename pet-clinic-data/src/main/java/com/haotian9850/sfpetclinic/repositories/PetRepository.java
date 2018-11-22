package com.haotian9850.sfpetclinic.repositories;

import com.haotian9850.sfpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
