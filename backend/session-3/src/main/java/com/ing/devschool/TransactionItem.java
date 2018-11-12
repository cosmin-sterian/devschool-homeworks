package com.ing.devschool;

import java.util.Date;

public class TransactionItem {
    /*
     * What should I do with the time variable?
     * I can't just abandon it, it looks odd,
     * but if I have to sort the TransactionItems
     * by the time, what happens when there's another
     * item bough, so the count increases?
     * Will it be shown lower in the transaction list?
     */

    private String name;
    private int count;
    private Date time;

    TransactionItem(String name, Date time) {
        this.name = name;
        this.count = 1;
        this.time = time;
    }

    void increaseCount(Date time) {
        this.count ++;
        this.time = time;
    }

    void decreaseCount(Date time) {
        if (decreaseCountSanityCheck()) {
            this.count --;
            this.time = time;
        }
    }

    private boolean decreaseCountSanityCheck() {
        return count > 0;
    }

}
