package com.ing.devschool.transactions.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ing.devschool.transactions.Transaction;

import java.io.IOException;

public class TransactionSerializer extends StdSerializer<Transaction> {

    public TransactionSerializer() {
        this(null);
    }

    public TransactionSerializer(Class<Transaction> t) {
        super(t);
    }

    @Override
    public void serialize(Transaction transaction, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        try {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("date", transaction.getDate());
            jsonGenerator.writeNumberField("transactionId", transaction.getTransactionId());
            jsonGenerator.writeObjectField("itemsSummary", transaction.getTransactionItemsMap());
            jsonGenerator.writeEndObject();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
