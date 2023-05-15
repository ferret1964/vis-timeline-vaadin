package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;
import org.vaadin.addons.visjs.timeline.event.ItemOverEvent;

/**
 * 	Fired when the user moves the mouse over an item.
 * 	item: hovered item id
 *  event: the original mouseover event
 *
 * @see <a href="https://visjs.github.io/vis-timeline/docs/timeline/#Events"</a>
 *
 * @author Jerry Goodnough
 *
 *
 * */
public interface ItemOverListener extends ComponentEventListener<ItemOverEvent> {
}
