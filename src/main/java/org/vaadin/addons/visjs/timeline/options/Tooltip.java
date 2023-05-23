package org.vaadin.addons.visjs.timeline.options;

import javax.annotation.Nonnull;

public class Tooltip {
    private Tooltip(Builder builder) {
        setFollowMouse(builder.followMouse);
        setOverflowMethod(builder.overflowMethod);
        setDelay(builder.delay);
    }

    public static Builder newBuilder(@Nonnull Tooltip copy) {
        Builder builder = new Builder();
        builder.followMouse = copy.getFollowMouse();
        builder.overflowMethod = copy.getOverflowMethod();
        builder.delay = copy.getDelay();
        return builder;
    }
    public static Builder newBuilder() {
        Builder builder = new Builder();
        return builder;
    }
    public Boolean getFollowMouse() {
        return followMouse;
    }

    public void setFollowMouse(Boolean followMouse) {
        this.followMouse = followMouse;
    }

    public String getOverflowMethod() {
        return overflowMethod;
    }

    public void setOverflowMethod(String overflowMethod) {
        this.overflowMethod = overflowMethod;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    private Boolean followMouse = Boolean.FALSE;
    private String overflowMethod = "flip";
    private int delay = 500;
    //private Function template;

    public Tooltip() {
    }

    /**
     * {@code Tooltip} builder static inner class.
     */
    public static final class Builder {
        private Boolean followMouse;
        private String overflowMethod;
        private int delay;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * Sets the {@code followMouse} and returns a reference to this Builder enabling method chaining.
         *
         * @param followMouse the {@code followMouse} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withFollowMouse(@Nonnull Boolean followMouse) {
            this.followMouse = followMouse;
            return this;
        }

        /**
         * Sets the {@code overflowMethod} and returns a reference to this Builder enabling method chaining.
         *
         * @param overflowMethod the {@code overflowMethod} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withOverflowMethod(@Nonnull String overflowMethod) {
            this.overflowMethod = overflowMethod;
            return this;
        }

        /**
         * Sets the {@code delay} and returns a reference to this Builder enabling method chaining.
         *
         * @param delay the {@code delay} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withDelay(int delay) {
            this.delay = delay;
            return this;
        }

        /**
         * Returns a {@code Tooltip} built from the parameters previously set.
         *
         * @return a {@code Tooltip} built with parameters of this {@code Tooltip.Builder}
         */
        @Nonnull
        public Tooltip build() {
            return new Tooltip(this);
        }
    }
}
