package se.iths.jd.javafxttlabthree.shapes.shapesMainClass;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public abstract class Shapes {
    //TODO Make Abstract where Circle, Rectangle, Triangle should implement.
    private double x;
    private double y;
    private Color color;

    public Shapes(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color= color;
    }
    public abstract void draw(GraphicsContext graphicsContext);

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
}
