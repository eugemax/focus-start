package mocks.crud.task.repository;

import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;

import java.util.List;

/**
 * Дополнительный репозиторий
 */
public interface AdvancedRepository <Person>{
    Person findById(Long id);
    Person update(Person element);
    void delete(Person element);
    void save(Person element);
    List<Person> findAll();
    /**
     * Метод для поиска родственников
     * @param person человек, родственников которого нужно найти
     * @return список родственников
     */
    List<Person> findAllRelatives(Person person);

    /**
     * Метод для поиска адреса пользователя
     * @param person человек, адрес которого нужно найти
     * @return список родственников
     */
    Address getAddress(Person person);
}
