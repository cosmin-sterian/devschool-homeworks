package com.ing.devschool;

import java.util.Map;

public class HomeWork {



    public static void main(String[] args) {
        ; // todo:

        try {
            Map<Integer, Transaction> transactionMap = MyCSVParser.parseTransactions();
            transactionMap.forEach((id, transaction) -> System.out.println("Id: " + id + ", transaction: " + transaction));
        } catch (DevSchoolException exception) {
            exception.printStackTrace();
        }
    }
}
