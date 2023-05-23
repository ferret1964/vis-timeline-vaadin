package org.vaadin.addons.visjs.timeline.options;

import com.fasterxml.jackson.databind.JsonNode;

import javax.annotation.Nonnull;

public class EditableObject extends Editable{

    private Boolean add = Boolean.FALSE;
    private Boolean remove = Boolean.FALSE;

    private Boolean updateGroup =  Boolean.FALSE;

    private Boolean updateTime = Boolean.FALSE;

    private Boolean overrideItems = Boolean.FALSE;

    public EditableObject() {
    }

    private EditableObject(Builder builder) {
        setAdd(builder.add);
        setRemove(builder.remove);
        setUpdateGroup(builder.updateGroup);
        setUpdateTime(builder.updateTime);
        setOverrideItems(builder.overrideItems);
    }

    public static EditableObject fromNode(JsonNode node)
    {
        EditableObject out = new EditableObject();

        out.setAdd(getField(node, "add"));
        out.setRemove(getField(node,"remove"));
        out.setUpdateGroup(getField(node,"updateGroup"));
        out.setUpdateTime(getField(node,"updateTime"));
        out.setOverrideItems(getField(node,"overrideItems"));
        return out;
    }
    private static Boolean getField(JsonNode node, String name)
    {
        Boolean out = false;
        JsonNode nd = node.findPath("add");
        if (nd != null) {
            out = nd.booleanValue();
        }
        return out;
    }
    public static Builder newBuilder() {
        Builder builder = new Builder();
        return builder;
    }
    public static Builder newBuilder(@Nonnull EditableObject copy) {
        Builder builder = new Builder();
        builder.add = copy.isAdd();
        builder.remove = copy.isRemove();
        builder.updateGroup = copy.isUpdateGroup();
        builder.updateTime = copy.isUpdateTime();
        builder.overrideItems = copy.isOverrideItems();
        return builder;
    }

    public Boolean isAdd() {
        return add;
    }

    public void setAdd(Boolean add) {
        this.add = add;
    }

    public Boolean isRemove() {
        return remove;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
    }

    public Boolean isUpdateGroup() {
        return updateGroup;
    }

    public void setUpdateGroup(Boolean updateGroup) {
        this.updateGroup = updateGroup;
    }

    public Boolean isUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Boolean updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean isOverrideItems() {
        return overrideItems;
    }

    public void setOverrideItems(Boolean overrideItems) {
        this.overrideItems = overrideItems;
    }


    /**
     * {@code EditableObject} builder static inner class.
     */
    public static final class Builder {
        private Boolean add = Boolean.FALSE;
        private Boolean remove = Boolean.FALSE;
        private Boolean updateGroup = Boolean.FALSE;
        private Boolean updateTime = Boolean.FALSE;
        private Boolean overrideItems = Boolean.FALSE;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * Sets the {@code add} and returns a reference to this Builder enabling method chaining.
         *
         * @param add the {@code add} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withAdd(Boolean add) {
            this.add = add;
            return this;
        }

        /**
         * Sets the {@code remove} and returns a reference to this Builder enabling method chaining.
         *
         * @param remove the {@code remove} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withRemove(Boolean remove) {
            this.remove = remove;
            return this;
        }

        /**
         * Sets the {@code updateGroup} and returns a reference to this Builder enabling method chaining.
         *
         * @param updateGroup the {@code updateGroup} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withUpdateGroup(Boolean updateGroup) {
            this.updateGroup = updateGroup;
            return this;
        }

        /**
         * Sets the {@code updateTime} and returns a reference to this Builder enabling method chaining.
         *
         * @param updateTime the {@code updateTime} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withUpdateTime(Boolean updateTime) {
            this.updateTime = updateTime;
            return this;
        }

        /**
         * Sets the {@code overrideItems} and returns a reference to this Builder enabling method chaining.
         *
         * @param overrideItems the {@code overrideItems} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withOverrideItems(Boolean overrideItems) {
            this.overrideItems = overrideItems;
            return this;
        }

        /**
         * Returns a {@code EditableObject} built from the parameters previously set.
         *
         * @return a {@code EditableObject} built with parameters of this {@code EditableObject.Builder}
         */
        @Nonnull
        public EditableObject build() {
            return new EditableObject(this);
        }
    }
}
