package org.vaadin.addons.visjs.timeline.options.cluster;

import javax.annotation.Nonnull;

/**
 * Created by roshans on 10/30/14.
 */
public class Cluster {

  public Cluster()
  {

  }
  private Cluster(Builder builder) {
    setMaxItems(builder.maxItems);
    setTitleTemplate(builder.titleTemplate);
    setShowStipes(builder.showStipes);
    setFitOnDoubleClick(builder.fitOnDoubleClick);
  }

  public static Builder newBuilder(@Nonnull Cluster copy) {
    Builder builder = new Builder();
    builder.maxItems = copy.getMaxItems();
    builder.titleTemplate = copy.getTitleTemplate();
    builder.showStipes = copy.getShowStipes();
    builder.fitOnDoubleClick = copy.getFitOnDoubleClick();
    return builder;
  }

  public static Builder newBuilder() {
    return new Builder();
  };

  public int getMaxItems() {
    return maxItems;
  }

  public void setMaxItems(int maxItems) {
    this.maxItems = maxItems;
  }

  public String getTitleTemplate() {
    return titleTemplate;
  }

  public void setTitleTemplate(String titleTemplate) {
    this.titleTemplate = titleTemplate;
  }

  public Boolean getShowStipes() {
    return showStipes;
  }

  public void setShowStipes(Boolean showStipes) {
    this.showStipes = showStipes;
  }

  public Boolean getFitOnDoubleClick() {
    return fitOnDoubleClick;
  }

  public void setFitOnDoubleClick(Boolean fitOnDoubleClick) {
    this.fitOnDoubleClick = fitOnDoubleClick;
  }

  private int maxItems = 1;
  private String titleTemplate;
  //private Function clusterCriteria
  private Boolean showStipes;
  private Boolean fitOnDoubleClick;

  /**
   * {@code Cluster} builder static inner class.
   */
  public static final class Builder {
    private int maxItems;
    private String titleTemplate;
    private Boolean showStipes;
    private Boolean fitOnDoubleClick;

    private Builder() {
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    /**
     * Sets the {@code maxItems} and returns a reference to this Builder enabling method chaining.
     *
     * @param maxItems the {@code maxItems} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withMaxItems(int maxItems) {
      this.maxItems = maxItems;
      return this;
    }

    /**
     * Sets the {@code titleTemplate} and returns a reference to this Builder enabling method chaining.
     *
     * @param titleTemplate the {@code titleTemplate} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withTitleTemplate(@Nonnull String titleTemplate) {
      this.titleTemplate = titleTemplate;
      return this;
    }

    /**
     * Sets the {@code showStipes} and returns a reference to this Builder enabling method chaining.
     *
     * @param showStipes the {@code showStipes} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withShowStipes(@Nonnull Boolean showStipes) {
      this.showStipes = showStipes;
      return this;
    }

    /**
     * Sets the {@code fitOnDoubleClick} and returns a reference to this Builder enabling method chaining.
     *
     * @param fitOnDoubleClick the {@code fitOnDoubleClick} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withFitOnDoubleClick(@Nonnull Boolean fitOnDoubleClick) {
      this.fitOnDoubleClick = fitOnDoubleClick;
      return this;
    }

    /**
     * Returns a {@code Cluster} built from the parameters previously set.
     *
     * @return a {@code Cluster} built with parameters of this {@code Cluster.Builder}
     */
    @Nonnull
    public Cluster build() {
      return new Cluster(this);
    }
  }
}
