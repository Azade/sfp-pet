package pro.springframework.sfppetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.springframework.sfppetclinic.model.Speciality;

public interface SpecialtyRepository  extends CrudRepository<Speciality, Long> {
}
