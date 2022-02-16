package com.stakhiyevich.epamtraining.repository;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.entity.comparator.ArrayComparatorId;
import com.stakhiyevich.epamtraining.entity.comparator.ArrayComparatorLength;
import com.stakhiyevich.epamtraining.repository.impl.ArraySpecificationGreaterSum;
import com.stakhiyevich.epamtraining.repository.impl.ArraySpecificationId;
import com.stakhiyevich.epamtraining.repository.impl.ArraySpecificationLength;
import com.stakhiyevich.epamtraining.util.IdGenerator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ArrayRepositoryTest {

    @BeforeClass
    public void setUp() {

        IdGenerator.resetId();
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
    public void testBasicQueryArraySpecificationId() {

        ArraySpecification specification = new ArraySpecificationId(1);
        ArrayRepository repository = ArrayRepository.getInstance();
        List<ArrayEntity> test = repository.getAll();
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
    public void testSortById() {

        ArrayRepository repository = ArrayRepository.getInstance();
        repository.get(0).setArrayId(2);
        repository.get(1).setArrayId(1);
        List<ArrayEntity> actual = repository.sortById(new ArrayComparatorId());

        ArrayEntity firstArray = new ArrayEntity(1, 3, 4, 5, 6);
        ArrayEntity secondArray = new ArrayEntity(8, 9, 4, 7, 1);
        ArrayEntity thirdArray = new ArrayEntity(0, 2, -4, 3, 4, 3);
        ArrayEntity fourthArray = new ArrayEntity(3, 5, 9);
        ArrayEntity fifthArray = new ArrayEntity(7, 1, 1, 1, 3);

        List<ArrayEntity> expected = List.of(secondArray, firstArray, thirdArray, fourthArray, fifthArray);

        assertEquals(actual, expected);
    }

    @Test
    public void testSortByLength() {

        ArrayRepository repository = ArrayRepository.getInstance();
        List<ArrayEntity> actual = repository.sortById(new ArrayComparatorLength());

        ArrayEntity firstArray = new ArrayEntity(1, 3, 4, 5, 6);
        ArrayEntity secondArray = new ArrayEntity(8, 9, 4, 7, 1);
        ArrayEntity thirdArray = new ArrayEntity(0, 2, -4, 3, 4, 3);
        ArrayEntity fourthArray = new ArrayEntity(3, 5, 9);
        ArrayEntity fifthArray = new ArrayEntity(7, 1, 1, 1, 3);

        List<ArrayEntity> expected = List.of(fourthArray, firstArray, secondArray, fifthArray, thirdArray);

        assertEquals(actual, expected);
    }

}