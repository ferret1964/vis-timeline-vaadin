package org.vaadin.addons.visjs.timeline.options;

import javax.annotation.Nonnull;

public class Margin {
    private int axis;
    private Item item = new Item();

    public Margin() {
    }

    private Margin(Builder builder) {
        setAxis(builder.axis);
        item.setVertical(builder.vertical);
        item.setHorizontal(builder.horizontal);
    }
    public static Builder newBuilder() {
        Builder builder = new Builder();
        return builder;
    }
    public static Builder newBuilder(@Nonnull Margin copy) {
        Builder builder = new Builder();
        builder.axis = copy.getAxis();
        return builder;
    }

    public int getAxis() {
        return axis;
    }

    public void setAxis(int axis) {
        this.axis = axis;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    class Item
    {
        public Item(){};
        private int horizontal;
        private int vertical;

        public int getHorizontal() {
            return horizontal;
        }

        public void setHorizontal(int horizontal) {
            this.horizontal = horizontal;
        }

        public int getVertical() {
            return vertical;
        }

        public void setVertical(int vertical) {
            this.vertical = vertical;
        }


    }

    /**
     * {@code Margin} builder static inner class.
     */
    public static final class Builder {
        private int axis;
        private int horizontal;
        private int vertical;
        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * Sets the {@code axis} and returns a reference to this Builder enabling method chaining.
         *
         * @param axis the {@code axis} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withAxis(int axis) {
            this.axis = axis;
            return this;
        }
        @Nonnull
        public Builder withHorizontal(int horizontal) {
            this.horizontal = horizontal;
            return this;
        }
        @Nonnull
        public Builder withVertical(int vertical) {
            this.vertical = vertical;
            return this;
        }

        /**
         * Sets the {@code item} and returns a reference to this Builder enabling method chaining.
         *
         * @param item the {@code item} to set
         * @return a reference to this Builder
         */

        /**
         * Returns a {@code Margin} built from the parameters previously set.
         *
         * @return a {@code Margin} built with parameters of this {@code Margin.Builder}
         */
        @Nonnull
        public Margin build() {
            return new Margin(this);
        }
    }
}
