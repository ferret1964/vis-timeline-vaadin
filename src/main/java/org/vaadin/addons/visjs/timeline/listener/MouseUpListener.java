package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;
import org.vaadin.addons.visjs.timeline.event.ItemOverEvent;
import org.vaadin.addons.visjs.timeline.event.MouseUpEvent;

/**
 * 	Fired when the mouse up event is triggered over a timeline element.
 *
 *  Passes a properties object as returned by the method Timeline.getEventProperties(event).
 *
 * @see <a href="https://visjs.github.io/vis-timeline/docs/timeline/#Events"</a>
 *
 * @author Jerry Goodnough
 *
 *
 * */
public interface MouseUpListener extends ComponentEventListener<MouseUpEvent> {
}
