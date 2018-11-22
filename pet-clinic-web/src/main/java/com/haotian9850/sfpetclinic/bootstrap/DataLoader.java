package com.haotian9850.sfpetclinic.bootstrap;

import com.haotian9850.sfpetclinic.model.*;
import com.haotian9850.sfpetclinic.services.OwnerService;
import com.haotian9850.sfpetclinic.services.PetTypeService;
import com.haotian9850.sfpetclinic.services.SpecialtyService;
import com.haotian9850.sfpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService){
        this.ownerService = ownerService;   //using the interface
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int cnt = petTypeService.findAll().size();
        if(cnt == 0) {
            localData();
        }
    }

    //refactored
    private void localData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType saveDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPatType = petTypeService.save(cat);

        //initialize specialties
        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology as a specialty!");

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery as a specialty!");

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry as a specialty!");

        Specialty savedRadiology = specialtyService.save(radiology);
        Specialty savedSurgery = specialtyService.save(surgery);
        Specialty savedDentistry = specialtyService.save(dentistry);


        Owner owner1 = new Owner();
        owner1.setFirstName("Haotian");
        owner1.setLastName("Liu");
        owner1.setAddress("2 DAVIS");
        owner1.setCity("Charlottesville");
        owner1.setTelephone("4344090928");

        Pet haotiansPet = new Pet();
        haotiansPet.setPetType(saveDogPetType);
        haotiansPet.setOwner(owner1);
        haotiansPet.setBirthDate(LocalDate.now());
        haotiansPet.setName("Rosco");
        owner1.getPets().add(haotiansPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Fiona");
        owner2.setLastName("Glenanne");
        owner2.setAddress("2 DAVIS");
        owner2.setCity("Charlottesville");
        owner2.setTelephone("4344090928");

        Pet fionasCat = new Pet();
        fionasCat.setPetType(savedCatPatType);
        fionasCat.setOwner(owner2);
        fionasCat.setName("Fiona's cat");
        fionasCat.setBirthDate(LocalDate.now());
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

        Owner owner3 = new Owner();
        owner3.setFirstName("Sam");
        owner3.setLastName("Axe");

        ownerService.save(owner3);


        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);  //give vet a specialty type
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialties().add(surgery);
        vetService.save(vet2);

        System.out.println("Loading data from Bootstrap dataloader...");
    }
}
