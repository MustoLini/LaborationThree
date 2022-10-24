package se.iths.jd.javafxttlabthree;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleGroup;
import se.iths.jd.javafxttlabthree.shapes.Circle;
import se.iths.jd.javafxttlabthree.shapes.Rectangle;
import se.iths.jd.javafxttlabthree.shapes.Triangle;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

import java.util.ArrayDeque;
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
    private ToggleGroup shapesGroupButton;
    @FXML
    private RadioButton eraser;
    @FXML
    private RadioButton line;

    @FXML
    void closeProgram(ActionEvent event) {
        System.exit(1);
    }

    public void initialize() {

        makeACircle();
        makeLines();

    }

    void makeLines() {

        if (line.isSelected()) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            canvas.setOnMouseDragged(mouseEvent -> {
                double size = sizeOfBrush.getValue();
                double x = mouseEvent.getX() - size / 2;
                double y = mouseEvent.getY() - size / 2;

                if (eraser.isSelected()) {
                    gc.clearRect(x, y, size, size);
                } else {
                    gc.setFill(colorPicker.getValue());
                    gc.fillRect(x, y, size, size);
                }

            });
        }
    }


    void makeACircle() {

        if (circleButton.isSelected()) {
            GraphicsContext gc = canvas.getGraphicsContext2D();
            canvas.setOnMousePressed(mouseEvent -> {
                double size = sizeOfBrush.getValue();
                double x = mouseEvent.getX() - size / 2;
                double y = mouseEvent.getY() - size / 2;
                Circle circle = new Circle(size, size, colorPicker.getValue());
                gc.fillRect(x, y, size, size);
                circle.draw(gc);

            });
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
            shapes.add(new Triangle(sizeOfBrush.getValue(), sizeOfBrush.getValue(), colorPicker.getValue()));
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
    void saveImage(ActionEvent event) {


    }


}