package com.ing.devschool.transactions.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ing.devschool.transactions.TransactionItem;

import java.io.IOException;

public class TransactionItemSerializer extends StdSerializer<TransactionItem> {

    public TransactionItemSerializer() {
        this(null);
    }

    public TransactionItemSerializer(Class<TransactionItem> t) {
        super(t);
    }

    @Override
    public void serialize(TransactionItem transactionItem, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        try {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeNumberField(transactionItem.getName(), transactionItem.getCount());
            jsonGenerator.writeEndObject();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
