package mocks.crud.task.service;


import mocks.crud.example.Book;
import mocks.crud.task.model.Address;
import mocks.crud.task.model.Person;

public final class ServiceTestUtil {

    public static final Person TEST_PERSON1, TEST_PERSON2, TEST_PERSON3, TEST_PERSON4;
    public static final Address TEST_ADDRESS;

    static {
        TEST_ADDRESS=new Address();
        TEST_ADDRESS.setId(1L);
        TEST_ADDRESS.setAddress("Broadway");
        TEST_PERSON1 = new Person(1L,"Alexander",85, TEST_ADDRESS);
        TEST_PERSON2=new Person(2L,"Victoria",20,TEST_ADDRESS);
        TEST_PERSON3=new Person(3L,"Maria",54,TEST_ADDRESS);
        TEST_PERSON4=new Person(4L,"Boris",55,TEST_ADDRESS);


    }
}
