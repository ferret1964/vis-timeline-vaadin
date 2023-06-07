package org.vaadin.addons.visjs.timeline.options;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.vaadin.addons.visjs.timeline.util.deserializers.FunctionDeserializer;

@JsonDeserialize(using = FunctionDeserializer.class)
public class Function {
   String code;

   public Function(String code){
       this.code = code;
   }

    @JsonValue
    public Object getJSON() throws JsonProcessingException {
        return this.code;
    }

}
