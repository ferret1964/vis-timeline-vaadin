package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;

import org.vaadin.addons.visjs.timeline.event.StabilizationIterationsDoneEvent;

/**
 * Fired when the 'hidden' stabilization finishes. This does not necessarily mean the network is
 * stabilized; it could also mean that the amount of iterations defined in the options has been
 * reached.
 *
 * @see <a href="http://visjs.org/docs/network/#Events">http://visjs.org/docs/network/#Events</a>
 *
 * @author watho
 *
 */
public interface StabilizationIterationsDoneListener
    extends ComponentEventListener<StabilizationIterationsDoneEvent> {
}
