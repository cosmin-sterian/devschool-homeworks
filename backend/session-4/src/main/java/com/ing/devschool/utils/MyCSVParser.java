package com.ing.devschool.utils;

import com.ing.devschool.DevSchoolException;
import com.ing.devschool.transactions.Transaction;
import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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

    public static List<Transaction> parseTransactions() throws DevSchoolException {

        List<String[]> csvTransactionsList;

        try {
            csvTransactionsList = readAllLines();
        } catch (DevSchoolException exception) {
            exception.printStackTrace();
            throw new DevSchoolException("readAllLines failed while trying to get the csv transactions list", exception);
            // We can't go further with a null list
        }

        List<Transaction> transactionsList = new ArrayList<>();
        for (String[] line : csvTransactionsList) {
            String dateString = line[DATE];
            /*
             * I don't know what to do with the time,
             * it's not needed in the output, unless
             * the "inner" transactions are sorted by time
             */
            String timeString = line[DATE] + " " + line[TIME];
            Integer transactionId = Integer.parseInt(line[TRANSACTION]);
            String itemName = line[ITEM];

            Transaction transaction = new Transaction(transactionId, dateString);
            // Check if transaction exists
            if (transactionsList.contains(transaction)) {
                // It exists, grab the object
                transaction = transactionsList.get(transactionsList.indexOf(transaction));
                transaction.addTransaction(itemName, timeString);
            } else {
                // Insert a new object
                transaction.addTransaction(itemName, timeString);
                transactionsList.add(transaction);
            }
            transactionsList.sort(Transaction::compareTo);
        }

        return transactionsList;

    }

}
