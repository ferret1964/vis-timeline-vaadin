package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;
import org.vaadin.addons.visjs.timeline.event.MouseDownEvent;

/**
 * Fired when the mouse down event is triggered over a timeline element.
 *
 *   Passes a properties object as returned by the method Timeline.getEventProperties(event).
 *
 * @see <a href="https://visjs.github.io/vis-timeline/docs/timeline/#Events"</a>
 *
 * @author Jerry Goodnough
 *
 *
 * */
public interface MouseDownListener extends ComponentEventListener<MouseDownEvent> {
}
