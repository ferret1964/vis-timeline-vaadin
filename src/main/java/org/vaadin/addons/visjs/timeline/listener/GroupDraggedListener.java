package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;
import org.vaadin.addons.visjs.timeline.event.GroupDraggedEvent;

/**
 * 	Fired after the dragging of a group is finished.
 * 	Passes the id of the dragged group.
 *
 * @see <a href="https://visjs.github.io/vis-timeline/docs/timeline/#Events"</a>
 *
 * @author Jerry Goodnough
 *
 *
 * */
public interface GroupDraggedListener extends ComponentEventListener<GroupDraggedEvent> {
}
