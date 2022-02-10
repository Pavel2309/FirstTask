package com.stakhiyevich.epamtraining.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class WarehouseEntity {

    private static final Logger logger = LogManager.getLogger();
    private static WarehouseEntity instance;
    private final Map<Long, ArrayStatisticsEntity> storage;

    private WarehouseEntity() {
        storage = new HashMap<>();
    }

    public static WarehouseEntity getInstance() {
        if (instance == null) {
            instance = new WarehouseEntity();
        }
        return instance;
    }

    public ArrayStatisticsEntity getStatistics(Integer key) {
        return storage.get(key);
    }

    public ArrayStatisticsEntity updateStatistics(Long key, ArrayStatisticsEntity value) {
        return storage.replace(key, value);
    }

}
