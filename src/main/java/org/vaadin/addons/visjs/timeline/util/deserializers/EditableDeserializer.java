package org.vaadin.addons.visjs.timeline.util.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.vaadin.addons.visjs.timeline.options.DataAttributes;
import org.vaadin.addons.visjs.timeline.options.DateBoundary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class DataAttributesDeserializer extends StdDeserializer<DataAttributes> {

    public DataAttributesDeserializer() {
        this(null);
    }

    public DataAttributesDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public DataAttributes deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        if (node.isArray())
        {
            ArrayList<String> out = new ArrayList<>();
            Iterator<JsonNode> itr = node.elements();
            while(itr.hasNext())
            {
                JsonNode nd = itr.next();
                out.add(nd.textValue());
            }
            String[] array = new String[0];
            array = out.toArray(array);
            return new DataAttributes(array);
        }
        else {
            String value = node.textValue();
            return new DataAttributes(value);
        }
    }
}
