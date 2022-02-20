package com.stakhiyevich.arrays.util;

public class IdGenerator {

    private static long id = 0L;

    private IdGenerator() {

    }

    public static long generateId() {
        return ++id;
    }

    public static void resetId() {
        id = 0L;
    }

}
