package pro.springframework.sfppetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.springframework.sfppetclinic.model.Vet;

public interface VetRepository  extends CrudRepository<Vet, Long> {
}
