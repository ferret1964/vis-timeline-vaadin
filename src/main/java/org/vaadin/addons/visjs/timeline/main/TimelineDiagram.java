package org.vaadin.addons.visjs.timeline.main;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.json.JsonWriteFeature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.DomEvent;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.data.provider.DataProvider;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.function.SerializableConsumer;
import com.vaadin.flow.internal.JsonUtils;
import com.vaadin.flow.shared.Registration;

import org.vaadin.addons.visjs.timeline.api.Event;
import org.vaadin.addons.visjs.timeline.event.*;
import org.vaadin.addons.visjs.timeline.listener.*;
import org.vaadin.addons.visjs.timeline.options.Options;
import org.vaadin.addons.visjs.timeline.options.groups.Groups;
import elemental.json.JsonArray;
import elemental.json.impl.JreJsonString;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;

/**
 * Wraps a visjs network diagram. See http://visjs.org/network_examples.html
 */
@SuppressWarnings("serial")
@Tag("div")
@JsModule("./vis-loader-new.ts")
@JsModule("./timelineDiagram-connector-flow.js")
@JsModule("vis-timeline/standalone/umd/vis-timeline.min.js")
@NpmPackage(value = "vis-timeline", version = "7.7.2")
public class TimelineDiagram extends Component implements HasSize {

  Logger log = LoggerFactory.getLogger(org.vaadin.addons.visjs.timeline.main.TimelineDiagram.class);

  private Set<String> selections = new HashSet<String>();
  private final Options options;
  private final ObjectMapper mapper = new ObjectMapper();

  // Holds all eventtypes already registered client side.
  private final Set<Class<? extends Event>> enabledEvents = new LinkedHashSet<>();

  private DataProvider<Groups, ?> groupsDataProvider = DataProvider.ofItems();
  private DataProvider<Item, ?> itemsDataProvider = DataProvider.ofItems();

  private Registration itemsDataProviderListenerRegistration;
  private Registration groupsDataProviderListenerRegistration;

  public TimelineDiagram(final Options options) {
    super();
    // Dont transfer empty options.
    mapper.setSerializationInclusion(Include.NON_EMPTY);
    // Dont transfer getter and setter
    mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
        .withGetterVisibility(Visibility.NONE).withSetterVisibility(Visibility.NONE)
        .withIsGetterVisibility(Visibility.NONE).withFieldVisibility(Visibility.ANY));
    // remains utf8 escaped chars
    mapper.configure(JsonWriteFeature.ESCAPE_NON_ASCII.mappedFeature(), true);
    // mapper.getFactory().configure(JsonGenerator, true);
    this.options = Objects.requireNonNull(options);
    //if (options.getManipulation() == null) {
    //   options.setManipulation(new Editable());
    // }
    this.setWidth(options.getWidth());
    this.setHeight(options.getHeight());
  }

  private void initConnector() {
    String itemArray = "[]";
    try {
      itemArray = mapper.writeValueAsString(
          getItemsDataProviderDataProvider().fetch(new Query<>()).collect(Collectors.toSet()));
    } catch (final JsonProcessingException e) {
      e.printStackTrace();
    }
    String groupsArray = "[]";
    try {
      groupsArray = mapper.writeValueAsString(
          getGroupsDataProvider().fetch(new Query<>()).collect(Collectors.toSet()));
    } catch (final JsonProcessingException e) {
      e.printStackTrace();
    }

    /*Page page = UI.getCurrent().getPage();
    page.executeJs("window.Vaadin.Flow.networkDiagramConnector.initLazy($0, $1, $2, $3)",
            getElement(), nodesArray, edgesArray, optionsToJson(options));*/

    getUI()
        .orElseThrow(() -> new IllegalStateException(
            "Connector can only be initialized for an attached NetworkDiagram"))
        .getPage()
        .executeJs("window.Vaadin.Flow.timelinekDiagramConnector.initLazy($0, $1, $2, $3)",
            getElement(), itemArray, groupsArray, optionsToJson(options));


  }

  @Override
  protected void onAttach(AttachEvent attachEvent) {
    super.onAttach(attachEvent);
    initConnector();
  }

  @Override
  protected void onDetach(DetachEvent detachEvent) {
    super.onDetach(detachEvent);
    // FIXME does not work this.diagamDestroy();
    enabledEvents.clear();
  }

  private String optionsToJson(final Options options) {
    try {
      log.info("Options: {}", mapper.writeValueAsString(options));
      return mapper.writeValueAsString(options);
    } catch (final JsonProcessingException e) {
      e.printStackTrace();
    }
    return "{}";
  }

  void runBeforeClientResponse(SerializableConsumer<UI> command) {
    getElement().getNode()
        .runWhenAttached(ui -> ui.beforeClientResponse(this, context -> command.accept(ui)));
  }

  // public void setCustomNodeIfAdded(final boolean activate, final String id, final String label) {
  // callFunction("setCustomNodeIfAdded", activate, id, label);
  // }
  //
  // public void setCustomEdgeIfAdded(final boolean activate, final String id, final String label) {
  // callFunction("setCustomEdgeIfAdded", activate, id, label);
  // }

  // public void updateOptions(final Options options) {
  // getState().updates++;
  // callFunction("updateOptions", gson.toJson(options));
  // }
  //

  /**
   * Creates a ListDataProvider with the given items.
   *
   * @param items
   */

  public void setItems(Collection<Item> items) {
    setItemsDataProvider(new ListDataProvider<>(items));
  }


  /**
   * Creates a ListDataProvider with the given items.
   *
   * @param items
   */

  public void setItems(Item... items) {
    setItemsDataProvider(new ListDataProvider<>(Arrays.asList(items)));
  }

  /**
   * Creates a ListDataProvider with the given items.
   *
   * @param groups
   */
  public void setGroups(Collection<Groups> groups) {
    setGroupsDataProvider(new ListDataProvider<>(groups));
  }



  /**
   * Creates a ListDataProvider with the given groups.
   *
   * @param groups
   */
  public void setGroups(Groups... groups) {
    setGroupsDataProvider(new ListDataProvider<>(Arrays.asList(groups)));
  }

   private void addItems(Iterable<Item> items) {
     addItems(StreamSupport.stream(items.spliterator(), false).toArray(Item[]::new));
   }

   private void addItems(final Item... item) {
     runBeforeClientResponse(ui -> {
       try {
         getElement().callJsFunction("$connector.addItems", mapper.writeValueAsString(item));
       } catch (final JsonProcessingException e) {
         e.printStackTrace();
       }
     });
   }

   public void addGroups(Iterable<Groups> groups) {
     addGroups(StreamSupport.stream(groups.spliterator(), false).toArray(Groups[]::new));
   }

   private void addGroups(final Groups... groups) {
     runBeforeClientResponse(ui -> {
       try {
         getElement().callJsFunction("$connector.addGroups", mapper.writeValueAsString(groups));
       } catch (final JsonProcessingException e) {
         e.printStackTrace();
       }
     });
   }

   private void removeAllItems() {
     runBeforeClientResponse(ui -> {
       getElement().callJsFunction("$connector.clearItems");
     });
   }

   private void removeAllGroups() {
     runBeforeClientResponse(ui -> {
       getElement().callJsFunction("$connector.clearGroups");
     });
   }
  public Set<String> getSelections() {
    return selections;
  }
  /**
   * Returns the data provider of this diagram.
   *
   * @return the data provider of this diagram, not {@code null}
   */
  public DataProvider<Groups, ?> getGroupsDataProvider() {
    return groupsDataProvider;
  }

  /**
   * Returns the data provider of this diagram.
   *
   * @return the data provider of this diagram, not {@code null}
   */
  public DataProvider<Item, ?> getItemsDataProviderDataProvider() {
    return itemsDataProvider;
  }

  public void setGroupsDataProvider(DataProvider<Groups, ?> dataProvider) {
    Objects.requireNonNull(dataProvider, "The dataProvider cannot be null");
    this.groupsDataProvider = dataProvider;
    reset();
    if (groupsDataProviderListenerRegistration != null) {
      groupsDataProviderListenerRegistration.remove();
    }
    groupsDataProviderListenerRegistration = dataProvider.addDataProviderListener(e -> reset());
  }

  public void setItemsDataProvider(DataProvider<Item, ?> dataProvider) {
    Objects.requireNonNull(dataProvider, "The dataProvider cannot be null");
    this.itemsDataProvider = dataProvider;
    reset();
    if (itemsDataProviderListenerRegistration != null) {
      itemsDataProviderListenerRegistration.remove();
    }
    itemsDataProviderListenerRegistration = dataProvider.addDataProviderListener(e -> reset());
  }

  private void reset() {
    final Set<Item> items = itemsDataProvider.fetch(new Query<>()).collect(Collectors.toSet());
    final Set<Groups> groups = groupsDataProvider.fetch(new Query<>()).collect(Collectors.toSet());
    removeAllItems();
    removeAllGroups();
    addItems(items);
    addGroups(groups);
  }

  // ==== Diagram-Methods ====
  public void diagamRedraw() {
    runBeforeClientResponse(ui -> getElement().callJsFunction("$connector.diagram.redraw"));
  }

  public void diagramSetSize(final String width, final String height) {
    this.setWidth(width);
    this.setHeight(height);
    runBeforeClientResponse(
        ui -> getElement().callJsFunction("$connector.diagram.setSize", width, height));
  }

  public void diagramSelectItems(Iterable<String> itemIds) {
    final JsonArray nodeIdArray = StreamSupport.stream(itemIds.spliterator(), false)
        .map(JreJsonString::new).collect(JsonUtils.asArray());
    runBeforeClientResponse(
        ui -> getElement().callJsFunction("$connector.diagram.selectItems", nodeIdArray));
  }


  public void diagramUnselectAll() {
    runBeforeClientResponse(ui -> getElement().callJsFunction("$connector.diagram.unselectAll"));
    selections.clear();
  }

  public void diagramFit() {
    runBeforeClientResponse(ui -> getElement().callJsFunction("$connector.diagram.fit"));
  }

  @Override
  public void setSizeFull() {
    HasSize.super.setSizeFull();
    runBeforeClientResponse(
        ui -> getElement().callJsFunction("$connector.diagram.setSize", getWidth(), getHeight()));
  }

  public void diagamDestroy() {
    runBeforeClientResponse(ui -> getElement().callJsFunction("$connector.diagram.destroy"));
  }

  // ==== Events ====
  private void enableEventDispatching(Class<? extends Event> clazz) {
    runBeforeClientResponse(ui -> {
      if (!enabledEvents.contains(clazz)) {
        enabledEvents.add(clazz);
        getElement().callJsFunction("$connector.enableEventDispatching",
            clazz.getAnnotation(DomEvent.class).value());
      }
    });
  }

  public Registration addClickListener(final ClickListener listener) {
    enableEventDispatching(ClickEvent.class);
    return addListener(ClickEvent.class, listener);
  }

  public Registration addCurrentTimeTickListener(final CurrentTimeTickListener listener) {
    enableEventDispatching(CurrentTimeTickEvent.class);
    return addListener(CurrentTimeTickEvent.class, listener);
  }

  public Registration addContextMenuListener(final ContextMenuListener listener) {
    enableEventDispatching(ContextMenuEvent.class);
    return addListener(ContextMenuEvent.class, listener);
  }

  public Registration addDoubleClickListener(final DoubleClickListener listener) {
    enableEventDispatching(DoubleClickEvent.class);
    return addListener(DoubleClickEvent.class, listener);
  }

  public Registration addDragOverListener(final DragOverListener listener) {
    enableEventDispatching(DragOverEvent.class);
    return addListener(DragOverEvent.class, listener);
  }

  public Registration addDropListener(final DropListener listener) {
    enableEventDispatching(DropEvent.class);
    return addListener(DropEvent.class, listener);
  }
  public Registration addSelectListener(final SelectListener listener) {
    enableEventDispatching(SelectEvent.class);
    return addListener(SelectEvent.class, listener);
  }



  public Registration addChangeListener(final ChangedListener listener) {
    enableEventDispatching(ChangedEvent.class);
    return addListener(ChangedEvent.class, listener);
  }

  private static class TimelineDiagramRegistration implements Registration {
    private boolean isInvoked;

    private final Registration origin;

    private final SerializableConsumer<TimelineDiagramRegistration> callback;

    private TimelineDiagramRegistration(Registration origin,
        SerializableConsumer<TimelineDiagramRegistration> onRemoveCallback) {
      this.origin = origin;
      this.callback = onRemoveCallback;

    }

    @Override
    public void remove() {
      if (isInvoked) {
        return;
      }
      origin.remove();
      callback.accept(this);

      isInvoked = true;
    }

  }

}
