package com.stakhiyevich.epamtraining;

import com.stakhiyevich.epamtraining.entity.ArrayEntity;
import com.stakhiyevich.epamtraining.exception.ArrayException;
import com.stakhiyevich.epamtraining.exception.ParseException;
import com.stakhiyevich.epamtraining.exception.ReadException;
import com.stakhiyevich.epamtraining.factory.ArrayFactory;
import com.stakhiyevich.epamtraining.parser.ArrayParser;
import com.stakhiyevich.epamtraining.parser.impl.ArrayParserImpl;
import com.stakhiyevich.epamtraining.reader.ArrayReader;
import com.stakhiyevich.epamtraining.reader.impl.ArrayReaderImpl;
import com.stakhiyevich.epamtraining.service.ArrayService;
import com.stakhiyevich.epamtraining.service.ArraySortService;
import com.stakhiyevich.epamtraining.service.impl.ArrayServiceImpl;
import com.stakhiyevich.epamtraining.service.impl.ArraySortServiceImpl;

public class main {

    private static final String ARRAY_FILE_PATH = "data/input_data.txt";

    public static void main(String[] args) throws ArrayException {

        ArrayReader reader = new ArrayReaderImpl();
        ArrayEntity array = ArrayFactory.createArray();
        ArrayParser parser = new ArrayParserImpl();
        ArrayService service = new ArrayServiceImpl();

        try {
            String test = reader.readFile(ARRAY_FILE_PATH);
            System.out.println(test);
            array = parser.parseValue(test);
        } catch (ReadException | ParseException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < array.getArrayLength(); i++) {
            System.out.println(array.getElement(i));
        }

        System.out.println("==================");

        System.out.println(service.getMinElement(array));

        System.out.println("=====================");

        ArraySortService sortService = new ArraySortServiceImpl();
//        sortService.heapSort(array);
//        for (int i = 0; i < array.getArrayLength(); i++) {
//            System.out.print(array.getElement(i) + " ");
//        }

        System.out.println("=====================");

        sortService.bubbleSort(array, array.getArrayLength());
        for (int i = 0; i < array.getArrayLength(); i++) {
            System.out.print(array.getElement(i) + " ");
        }

    }
}
