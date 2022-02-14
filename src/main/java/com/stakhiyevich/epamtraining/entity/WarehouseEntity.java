package com.stakhiyevich.epamtraining.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class WarehouseEntity {

    private static final Logger logger = LogManager.getLogger();
    private static WarehouseEntity instance;
    private final Map<Long, ArrayStatisticEntity> storage;

    private WarehouseEntity() {
        storage = new HashMap<>();
    }

    public static WarehouseEntity getInstance() {
        if (instance == null) {
            instance = new WarehouseEntity();
        }
        return instance;
    }

    public ArrayStatisticEntity getStatistics(Long arrayId) {
        return storage.get(arrayId);
    }

    public void putStatistics(Long arrayId, ArrayStatisticEntity arrayStatistics) {
        storage.put(arrayId, arrayStatistics);
        logger.info("statistics has been added for an array with id {}", arrayId);
    }

    public void putStatistics(Long arrayId, int max, int min, double average,
                              int numberOfPositiveElements, int numberOfNegativeElements) {
        ArrayStatisticEntity arrayStatistics = new ArrayStatisticEntity(max, min, average, numberOfPositiveElements, numberOfNegativeElements);
        putStatistics(arrayId, arrayStatistics);
        logger.info("statistics has been added for an array with id {}", arrayId);
    }

    public void updateStatistics(Long arrayId, ArrayStatisticEntity arrayStatistics) {
        if (storage.containsKey(arrayId)) {
            storage.replace(arrayId, arrayStatistics);
        } else {
            logger.error("can't find statistics for array with id {}", arrayId);
        }
    }

    public void updateStatistics(Long arrayId, int max, int min, double average,
                                 int numberOfPositiveElements, int numberOfNegativeElements) {

        if (storage.containsKey(arrayId)) {
            storage.replace(arrayId, new ArrayStatisticEntity(max, min, average,
                    numberOfPositiveElements, numberOfNegativeElements));
        } else {
            logger.error("can't find statistics for an array with id {}", arrayId);
        }

    }

}
