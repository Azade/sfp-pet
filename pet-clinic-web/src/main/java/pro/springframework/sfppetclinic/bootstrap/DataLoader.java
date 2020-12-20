package pro.springframework.sfppetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.springframework.sfppetclinic.model.Owner;
import pro.springframework.sfppetclinic.model.Pet;
import pro.springframework.sfppetclinic.model.PetType;
import pro.springframework.sfppetclinic.model.Vet;
import pro.springframework.sfppetclinic.services.OwnerService;
import pro.springframework.sfppetclinic.services.PetTypeService;
import pro.springframework.sfppetclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Helena");
        owner1.setLastName("Weston");
        owner1.setAddress("125 Hillview");
        owner1.setCity("Los Angeles");
        owner1.setTelephone("4083214556");

        Pet HelenaPet = new Pet();
        HelenaPet.setPetType(savedDogType);
        HelenaPet.setOwner(owner1);
        HelenaPet.setBirthDate(LocalDate.now());
        HelenaPet.setName("Cotton");
        owner1.getPets().add(HelenaPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Stephane");
        owner2.setLastName("Berrie");
        owner2.setAddress("125 El Mont");
        owner2.setCity("Los Altos");
        owner2.setTelephone("4083214556");

        Pet StephanePet = new Pet();
        StephanePet.setPetType(savedCatType);
        StephanePet.setOwner(owner2);
        StephanePet.setBirthDate(LocalDate.now());
        StephanePet.setName("JJ");
        owner2.getPets().add(StephanePet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Al");
        vet1.setLastName("Smith");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nina");
        vet2.setLastName("Smith");

        vetService.save(vet2);

        System.out.println("Loaded Vets....");

    }
}



