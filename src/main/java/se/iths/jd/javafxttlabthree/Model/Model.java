package se.iths.jd.javafxttlabthree.Model;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;
import se.iths.jd.javafxttlabthree.shapes.Circle;
import se.iths.jd.javafxttlabthree.shapes.Rectangle;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

import java.util.ArrayList;
import java.util.List;

public class Model {

    List<Shapes> shapes;
    ObjectProperty<Color> color;
    DoubleProperty size;

    public Model() {

        shapes = new ArrayList<>();
        color = new SimpleObjectProperty<>(Color.BLACK);
        size = new SimpleDoubleProperty(4.3);
    }


    public void addShapes(double x, double y) {
        if (rectangleISSSelected(true)) {
            shapes.add(new Rectangle(x, y, color.getValue()));
        }
        if (circleISSelected(true)) {
            shapes.add(new Circle(x, y, color.getValue(), size.getValue()));
        }
    }

    public boolean rectangleISSSelected(boolean isSelected) {
        if (isSelected == true) {
            return true;
        }
        return false;
    }

    public boolean circleISSelected(boolean isSelected) {
        if (isSelected == true) {
            return true;
        }

        return false;

    }

    public ObjectProperty<Color> getcolor() {
        return color;
    }

    public List<Shapes> getShapes() {
        return shapes;
    }

    public DoubleProperty sizeProperty() {
        return size;
    }
}
