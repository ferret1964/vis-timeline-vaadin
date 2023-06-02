package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;
import org.vaadin.addons.visjs.timeline.event.ItemOverEvent;
import org.vaadin.addons.visjs.timeline.event.RangeChangedEvent;

/**
 * Fired repeatedly when the timeline window is being changed.
 *
 * start (Number): timestamp of the current start of the window.
 * end (Number): timestamp of the current end of the window.
 * byUser (Boolean): change happened because of user drag/zoom.
 * event (Object): original event triggering the rangechange.
 *
 * @see <a href="https://visjs.github.io/vis-timeline/docs/timeline/#Events"</a>
 *
 * @author Jerry Goodnough
 *
 *
 * */
public interface RangeChangedListener extends ComponentEventListener<RangeChangedEvent> {
}
