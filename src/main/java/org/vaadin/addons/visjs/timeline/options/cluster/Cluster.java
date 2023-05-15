package org.vaadin.addons.visjs.timeline.options.cluster;

import org.vaadin.addons.visjs.timeline.options.DateBoundry;
import org.vaadin.addons.visjs.timeline.options.TimeAxis;

/**
 * Created by roshans on 10/30/14.
 */
public class Cluster {

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

}
