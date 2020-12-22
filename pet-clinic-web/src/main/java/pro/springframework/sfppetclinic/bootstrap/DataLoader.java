package pro.springframework.sfppetclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pro.springframework.sfppetclinic.model.*;
import pro.springframework.sfppetclinic.services.*;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService,
                      SpecialtyService specialtyService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }
    }

    private void loadData(){
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");
        Speciality savedRadiology = specialtyService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");
        Speciality savedSurgery = specialtyService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");
        Speciality savedDentistry = specialtyService.save(dentistry);

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

        Visit catVisit = new Visit();
        catVisit.setPet(StephanePet);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("kitten");

        visitService.save(catVisit);

        System.out.println("Loaded Owners....");

        Vet vet1 = new Vet();
        vet1.setFirstName("Al");
        vet1.setLastName("Smith");
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Nina");
        vet2.setLastName("Smith");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Loaded Vets....");
    }
}



