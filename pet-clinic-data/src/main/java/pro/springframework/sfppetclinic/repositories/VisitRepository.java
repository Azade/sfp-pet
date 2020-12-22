package pro.springframework.sfppetclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import pro.springframework.sfppetclinic.model.Visit;

public interface VisitRepository  extends CrudRepository<Visit, Long> {
}
