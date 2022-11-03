package se.iths.jd.javafxttlabthree;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;
import se.iths.jd.javafxttlabthree.Model.Model;
import se.iths.jd.javafxttlabthree.shapes.Circle;
import se.iths.jd.javafxttlabthree.shapes.Square;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ViewTest {
    Model model= new Model();
    Circle circle= new Circle(10,20, Color.ALICEBLUE,60);
    Square square= new Square(5,5,Color.CHOCOLATE,25);

    @Test
    void addShapeToListAndChecksItsSize() {
        model.shapes.add(circle);
        model.shapes.add(square);
        assertEquals(2,model.shapes.size());
    }

    @Test
    void switchColor() {
        model.shapes.add(circle);
        model.shapes.add(square);
        model.shapes.get(1).setColor(Color.MAGENTA);
        assertEquals(Color.MAGENTA, model.shapes.get(1).getColor());
    }

}