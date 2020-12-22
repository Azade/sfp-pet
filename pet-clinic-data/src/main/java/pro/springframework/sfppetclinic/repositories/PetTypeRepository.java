package pro.springframework.sfppetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.springframework.sfppetclinic.model.PetType;

public interface PetTypeRepository  extends CrudRepository<PetType, Long> {
}
