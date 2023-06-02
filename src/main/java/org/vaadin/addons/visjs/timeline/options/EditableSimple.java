package org.vaadin.addons.visjs.timeline.options;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;

import javax.annotation.Nonnull;

public class EditableSimple extends Editable {

    public EditableSimple(Boolean editable)
    {
        this.editable = editable;
    }
    private EditableSimple(Builder builder) {
        setEditable(builder.editable);
    }
    @JsonValue
    public Boolean getJSON() throws JsonProcessingException {
        return Boolean.valueOf(editable);
    }
    public static Builder newBuilder(@Nonnull EditableSimple copy) {
        Builder builder = new Builder();
        builder.editable = copy.getEditable();
        return builder;
    }
    public static Builder newBuilder() {
        Builder builder = new Builder();
        return builder;
    }
    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    private Boolean editable = false;

    /**
     * {@code EditableSimple} builder static inner class.
     */
    public static final class Builder {
        private Boolean editable;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * Sets the {@code editable} and returns a reference to this Builder enabling method chaining.
         *
         * @param editable the {@code editable} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withEditable(Boolean editable) {
            this.editable = editable;
            return this;
        }

        /**
         * Returns a {@code EditableSimple} built from the parameters previously set.
         *
         * @return a {@code EditableSimple} built with parameters of this {@code EditableSimple.Builder}
         */
        @Nonnull
        public EditableSimple build() {
            return new EditableSimple(this);
        }
    }
}
