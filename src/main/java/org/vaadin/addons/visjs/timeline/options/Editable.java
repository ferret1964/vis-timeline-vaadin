package org.vaadin.addons.visjs.timeline.options;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.vaadin.addons.visjs.timeline.util.deserializers.DataAttributesDeserializer;
import org.vaadin.addons.visjs.timeline.util.deserializers.EditableDeserializer;

@JsonDeserialize(using = EditableDeserializer.class)
public class Editable {
    public static EditableSimple.Builder newSimpleBuilder() {
        EditableSimple.Builder builder = EditableSimple.newBuilder();
        return builder;
    }
    public static EditableObject.Builder newObjectBuilder() {
        EditableObject.Builder builder = EditableObject.newBuilder();
        return builder;
    }

}
