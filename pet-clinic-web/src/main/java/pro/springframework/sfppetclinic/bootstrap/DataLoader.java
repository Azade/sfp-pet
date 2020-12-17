package pro.springframework.sfppetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.springframework.sfppetclinic.model.Owner;
import pro.springframework.sfppetclinic.model.Vet;
import pro.springframework.sfppetclinic.services.OwnerService;
import pro.springframework.sfppetclinic.services.VetService;
import pro.springframework.sfppetclinic.services.map.OwnerServiceMap;
import pro.springframework.sfppetclinic.services.map.VetServiceMap;

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

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Helena");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Stephane");
        owner1.setLastName("Berrie");

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Al");
        vet1.setLastName("Smith");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Nina");
        vet2.setLastName("Smith");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");


    }
}














