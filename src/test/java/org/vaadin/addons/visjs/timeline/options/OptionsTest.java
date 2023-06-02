package org.vaadin.addons.visjs.timeline.options;

import com.fasterxml.jackson.core.JsonProcessingException;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.vaadin.addons.visjs.timeline.main.TimelineDate;
import org.vaadin.addons.visjs.timeline.options.cluster.Cluster;
import org.vaadin.addons.visjs.timeline.util.JsonObjectMapping;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashMap;

public class OptionsTest extends TestCase {

    private Options buildOptions()
    {
        Options options = new Options();
        options.setAlign("left");
        options.setClickToUse(Boolean.FALSE);
        options.setAutoResize(Boolean.TRUE);
        options.setCluster(Cluster.newBuilder().withFitOnDoubleClick(Boolean.TRUE).withMaxItems(10).withShowStipes(Boolean.TRUE).withTitleTemplate("template").build());
        options.setConfigure(Configure.newBuilder().withContainer("ContainerY").withFilter("FilterX").withEnabled(Boolean.TRUE).withShowButton(Boolean.FALSE).build());
        String[] attributes = new String[4];
        attributes[0] = "a1";
        attributes[1] = "b2";
        attributes[2] = "c3";
        attributes[3] = "d4";
        options.setDataAttributes(DataAttributes.newBuilder().withAttributes(attributes).build());
        options.setEditable(Editable.newObjectBuilder().withAdd(true).withAdd(true).build());
        options.setGroupEditable(Editable.newSimpleBuilder().withEditable(true).build());
        options.setGroupHeightMode("auto");
        //options.setGroupOrder();  - NYI
        //options.setGroupOrderSwap();  - NYI
        //options.setGroupTemplate();  - NYI
        //options.setHiddenDates(); - NYI
        options.setHorizontalScroll(true);
        options.setItemsAlwaysDraggable(ItemsAlwaysDraggable.newBuilder().withItem(true).build());
        HashMap testLocale = new HashMap<>();
        testLocale.put("MyLocale", Locale.newBuilder().withCurrent("CURRENT").build());
        options.setLocales(testLocale);
        options.setLocale("MyLocale");
        options.setLongSelectPressTime(255);
        //options.setMoment(); - NYI
        options.setMargin(Margin.newBuilder().withAxis(20).withHorizontal(10).withVertical(12).build());
        options.setMaxHeight("300px");
        options.setMaxMinorChars(8);
        options.setMinHeight("200px");
        options.setMovable(Boolean.TRUE);
        options.setMultiselect(Boolean.TRUE);
        options.setMultiSelectPerGroup(Boolean.TRUE);
        options.setOrientation("bottom");  //TODO: Add Object version
        options.setPreferZoom(Boolean.TRUE);
        options.setRollingMode(RollingMode.newBuilder().withFollow(true).withOffset(10).build());
        options.setRtl(Boolean.FALSE);
        options.setSelectable(Boolean.TRUE);
        options.setSequentialSelection(Boolean.FALSE);
        options.setShowCurrentTime(Boolean.FALSE);
        options.setShowMajorLabels(Boolean.FALSE);
        options.setShowMinorLabels(Boolean.FALSE);
        options.setShowWeekScale(Boolean.TRUE);
        options.setShowTooltips(Boolean.FALSE);
        options.setStack(Boolean.FALSE);
        options.setStackSubgroups(Boolean.FALSE);
        //options.setSnap() - NYI
        options.setTimeAxis(TimeAxis.newBuilder().withScale("day").withStep(1).build());
        options.setType("box");
        options.setTooltip(Tooltip.newBuilder().withOverflowMethod("cap").build());
        //options.setTooltipOnItemUpdateTime -NYI
        options.setVerticalScroll(Boolean.TRUE);
        options.setWidth("400px");
        options.setXss(Xss.newBuilder().withDisabled(Boolean.TRUE).build());
        options.setZoomable(Boolean.TRUE);
        options.setZoomFriction(8);
        options.setZoomKey("altKey");
        options.setZoomMax(3153600000000L);
        options.setZoomMin(15);
        //
        options.setStart(TimelineDate.newBuilder().withDate(LocalDate.now()).build());
        options.setEnd(TimelineDate.newBuilder().withString("tomorrow").build());
        options.setMax(TimelineDate.newBuilder().withMoment(Instant.now()).build());
        options.setMin(TimelineDate.newBuilder().withNumber(1000).build());
        //
        options.setTemplateCode("function (item, elelment, data) {return \"<div class=\\\"card\\\"><div class=\\\"card-title\">Encounter</div><div class=\\\"card-location\\\"></div>\"+patientLocations(item.id)+\"</div></div><div class=\\\"network-node\\\" id= \\\"tl\" + item.id + \"\\\"></div>\";");
        return options;
    }
    @Test
    public void testOptionsJSON() throws JsonProcessingException {
        Options options =  buildOptions();
        Assert.assertNotNull(options.getEnd());
        System.out.println(JsonObjectMapping.getObjectMapper().writeValueAsString(options.getEnd()));
        String out = JsonObjectMapping.getObjectMapper().writeValueAsString(options);
        System.out.println(out);
        Options chk = JsonObjectMapping.getObjectMapper().readValue(out,Options.class );
        Assert.assertNotNull(chk);
        Assert.assertTrue(chk.getStart().getType() == TimelineDate.DateType.DATE);
        Assert.assertTrue(chk.getEnd().getType() == TimelineDate.DateType.STRING);
        Assert.assertTrue(chk.getMin().getType() == TimelineDate.DateType.NUMBER);
        Assert.assertTrue(chk.getMax().getType() == TimelineDate.DateType.MOMENT);
        out = JsonObjectMapping.getObjectMapper().writeValueAsString(chk);
        System.out.println(out);
    }
    @Test
    public void testGetEnd() {
        Options options = buildOptions();
        TimelineDate fnd = options.getEnd();
        Assert.assertNotNull(fnd);
    }
}
