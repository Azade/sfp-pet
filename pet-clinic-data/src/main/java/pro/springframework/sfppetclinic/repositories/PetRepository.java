package pro.springframework.sfppetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.springframework.sfppetclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {

}
