package org.vaadin.addons.visjs.timeline.util.deserializers;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.vaadin.addons.visjs.timeline.options.Function;

import java.io.IOException;

public class FunctionDeserializer extends StdDeserializer<Function> {

    public FunctionDeserializer() {
        this(null);
    }

    public FunctionDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Function deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        String code = jp.getCodec().readValue(jp, String.class);
        return new Function(code);
    }
}

