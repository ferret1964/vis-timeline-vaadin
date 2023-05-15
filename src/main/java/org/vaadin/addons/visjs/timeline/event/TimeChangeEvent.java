package org.vaadin.addons.visjs.timeline.event;

import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.EventData;
import elemental.json.JsonException;
import elemental.json.JsonObject;
import org.vaadin.addons.visjs.timeline.api.Event;

@DomEvent("vaadin-timechange")
public class TimeChangeEvent extends Event {
    TimeChangeEvent(final org.vaadin.addons.visjs.timeline.main.TimelineDiagram source, boolean fromClient,
                    @EventData("event.detail") final JsonObject params)
            throws JsonException {
        super(source, fromClient, params);
    }
}
