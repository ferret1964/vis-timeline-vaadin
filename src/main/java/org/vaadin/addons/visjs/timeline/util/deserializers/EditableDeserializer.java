package org.vaadin.addons.visjs.timeline.util.deserializers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import org.vaadin.addons.visjs.timeline.options.DataAttributes;
import org.vaadin.addons.visjs.timeline.options.Editable;
import org.vaadin.addons.visjs.timeline.options.EditableObject;
import org.vaadin.addons.visjs.timeline.options.EditableSimple;
import org.vaadin.addons.visjs.timeline.util.JsonObjectMapping;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class EditableDeserializer extends StdDeserializer<Editable> {

    public EditableDeserializer() {
        this(null);
    }

    public EditableDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Editable deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        if (node.isObject())
        {
            return EditableObject.fromNode(node);
            //We have a EditableObject
        }
        else {
            boolean value = node.booleanValue();
            return new EditableSimple(value);
        }
    }
}
