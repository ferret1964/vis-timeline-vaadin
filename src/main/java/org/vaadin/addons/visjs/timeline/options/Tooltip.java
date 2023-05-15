package org.vaadin.addons.visjs.timeline.options;

public class Tooltip {
    public Boolean getFollowMouse() {
        return followMouse;
    }

    public void setFollowMouse(Boolean followMouse) {
        this.followMouse = followMouse;
    }

    public String getOverflowMethod() {
        return overflowMethod;
    }

    public void setOverflowMethod(String overflowMethod) {
        this.overflowMethod = overflowMethod;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    private Boolean followMouse;
    private String overflowMethod;
    private int delay;
    //private Function template;

}
