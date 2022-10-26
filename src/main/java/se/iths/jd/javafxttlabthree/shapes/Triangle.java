package se.iths.jd.javafxttlabthree.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

import java.awt.event.MouseEvent;

public class Triangle extends Shapes {
    public Triangle(double x, double y, Color color) {
        super(x, y, color);
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

    }

    @Override
    public void isSelected(MouseEvent mouseEvent) {

    }

    // TODO: 10/18/2022 Implement Shapes From Inteface Shapes
}
