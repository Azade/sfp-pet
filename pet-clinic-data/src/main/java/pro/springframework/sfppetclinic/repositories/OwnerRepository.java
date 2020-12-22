package pro.springframework.sfppetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.springframework.sfppetclinic.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
