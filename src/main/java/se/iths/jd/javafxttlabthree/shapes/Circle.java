package se.iths.jd.javafxttlabthree.shapes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

public class Circle extends Shapes {
    private double radius;
    public Circle(double x, double y, Color color) {
        super(x, y, color);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw(GraphicsContext graphicsContext) {

       graphicsContext.setFill(getColor());
       graphicsContext.fillOval(getX()-(getRadius()/2)-2.5,getY()-(getRadius()/2)-2.5,getRadius()+5,getRadius()+5);
       graphicsContext.setFill(getColor());
       graphicsContext.fillOval(getX()-(getRadius()/2), getY()-(getRadius()/2), getRadius(),getRadius());
    }
    // TODO: 10/18/2022 Implement Shapes From Inteface Shapes
}
