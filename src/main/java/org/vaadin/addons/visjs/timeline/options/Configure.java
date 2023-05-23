package org.vaadin.addons.visjs.timeline.options;

import javax.annotation.Nonnull;

/**
 * Created by Martin Prause 4.8.2017
 */
public class Configure {

	 private Boolean enabled= false;
	 private Boolean showButton= false;
	 private String filter;
	 private String container;
	
	public Configure()
	{

	}

	private Configure(Builder builder) {
		setEnabled(builder.enabled);
		setShowButton(builder.showButton);
		setFilter(builder.filter);
		setContainer(builder.container);
	}
	public static Builder newBuilder() {
		Builder builder = new Builder();
		return builder;
	}

	public static Builder newBuilder(@Nonnull Configure copy) {
		Builder builder = new Builder();
		builder.enabled = copy.isEnabled();
		builder.showButton = copy.isShowButton();
		builder.filter = copy.getFilter();
		builder.container = copy.getContainer();
		return builder;
	}

	public Boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public Boolean isShowButton() {
		return showButton;
	}
	public void setShowButton(Boolean showButton) {
		this.showButton = showButton;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getContainer() {
		return container;
	}
	public void setContainer(String container) {
		this.container = container;
	}


	/**
	 * {@code Configure} builder static inner class.
	 */
	public static final class Builder {
		private Boolean enabled = false;
		private Boolean showButton = false;
		private String filter;
		private String container;

		private Builder() {
		}

		public static Builder newBuilder() {
			return new Builder();
		}

		/**
		 * Sets the {@code enabled} and returns a reference to this Builder enabling method chaining.
		 *
		 * @param enabled the {@code enabled} to set
		 * @return a reference to this Builder
		 */
		@Nonnull
		public Builder withEnabled(Boolean enabled) {
			this.enabled = enabled;
			return this;
		}

		/**
		 * Sets the {@code showButton} and returns a reference to this Builder enabling method chaining.
		 *
		 * @param showButton the {@code showButton} to set
		 * @return a reference to this Builder
		 */
		@Nonnull
		public Builder withShowButton(Boolean showButton) {
			this.showButton = showButton;
			return this;
		}

		/**
		 * Sets the {@code filter} and returns a reference to this Builder enabling method chaining.
		 *
		 * @param filter the {@code filter} to set
		 * @return a reference to this Builder
		 */
		@Nonnull
		public Builder withFilter(@Nonnull String filter) {
			this.filter = filter;
			return this;
		}

		/**
		 * Sets the {@code container} and returns a reference to this Builder enabling method chaining.
		 *
		 * @param container the {@code container} to set
		 * @return a reference to this Builder
		 */
		@Nonnull
		public Builder withContainer(@Nonnull String container) {
			this.container = container;
			return this;
		}

		/**
		 * Returns a {@code Configure} built from the parameters previously set.
		 *
		 * @return a {@code Configure} built with parameters of this {@code Configure.Builder}
		 */
		@Nonnull
		public Configure build() {
			return new Configure(this);
		}
	}
}
