package se.iths.jd.javafxttlabthree.Model;

import javafx.beans.property.*;
import javafx.scene.paint.Color;
import se.iths.jd.javafxttlabthree.shapes.Circle;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.ShapeType;
import se.iths.jd.javafxttlabthree.shapes.Square;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

import java.util.ArrayList;
import java.util.List;

import static se.iths.jd.javafxttlabthree.shapes.shapesMainClass.ShapeType.CIRCLE;
import static se.iths.jd.javafxttlabthree.shapes.shapesMainClass.ShapeType.SQUARE;

public class Model {

    ObjectProperty<Color> color;
    DoubleProperty size;
    public List<Shapes> shapes;
    public List<Shapes> selectedShapes;
    ShapeType whatShapeISSelected;

    public Model() {

        shapes = new ArrayList<>();
        selectedShapes = new ArrayList<>();
        color = new SimpleObjectProperty<>(Color.BLACK);
        size = new SimpleDoubleProperty(4.3);
        whatShapeISSelected= CIRCLE;

    }

    public List<Shapes> getSelectedShapes() {
        return selectedShapes;
    }


    public void addShapes(double x, double y) {
        if (getWhatShapeISSelected().equals(SQUARE)) {
            shapes.add(new Square(x, y, color.getValue(), size.getValue()));

        }
        if (getWhatShapeISSelected().equals(CIRCLE)) {
            shapes.add(new Circle(x, y, color.getValue(), size.getValue()));
        }
    }

    public ObjectProperty<Color> getcolor() {
        return color;
    }

    public List<Shapes> getShapes() {
        return shapes;
    }

    public void setWhatShapeISSelected(ShapeType shapeType){

        this.whatShapeISSelected= shapeType;

    }

    public ShapeType getWhatShapeISSelected() {
        return whatShapeISSelected;
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


    public DoubleProperty sizeProperty() {
        return size;
    }

    public void remove() {
        shapes.remove(shapes.size() - 1);
    }
    public void switchColorOnSelected(){
        for (Shapes shapes : selectedShapes){
            shapes.setColor(getColor());
        }
    }

}
