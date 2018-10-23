package Shapes.Abstract_classes;


import Shapes.Circle;
import Shapes.Line;
import Shapes.Rectangle;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY
        )
@JsonSubTypes({
        @JsonSubTypes.Type(value = Line.class, name = "Shapes.Line"),
        @JsonSubTypes.Type(value = Circle.class, name = "Shapes.Circle"),
        @JsonSubTypes.Type(value = Rectangle.class, name = "Shapes.Rectangle")
})
public abstract class Shape {

    public abstract void color(String color);
}
