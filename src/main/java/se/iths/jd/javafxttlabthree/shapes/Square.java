package se.iths.jd.javafxttlabthree.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

public class Square extends Shapes {
    double radius;

    public Square(double x, double y, Color color, double radius) {
        super(x, y, color);
        this.radius = radius;
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(getColor());
        graphicsContext.fillRect(getX() - (radius / 2) - 2.5, getY() - (radius / 2) - 2.5, radius + 5, radius + 5);
        graphicsContext.setFill(getColor());
        graphicsContext.fillRect(getX() - (radius / 2), getY() - (radius / 2) - 2.5, radius, radius);


    }

    @Override
    public boolean isSelected() {
        return true;
    }
    // TODO: 10/18/2022 Implement Shapes From Inteface Shapes
}
