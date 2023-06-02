package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;
import org.vaadin.addons.visjs.timeline.event.MarkerChangeEvent;
import org.vaadin.addons.visjs.timeline.event.MarkerChangedEvent;

/**
 * Fired when the marker title has been changed. Only available when the marker is editable.
 *
 *   id (Number or String): custom time bar id which the marker is attached to.
 *   title (Date): the marker title.
 *   event (Object): original event triggering the markerchanged.
 *
 * @see <a href="https://visjs.github.io/vis-timeline/docs/timeline/#Events"</a>
 *
 * @author Jerry Goodnough
 *
 *
 * */
public interface MarkerChangeListener extends ComponentEventListener<MarkerChangeEvent> {
}
