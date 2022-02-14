package com.stakhiyevich.epamtraining.repository;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.entity.comparator.ArrayComparator;
import com.stakhiyevich.epamtraining.repository.impl.ArraySpecificationGreaterSum;
import com.stakhiyevich.epamtraining.repository.impl.ArraySpecificationId;
import com.stakhiyevich.epamtraining.repository.impl.ArraySpecificationLength;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ArrayRepositoryTest {

    @BeforeClass
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

        repository.remove(arrayForRemoving);

        int actual = repository.getAll().size();
        int expected = 4;

        assertEquals(actual, expected);
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
    public void testBasicQueryArraySpecificationGreaterSum() {

        ArraySpecification specification = new ArraySpecificationGreaterSum(15);
        ArrayRepository repository = ArrayRepository.getInstance();

        List<ArrayEntity> arrayEntities = repository.basicQuery(specification);

        int actual = arrayEntities.size();
        int expected = 3;

        assertEquals(actual, expected);
    }

    @Test
    public void testStreamQueryArraySpecificationGreaterSum() {

        ArraySpecification specification = new ArraySpecificationGreaterSum(15);
        ArrayRepository repository = ArrayRepository.getInstance();

        List<ArrayEntity> arrayEntities = repository.streamQuery(specification);

        int actual = arrayEntities.size();
        int expected = 3;

        assertEquals(actual, expected);

    }

    @Test
    public void testBasicQueryArraySpecificationLength() {

        ArraySpecification specification = new ArraySpecificationLength(6);
        ArrayRepository repository = ArrayRepository.getInstance();

        List<ArrayEntity> arrayEntities = repository.basicQuery(specification);

        int actual = arrayEntities.size();
        int expected = 1;

        assertEquals(actual, expected);

    }

    @Test
    public void testStreamQueryArraySpecificationLength() {

        ArraySpecification specification = new ArraySpecificationLength(5);
        ArrayRepository repository = ArrayRepository.getInstance();

        List<ArrayEntity> arrayEntities = repository.streamQuery(specification);

        int actual = arrayEntities.size();
        int expected = 3;

        assertEquals(actual, expected);

    }

    @Test
    public void testSort() {
        //todo test sort
    }


}