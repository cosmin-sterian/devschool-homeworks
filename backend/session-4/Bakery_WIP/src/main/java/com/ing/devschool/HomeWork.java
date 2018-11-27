package com.ing.devschool;

import com.ing.devschool.transactions.Transaction;
import com.ing.devschool.utils.MyCSVParser;
import com.ing.devschool.utils.MyJSONWriter;

import java.util.List;

public class HomeWork {

    public static void main(String[] args) {
        try {
            List<Transaction> transactionsList = MyCSVParser.parseTransactions();
            MyJSONWriter.writeJSON(transactionsList); // Array elements are not indented like in the example :(
        } catch (DevSchoolException exception) {
            exception.printStackTrace();
        }
    }
}
