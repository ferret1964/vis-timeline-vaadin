package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;
import org.vaadin.addons.visjs.timeline.event.MarkerChangedEvent;

/**
 * Fired when an alteration to the marker title is committed. Only available when the marker is editable..
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

public interface MarkerChangedListener extends ComponentEventListener<MarkerChangedEvent> {
}
