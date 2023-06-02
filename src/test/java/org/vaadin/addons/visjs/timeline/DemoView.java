package org.vaadin.addons.visjs.timeline;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

import org.vaadin.addons.visjs.timeline.options.groups.Groups;
import org.vaadin.addons.visjs.timeline.main.Item;
import org.vaadin.addons.visjs.timeline.options.Options;

@SuppressWarnings("serial")
@Route("")
public class DemoView extends VerticalLayout {

  public DemoView() {
    setMargin(true);
    setPadding(true);
    setSpacing(true);
    // setWidth("400px");

    final org.vaadin.addons.visjs.timeline.main.TimelineDiagram nd =
        new org.vaadin.addons.visjs.timeline.main.TimelineDiagram(Options.builder().withWidth("600px").withHeight("400px").build());

    final List<Item> items = new LinkedList<>();
    AtomicInteger idCounter = new AtomicInteger();
    for (int i=1 ; i <= 5 ; i++)
    {
      int nodeId = idCounter.incrementAndGet();
      items.add(new Item(nodeId+"", "Items "+nodeId));
    }
    final ListDataProvider<Item> dataProvider = new ListDataProvider<>(items);
    nd.setItemsDataProvider(dataProvider);

    //final Registration registrationSelect = nd.addSelectNodeListener(
    //        ls -> Notification.show("NodeId selected " + ls.getParams().getArray("nodes").toJson()));
    //final Registration registrationDeselect =  nd.addDeselectNodeListener(
    //        ls -> Notification.show("NodeId deselected " + ls.getParams().getObject("previousSelection").getArray("nodes").toJson()));
    add(nd);
    add(new HorizontalLayout(new Button("Add Node", e -> {
      final String id = (idCounter.incrementAndGet())+"";
     // items.add(new Node(id, "Node "+id));
      dataProvider.refreshAll();
    }), new Button("remove all Nodes", e -> {
      items.clear();
      dataProvider.refreshAll();
    //  registrationSelect.remove();
    //  registrationDeselect.remove();
    }), new Button("fit", e -> {
      nd.diagramFit();
    }), new Button("selectNode", e -> {
     // nd.diagramSelectNodes(Arrays.asList(new String[] {"1", "2"}));
    }), new Button("unselectAll", e -> {
      //nd.diagramUnselectAll();;
    })));
    setSizeFull();
  }

}
