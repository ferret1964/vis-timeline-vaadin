package org.vaadin.addons.visjs.timeline.main;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.vaadin.addons.visjs.timeline.util.deserializers.DateBoundaryDeserializer;
import org.vaadin.addons.visjs.timeline.util.JsonObjectMapping;

import javax.annotation.Nonnull;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@JsonDeserialize(using = DateBoundaryDeserializer.class)
public class TimelineDate {

    private DateType type = DateType.EMPTY;

    private static SimpleDateFormat momentFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss.SSSSSS'Z'");
    private static Pattern simpleNumberPattern = Pattern.compile("\\d+");
    private String dateAsString;
    private LocalDate dateAsDate;
    private int dateAsNumber;
    private Instant dateAsMoment;

    public TimelineDate()
    {

    }
    // @JsonCreator
    public TimelineDate(String value)
    {
            if (value.endsWith("Z")) {
                try {
                    //Momenet
                    setDateAsMoment(JsonObjectMapping.getObjectMapper().readValue("\""+value+"\"", Instant.class));
                }
                catch (JsonProcessingException e)
                {
                    setDateAsString(value);
                }
            }
            else {
                if (value.contains("-")) {
                    //Should be a LocalDate
                    try {
                        setDateAsDate(JsonObjectMapping.getObjectMapper().readValue("\""+value+"\"", LocalDate.class));
                    }
                    catch (JsonProcessingException e) {
                        setDateAsString(value);
                    }
                } else {
                    Matcher matcher = simpleNumberPattern.matcher(value);
                    if (matcher.matches()) {
                        this.setDataAsNumber(Integer.parseInt(value));
                    } else {
                        setDateAsString(value);
                    }
                }
            }


    }

    private TimelineDate(Builder builder) {
        switch(builder.type)
        {
            case DATE:
            {
                setDateAsDate(builder.dateAsDate);
                break;
            }
            case STRING:
            {
                setDateAsString(builder.dateAsString);
                break;
            }
            case NUMBER:
            {
                setDataAsNumber(builder.dateAsNumber);
                break;
            }
            case MOMENT:
            {
                setDateAsMoment(builder.dateAsMoment);
                break;
            }
            default:
            {
                break;
            }
        }
    }

    public static Builder newBuilder(@Nonnull TimelineDate copy) {
        Builder builder = new Builder();
        builder.dateAsString = copy.getDateAsString();
        builder.dateAsDate = copy.getDateAsDate();
        builder.dateAsNumber = copy.getDateAsNumber();
        builder.dateAsMoment = copy.getDateAsMoment();
        return builder;
    }


    public static Builder newBuilder() {
        Builder builder = new Builder();
        return builder;
    }

    public void clear()
    {
        dateAsDate = null;
        dateAsMoment = null;
        dateAsNumber = 0;
        dateAsString = null;
        type = DateType.EMPTY;
    }
    public Instant getDateAsMoment() {
        return dateAsMoment;
    }

    public void setDateAsMoment(Instant dateAsMoment) {
        clear();
        this.dateAsMoment = dateAsMoment;
        type=DateType.MOMENT;
    }

    public int getDateAsNumber() {
        return dateAsNumber;
    }

    public void setDataAsNumber(int dateAsNumber) {
        clear();
        this.dateAsNumber = dateAsNumber;
        type = DateType.NUMBER;
    }

    public LocalDate getDateAsDate() {
        return dateAsDate;
    }

    public void setDateAsDate(LocalDate dateAsDate) {
        clear();
        this.dateAsDate = dateAsDate;
        type= DateType.DATE;
    }

    public String getDateAsString() {
        return dateAsString;
    }

    public void setDateAsString(String dateAsString) {
        clear();
        this.dateAsString = dateAsString;
        type = DateType.STRING;
    }
    public DateType getType() {
        return type;
    }

    @JsonValue
    public Object getJSON() throws JsonProcessingException {
        Object out = null;
        switch(type)
        {
            case EMPTY:
            {
                break;
            }
            case STRING:
            {
                out = dateAsString;
                break;
            }
            case NUMBER:
            {
                out = Integer.valueOf(dateAsNumber);
                break;
            }
            case MOMENT:
            {
                //out = JsonObjectMapping.getObjectMapper().writeValueAsString(dateAsMoment);
                //out = out.substring(1,out.length()-1);
                out = dateAsMoment;
                break;
            }
            case DATE:
            {
                //out = JsonObjectMapping.getObjectMapper().writeValueAsString(dateAsDate);
                //out = out.substring(1,out.length()-1);
                out = dateAsDate;
                break;
            }
            default:
            {
                break;
            }
        }
        return out;
    }



    public enum DateType {

        EMPTY(0, "Empty"), STRING(1, "String"), NUMBER(2, "Number"), DATE(3, "Date"), MOMENT(4, "Moment");

        private final Integer id;
        private final String name;

        DateType(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }


    }

    /**
     * {@code TimelineDate} builder static inner class.
     */
    public static final class Builder {

        private DateType type = DateType.EMPTY;
        private String dateAsString;
        private LocalDate dateAsDate;
        private int dateAsNumber;
        private Instant dateAsMoment;

        private Builder() {
        }

        private void clear()
        {
            type = DateType.EMPTY;
            dateAsString=null;
            dateAsDate=null;
            dateAsNumber=0;
            dateAsMoment=null;
        }
        public static Builder newBuilder() {
            return new Builder();
        }

        /**
         * Sets the {@code dateAsString} and returns a reference to this Builder enabling method chaining.
         *
         * @param dateAsString the {@code dateAsString} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withString(@Nonnull String dateAsString) {
            clear();
            this.dateAsString = dateAsString;
            type=DateType.STRING;
            return this;
        }

        /**
         * Sets the {@code dateAsDate} and returns a reference to this Builder enabling method chaining.
         *
         * @param dateAsDate the {@code dateAsDate} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withDate(@Nonnull LocalDate dateAsDate) {
            clear();
            this.dateAsDate = dateAsDate;
            type=DateType.DATE;
            return this;
        }

        /**
         * Sets the {@code dateAsNumber} and returns a reference to this Builder enabling method chaining.
         *
         * @param dateAsNumber the {@code dateAsNumber} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withNumber(int dateAsNumber) {
            clear();
            this.dateAsNumber = dateAsNumber;
            type = DateType.NUMBER;
            return this;
        }

        /**
         * Sets the {@code dateAsMoment} and returns a reference to this Builder enabling method chaining.
         *
         * @param dateAsMoment the {@code dateAsMoment} to set
         * @return a reference to this Builder
         */
        @Nonnull
        public Builder withMoment(@Nonnull Instant dateAsMoment) {
            clear();
            this.dateAsMoment = dateAsMoment;
            type = DateType.MOMENT;
            return this;
        }

        /**
         * Returns a {@code TimelineDate} built from the parameters previously set.
         *
         * @return a {@code TimelineDate} built with parameters of this {@code TimelineDate.Builder}
         */
        @Nonnull
        public TimelineDate build() {
            return new TimelineDate(this);
        }
    }

}
