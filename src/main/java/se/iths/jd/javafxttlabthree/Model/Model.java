package se.iths.jd.javafxttlabthree.Model;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import se.iths.jd.javafxttlabthree.shapes.Circle;
import se.iths.jd.javafxttlabthree.shapes.Square;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private final List<Shapes> shapes;
    private final ObjectProperty<Color> color;
    private final DoubleProperty size;
    BooleanProperty circleSelected;
    BooleanProperty squareSelected;

    public Model() {

        shapes = new ArrayList<>();
        color = new SimpleObjectProperty<>(Color.BLACK);
        size = new SimpleDoubleProperty(4.3);
        circleSelected = new SimpleBooleanProperty(false);
        squareSelected = new SimpleBooleanProperty(false);

    }

    public boolean isCircleSelected() {
        return circleSelected.get();
    }

    public void setCircleSelected(boolean circleSelected) {
        this.circleSelected.set(circleSelected);
    }

    public boolean isSquareSelected() {
        return squareSelected.get();
    }

    public void setSquareSelected(boolean squareSelected) {
        this.squareSelected.set(squareSelected);
    }

    public void addShapes(double x, double y) {
        if (isSquareSelected()) {
            shapes.add(new Square(x, y, color.getValue(), size.getValue()));

        }
        if (isCircleSelected()) {
            shapes.add(new Circle(x, y, color.getValue(), size.getValue()));
        }
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
