package org.vaadin.addons.visjs.timeline.options;

import javax.annotation.Nonnull;

public class ItemsAlwaysDraggable {
    private Boolean item;
    private Boolean range;

    public ItemsAlwaysDraggable() {
    }

    private ItemsAlwaysDraggable(Builder builder) {
        setItem(builder.item);
        setRange(builder.range);
    }
    public static Builder newBuilder() {
        Builder builder = new Builder();
        return builder;
    }
    public static Builder newBuilder(@Nonnull ItemsAlwaysDraggable copy) {
        Builder builder = new Builder();
        builder.item = copy.isItem();
        builder.range = copy.isRange();
        return builder;
    }

    public Boolean isItem() {
        return item;
    }

    public void setItem(Boolean item) {
        this.item = item;
    }

    public Boolean isRange() {
        return range;
    }

    public void setRange(Boolean range) {
        this.range = range;
    }

    /**
     * {@code ItemsAlwaysDraggable} builder static inner class.
     */
    public static final class Builder {
        private Boolean item;
        private Boolean range;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * Sets the {@code item} and returns a reference to this Builder enabling method chaining.
         *
         * @param item the {@code item} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withItem(Boolean item) {
            this.item = item;
            return this;
        }

        /**
         * Sets the {@code range} and returns a reference to this Builder enabling method chaining.
         *
         * @param range the {@code range} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withRange(Boolean range) {
            this.range = range;
            return this;
        }

        /**
         * Returns a {@code ItemsAlwaysDraggable} built from the parameters previously set.
         *
         * @return a {@code ItemsAlwaysDraggable} built with parameters of this {@code ItemsAlwaysDraggable.Builder}
         */
        @Nonnull
        public ItemsAlwaysDraggable build() {
            return new ItemsAlwaysDraggable(this);
        }
    }
}
