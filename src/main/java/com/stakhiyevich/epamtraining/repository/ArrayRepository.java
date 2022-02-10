package com.stakhiyevich.epamtraining.repository;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;

import java.util.ArrayList;
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

}
