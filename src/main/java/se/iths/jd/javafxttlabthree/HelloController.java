package se.iths.jd.javafxttlabthree;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import se.iths.jd.javafxttlabthree.shapes.Circle;
import se.iths.jd.javafxttlabthree.shapes.Rectangle;
import se.iths.jd.javafxttlabthree.shapes.Triangle;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class HelloController {
    Queue<Shapes> shapes = new ArrayDeque<>();
    @FXML
    private Slider sizeOfBrush;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private RadioButton rectangleButton;
    @FXML
    private RadioButton triangleButton;
    @FXML
    private RadioButton circleButton;

    @FXML
    void closeProgram(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    void makeACircle(ActionEvent event) {
        if (circleButton.isSelected()) {
            shapes.add(new Circle(sizeOfBrush.getValue(), sizeOfBrush.getValue(), colorPicker.getValue()));
        }
    }

    @FXML
    void makeARectangle(ActionEvent event) {
        if (rectangleButton.isSelected()) {
            shapes.add(new Rectangle(sizeOfBrush.getValue(), sizeOfBrush.getValue(), colorPicker.getValue()));
        }
    }

    @FXML
    void makeATriangle(ActionEvent event) {
        if (triangleButton.isSelected()) {
            shapes.add(new Triangle(sizeOfBrush.getValue(), sizeOfBrush.getValue(),colorPicker.getValue()));
        }
    }


    @FXML
    void undoLatestThing(ActionEvent event) {
        //TODO Checks what is in latest in stack and removes it, does it from another class.
        // Make classes for Stacking Objects for example Circle,Rectangle and Triangle

    }

    @FXML
    void infoOfProject(ActionEvent event) {
        //TODO Here is where I should make it so the object that is disable,
        // enables and it comes upp info about the project and where you can get my LinkedIn and Github.
    }

    @FXML
    void onDrawing(MouseEvent event) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setLineWidth(sizeOfBrush.getValue());
        canvas.setOnMousePressed(mouseEvent -> gc.beginPath());
        canvas.setOnMouseDragged(mouseEvent -> {
            gc.lineTo(mouseEvent.getX(), mouseEvent.getY());
            gc.stroke();
        });

    }


}