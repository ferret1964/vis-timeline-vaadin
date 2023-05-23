package org.vaadin.addons.visjs.timeline.options;

import javax.annotation.Nonnull;

public class RollingMode {
    private Boolean follow;
    private int offset;

    public RollingMode() {
    }

    private RollingMode(Builder builder) {
        setFollow(builder.follow);
        setOffset(builder.offset);
    }

    public static Builder newBuilder(@Nonnull RollingMode copy) {
        Builder builder = new Builder();
        builder.follow = copy.isFollow();
        builder.offset = copy.getOffset();
        return builder;
    }
    public static Builder newBuilder() {
        Builder builder = new Builder();
        return builder;
    }
    public Boolean isFollow() {
        return follow;
    }

    public void setFollow(Boolean follow) {
        this.follow = follow;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * {@code RollingMode} builder static inner class.
     */
    public static final class Builder {
        private Boolean follow;
        private int offset;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * Sets the {@code follow} and returns a reference to this Builder enabling method chaining.
         *
         * @param follow the {@code follow} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withFollow(Boolean follow) {
            this.follow = follow;
            return this;
        }

        /**
         * Sets the {@code offset} and returns a reference to this Builder enabling method chaining.
         *
         * @param offset the {@code offset} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withOffset(int offset) {
            this.offset = offset;
            return this;
        }

        /**
         * Returns a {@code RollingMode} built from the parameters previously set.
         *
         * @return a {@code RollingMode} built with parameters of this {@code RollingMode.Builder}
         */
        @Nonnull
        public RollingMode build() {
            return new RollingMode(this);
        }
    }
}
