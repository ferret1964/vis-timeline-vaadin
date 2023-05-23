package org.vaadin.addons.visjs.timeline.options;

import javax.annotation.Nonnull;

public class TimeAxis {

    private TimeAxis(Builder builder) {
        setScale(builder.scale);
        setStep(builder.step);
    }

    public static Builder newBuilder(@Nonnull TimeAxis copy) {
        Builder builder = new Builder();
        builder.scale = copy.getScale();
        builder.step = copy.getStep();
        return builder;
    }
    public static Builder newBuilder() {
        Builder builder = new Builder();

        return builder;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    private String scale;
    private int step=1;

    public TimeAxis() {
    }

    /**
     * {@code TimeAxis} builder static inner class.
     */
    public static final class Builder {
        private String scale;
        private int step;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * Sets the {@code scale} and returns a reference to this Builder enabling method chaining.
         *
         * @param scale the {@code scale} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withScale(@Nonnull String scale) {
            this.scale = scale;
            return this;
        }

        /**
         * Sets the {@code step} and returns a reference to this Builder enabling method chaining.
         *
         * @param step the {@code step} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withStep(int step) {
            this.step = step;
            return this;
        }

        /**
         * Returns a {@code TimeAxis} built from the parameters previously set.
         *
         * @return a {@code TimeAxis} built with parameters of this {@code TimeAxis.Builder}
         */
        @Nonnull
        public TimeAxis build() {
            return new TimeAxis(this);
        }
    }
}
