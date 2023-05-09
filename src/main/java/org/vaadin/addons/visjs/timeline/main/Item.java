package org.vaadin.addons.visjs.timeline.main;

import org.vaadin.addons.visjs.timeline.options.items.Items;
import org.vaadin.addons.visjs.timeline.options.nodes.Nodes;

public class Item extends Items {

    private String id;

    // @JsonIgnore
    // private transient List<Edge> edgeList = new ArrayList<>();;
    // @JsonIgnore
    // private transient Map<String, Edge> edgeMap = new HashMap<>();;

    public Item() {};

    public Item(final String id) {
        this.id = id;
    }

    public Item(final String id, Items.Builder builder) {
        super(builder);
        this.id = id;
    }

    public Item(String id, String title) {
        this.id = id;
        this.setTitle(title);
    }

    public Item(String id, String title, final Items.Builder builder) {
        super(builder);
        this.id = id;
        this.setTitle(title);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
