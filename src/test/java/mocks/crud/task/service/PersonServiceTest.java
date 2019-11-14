package mocks.crud.task.service;

import mocks.crud.task.repository.AdvancedRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import mocks.crud.task.model.Address;
import mocks.crud.task.repository.CrudRepository;
import static org.junit.Assert.*;
import mocks.crud.task.model.Person;
import static mocks.crud.task.service.ServiceTestUtil.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class PersonServiceTest {

    @Mock
    CrudRepository<Long, Address> repository;

    @Mock
    AdvancedRepository<Person>advancedRepository;

    private AddressService addressService;
    private PersonService personService;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        addressService=new AddressService(repository);
        personService = new PersonService(advancedRepository, addressService);
    }
    @Test
    public void getAddressTest(){
        when(advancedRepository.getAddress(TEST_PERSON1)).thenReturn(TEST_ADDRESS);
        Address result=personService.getAddress(TEST_PERSON1);
        assertEquals(result,TEST_ADDRESS);
        verify(advancedRepository, times(1)).getAddress(TEST_PERSON1);
    }
    @Test
    public void findAllRelativesTest(){
        List<Person> list=new ArrayList<>();
        list.add(TEST_PERSON2);
        list.add(TEST_PERSON3);
        when(advancedRepository.findAllRelatives(TEST_PERSON1)).thenReturn(list);
        List<Person> result = personService.findAllRelatives(TEST_PERSON1);
        assertEquals(result, list);
        verify(advancedRepository, times(1)).findAllRelatives(TEST_PERSON1);
    }

}