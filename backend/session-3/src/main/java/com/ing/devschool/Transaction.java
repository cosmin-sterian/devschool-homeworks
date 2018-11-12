package com.ing.devschool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction implements Comparable<Transaction> {

    private Integer transactionId;
    private Date date;
    private TransactionItemsMap transactionItemsMap;

    public Transaction(Integer transactionId, String dateString) throws DevSchoolException {
        this.transactionId = transactionId;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            this.date = dateFormat.parse(dateString);
        } catch (ParseException exception) {
            exception.printStackTrace();
            throw new DevSchoolException(exception);
        }
        transactionItemsMap = new TransactionItemsMap();
    }

    public void addTransaction(String name) {
        transactionItemsMap.add(name);
    }

    public void removeTransaction(String name) {
        transactionItemsMap.remove(name);
    }

    public int getTransaction(String name) {
        return transactionItemsMap.get(name);
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public int compareTo(Transaction t) {
        int mySize = this.transactionItemsMap.size();
        int othersSize = t.transactionItemsMap.size();
        if (mySize == othersSize) {
            return this.transactionId - t.transactionId;
        }
        return mySize - othersSize;
    }
}
