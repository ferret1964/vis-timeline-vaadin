package org.vaadin.addons.visjs.timeline.api;

import com.vaadin.flow.component.ComponentEvent;

import elemental.json.JsonObject;

@SuppressWarnings("serial")
public abstract class Event extends ComponentEvent<org.vaadin.addons.visjs.timeline.main.TimelineDiagram> {

  private final JsonObject params;

  /**
   * TODO parse jsonParameter
   *
   * @param source
   * @param fromClient
   * @param params
   */
  public Event(org.vaadin.addons.visjs.timeline.main.TimelineDiagram source, boolean fromClient, final JsonObject params) {
    super(source, fromClient);
    this.params = params;
  }

  /**
   * Event parameter. See http://visjs.org/docs/network/#Events
   *
   * @return
   */
  public JsonObject getParams() {
    return params;
  }

}
