package com.stakhiyevich.epamtraining.repository;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.entity.comparator.ArrayComparator;
import com.stakhiyevich.epamtraining.repository.impl.ArraySpecificationId;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ArrayRepositoryTest {

    @BeforeMethod
    public void setUp() {

        ArrayEntity firstArray = new ArrayEntity(1, 3, 4, 5, 6);
        ArrayEntity secondArray = new ArrayEntity(8, 9, 4, 7, 1);
        ArrayEntity thirdArray = new ArrayEntity(0, 2, -4, 3, 4, 3);
        ArrayEntity fourthArray = new ArrayEntity(3, 5, 9);
        ArrayEntity fifthArray = new ArrayEntity(7, 1, 1, 1, 3);

        ArrayRepository repository = ArrayRepository.getInstance();
        repository.add(firstArray);
        repository.add(secondArray);
        repository.add(thirdArray);
        repository.add(fourthArray);
        repository.add(fifthArray);

    }

    @Test
    public void testRemove() {
        ArrayRepository repository = ArrayRepository.getInstance();
        ArrayEntity arrayForRemoving = repository.get(2);
        boolean actual = repository.remove(arrayForRemoving);

        assertTrue(actual);
    }


    @Test
    public void testBasicQueryArraySpecificationId() {

        ArraySpecification specification = new ArraySpecificationId(1);
        ArrayRepository repository = ArrayRepository.getInstance();

        List<ArrayEntity> arrayEntities = repository.basicQuery(specification);

        int actual = arrayEntities.size();
        int expected = 1;

        assertEquals(actual, expected);
    }

    @Test
    public void testStreamQueryArraySpecificationId() {

        ArraySpecification specification = new ArraySpecificationId(1);
        ArrayRepository repository = ArrayRepository.getInstance();

        List<ArrayEntity> arrayEntities = repository.streamQuery(specification);

        int actual = arrayEntities.size();
        int expected = 1;

        assertEquals(actual, expected);
    }

    @Test
    public void testSort() {
        //todo test sort
    }

}