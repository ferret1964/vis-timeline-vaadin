package org.vaadin.addons.visjs.timeline.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonObjectMapping {

    private static ObjectMapper objectMapper;
    public static ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    static {
        objectMapper= new ObjectMapper();
        JavaTimeModule module = new JavaTimeModule();
        objectMapper.registerModule(module);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        //objectMapper.setDateFormat(df);
    }

}
