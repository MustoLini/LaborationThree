package se.iths.jd.javafxttlabthree.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

public class Circle extends Shapes {
    private double radius;

    public Circle(double x, double y, Color color, double radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

        graphicsContext.setFill(getBorderColor());
        graphicsContext.fillOval(getX() - (getRadius() / 2) - 2.5, getY() - (getRadius() / 2) - 2.5, getRadius() + 5, getRadius() + 5);
        graphicsContext.setFill(getColor());
        graphicsContext.fillOval(getX() - (getRadius() / 2), getY() - (getRadius() / 2), getRadius(), getRadius());
    }

    @Override
    public boolean isSelected(double x, double y) {
        double areaX= x- getX();
        double areaY= y- getY();
        double distance= Math.sqrt((areaX*areaX)+ (areaY*areaY));
        return distance<= getRadius();
    }
    // TODO: 10/18/2022 Implement Shapes From Inteface Shapes
}
