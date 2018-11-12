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
    private static final int DATE = 0;
    private static final int TIME = 1;
    private static final int TRANSACTION = 2;
    private static final int ITEM = 3;

    public static List<String[]> readAllLines() throws DevSchoolException {

        List<String[]> content;
        Reader reader;
        CSVReader csvReader;

        try {
            reader = Files.newBufferedReader(
                    Paths.get("src/main/resources/bakery-transactions.csv")
            );
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new DevSchoolException("Couldn't properly open file", exception);
        }
        csvReader = new CSVReader(reader);
        content = new LinkedList<>();
        String[] line = null;
        try {
            csvReader.readNext(); // Get past the first line which represents the columns' names
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        do {
            try {
                line = csvReader.readNext();
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            if (line != null) {
                content.add(line);
            }
        } while (line != null);

        try {
            reader.close();
            csvReader.close();
        } catch (IOException exception) {
            exception.printStackTrace();
            throw new DevSchoolException("Couldn't properly close reader and csv reader", exception);
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
            // We can't go further with a null list
        }

        Map<Integer, Transaction> transactionsMap = new HashMap<>();
        for (String[] line : csvTransactionsList) {
            String dateString = line[DATE];
            /*
             * I don't know what to do with the time,
             * it's not needed in the output, unless
             * the "inner" transactions are sorted by time
             */
            String timeString = line[TIME];
            Integer transactionId = Integer.parseInt(line[TRANSACTION]);
            String itemName = line[ITEM];

            // Check if transaction exists
            if (transactionsMap.containsKey(transactionId)) {
                // It exists, grab the object
                Transaction transaction = transactionsMap.get(transactionId);
                transaction.addTransaction(itemName, timeString);
            } else {
                // Create a new object
                Transaction transaction = new Transaction(transactionId, dateString);
                transaction.addTransaction(itemName, timeString);
                transactionsMap.put(transactionId, transaction);
            }
        }

        return transactionsMap;

    }

}
