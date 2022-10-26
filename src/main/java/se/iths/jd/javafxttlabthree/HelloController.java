package se.iths.jd.javafxttlabthree;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import se.iths.jd.javafxttlabthree.shapes.Circle;
import se.iths.jd.javafxttlabthree.shapes.Rectangle;
import se.iths.jd.javafxttlabthree.shapes.Triangle;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


public class HelloController {
    List<Shapes> shapes = new ArrayList<>();
    @FXML
    private Slider sizeOfBrush;
    @FXML
    private Canvas canvas;
    String[]shapeChoices= new String[]{"Draw Normal","Make a Circle", "Make a Rectangle", "Make a Triangle", "Eraser"};
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ChoiceBox<String> whatShapeToPick;



    @FXML
    void closeProgram(ActionEvent event) {
        System.exit(1);
    }
    @FXML
    public void initialize() {
        whatShapeToPick.getItems().addAll(shapeChoices);
    }
    @FXML
    public void whatShapeYouHavePicked(ActionEvent event){
        String value = whatShapeToPick.getValue();
        if ("Draw Normal".equals(value)) {
            drawNormal();
        } else if ("Make a Circle".equals(value)) {
            makeACircle();
        } else if ("Make a Triangle".equals(value)) {
            makeATriangle();
        } else if ("Make a Rectangle".equals(value)) {
            makeARectangle();
        }else if ("Eraser".equals(value)){
            eraser();
        }
    }


    void drawNormal() {


            GraphicsContext gc = canvas.getGraphicsContext2D();
            canvas.setOnMouseDragged(mouseEvent -> {
                double size = sizeOfBrush.getValue();
                double x = mouseEvent.getX() - size / 2;
                double y = mouseEvent.getY() - size / 2;
                gc.setFill(colorPicker.getValue());
                gc.fillRect(x, y, size, size);

            });

    }
    void eraser(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(mouseEvent -> {
            double size = sizeOfBrush.getValue();
            double x = mouseEvent.getX() - size / 2;
            double y = mouseEvent.getY() - size / 2;

            gc.clearRect(x,y,size,size);
        });
    }



    void makeACircle() {

            GraphicsContext gc = canvas.getGraphicsContext2D();
            canvas.setOnMousePressed(mouseEvent -> {
                double size = sizeOfBrush.getValue();
                Circle circle = new Circle(size, size, colorPicker.getValue());
                circle.draw(gc);

            });

    }


    void makeARectangle() {

        shapes.add(new Rectangle(sizeOfBrush.getValue(), sizeOfBrush.getValue(), colorPicker.getValue()));

    }


    void makeATriangle() {
        shapes.add(new Triangle(sizeOfBrush.getValue(), sizeOfBrush.getValue(), colorPicker.getValue()));
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