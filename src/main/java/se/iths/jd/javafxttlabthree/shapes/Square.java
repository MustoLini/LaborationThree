package se.iths.jd.javafxttlabthree.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

public class Square extends Shapes {
    private double radius;

    public Square(double x, double y, Color color, double radius) {
        super(x, y, color);
        this.radius = radius;
    }


    @Override
    public void draw(GraphicsContext graphicsContext) {
        graphicsContext.setFill(getBorderColor());
        graphicsContext.fillRect(getX() - (radius / 2) - 2.5, getY() - (radius / 2) - 2.5, radius + 5, radius + 5);
        graphicsContext.setFill(getColor());
        graphicsContext.fillRect(getX() - (radius / 2), getY() - (radius / 2), radius, radius);
        System.out.println(this);

    }

    @Override
    public boolean isSelected(double x, double y) {
        double leftX = getX() - getRadius() / 2;
        double topY = getY() - getRadius() / 2;


        return x >= leftX &&
                x <= leftX + radius &&
                y >= topY &&
                y <= topY + radius;


    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toSVG() {
        String color = "#" + getColor().toString().substring(2, 10);
        return "<rect x=\"" + getX() + "\" y=\"" + getY() + "\" width=\"" + radius + "\" height=\"" + radius + "\" fill=\"" + color + "\" />";
    }
    // TODO: 10/18/2022 Implement Shapes From Inteface Shapes
}
