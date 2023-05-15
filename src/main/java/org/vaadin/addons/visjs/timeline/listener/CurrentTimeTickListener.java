package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;
import org.vaadin.addons.visjs.timeline.event.CurrentTimeTickEvent;
/**
 * Fired when the current time bar redraws. The rate depends on the zoom level.
 *
 * @see <a href="https://visjs.github.io/vis-timeline/docs/timeline/#Events"</a>
 *
 * @author Jerry Goodnough
 *
 */
public interface CurrentTimeTickListener extends ComponentEventListener<CurrentTimeTickEvent> {
}
