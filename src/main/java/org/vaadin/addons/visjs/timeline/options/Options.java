package org.vaadin.addons.visjs.timeline.options;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nonnull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.vaadin.addons.visjs.timeline.options.cluster.Cluster;
import org.vaadin.addons.visjs.timeline.options.groups.GroupOrder;
import org.vaadin.addons.visjs.timeline.options.groups.GroupOrderSwap;
import org.vaadin.addons.visjs.timeline.options.groups.GroupTemplate;

public class Options {

  private String align;
  private Boolean autoResize;
  private Boolean clickToUse;

  private Configure configure;

  private DataAttributes dataAttributes;
  private Editable editable;

  private DateBoundary end;
  private DateFormat format;
  private Editable groupEditable;
  private String groupHeightMode;

  private GroupOrder groupOrder;
  private GroupOrderSwap groupOrderSwap;
  private GroupTemplate groupTemplate;

  private String height;
  private HiddenDates hiddenDates;

  private Boolean horizontalScroll;
  private ItemsAlwaysDraggable itemsAlwaysDraggable;
  private String locale;

  private Map<String, Locale> locales = new HashMap<>();
  private int longSelectPressTimee = 251;
  private Moment moment;
  private Margin margin;
  private DateBoundary max;
  private String maxHeight;
  private int maxMinorCharacters = 7;
  private DateBoundary min;
  private String minHeight;
  private Boolean movable = Boolean.TRUE;
  private Boolean multiselect;
  private Boolean multiSelectPerGroup;

  /*
onAdd	function	none	Callback function triggered when an item is about to be added: when the user double taps an empty space in the Timeline. See section Editing Items for more information. Only applicable when both options selectable and editable.add are set true.
onAddGroup	function	none	Callback function triggered when a group is about to be added. The signature and semantics are the same as for onAdd.
onDropObjectOnItem	function	none	Callback function triggered when an object containing target:'item' in its drag data is dropped in to a timeline item.
onInitialDrawComplete	function	none	Callback function triggered when the timeline is initially drawn. This function fires once per timeline creation.
onMove	function	none	Callback function triggered when an item has been moved: after the user has dragged the item to an other position. See section Editing Items for more information. Only applicable when both options selectable and editable.updateTime or editable.updateGroup are set true.
onMoveGroup	function	none	Callback function triggered when a group has been moved: after the user has dragged the group to an other position. The signature and semantics are the same as for onMove.
onMoving	function	none	Callback function triggered repeatedly when an item is being moved. See section Editing Items for more information. Only applicable when both options selectable and editable.updateTime or editable.updateGroup are set true.
onRemove	function	none	Callback function triggered when an item is about to be removed: when the user tapped the delete button on the top right of a selected item. See section Editing Items for more information. Only applicable when both options selectable and editable.remove are set true.
onRemoveGroup	function	none	Callback function triggered when a group is about to be removed. The signature and semantics are the same as for onRemove.
onUpdate	function	none	Callback function triggered when an item is about to be updated, when the user double taps an item in the Timeline. See section Editing Items for more information. Only applicable when both options selectable and editable.updateTime or editable.updateGroup are set true.
order	function	none
Provide a custom sort function to order the items. The order of the items is determining the way they are stacked. The function order is called with two arguments containing the data of two items to be compared.

WARNING: Use with caution. Custom ordering is not suitable for large amounts of items. On load, the Timeline will render all items once to determine their width and height. Keep the number of items in this configuration limited to a maximum of a few hundred items.
   */

  private String orientation = "bottom";
  private Boolean preferZoom;
  private RollingMode rollingMode;

  private Boolean rtl;
  private Boolean selectable;
  private Boolean sequentialSelection;
  private Boolean showCurrentTime;
  private Boolean showMajorLabels;
  private Boolean showMinorLabels;
  private Boolean showWeekScale;

  private Boolean showTooltips;
  private Boolean stack;

  public Boolean getStackSubgroups() {
    return stackSubgroups;
  }

  public void setStackSubgroups(Boolean stackSubgroups) {
    this.stackSubgroups = stackSubgroups;
  }

  private Boolean stackSubgroups = Boolean.TRUE;

  private Cluster cluster;

  private DateBoundary start;

  //private Function snap;
  //TODO:
  //private Function template;
  //private Function visableFrameTemplate;
  private TimeAxis timeAxis;
  private String type;
  private Tooltip tooltip;
  private Boolean verticalScroll;
  private String width="100%";

  private Xss xss;
  private Boolean zoomable;
  private int zoomFriction = 5;
  private String zoomKey;

  private long zoomMax = 315360000000000L;

  private long zoomMin=10;

  public static Builder newBuilder(@Nonnull Options copy) {
    Builder builder = new Builder();
    builder.align = copy.getAlign();
    builder.autoResize = copy.getAutoResize();
    builder.clickToUse = copy.getClickToUse();
    builder.configure = copy.getConfigure();
    builder.dataAttributes = copy.getDataAttributes();
    builder.editable = copy.getEditable();
    builder.end = copy.getEnd();
    builder.format = copy.getFormat();
    builder.groupEditable = copy.getGroupEditable();
    builder.groupHeightMode = copy.getGroupHeightMode();
    builder.groupOrder = copy.getGroupOrder();
    builder.groupOrderSwap = copy.getGroupOrderSwap();
    builder.groupTemplate = copy.getGroupTemplate();
    builder.height = copy.getHeight();
    builder.hiddenDates = copy.getHiddenDates();
    builder.horizontalScroll = copy.getHorizontalScroll();
    builder.itemsAlwaysDraggable = copy.getItemsAlwaysDraggable();
    builder.locale = copy.getLocale();
    builder.locales = copy.getLocales();
    builder.longSelectPressTimee = copy.getLongSelectPressTimee();
    builder.moment = copy.getMoment();
    builder.margin = copy.getMargin();
    builder.max = copy.getMax();
    builder.maxHeight = copy.getMaxHeight();
    builder.maxMinorCharacters = copy.getMaxMinorCharacters();
    builder.min = copy.getMin();
    builder.minHeight = copy.getMinHeight();
    builder.movable = copy.getMovable();
    builder.multiselect = copy.getMultiselect();
    builder.multiSelectPerGroup = copy.getMultiSelectPerGroup();
    builder.orientation = copy.getOrientation();
    builder.preferZoom = copy.getPreferZoom();
    builder.rollingMode = copy.getRollingMode();
    builder.rtl = copy.getRtl();
    builder.selectable = copy.getSelectable();
    builder.sequentialSelection = copy.getSequentialSelection();
    builder.showCurrentTime = copy.getShowCurrentTime();
    builder.showMajorLabels = copy.getShowMajorLabels();
    builder.showMinorLabels = copy.getShowMinorLabels();
    builder.showWeekScale = copy.getShowWeekScale();
    builder.showTooltips = copy.getShowTooltips();
    builder.stack = copy.getStack();
    builder.stackSubgroups = copy.getStackSubgroups();
    builder.cluster = copy.getCluster();
    builder.start = copy.getStart();
    builder.timeAxis = copy.getTimeAxis();
    builder.type = copy.getType();
    builder.tooltip = copy.getTooltip();
    builder.verticalScroll = copy.getVerticalScroll();
    builder.width = copy.getWidth();
    builder.xss = copy.getXss();
    builder.zoomable = copy.getZoomable();
    builder.zoomFriction = copy.getZoomFriction();
    builder.zoomKey = copy.getZoomKey();
    builder.zoomMax = copy.getZoomMax();
    builder.zoomMin = copy.getZoomMin();
    return builder;
  }

  public String getAlign() {
    return align;
  }

  public void setAlign(String align) {
    this.align = align;
  }

  public Boolean getAutoResize() {
    return autoResize;
  }

  public Boolean getClickToUse() {
    return clickToUse;
  }

  public DataAttributes getDataAttributes() {
    return dataAttributes;
  }

  public void setDataAttributes(DataAttributes dataAttributes) {
    this.dataAttributes = dataAttributes;
  }

  public Editable getEditable() {
    return editable;
  }

  public void setEditable(Editable editable) {
    this.editable = editable;
  }

  public DateBoundary getEnd() {
    return end;
  }

  public void setEnd(DateBoundary end) {
    this.end = end;
  }

  public DateFormat getFormat() {
    return format;
  }

  public void setFormat(DateFormat format) {
    this.format = format;
  }

  public Editable getGroupEditable() {
    return groupEditable;
  }

  public void setGroupEditable(Editable groupEditable) {
    this.groupEditable = groupEditable;
  }

  public String getGroupHeightMode() {
    return groupHeightMode;
  }

  public void setGroupHeightMode(String groupHeightMode) {
    this.groupHeightMode = groupHeightMode;
  }

  public GroupOrder getGroupOrder() {
    return groupOrder;
  }

  public void setGroupOrder(GroupOrder groupOrder) {
    this.groupOrder = groupOrder;
  }

  public GroupOrderSwap getGroupOrderSwap() {
    return groupOrderSwap;
  }

  public void setGroupOrderSwap(GroupOrderSwap groupOrderSwap) {
    this.groupOrderSwap = groupOrderSwap;
  }

  public GroupTemplate getGroupTemplate() {
    return groupTemplate;
  }

  public void setGroupTemplate(GroupTemplate groupTemplate) {
    this.groupTemplate = groupTemplate;
  }

  public HiddenDates getHiddenDates() {
    return hiddenDates;
  }

  public void setHiddenDates(HiddenDates hiddenDates) {
    this.hiddenDates = hiddenDates;
  }

  public Boolean getHorizontalScroll() {
    return horizontalScroll;
  }

  public void setHorizontalScroll(Boolean horizontalScroll) {
    this.horizontalScroll = horizontalScroll;
  }

  public ItemsAlwaysDraggable getItemsAlwaysDraggable() {
    return itemsAlwaysDraggable;
  }

  public void setItemsAlwaysDraggable(ItemsAlwaysDraggable itemsAlwaysDraggable) {
    this.itemsAlwaysDraggable = itemsAlwaysDraggable;
  }

  public int getLongSelectPressTimee() {
    return longSelectPressTimee;
  }

  public void setLongSelectPressTimee(int longSelectPressTimee) {
    this.longSelectPressTimee = longSelectPressTimee;
  }


  public Moment getMoment() {
    return moment;
  }

  public void setMoment(Moment moment) {
    this.moment = moment;
  }

  public Margin getMargin() {
    return margin;
  }

  public void setMargin(Margin margin) {
    this.margin = margin;
  }

  public DateBoundary getMax() {
    return max;
  }

  public void setMax(DateBoundary max) {
    this.max = max;
  }

  public String getMaxHeight() {
    return maxHeight;
  }

  public void setMaxHeight(String maxHeight) {
    this.maxHeight = maxHeight;
  }

  public int getMaxMinorCharacters() {
    return maxMinorCharacters;
  }

  public void setMaxMinorCharacters(int maxMinorCharacters) {
    this.maxMinorCharacters = maxMinorCharacters;
  }

  public DateBoundary getMin() {
    return min;
  }

  public void setMin(DateBoundary min) {
    this.min = min;
  }

  public String getMinHeight() {
    return minHeight;
  }

  public void setMinHeight(String minHeight) {
    this.minHeight = minHeight;
  }

  public Boolean getMovable() {
    return movable;
  }

  public void setMovable(Boolean movable) {
    this.movable = movable;
  }

  public Boolean getMultiselect() {
    return multiselect;
  }

  public void setMultiselect(Boolean multiselect) {
    this.multiselect = multiselect;
  }

  public Boolean getMultiSelectPerGroup() {
    return multiSelectPerGroup;
  }

  public void setMultiSelectPerGroup(Boolean multiSelectPerGroup) {
    this.multiSelectPerGroup = multiSelectPerGroup;
  }

  public String getOrientation() {
    return orientation;
  }

  public void setOrientation(String orientation) {
    this.orientation = orientation;
  }

  public Boolean getPreferZoom() {
    return preferZoom;
  }

  public void setPreferZoom(Boolean preferZoom) {
    this.preferZoom = preferZoom;
  }

  public RollingMode getRollingMode() {
    return rollingMode;
  }

  public void setRollingMode(RollingMode rollingMode) {
    this.rollingMode = rollingMode;
  }

  public Boolean getRtl() {
    return rtl;
  }

  public void setRtl(Boolean rtl) {
    this.rtl = rtl;
  }

  public Boolean getSelectable() {
    return selectable;
  }

  public void setSelectable(Boolean selectable) {
    this.selectable = selectable;
  }

  public Boolean getSequentialSelection() {
    return sequentialSelection;
  }

  public void setSequentialSelection(Boolean sequentialSelection) {
    this.sequentialSelection = sequentialSelection;
  }

  public Boolean getShowCurrentTime() {
    return showCurrentTime;
  }

  public void setShowCurrentTime(Boolean showCurrentTime) {
    this.showCurrentTime = showCurrentTime;
  }

  public Boolean getShowMajorLabels() {
    return showMajorLabels;
  }

  public void setShowMajorLabels(Boolean showMajorLabels) {
    this.showMajorLabels = showMajorLabels;
  }

  public Boolean getShowMinorLabels() {
    return showMinorLabels;
  }

  public void setShowMinorLabels(Boolean showMinorLabels) {
    this.showMinorLabels = showMinorLabels;
  }

  public Boolean getShowWeekScale() {
    return showWeekScale;
  }

  public void setShowWeekScale(Boolean showWeekScale) {
    this.showWeekScale = showWeekScale;
  }

  public Boolean getShowTooltips() {
    return showTooltips;
  }

  public void setShowTooltips(Boolean showTooltips) {
    this.showTooltips = showTooltips;
  }

  public Boolean getStack() {
    return stack;
  }

  public void setStack(Boolean stack) {
    this.stack = stack;
  }

  public DateBoundary getStart() {
    return start;
  }

  public Cluster getCluster() {
    return cluster;
  }

  public void setCluster(Cluster cluster) {
    this.cluster = cluster;
  }

  public TimeAxis getTimeAxis() {
    return timeAxis;
  }

  public void setTimeAxis(TimeAxis timeAxis) {
    this.timeAxis = timeAxis;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Tooltip getTooltip() {
    return tooltip;
  }

  public void setTooltip(Tooltip tooltip) {
    this.tooltip = tooltip;
  }

  public Boolean getVerticalScroll() {
    return verticalScroll;
  }

  public void setVerticalScroll(Boolean verticalScroll) {
    this.verticalScroll = verticalScroll;
  }

  public Xss getXss() {
    return xss;
  }

  public void setXss(Xss xss) {
    this.xss = xss;
  }

  public Boolean getZoomable() {
    return zoomable;
  }

  public void setZoomable(Boolean zoomable) {
    this.zoomable = zoomable;
  }

  public int getZoomFriction() {
    return zoomFriction;
  }

  public void setZoomFriction(int zoomFriction) {
    this.zoomFriction = zoomFriction;
  }

  public String getZoomKey() {
    return zoomKey;
  }

  public void setZoomKey(String zoomKey) {
    this.zoomKey = zoomKey;
  }

  public long getZoomMax() {
    return zoomMax;
  }

  public void setZoomMax(long zoomMax) {
    this.zoomMax = zoomMax;
  }

  public long getZoomMin() {
    return zoomMin;
  }

  public void setZoomMin(long zoomMin) {
    this.zoomMin = zoomMin;
  }

  private Options(Builder builder) {
    setAlign(builder.align);
    setAutoResize(builder.autoResize);
    setClickToUse(builder.clickToUse);
    setConfigure(builder.configure);
    setDataAttributes(builder.dataAttributes);
    setEditable(builder.editable);
    setEnd(builder.end);
    setFormat(builder.format);
    setGroupEditable(builder.groupEditable);
    setGroupHeightMode(builder.groupHeightMode);
    setGroupOrder(builder.groupOrder);
    setGroupOrderSwap(builder.groupOrderSwap);
    setGroupTemplate(builder.groupTemplate);
    setHeight(builder.height);
    setHiddenDates(builder.hiddenDates);
    setHorizontalScroll(builder.horizontalScroll);
    setItemsAlwaysDraggable(builder.itemsAlwaysDraggable);
    setLocale(builder.locale);
    setLocales(builder.locales);
    setLongSelectPressTimee(builder.longSelectPressTimee);
    setMoment(builder.moment);
    setMargin(builder.margin);
    setMax(builder.max);
    setMaxHeight(builder.maxHeight);
    setMaxMinorCharacters(builder.maxMinorCharacters);
    setMin(builder.min);
    setMinHeight(builder.minHeight);
    setMovable(builder.movable);
    setMultiselect(builder.multiselect);
    setMultiSelectPerGroup(builder.multiSelectPerGroup);
    setOrientation(builder.orientation);
    setPreferZoom(builder.preferZoom);
    setRollingMode(builder.rollingMode);
    setRtl(builder.rtl);
    setSelectable(builder.selectable);
    setSequentialSelection(builder.sequentialSelection);
    setShowCurrentTime(builder.showCurrentTime);
    setShowMajorLabels(builder.showMajorLabels);
    setShowMinorLabels(builder.showMinorLabels);
    setShowWeekScale(builder.showWeekScale);
    setShowTooltips(builder.showTooltips);
    setStack(builder.stack);
    setStackSubgroups(builder.stackSubgroups);
    setCluster(builder.cluster);
    setStart(builder.start);
    setTimeAxis(builder.timeAxis);
    setType(builder.type);
    setTooltip(builder.tooltip);
    setVerticalScroll(builder.verticalScroll);
    setWidth(builder.width);
    setXss(builder.xss);
    setZoomable(builder.zoomable);
    setZoomFriction(builder.zoomFriction);
    setZoomKey(builder.zoomKey);
    setZoomMax(builder.zoomMax);
    setZoomMin(builder.zoomMin);
  }

  public Options() {}


  public Boolean isAutoResize() {
    return autoResize;
  }

  public void setAutoResize(final Boolean autoResize) {
    this.autoResize = autoResize;
  }

  public String getLocale() {
    return locale;
  }

  public void setLocale(final String locale) {
    this.locale = locale;
  }

  public Configure getConfigure() {
    return configure;
  }

  public void setConfigure(final Configure configure) {
    this.configure = configure;
  }

  public Editable getManipulation() {
    return editable;
  }

  public void setManipulation(final Editable editable) {
    this.editable = editable;
  }

  /**
   * Toggle the manipulation system on or off. Even when false, the manipulation API through the
   * methods will still work.
   */


  public Boolean isClickToUse() {
    return clickToUse;
  }

  public void setClickToUse(final Boolean clickToUse) {
    this.clickToUse = clickToUse;
  }

  public String getHeight() {
    return height;
  }

  public void setHeight(final String height) {
    this.height = height;
  }

  public String getWidth() {
    return width;
  }

  public void setWidth(final String width) {
    this.width = width;
  }

  public Map<String, Locale> getLocales() {
    return locales;
  }

  public void setLocales(final Map<String, Locale> locales) {
    this.locales = locales;
  }

  public void setStart(DateBoundary start) {
    this.start = start;
  }

  /**
   * Creates builder to build {@link Options}. For default options for every option not set see
   * <a href="http://visjs.org/docs/network/#options">http://visjs.org/docs/network/#options</a>
   *
   * @return created builder
   */
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link Options}.
   */
  public static final class Builder {
    private String align;
    private Boolean autoResize;
    private Boolean clickToUse;

    private Configure configure;

    private DataAttributes dataAttributes;
    private Editable editable;

    private DateBoundary end;
    private DateFormat format;
    private Editable groupEditable;
    private String groupHeightMode;

    private GroupOrder groupOrder;
    private GroupOrderSwap groupOrderSwap;
    private GroupTemplate groupTemplate;

    private String height;
    private HiddenDates hiddenDates;

    private Boolean horizontalScroll;
    private ItemsAlwaysDraggable itemsAlwaysDraggable;
    private String locale;

    private Map<String, Locale> locales;
    private int longSelectPressTimee;
    private Moment moment;
    private Margin margin;
    private DateBoundary max;
    private String maxHeight;
    private int maxMinorCharacters;
    private DateBoundary min;
    private String minHeight;
    private Boolean movable;
    private Boolean multiselect;
    private Boolean multiSelectPerGroup;
    private String orientation;
    private Boolean preferZoom;
    private RollingMode rollingMode;

    private Boolean rtl;
    private Boolean selectable;
    private Boolean sequentialSelection;
    private Boolean showCurrentTime;
    private Boolean showMajorLabels;
    private Boolean showMinorLabels;
    private Boolean showWeekScale;

    private Boolean showTooltips;
    private Boolean stack;
    private Boolean stackSubgroups;
    private Cluster cluster;
    private DateBoundary start;

    private TimeAxis timeAxis;
    private String type;
    private Tooltip tooltip;
    private Boolean verticalScroll;
    private String width;

    private Xss xss;
    private Boolean zoomable;
    private int zoomFriction = 5;
    private String zoomKey;

    private long zoomMax = 315360000000000L   ;
    private long zoomMin = 10;

    private Builder() {
    }

    public static Builder newBuilder() {
      return new Builder();
    }

    /**
     * Sets the {@code align} and returns a reference to this Builder enabling method chaining.
     *
     * @param align the {@code align} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withAlign(@Nonnull String align) {
      this.align = align;
      return this;
    }

    /**
     * Sets the {@code autoResize} and returns a reference to this Builder enabling method chaining.
     *
     * @param autoResize the {@code autoResize} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withAutoResize(@Nonnull Boolean autoResize) {
      this.autoResize = autoResize;
      return this;
    }

    /**
     * Sets the {@code clickToUse} and returns a reference to this Builder enabling method chaining.
     *
     * @param clickToUse the {@code clickToUse} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withClickToUse(@Nonnull Boolean clickToUse) {
      this.clickToUse = clickToUse;
      return this;
    }

    /**
     * Sets the {@code configure} and returns a reference to this Builder enabling method chaining.
     *
     * @param configure the {@code configure} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withConfigure(@Nonnull Configure configure) {
      this.configure = configure;
      return this;
    }

    /**
     * Sets the {@code dataAttributes} and returns a reference to this Builder enabling method chaining.
     *
     * @param dataAttributes the {@code dataAttributes} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withDataAttributes(@Nonnull DataAttributes dataAttributes) {
      this.dataAttributes = dataAttributes;
      return this;
    }

    /**
     * Sets the {@code editable} and returns a reference to this Builder enabling method chaining.
     *
     * @param editable the {@code editable} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withEditable(@Nonnull Editable editable) {
      this.editable = editable;
      return this;
    }

    /**
     * Sets the {@code end} and returns a reference to this Builder enabling method chaining.
     *
     * @param end the {@code end} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withEnd(@Nonnull DateBoundary end) {
      this.end = end;
      return this;
    }

    /**
     * Sets the {@code format} and returns a reference to this Builder enabling method chaining.
     *
     * @param format the {@code format} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withFormat(@Nonnull DateFormat format) {
      this.format = format;
      return this;
    }

    /**
     * Sets the {@code groupEditable} and returns a reference to this Builder enabling method chaining.
     *
     * @param groupEditable the {@code groupEditable} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withGroupEditable(@Nonnull Editable groupEditable) {
      this.groupEditable = groupEditable;
      return this;
    }

    /**
     * Sets the {@code groupHeightMode} and returns a reference to this Builder enabling method chaining.
     *
     * @param groupHeightMode the {@code groupHeightMode} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withGroupHeightMode(@Nonnull String groupHeightMode) {
      this.groupHeightMode = groupHeightMode;
      return this;
    }

    /**
     * Sets the {@code groupOrder} and returns a reference to this Builder enabling method chaining.
     *
     * @param groupOrder the {@code groupOrder} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withGroupOrder(@Nonnull GroupOrder groupOrder) {
      this.groupOrder = groupOrder;
      return this;
    }

    /**
     * Sets the {@code groupOrderSwap} and returns a reference to this Builder enabling method chaining.
     *
     * @param groupOrderSwap the {@code groupOrderSwap} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withGroupOrderSwap(@Nonnull GroupOrderSwap groupOrderSwap) {
      this.groupOrderSwap = groupOrderSwap;
      return this;
    }

    /**
     * Sets the {@code groupTemplate} and returns a reference to this Builder enabling method chaining.
     *
     * @param groupTemplate the {@code groupTemplate} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withGroupTemplate(@Nonnull GroupTemplate groupTemplate) {
      this.groupTemplate = groupTemplate;
      return this;
    }

    /**
     * Sets the {@code height} and returns a reference to this Builder enabling method chaining.
     *
     * @param height the {@code height} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withHeight(@Nonnull String height) {
      this.height = height;
      return this;
    }

    /**
     * Sets the {@code hiddenDates} and returns a reference to this Builder enabling method chaining.
     *
     * @param hiddenDates the {@code hiddenDates} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withHiddenDates(@Nonnull HiddenDates hiddenDates) {
      this.hiddenDates = hiddenDates;
      return this;
    }

    /**
     * Sets the {@code horizontalScroll} and returns a reference to this Builder enabling method chaining.
     *
     * @param horizontalScroll the {@code horizontalScroll} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withHorizontalScroll(@Nonnull Boolean horizontalScroll) {
      this.horizontalScroll = horizontalScroll;
      return this;
    }

    /**
     * Sets the {@code itemsAlwaysDraggable} and returns a reference to this Builder enabling method chaining.
     *
     * @param itemsAlwaysDraggable the {@code itemsAlwaysDraggable} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withItemsAlwaysDraggable(@Nonnull ItemsAlwaysDraggable itemsAlwaysDraggable) {
      this.itemsAlwaysDraggable = itemsAlwaysDraggable;
      return this;
    }

    /**
     * Sets the {@code locale} and returns a reference to this Builder enabling method chaining.
     *
     * @param locale the {@code locale} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withLocale(@Nonnull String locale) {
      this.locale = locale;
      return this;
    }

    /**
     * Sets the {@code locales} and returns a reference to this Builder enabling method chaining.
     *
     * @param locales the {@code locales} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withLocales(@Nonnull Map<String, Locale> locales) {
      this.locales = locales;
      return this;
    }

    /**
     * Sets the {@code longSelectPressTimee} and returns a reference to this Builder enabling method chaining.
     *
     * @param longSelectPressTimee the {@code longSelectPressTimee} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withLongSelectPressTimee(int longSelectPressTimee) {
      this.longSelectPressTimee = longSelectPressTimee;
      return this;
    }

    /**
     * Sets the {@code moment} and returns a reference to this Builder enabling method chaining.
     *
     * @param moment the {@code moment} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withMoment(@Nonnull Moment moment) {
      this.moment = moment;
      return this;
    }

    /**
     * Sets the {@code margin} and returns a reference to this Builder enabling method chaining.
     *
     * @param margin the {@code margin} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withMargin(@Nonnull Margin margin) {
      this.margin = margin;
      return this;
    }

    /**
     * Sets the {@code max} and returns a reference to this Builder enabling method chaining.
     *
     * @param max the {@code max} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withMax(@Nonnull DateBoundary max) {
      this.max = max;
      return this;
    }

    /**
     * Sets the {@code maxHeight} and returns a reference to this Builder enabling method chaining.
     *
     * @param maxHeight the {@code maxHeight} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withMaxHeight(@Nonnull String maxHeight) {
      this.maxHeight = maxHeight;
      return this;
    }

    /**
     * Sets the {@code maxMinorCharacters} and returns a reference to this Builder enabling method chaining.
     *
     * @param maxMinorCharacters the {@code maxMinorCharacters} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withMaxMinorCharacters(int maxMinorCharacters) {
      this.maxMinorCharacters = maxMinorCharacters;
      return this;
    }

    /**
     * Sets the {@code min} and returns a reference to this Builder enabling method chaining.
     *
     * @param min the {@code min} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withMin(@Nonnull DateBoundary min) {
      this.min = min;
      return this;
    }

    /**
     * Sets the {@code minHeight} and returns a reference to this Builder enabling method chaining.
     *
     * @param minHeight the {@code minHeight} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withMinHeight(@Nonnull String minHeight) {
      this.minHeight = minHeight;
      return this;
    }

    @Nonnull
    public Builder withMovable(Boolean movable) {
      this.movable = movable;
      return this;
    }

    /**
     * Sets the {@code multiselect} and returns a reference to this Builder enabling method chaining.
     *
     * @param multiselect the {@code multiselect} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withMultiselect(@Nonnull Boolean multiselect) {
      this.multiselect = multiselect;
      return this;
    }

    /**
     * Sets the {@code multiSelectPerGroup} and returns a reference to this Builder enabling method chaining.
     *
     * @param multiSelectPerGroup the {@code multiSelectPerGroup} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withMultiSelectPerGroup(@Nonnull Boolean multiSelectPerGroup) {
      this.multiSelectPerGroup = multiSelectPerGroup;
      return this;
    }

    /**
     * Sets the {@code orientation} and returns a reference to this Builder enabling method chaining.
     *
     * @param orientation the {@code orientation} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withOrientation(@Nonnull String orientation) {
      this.orientation = orientation;
      return this;
    }

    /**
     * Sets the {@code preferZoom} and returns a reference to this Builder enabling method chaining.
     *
     * @param preferZoom the {@code preferZoom} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withPreferZoom(@Nonnull Boolean preferZoom) {
      this.preferZoom = preferZoom;
      return this;
    }

    /**
     * Sets the {@code rollingMode} and returns a reference to this Builder enabling method chaining.
     *
     * @param rollingMode the {@code rollingMode} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withRollingMode(@Nonnull RollingMode rollingMode) {
      this.rollingMode = rollingMode;
      return this;
    }

    /**
     * Sets the {@code rtl} and returns a reference to this Builder enabling method chaining.
     *
     * @param rtl the {@code rtl} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withRtl(@Nonnull Boolean rtl) {
      this.rtl = rtl;
      return this;
    }

    /**
     * Sets the {@code selectable} and returns a reference to this Builder enabling method chaining.
     *
     * @param selectable the {@code selectable} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withSelectable(@Nonnull Boolean selectable) {
      this.selectable = selectable;
      return this;
    }

    /**
     * Sets the {@code sequentialSelection} and returns a reference to this Builder enabling method chaining.
     *
     * @param sequentialSelection the {@code sequentialSelection} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withSequentialSelection(@Nonnull Boolean sequentialSelection) {
      this.sequentialSelection = sequentialSelection;
      return this;
    }

    /**
     * Sets the {@code showCurrentTime} and returns a reference to this Builder enabling method chaining.
     *
     * @param showCurrentTime the {@code showCurrentTime} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withShowCurrentTime(@Nonnull Boolean showCurrentTime) {
      this.showCurrentTime = showCurrentTime;
      return this;
    }

    /**
     * Sets the {@code showMajorLabels} and returns a reference to this Builder enabling method chaining.
     *
     * @param showMajorLabels the {@code showMajorLabels} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withShowMajorLabels(@Nonnull Boolean showMajorLabels) {
      this.showMajorLabels = showMajorLabels;
      return this;
    }

    /**
     * Sets the {@code showMinorLabels} and returns a reference to this Builder enabling method chaining.
     *
     * @param showMinorLabels the {@code showMinorLabels} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withShowMinorLabels(@Nonnull Boolean showMinorLabels) {
      this.showMinorLabels = showMinorLabels;
      return this;
    }

    /**
     * Sets the {@code showWeekScale} and returns a reference to this Builder enabling method chaining.
     *
     * @param showWeekScale the {@code showWeekScale} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withShowWeekScale(@Nonnull Boolean showWeekScale) {
      this.showWeekScale = showWeekScale;
      return this;
    }

    /**
     * Sets the {@code showTooltips} and returns a reference to this Builder enabling method chaining.
     *
     * @param showTooltips the {@code showTooltips} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withShowTooltips(@Nonnull Boolean showTooltips) {
      this.showTooltips = showTooltips;
      return this;
    }

    /**
     * Sets the {@code stack} and returns a reference to this Builder enabling method chaining.
     *
     * @param stack the {@code stack} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withStack(@Nonnull Boolean stack) {
      this.stack = stack;
      return this;
    }

    /**
     * Sets the {@code stackSubgroups} and returns a reference to this Builder enabling method chaining.
     *
     * @param stackSubgroups the {@code stackSubgroups} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withStackSubgroups(@Nonnull Boolean stackSubgroups) {
      this.stackSubgroups = stackSubgroups;
      return this;
    }

    /**
     * Sets the {@code cluster} and returns a reference to this Builder enabling method chaining.
     *
     * @param cluster the {@code cluster} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withCluster(@Nonnull Cluster cluster) {
      this.cluster = cluster;
      return this;
    }

    /**
     * Sets the {@code start} and returns a reference to this Builder enabling method chaining.
     *
     * @param start the {@code start} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withStart(@Nonnull DateBoundary start) {
      this.start = start;
      return this;
    }

    /**
     * Sets the {@code timeAxis} and returns a reference to this Builder enabling method chaining.
     *
     * @param timeAxis the {@code timeAxis} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withTimeAxis(@Nonnull TimeAxis timeAxis) {
      this.timeAxis = timeAxis;
      return this;
    }

    /**
     * Sets the {@code type} and returns a reference to this Builder enabling method chaining.
     *
     * @param type the {@code type} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withType(@Nonnull String type) {
      this.type = type;
      return this;
    }

    /**
     * Sets the {@code tooltip} and returns a reference to this Builder enabling method chaining.
     *
     * @param tooltip the {@code tooltip} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withTooltip(@Nonnull Tooltip tooltip) {
      this.tooltip = tooltip;
      return this;
    }

    /**
     * Sets the {@code verticalScroll} and returns a reference to this Builder enabling method chaining.
     *
     * @param verticalScroll the {@code verticalScroll} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withVerticalScroll(@Nonnull Boolean verticalScroll) {
      this.verticalScroll = verticalScroll;
      return this;
    }

    /**
     * Sets the {@code width} and returns a reference to this Builder enabling method chaining.
     *
     * @param width the {@code width} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withWidth(@Nonnull String width) {
      this.width = width;
      return this;
    }

    /**
     * Sets the {@code xss} and returns a reference to this Builder enabling method chaining.
     *
     * @param xss the {@code xss} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withXss(@Nonnull Xss xss) {
      this.xss = xss;
      return this;
    }

    /**
     * Sets the {@code zoomable} and returns a reference to this Builder enabling method chaining.
     *
     * @param zoomable the {@code zoomable} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withZoomable(@Nonnull Boolean zoomable) {
      this.zoomable = zoomable;
      return this;
    }

    /**
     * Sets the {@code zoomFriction} and returns a reference to this Builder enabling method chaining.
     *
     * @param zoomFriction the {@code zoomFriction} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withZoomFriction(int zoomFriction) {
      this.zoomFriction = zoomFriction;
      return this;
    }

    /**
     * Sets the {@code zoomKey} and returns a reference to this Builder enabling method chaining.
     *
     * @param zoomKey the {@code zoomKey} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withZoomKey(@Nonnull String zoomKey) {
      this.zoomKey = zoomKey;
      return this;
    }

    /**
     * Sets the {@code zoomMax} and returns a reference to this Builder enabling method chaining.
     *
     * @param zoomMax the {@code zoomMax} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withZoomMax(long zoomMax) {
      this.zoomMax = zoomMax;
      return this;
    }

    /**
     * Sets the {@code zoomMin} and returns a reference to this Builder enabling method chaining.
     *
     * @param zoomMin the {@code zoommMin} to set
     * @return a reference to this Builder
     */
    @Nonnull
    public Builder withZoomMin(long zoomMin) {
      this.zoomMin = zoomMin;
      return this;
    }

    @Nonnull
    public Options build() {
      return new Options(this);
    }
  }

}
