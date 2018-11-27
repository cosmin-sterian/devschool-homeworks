package com.ing.devschool.transactions;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ing.devschool.DevSchoolException;
import com.ing.devschool.transactions.serializers.TransactionSerializer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@JsonSerialize(using = TransactionSerializer.class)
public class Transaction implements Comparable<Transaction> {

    private Integer transactionId;
    private String date;
    private TransactionItemsMap transactionItemsMap;

    public Transaction(Integer transactionId, String dateString) {
        this.transactionId = transactionId;
        /*
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            this.date = dateFormat.parse(dateString);
        } catch (ParseException exception) {
            exception.printStackTrace();
            throw new DevSchoolException(exception);
        }
        */
        this.date = dateString;
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

    public String getDate() {
        return date;
    }

    public TransactionItemsMap getTransactionItemsMap() {
        return transactionItemsMap;
    }

    private Date getTimeFromString(String timeString) throws DevSchoolException {
        Date time;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(transactionId, that.transactionId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(transactionId);
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", date=" + date +
                ", size=" + transactionItemsMap.size() +
                ", transactionItemsMap=" + transactionItemsMap +
                '}';
    }
}
