package org.vaadin.addons.visjs.timeline.event;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;

import org.vaadin.addons.visjs.timeline.api.Event;
import elemental.json.JsonException;
import elemental.json.JsonObject;

@SuppressWarnings("serial")
@DomEvent("vaadin-hold")
public class HoldEvent extends Event {
  public HoldEvent(final org.vaadin.addons.visjs.timeline.main.TimelineDiagram source, boolean fromClient,
                   @EventData("event.detail") final JsonObject params) throws JsonException {
    super(source, fromClient, params);
  }
}
