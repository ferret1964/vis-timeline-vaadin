package org.vaadin.addons.visjs.timeline.options;

import javax.annotation.Nonnull;


public class Locale {


		private String current = "current";

		private String time = "time";
		private String deleteSelected = "Delete selected";

		public Locale()
		{

		}
	private Locale(Builder builder) {
		setCurrent(builder.current);
		setTime(builder.time);
		setDeleteSelected(builder.deleteSelected);
	}

	public static Builder newBuilder(@Nonnull Locale copy) {
		Builder builder = new Builder();
		builder.current = copy.getCurrent();
		builder.time = copy.getTime();
		builder.deleteSelected = copy.getDeleteSelected();
		return builder;
	}
	public static Builder newBuilder() {
		Builder builder = new Builder();
		return builder;
	}
	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDeleteSelected() {
		return deleteSelected;
	}

	public void setDeleteSelected(String deleteSelected) {
		this.deleteSelected = deleteSelected;
	}

	/**
	 * {@code Locale} builder static inner class.
	 */
	public static final class Builder {
		private String current;
		private String time;
		private String deleteSelected;

		private Builder() {
		}

		public static Builder newBuilder() {
			return new Builder();
		}

		/**
		 * Sets the {@code current} and returns a reference to this Builder enabling method chaining.
		 *
		 * @param current the {@code current} to set
		 * @return a reference to this Builder
		 */
		@Nonnull
		public Builder withCurrent(@Nonnull String current) {
			this.current = current;
			return this;
		}

		/**
		 * Sets the {@code time} and returns a reference to this Builder enabling method chaining.
		 *
		 * @param time the {@code time} to set
		 * @return a reference to this Builder
		 */
		@Nonnull
		public Builder withTime(@Nonnull String time) {
			this.time = time;
			return this;
		}

		/**
		 * Sets the {@code deleteSelected} and returns a reference to this Builder enabling method chaining.
		 *
		 * @param deleteSelected the {@code deleteSelected} to set
		 * @return a reference to this Builder
		 */
		@Nonnull
		public Builder withDeleteSelected(@Nonnull String deleteSelected) {
			this.deleteSelected = deleteSelected;
			return this;
		}

		/**
		 * Returns a {@code Locale} built from the parameters previously set.
		 *
		 * @return a {@code Locale} built with parameters of this {@code Locale.Builder}
		 */
		@Nonnull
		public Locale build() {
			return new Locale(this);
		}
	}
}
