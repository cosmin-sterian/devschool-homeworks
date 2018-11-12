package com.ing.devschool;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TransactionItemsMap {
    /*
     * wrapper class over a hashmap
     */

    private Map<String, TransactionItem> transactionItemsMap;

    TransactionItemsMap() {
        transactionItemsMap = new HashMap<>();
    }

    void add(String key, Date time) {
        if (transactionItemsMap.containsKey(key)) {
            TransactionItem value = transactionItemsMap.get(key);
            value.increaseCount(time);
            transactionItemsMap.put(key, value);
        } else {
            transactionItemsMap.put(key, new TransactionItem(key, time));
        }
    }

    void remove(String key, Date time) {
        if (transactionItemsMap.containsKey(key)) {
            TransactionItem value = transactionItemsMap.get(key);
            value.decreaseCount(time);
            transactionItemsMap.put(key, value);
        }
    }

    public TransactionItem get(String key) {
        return transactionItemsMap.get(key);
    }

    public Set<Map.Entry<String, TransactionItem>> entrySet() {
        return transactionItemsMap.entrySet();
    }

    int size() {
        return transactionItemsMap.size();
    }

}
