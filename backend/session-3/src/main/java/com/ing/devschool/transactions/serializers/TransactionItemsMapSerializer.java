package com.ing.devschool.transactions.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.ing.devschool.transactions.TransactionItem;
import com.ing.devschool.transactions.TransactionItemsMap;

import java.io.IOException;

public class TransactionItemsMapSerializer extends StdSerializer<TransactionItemsMap> {

    public TransactionItemsMapSerializer() {
        this(null);
    }

    public TransactionItemsMapSerializer(Class<TransactionItemsMap> t) {
        super(t);
    }

    @Override
    public void serialize(TransactionItemsMap transactionItemsMap, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        for (TransactionItem transactionItem : transactionItemsMap.values()) {
            jsonGenerator.writeNumberField(transactionItem.getName(), transactionItem.getCount());
        }
        jsonGenerator.writeEndObject();
    }
}
