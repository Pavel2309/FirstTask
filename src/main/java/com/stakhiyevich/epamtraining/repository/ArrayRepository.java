package com.stakhiyevich.epamtraining.repository;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayRepository {

    private final List<ArrayEntity> arrayEntityList;
    private static ArrayRepository instance;

    private ArrayRepository() {
        arrayEntityList = new ArrayList<>();
    }

    public static ArrayRepository getInstance() {
        if (instance == null) {
            instance = new ArrayRepository();
        }
        return instance;
    }

    public List<ArrayEntity> basicQuery(ArraySpecification specification) {

        List<ArrayEntity> queryResultList = new ArrayList<>();

        for (ArrayEntity arrayEntity : arrayEntityList) {
            if (specification.specify(arrayEntity)) {
                queryResultList.add(arrayEntity);
            }
        }

        return queryResultList;
    }

    public List<ArrayEntity> streamQuery(ArraySpecification specification) {
        return arrayEntityList.stream()
                .filter(specification::specify)
                .toList();
    }

    public boolean add(ArrayEntity arrayEntity) {
        return arrayEntityList.add(arrayEntity);
    }

    public void add(int index, ArrayEntity arrayEntity) {
        arrayEntityList.add(index, arrayEntity);
    }

    public void set(int index, ArrayEntity arrayEntity) {
        arrayEntityList.set(index, arrayEntity);
    }

    public boolean remove(ArrayEntity arrayEntity) {
        return arrayEntityList.remove(arrayEntity);
    }

    public ArrayEntity get(int index) {
        return arrayEntityList.get(index);
    }

    public List<ArrayEntity> sort(Comparator<? super ArrayEntity> comparator) {
        return arrayEntityList.stream().sorted(comparator).toList();
    }

}
