package com.ing.devschool;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.devschool.transactions.Transaction;
import com.ing.devschool.utils.MyCSVParser;

import java.util.List;

public class HomeWork {



    public static void main(String[] args) {
        ; // todo:

        try {
            List<Transaction> transactionsList = MyCSVParser.parseTransactions();
            // transactionsList.forEach(System.out::println);
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(objectMapper.writeValueAsString(transactionsList));
        } catch (DevSchoolException | JsonProcessingException exception) {
            exception.printStackTrace();
        }
    }
}
