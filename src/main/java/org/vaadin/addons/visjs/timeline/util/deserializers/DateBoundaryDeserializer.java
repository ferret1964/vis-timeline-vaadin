package org.vaadin.addons.visjs.timeline.util.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.vaadin.addons.visjs.timeline.options.DateBoundary;

import java.io.IOException;

public class DateBoundaryDeserializer extends StdDeserializer<DateBoundary> {

    public DateBoundaryDeserializer() {
        this(null);
    }

    public DateBoundaryDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DateBoundary deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        //JsonNode node = jp.getCodec().readTree(jp);
        String value = jp.getCodec().readValue(jp,String.class);
        return new DateBoundary(value);
    }
}
