package com.stakhiyevich.arrays.repository;

import com.stakhiyevich.arrays.entity.ArrayEntity;

@FunctionalInterface
public interface ArraySpecification {
    boolean specify(ArrayEntity array);
}
