package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;
import org.vaadin.addons.visjs.timeline.event.MouseMoveEvent;

/**
 * Fired when the mouse is moved over a timeline element.
 *
 *   Passes a properties object as returned by the method Timeline.getEventProperties(event).
 *
 * @see <a href="https://visjs.github.io/vis-timeline/docs/timeline/#Events"</a>
 *
 * @author Jerry Goodnough
 *
 *
 * */
public interface MouseMoveListener extends ComponentEventListener<MouseMoveEvent> {
}
