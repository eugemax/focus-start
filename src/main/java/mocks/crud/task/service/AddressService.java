package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.repository.CrudRepository;
import java.util.List;



public class AddressService {
    CrudRepository<Long, Address> repository;

    public AddressService(CrudRepository<Long, Address> repository) {

        this.repository = repository;
    }

    public Address findById(Long id) {

        return repository.findById(id);
    }
    List<Address> findAll(){
        return repository.findAll();
    }
    Address update(Address element){
        return repository.update(element);
    }
}

