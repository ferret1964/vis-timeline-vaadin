package org.vaadin.addons.visjs.timeline.options.items;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.annotation.Nonnull;

@JsonDeserialize(builder = Editable.Builder.class)
public class Editable {
    private Boolean remove;
    private Boolean updateGroup;
    private Boolean updateTime;

    private Editable(Builder builder)
    {
        remove = builder.remove;
        updateGroup = builder.updateGroup;
        updateTime = builder.updateTime;
    }

    public Boolean getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Boolean updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getUpdateGroup() {
        return updateGroup;
    }

    public Boolean getRemove() {
        return remove;
    }

    public void setRemove(Boolean remove) {
        this.remove = remove;
    }

    public void setUpdateGroup(Boolean updateGroup) {
        this.updateGroup = updateGroup;
    }

    public static Editable.Builder builder() {
        return new Editable.Builder();
    }


    public static final class Builder {
        private Boolean remove;
        private Boolean updateGroup;
        private Boolean updateTime;
        private Builder() {}

        @Nonnull
        public Editable.Builder withRemove(Boolean remove) {
            this.remove = remove;
            return this;
        }

        @Nonnull
        public Editable.Builder withUpdateGroup(Boolean updateGroup) {
            this.updateGroup = updateGroup;
            return this;
        }
        @Nonnull
        public Editable.Builder withUpdateTime(Boolean updateTime) {
            this.updateTime = updateTime;
            return this;
        }
    public Editable build() {
            return new Editable(this);
        }
    }
}
