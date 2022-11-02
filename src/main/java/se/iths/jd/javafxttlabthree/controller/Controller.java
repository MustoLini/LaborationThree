package se.iths.jd.javafxttlabthree.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import se.iths.jd.javafxttlabthree.shapes.ShapeType;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;


public class Controller {
    Model modelInitialize;
    @FXML
    private Slider sizeOfBrush;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ChoiceBox<ShapeType> choiceBox;

    ObservableList<ShapeType> shapeTypesList= FXCollections.observableArrayList(ShapeType.values());

    @FXML
    void closeProgram(ActionEvent event) {
        System.exit(1);
    }

    public void initialize() {
        modelInitialize = new Model();
        colorPicker.valueProperty().bindBidirectional(modelInitialize.getcolor());
        sizeOfBrush.valueProperty().bindBidirectional(modelInitialize.sizeProperty());
        choiceBox.setItems(shapeTypesList);


    }

    @FXML
    public void whatShapeYouHavePicked(ActionEvent event) {

        switch (choiceBox.getValue()) {
            case CIRCLE -> {
                modelInitialize.setWhatShapeISSelected(ShapeType.CIRCLE);
            }
            case SQUARE -> {
                modelInitialize.setWhatShapeISSelected(ShapeType.SQUARE);
            }
            case IsSelected -> {
                modelInitialize.setWhatShapeISSelected(ShapeType.IsSelected);
            }
        }
    }

    @FXML
    private void handleCanvasClick(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        if (choiceBox.getValue()==ShapeType.IsSelected){
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