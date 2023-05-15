package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;
import org.vaadin.addons.visjs.timeline.event.ItemOverEvent;
import org.vaadin.addons.visjs.timeline.event.TimeChangedEvent;

/**
 * 	Fired once after the user has dragged the custom time bar. Only available when the custom time bar is enabled.
 *
 * id (Number or String): custom time bar id.
 * time (Date): the custom time.
 * event (Object): original event triggering the timechanged.
 *
 * @see <a href="https://visjs.github.io/vis-timeline/docs/timeline/#Events"</a>
 *
 * @author Jerry Goodnough
 *
 *
 * */
public interface TimeChangedListener extends ComponentEventListener<TimeChangedEvent> {
}
