package se.iths.jd.javafxttlabthree.controller_folder;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import se.iths.jd.javafxttlabthree.Model.Model;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;


public class Controller {
    @FXML
    private Slider sizeOfBrush;
    @FXML
    private Canvas canvas;
    String[]shapeChoices= new String[]{"Draw Normal","Make a Circle", "Make a Rectangle", "Eraser"};
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ChoiceBox<String> whatShapeToPick;
    Model modelInitialize;


    @FXML
    void closeProgram(ActionEvent event) {
        System.exit(1);
    }

    public void initialize() {
        modelInitialize = new Model();
        colorPicker.valueProperty().bindBidirectional(modelInitialize.getcolor());
        sizeOfBrush.valueProperty().bindBidirectional(modelInitialize.sizeProperty());
        whatShapeToPick.getItems().addAll(shapeChoices);
    }
    @FXML
    public void whatShapeYouHavePicked(ActionEvent event){
        String value = whatShapeToPick.getValue();
        if ("Draw Normal".equals(value)) {
            drawNormal();
        } else if ("Make a Circle".equals(value)) {
            modelInitialize.circleISSelected(true);
        }  else if ("Make a Rectangle".equals(value)) {
            modelInitialize.rectangleISSSelected(true);
        }else if ("Eraser".equals(value)){
            eraser();
        }
    }
    @FXML
    private void handleCanvasClick(MouseEvent event){
        double x = event.getX();
        double y = event.getY();
        modelInitialize.addShapes(x,y);
        executeDraw();
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


    private void executeDraw(){
        GraphicsContext gc= canvas.getGraphicsContext2D();
        gc.clearRect(0,0,canvas.getWidth(),canvas.getHeight());

        for (Shapes shape: modelInitialize.getShapes()){
            shape.draw(gc);
        }
    }



}