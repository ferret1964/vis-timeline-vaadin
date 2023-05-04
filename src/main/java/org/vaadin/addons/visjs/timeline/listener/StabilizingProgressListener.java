package org.vaadin.addons.visjs.timeline.listener;

import com.vaadin.flow.component.ComponentEventListener;

import org.vaadin.addons.visjs.timeline.event.StabilizationProgressEvent;

/**
 * Fired when a multiple of the updateInterval number of iterations is reached. This only occurs in
 * the 'hidden' stabilization.
 *
 * @see <a href="http://visjs.org/docs/network/#Events">http://visjs.org/docs/network/#Events</a>
 *
 * @author watho
 *
 */
public interface StabilizingProgressListener
    extends ComponentEventListener<StabilizationProgressEvent> {
}
