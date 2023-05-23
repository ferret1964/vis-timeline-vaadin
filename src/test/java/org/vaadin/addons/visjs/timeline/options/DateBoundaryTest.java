package org.vaadin.addons.visjs.timeline.options;

import com.fasterxml.jackson.core.JsonProcessingException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.vaadin.addons.visjs.timeline.util.JsonObjectMapping;

import java.time.Instant;
import java.time.LocalDate;


public class DateBoundaryTest extends TestCase {

    public void testGetJSON() throws JsonProcessingException {
        DateBoundary test = DateBoundary.newBuilder().build();
        System.out.println(test.getJSON());
        test.setDateAsString("2030-01-01");
        System.out.println(test.getJSON());
        test.setDataAsNumber(3333);
        System.out.println(test.getJSON());
        test.setDateAsDate(LocalDate.now());
        System.out.println(test.getJSON());
        test.setDateAsMoment(Instant.now());
        Object out = test.getJSON();
        System.out.println(out);
        System.out.println(out.getClass().getName());
        String out2 = JsonObjectMapping.getObjectMapper().writeValueAsString(out);
        DateBoundary chk = JsonObjectMapping.getObjectMapper().readValue(out2,DateBoundary.class );
        Assert.assertNotNull(chk);
        System.out.println(chk.getJSON());
    }
}
