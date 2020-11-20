package pro.springframework.sfppetclinic.services;

import pro.springframework.sfppetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{
    Owner findByLastName(String lastName);
}
