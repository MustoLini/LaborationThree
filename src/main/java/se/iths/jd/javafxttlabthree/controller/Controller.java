package se.iths.jd.javafxttlabthree.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import se.iths.jd.javafxttlabthree.Model.Model;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;


public class Controller {
    String[] shapeChoices = new String[]{"Make a Circle", "Make a Square", "IsSelected"};
    Model modelInitialize;
    @FXML
    private Slider sizeOfBrush;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ChoiceBox<String> whatShapeToPick;


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
    public void whatShapeYouHavePicked(ActionEvent event) {
        String value = whatShapeToPick.getValue();
        if ("Make a Circle".equals(value)) {
            modelInitialize.setCircleSelected(true);
            modelInitialize.setSquareSelected(false);
            modelInitialize.setSelectedMode(false);
        } else if ("Make a Square".equals(value)) {
            modelInitialize.setSquareSelected(true);
            modelInitialize.setCircleSelected(false);
            modelInitialize.setSelectedMode(false);
        } else if ("IsSelected".equals(value)) {
            modelInitialize.setSelectedMode(true);
            modelInitialize.setCircleSelected(false);
            modelInitialize.setSquareSelected(false);
        }
    }

    @FXML
    private void handleCanvasClick(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        String value = whatShapeToPick.getValue();
        if ("IsSelected".equals(value)){
            for (Shapes shapes: modelInitialize.getShapes()) {
                if (shapes.isSelected( x,  y)){
                    shapes.setBorderColor(Color.MAGENTA);
                    modelInitialize.getSelectedShapes().add(shapes);
                }
            }
        }
        else {
            modelInitialize.addShapes(x, y);
        }

        drawOnExecute();
    }



    @FXML
    void undoLatestThing(ActionEvent event) {
        modelInitialize.remove();
        drawOnExecute();
    }

    @FXML
    void infoOfProject(ActionEvent event) {
        //TODO Here is where I should make it so the object that is disable,
        // enables and it comes upp info about the project and where you can get my LinkedIn and Github.
    }


    @FXML
    void saveImage(ActionEvent event) {


    }


    private void drawOnExecute() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shapes shape : modelInitialize.getShapes()) {
            shape.draw(gc);
        }
    }


}