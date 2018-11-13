package com.ing.devschool.transactions;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ing.devschool.transactions.serializers.TransactionItemsMapSerializer;

import java.util.*;
import java.util.function.BiConsumer;

@JsonSerialize(using = TransactionItemsMapSerializer.class)
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
            // transactionItemsMap.put(key, value);
        } else {
            transactionItemsMap.put(key, new TransactionItem(key, time));
        }
    }

    void remove(String key, Date time) {
        if (transactionItemsMap.containsKey(key)) {
            TransactionItem value = transactionItemsMap.get(key);
            value.decreaseCount(time);
            // transactionItemsMap.put(key, value);
        }
    }

    TransactionItem get(String key) {
        return transactionItemsMap.get(key);
    }

    public Set<Map.Entry<String, TransactionItem>> entrySet() {
        return transactionItemsMap.entrySet();
    }

    public Collection<TransactionItem> values() {
        /*
         * I don't know if it's a good practice to cast a collection to a List,
         * but I can't get to sort the items, it says that a Comparator doesn't
         * match for a List type, but there were no List keywords around
         */
        Collection<TransactionItem> values = transactionItemsMap.values();
        List<TransactionItem> valuesList;
        if (values instanceof List)
            valuesList = (List<TransactionItem>) values;
        else
            valuesList = new ArrayList<>(values);
        valuesList.sort(TransactionItem::compareTo);

        return valuesList;
    }

    int size() {
        return transactionItemsMap.size();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<String, TransactionItem> entry : transactionItemsMap.entrySet()) {
            result.append("Name: ").append(entry.getKey()).append(", item: ").append(entry.getValue());
        }

        return result.toString();
    }

    public void forEach(BiConsumer<String, TransactionItem> biConsumer) {
        transactionItemsMap.forEach(biConsumer);
    }

}
