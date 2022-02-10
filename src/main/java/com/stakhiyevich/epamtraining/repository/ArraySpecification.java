package com.stakhiyevich.epamtraining.repository;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;

@FunctionalInterface
public interface ArraySpecification {
    boolean specify(ArrayEntity array);
}
