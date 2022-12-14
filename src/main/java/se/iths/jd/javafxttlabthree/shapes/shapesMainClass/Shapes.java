package se.iths.jd.javafxttlabthree.shapes.shapesMainClass;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Shapes {
    private double x;
    private double y;
    private Color color;
    private Color borderColor;

    public Shapes(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.borderColor = Color.TRANSPARENT;
    }



    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public abstract void draw(GraphicsContext graphicsContext);

    public abstract boolean isSelected(double x, double y);

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract String toSVG();
}
