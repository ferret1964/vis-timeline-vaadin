package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;
import org.vaadin.addons.visjs.timeline.event.ChangedEvent;
/**
 * Fired once after each graph redraw.
 *
 * @see <a href="https://visjs.github.io/vis-timeline/docs/timeline/#Events"</a>
 *
 * @author Jerry Goodnough
 *
 */
public interface ChangedListener  extends ComponentEventListener<ChangedEvent> {
}
