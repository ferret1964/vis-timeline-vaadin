package org.vaadin.addons.visjs.timeline.options;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;

import java.time.Instant;
import java.time.LocalDateTime;

public class DateBoundry {

    private enum type
    @JsonIgnore
    private String dateAsString;
    @JsonIgnore
    private LocalDateTime dateAsDate;
    @JsonIgnore
    private int dateAsNumber;
    @JsonIgnore
    private Instant dataAsMoment;

    @JsonValue
    public String getJSON()
    {
        String out = null;
        return out;
    }

    public String getDateAsString() {
        return dateAsString;
    }

    public void setDateAsString(String dateAsString) {
        this.dateAsDate = null;
        this.dataAsMoment = null;
        this.dateAsNumber = 0;
        this.dateAsString = dateAsString;
    }

    public LocalDateTime getDateAsDate() {
        return dateAsDate;
    }

    public void setDateAsDate(LocalDateTime dateAsDate) {
        this.dataAsMoment = null;
        this.dateAsNumber = 0;
        this.dateAsString = null;
        this.dateAsDate = dateAsDate;
    }

    public int getDataAsNumber() {
        return dateAsNumber;
    }

    public void setDataAsNumber(int dateAsNumber) {
        this.dateAsDate = null;
        this.dataAsMoment = null;
        this.dateAsString = null;
        this.dateAsNumber = dateAsNumber;
    }

    public Instant getDataAsMoment() {
        return dataAsMoment;
    }

    public void setDataAsMoment(Instant dateAsMoment) {
        this.dateAsDate = null;
        this.dataAsMoment = dateAsMoment;
        this.dateAsNumber = 0;
        this.dateAsString = null;
    }
}
