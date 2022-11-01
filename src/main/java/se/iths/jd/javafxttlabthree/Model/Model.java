package se.iths.jd.javafxttlabthree.Model;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import se.iths.jd.javafxttlabthree.shapes.Circle;
import se.iths.jd.javafxttlabthree.shapes.Square;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private final ObjectProperty<Color> color;
    private final DoubleProperty size;
    BooleanProperty circleSelected;
    BooleanProperty squareSelected;
    BooleanProperty selectedMode;
    private List<Shapes> shapes;
    private List<Shapes> selectedShapes;

    public Model() {

        shapes = new ArrayList<>();
        selectedShapes = new ArrayList<>();
        color = new SimpleObjectProperty<>(Color.BLACK);
        size = new SimpleDoubleProperty(4.3);
        circleSelected = new SimpleBooleanProperty(false);
        squareSelected = new SimpleBooleanProperty(false);
        selectedMode = new SimpleBooleanProperty(false);
    }

    public List<Shapes> getSelectedShapes() {
        return selectedShapes;
    }

    public void setSelectedShapes(List<Shapes> selectedShapes) {
        this.selectedShapes = selectedShapes;
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

    public void setShapes(List<Shapes> shapes) {
        this.shapes = shapes;
    }

    public Color getColor() {
        return color.get();
    }

    public void setColor(Color color) {
        this.color.set(color);
    }

    public ObjectProperty<Color> colorProperty() {
        return color;
    }

    public double getSize() {
        return size.get();
    }

    public void setSize(double size) {
        this.size.set(size);
    }

    public BooleanProperty circleSelectedProperty() {
        return circleSelected;
    }

    public BooleanProperty squareSelectedProperty() {
        return squareSelected;
    }

    public DoubleProperty sizeProperty() {
        return size;
    }

    public ArrayList<Shapes> remove() {
        shapes.remove(shapes.size() - 1);
        return (ArrayList<Shapes>) shapes;
    }


    public void setSelectedMode(boolean selectedMode) {
        this.selectedMode.set(selectedMode);
    }
}
