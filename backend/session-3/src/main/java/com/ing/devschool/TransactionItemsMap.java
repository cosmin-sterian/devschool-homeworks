package com.ing.devschool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TransactionItemsMap {
    /*
     * wrapper class over a hashmap
     */

    private Map<String, Integer> transactionsMap;

    TransactionItemsMap() {
        transactionsMap = new HashMap<>();
    }

    void add(String key) {
        if (transactionsMap.containsKey(key)) {
            Integer value = transactionsMap.get(key);
            value ++;
            transactionsMap.put(key, value);
        } else {
            transactionsMap.put(key, 1);
        }
    }

    void remove(String key) {
        if (transactionsMap.containsKey(key)) {
            Integer value = transactionsMap.get(key);
            if (value <= 0)
                return;
            value --;
            transactionsMap.put(key, value);
        }
    }

    public Integer get(String key) {
        return transactionsMap.get(key);
    }

    public Set<Map.Entry<String, Integer>> entrySet() {
        return transactionsMap.entrySet();
    }

    int size() {
        return transactionsMap.size();
    }

}
