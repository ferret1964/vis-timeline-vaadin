package org.vaadin.addons.visjs.timeline.options;

public class TimeAxis {

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    private String scale;
    private int step;

}
