package com.github.valchevgd.sfgpetclinic.bootstrap;

import com.github.valchevgd.sfgpetclinic.model.Owner;
import com.github.valchevgd.sfgpetclinic.model.Vet;
import com.github.valchevgd.sfgpetclinic.services.OwnerService;
import com.github.valchevgd.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setFirstName("Ivan");
        owner.setLastName("Valchev");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Georgi");
        owner2.setLastName("Valchev");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet = new Vet();
        vet.setFirstName("Alex");
        vet.setLastName("Rod");
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nelly");
        vet2.setLastName("Mlad");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
