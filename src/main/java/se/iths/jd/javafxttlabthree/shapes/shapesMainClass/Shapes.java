package se.iths.jd.javafxttlabthree.shapes.shapesMainClass;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;

public abstract class Shapes {
    //TODO Make Abstract where Circle, Rectangle, Triangle should implement.
    private double x;
    private double y;

    public Shapes(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public abstract void draw(GraphicsContext graphicsContext);

}
