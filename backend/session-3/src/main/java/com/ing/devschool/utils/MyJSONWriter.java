package com.ing.devschool.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ing.devschool.DevSchoolException;

import java.io.File;
import java.io.IOException;

public class MyJSONWriter {

    public static void writeJSON(Object o) throws DevSchoolException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(new File("src/main/resources/bakery-summary.json"), o);
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new DevSchoolException("Could not write JSON file, propably missing write permissions", exception);
        }
    }

}
