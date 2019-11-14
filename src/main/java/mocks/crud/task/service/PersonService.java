package mocks.crud.task.service;

import mocks.crud.task.model.Address;
import mocks.crud.task.repository.CrudRepository;
import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;
import mocks.crud.task.repository.AdvancedRepository;
import mocks.crud.task.repository.CrudRepository;

import java.util.List;

public class PersonService{

    private AddressService addressService;

    private AdvancedRepository<Person> personRepository;

    public PersonService(AdvancedRepository repository,AddressService addressService) {
        this.addressService = addressService;
        this.personRepository=repository;
    }

    public List<Person> findAllRelatives(Person person) {

        return personRepository.findAllRelatives(person);
    }

    public Address getAddress(Person person) {

        return personRepository.getAddress(person);
    }

    public void save(Person element) {
        personRepository.save(element);
    }

    public Person findById(Long id) {

        return personRepository.findById(id);
    }

    public List<Person> findAll() {

        return personRepository.findAll();
    }

    public Person update(Person element) {

        return personRepository.update(element);
    }

    public void delete(Person element) {
        personRepository.update(element);
    }
}
