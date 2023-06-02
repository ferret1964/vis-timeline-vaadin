package org.vaadin.addons.visjs.timeline.options;

import javax.annotation.Nonnull;

public class Xss {
    private Xss(Builder builder) {
        setDisabled(builder.disabled);
    }

    public static Builder newBuilder(@Nonnull Xss copy) {
        Builder builder = new Builder();
        builder.disabled = copy.getDisabled();
        return builder;
    }
    public static Builder newBuilder() {
        Builder builder = new Builder();
        return builder;
    }
    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    private Boolean disabled;
    //private IFilterXSSOptions filterOptions;

    public Xss() {
    }


    /**
     * {@code Xss} builder static inner class.
     */
    public static final class Builder {
        private Boolean disabled;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * Sets the {@code disabled} and returns a reference to this Builder enabling method chaining.
         *
         * @param disabled the {@code disabled} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withDisabled(@Nonnull Boolean disabled) {
            this.disabled = disabled;
            return this;
        }

        /**
         * Returns a {@code Xss} built from the parameters previously set.
         *
         * @return a {@code Xss} built with parameters of this {@code Xss.Builder}
         */
        @Nonnull
        public Xss build() {
            return new Xss(this);
        }
    }
}
