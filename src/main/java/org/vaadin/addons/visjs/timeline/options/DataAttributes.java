package org.vaadin.addons.visjs.timeline.options;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.vaadin.addons.visjs.timeline.util.deserializers.DataAttributesDeserializer;

import javax.annotation.Nonnull;

@JsonDeserialize(using = DataAttributesDeserializer.class)
public class DataAttributes {
    private Boolean useAll = false;
    private String[] attributes = new String[0];

    public DataAttributes()
    {

    }
    public DataAttributes(String value)
    {
        if (value.compareTo("all")==0)
        {
            useAll = true;
        }
    }
    public DataAttributes(String[] values)
    {
        attributes = values;
        useAll = false;
    }

    @JsonValue
    public Object getJSON() throws JsonProcessingException {
        if (useAll)
            return "all";
        return this.attributes;
    }




    private DataAttributes(Builder builder) {
        if (builder.useAll)
        {
            setUseAll(builder.useAll);
        }
        else {
            setAttributes(builder.attributes);
        }
    }

    public static Builder newBuilder(@Nonnull DataAttributes copy) {
        Builder builder = new Builder();
        builder.useAll = copy.isUseAll();
        builder.attributes = copy.getAttributes();
        return builder;
    }

    public static Builder newBuilder() {
        Builder builder = new Builder();
        return builder;
    }

    public Boolean isUseAll() {
        return useAll;
    }

    public void setUseAll(Boolean useAll) {
        if (useAll)
        {
            this.attributes = new String[0];
        }
        this.useAll = useAll;
    }

    public String[] getAttributes() {
        return attributes;
    }

    public void setAttributes(String[] attributes) {
        useAll = false;
        this.attributes = attributes;
    }


    /**
     * {@code DataAttributes} builder static inner class.
     */
    public static final class Builder {
        private Boolean useAll = false;
        private String[] attributes;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * Sets the {@code useAll} and returns a reference to this Builder enabling method chaining.
         *
         * @param useAll the {@code useAll} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withUseAll(Boolean useAll) {
            this.useAll = useAll;
            return this;
        }

        /**
         * Sets the {@code attributes} and returns a reference to this Builder enabling method chaining.
         *
         * @param attributes the {@code attributes} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withAttributes(@Nonnull String[] attributes) {
            this.attributes = attributes;
            return this;
        }

        /**
         * Returns a {@code DataAttributes} built from the parameters previously set.
         *
         * @return a {@code DataAttributes} built with parameters of this {@code DataAttributes.Builder}
         */
        @Nonnull
        public DataAttributes build() {
            return new DataAttributes(this);
        }
    }
}
