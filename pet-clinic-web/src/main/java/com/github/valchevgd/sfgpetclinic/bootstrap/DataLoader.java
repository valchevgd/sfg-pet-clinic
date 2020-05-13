package com.github.valchevgd.sfgpetclinic.bootstrap;

import com.github.valchevgd.sfgpetclinic.model.Owner;
import com.github.valchevgd.sfgpetclinic.model.Vet;
import com.github.valchevgd.sfgpetclinic.services.OwnerService;
import com.github.valchevgd.sfgpetclinic.services.VetService;
import com.github.valchevgd.sfgpetclinic.services.map.OwnerServiceMap;
import com.github.valchevgd.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Ivan");
        owner.setLastName("Valchev");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Georgi");
        owner2.setLastName("Valchev");
        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Alex");
        vet.setLastName("Rod");
        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Nelly");
        vet2.setLastName("Mlad");
        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
