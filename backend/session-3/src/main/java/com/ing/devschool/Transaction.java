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

    public void addTransaction(String name, String timeString) throws DevSchoolException {
        Date time;

        try {
            time = getTimeFromString(timeString);
        } catch (DevSchoolException exception) {
            exception.printStackTrace();
            throw new DevSchoolException(exception);
        }

        transactionItemsMap.add(name, time);
    }

    public void removeTransaction(String name, String timeString) throws DevSchoolException {
        Date time;

        try {
            time = getTimeFromString(timeString);
        } catch (DevSchoolException exception) {
            exception.printStackTrace();
            throw new DevSchoolException(exception);
        }

        transactionItemsMap.remove(name, time);
    }

    public TransactionItem getTransaction(String name) {
        return transactionItemsMap.get(name);
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public Date getDate() {
        return date;
    }

    private Date getTimeFromString(String timeString) throws DevSchoolException {
        Date time;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            time = dateFormat.parse(timeString);
        } catch (ParseException exception) {
            exception.printStackTrace();
            throw new DevSchoolException(exception);
        }

        return time;
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

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", date=" + date +
                ", transactionItemsMap=" + transactionItemsMap +
                '}';
    }
}
