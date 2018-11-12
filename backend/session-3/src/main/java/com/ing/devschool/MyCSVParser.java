package com.ing.devschool;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MyCSVParser {
    public static final int DATE = 0;
    public static final int TIME = 1;
    public static final int TRANSACTION = 2;
    public static final int ITEM = 3;

    public static List<String[]> readAllLines() throws DevSchoolException {

        List<String[]> content;
        Reader reader;
        CSVReader csvReader;

        try {
            reader = Files.newBufferedReader(
                    Paths.get("src/main/resources/bakery-transactions.csv")
            );
            csvReader = new CSVReader(reader);
            content = new LinkedList<>();
            String[] line;
            csvReader.readNext(); // Get past the first line which represents the columns' names
            while ((line = csvReader.readNext()) != null) {
                content.add(line);
            }

            // For some reason I can't close these in a "finally" block, they still
            // throw an IOException
            reader.close();
            csvReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new DevSchoolException(exception);
        }

        return content;

    }

    public static Map<Integer, Transaction> parseTransactions() throws DevSchoolException {

        List<String[]> csvTransactionsList;

        try {
            csvTransactionsList = readAllLines();
        } catch (DevSchoolException exception) {
            exception.printStackTrace();
            throw new DevSchoolException("readAllLines failed while trying to get the csv transactions list", exception);
            return null; // We can't go further with a null list
        }

        Map<Integer, Transaction> transactionsMap = new HashMap<>();
        for (String[] line : csvTransactionsList) {
            String dateString = line[DATE];
            /*
             * I don't know what to do with the time,
             * it's not needed in the output, unless
             * the "inner" transactions are sorted by time
             */
            Integer transactionId = Integer.parseInt(line[TRANSACTION]);
        }

    }

}
