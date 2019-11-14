package mocks.crud.task.service;


import mocks.crud.task.repository.CrudRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import mocks.crud.task.model.Address;

import java.util.ArrayList;
import java.util.List;

import static mocks.crud.task.service.ServiceTestUtil.TEST_ADDRESS;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @Mock
    CrudRepository<Long, Address> repository;

    private AddressService service;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        service = new AddressService(repository);
    }
    @Test
    public void findByIdTest() {
        when(repository.findById(1L)).thenReturn(TEST_ADDRESS);
        Address result = service.findById(1L);
        assertEquals(result, TEST_ADDRESS);
        verify(repository, times(1)).findById(1L);
    }
    @Test
    public void findAllTest(){
        List<Address> list=new ArrayList<>();
        list.add(TEST_ADDRESS);
        when(repository.findAll()).thenReturn(list);
        List<Address> result = service.findAll();
        assertEquals(result, list);
        verify(repository, times(1)).findAll();
    }

}