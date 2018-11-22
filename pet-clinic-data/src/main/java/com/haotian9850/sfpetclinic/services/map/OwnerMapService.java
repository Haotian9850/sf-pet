package com.haotian9850.sfpetclinic.services.map;

import com.haotian9850.sfpetclinic.model.Owner;
import com.haotian9850.sfpetclinic.model.Pet;
import com.haotian9850.sfpetclinic.services.OwnerService;
import com.haotian9850.sfpetclinic.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService{
    
    private final PetTypeMapService petTypeMapService;
    private final PetService petService;

    public OwnerMapService(PetTypeMapService petTypeMapService, PetService petService) {
        this.petTypeMapService = petTypeMapService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Owner save(Owner object) {
        Owner savedOwner = null;
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() == null){
                            pet.setPetType(petTypeMapService.save(pet.getPetType()));   //consolidate pet type
                        }
                    }else{
                        throw new RuntimeException("Pet type is required!");
                    }

                    if(pet.getId() == null){
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);
        }else{
            return null;
        }
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
