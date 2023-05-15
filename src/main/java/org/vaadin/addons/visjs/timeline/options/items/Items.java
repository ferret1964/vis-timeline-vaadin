package org.vaadin.addons.visjs.timeline.options.items;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.annotation.Nonnull;
import java.time.LocalDateTime;

@JsonDeserialize(builder = Items.Builder.class)
public class Items
{

    private String className;
    private String align;
    private String content;
    // End needs special handling for object versus string
    private LocalDateTime end;
    private Object group;
    private String id;
    private Boolean selectable;
    // Start needs special handling for object versus string
    private LocalDateTime start;
    private String style;
    private String subgroup;
    private String title;
    private String type;
    private Boolean limitSize;
    private Editable editable;

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Object getGroup() {
        return group;
    }

    public void setGroup(Object group) {
        this.group = group;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getSelectable() {
        return selectable;
    }

    public void setSelectable(Boolean selectable) {
        this.selectable = selectable;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getLimitSize() {
        return limitSize;
    }

    public void setLimitSize(Boolean limitSize) {
        this.limitSize = limitSize;
    }

    public Editable getEdiable() {
        return editable;
    }

    public void setEdiable(Editable editable) {
        this.editable = editable;
    }


    protected Items(Items.Builder builder) {
        this.className = builder.className;
        this.align = builder.align;
        this.content = builder.content;
        this.end = builder.end;
        this.group = builder.group;
        this.id = builder.id;
        this.selectable = builder.selectable;
        this.start = builder.start;
        this.style = builder.style;
        this.subgroup = builder.subgroup;
        this.title = builder.title;
        this.type = builder.type;
        this.limitSize = builder.limitSize;
        this.editable = builder.editable;
    }

    public Items() {}

    public String getAlign() {
        return align;
    }

    public String getClassName() {
        return className;
    }

    public String getContent() {
        return content;
    }


    public String getTitle() {
        return title;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(final String title) {
        this.title = title;
    }


    /**
     * Creates builder to build {@link Items}.
     *
     * @return created builder
     */
    public static Items.Builder builder() {
        return new Items.Builder();
    }

    /**
     * Builder to build {@link Items}.
     */
    public static class Builder {
        private String className;
        private String align;
        private String content;
        // End needs special handling for object versus string
        private LocalDateTime end;
        private Object group;
        private String id;
        private Boolean selectable;
        // Start needs special handling for object versus string
        private LocalDateTime start;
        private String style;
        private String subgroup;
        private String title;
        private String type;
        private Boolean limitSize;
        private Editable editable;

        protected Builder() {}

        /* TODO: Implement fluant operations
        @Nonnull
        public Items.Builder withBorderWidth(Integer borderWidth) {
            this.borderWidth = borderWidth;
            return this;
        }

        @Nonnull
        public Items.Builder withBorderWidthSelected(Integer borderWidthSelected) {
            this.borderWidthSelected = borderWidthSelected;
            return this;
        }

        @Nonnull
        public Items.Builder withChosen(Boolean chosen) {
            this.chosen = chosen;
            return this;
        }

        @Nonnull
        public Items.Builder withColor(NodeColor color) {
            this.color = color;
            return this;
        }

        @Nonnull
        public Items.Builder withColorStr(String colorStr) {
            this.colorStr = colorStr;
            return this;
        }

        @Nonnull
        public Items.Builder withFixed(Fixed fixed) {
            this.fixed = fixed;
            return this;
        }

        @Nonnull
        public Items.Builder withFont(Font font) {
            this.font = font;
            return this;
        }

        @Nonnull
        public Items.Builder withGroup(String group) {
            this.group = group;
            return this;
        }

        @Nonnull
        public Items.Builder withLabel(String label) {
            this.label = label;
            return this;
        }

        @Nonnull
        public Items.Builder withHeightConstraint(Boolean heightConstraint) {
            this.heightConstraint = heightConstraint;
            return this;
        }

        @Nonnull
        public Items.Builder withHidden(Boolean hidden) {
            this.hidden = hidden;
            return this;
        }

        @Nonnull
        public Items.Builder withIcon(Icon icon) {
            this.icon = icon;
            return this;
        }

        @Nonnull
        public Items.Builder withImage(String image) {
            this.image = image;
            return this;
        }

        @Nonnull
        public Items.Builder withBrokenImage(String brokenImage) {
            this.brokenImage = brokenImage;
            return this;
        }

        @Nonnull
        public Items.Builder withLabelHighlightBold(Boolean labelHighlightBold) {
            this.labelHighlightBold = labelHighlightBold;
            return this;
        }

        @Nonnull
        public Items.Builder withLevel(Integer level) {
            this.level = level;
            return this;
        }

        @Nonnull
        public Items.Builder withMass(Integer mass) {
            this.mass = mass;
            return this;
        }

        @Nonnull
        public Items.Builder withPhysics(Boolean physics) {
            this.physics = physics;
            return this;
        }

        @Nonnull
        public Items.Builder withScaling(Scaling scaling) {
            this.scaling = scaling;
            return this;
        }

        @Nonnull
        public Items.Builder withShadow(Shadow shadow) {
            this.shadow = shadow;
            return this;
        }

        @Nonnull
        public Items.Builder withShape(Shape shape) {
            this.shape = shape;
            return this;
        }

        @Nonnull
        public Items.Builder withShapeProperties(ShapeProperties shapeProperties) {
            this.shapeProperties = shapeProperties;
            return this;
        }

        @Nonnull
        public Items.Builder withSize(Integer size) {
            this.size = size;
            return this;
        }

        @Nonnull
        public Items.Builder withTitle(String title) {
            this.title = title;
            return this;
        }

        @Nonnull
        public Items.Builder withValue(String value) {
            this.value = value;
            return this;
        }

        @Nonnull
        public Items.Builder withWidthConstraint(WidthConstraint widthConstraint) {
            this.widthConstraint = widthConstraint;
            return this;
        }

        @Nonnull
        public Items.Builder withx(Integer x) {
            this.x = x;
            return this;
        }

        @Nonnull
        public Items.Builder withy(Integer y) {
            this.y = y;
            return this;
        }
        */
        @Nonnull
        public Items build() {
            return new Items(this);
        }
    }

}
