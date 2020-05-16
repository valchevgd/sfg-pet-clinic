package com.github.valchevgd.sfgpetclinic.bootstrap;

import com.github.valchevgd.sfgpetclinic.model.*;
import com.github.valchevgd.sfgpetclinic.services.OwnerService;
import com.github.valchevgd.sfgpetclinic.services.PetTypeService;
import com.github.valchevgd.sfgpetclinic.services.SpecialtyService;
import com.github.valchevgd.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {

            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Loaded Pet Types...");

        Owner owner = new Owner();
        owner.setFirstName("Ivan");
        owner.setLastName("Valchev");
        owner.setAddress("123 Main Str.");
        owner.setCity("Sofia");
        owner.setTelephone("+555 265 784");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Georgi");
        owner2.setLastName("Valchev");
        owner2.setAddress("256 Main Str.");
        owner2.setCity("Sofia");
        owner2.setTelephone("+555 485 542");

        Pet rusty = new Pet();
        rusty.setPetType(savedDogPetType);
        rusty.setName("Rusty");
        rusty.setBirthDay(LocalDate.now());
        rusty.setOwner(owner2);

        owner2.getPets().add(rusty);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

        System.out.println("Loaded Specialities...");

        Vet vet = new Vet();
        vet.setFirstName("Alex");
        vet.setLastName("Rod");
        vet.getSpecialities().add(radiology);
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nelly");
        vet2.setLastName("Mlad");
        vet2.getSpecialities().add(surgery);
        vet2.getSpecialities().add(dentistry);
        vetService.save(vet2);

        System.out.println("Loaded Vets...");
    }
}
