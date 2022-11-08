package se.iths.jd.javafxttlabthree.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import se.iths.jd.javafxttlabthree.Model.Model;
import se.iths.jd.javafxttlabthree.SaveSVG;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.ShapeType;
import se.iths.jd.javafxttlabthree.shapes.shapesMainClass.Shapes;

import javax.imageio.ImageIO;
import java.io.File;


public class Controller {
    Model model;
    ObservableList<ShapeType> shapeTypesList = FXCollections.observableArrayList(ShapeType.values());
    @FXML
    private MenuItem saveImage;
    @FXML
    private Slider sizeOfBrush;
    @FXML
    private Canvas canvas;
    @FXML
    private ColorPicker colorPicker;
    @FXML
    private ChoiceBox<ShapeType> choiceBox;

    @FXML
    void closeProgram(ActionEvent event) {
        System.exit(1);
    }

    public void initialize() {
        model = new Model();
        colorPicker.valueProperty().bindBidirectional(model.getcolor());
        sizeOfBrush.valueProperty().bindBidirectional(model.sizeProperty());
        choiceBox.setItems(shapeTypesList);


    }

    @FXML
    public void whatShapeYouHavePicked(ActionEvent event) {
        switch (choiceBox.getValue()) {
            case CIRCLE -> {
                model.setWhatShapeISSelected(ShapeType.CIRCLE);
            }
            case SQUARE -> {
                model.setWhatShapeISSelected(ShapeType.SQUARE);
            }
            case IsSelected -> {
                model.setWhatShapeISSelected(ShapeType.IsSelected);
            }
        }
    }

    @FXML
    private void handleCanvasClick(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        if (choiceBox.getValue() == ShapeType.IsSelected) {
            for (Shapes shapes : model.getShapes()) {
                if (shapes.isSelected(x, y)) {
                    System.out.println(model.getSelectedShapes());
                    shapes.setBorderColor(Color.MAGENTA);
                    model.getSelectedShapes().add(shapes);
                }
            }
        } else {
            model.addShapes(x, y);
        }
        drawOnExecute();
    }

    @FXML
    void undoLatestThing(ActionEvent event) {
        model.remove();
        drawOnExecute();
    }

    @FXML
    void infoOfProject(ActionEvent event) {
        //TODO Here is where I should make it so the object that is disable,
        // enables and it comes upp info about the project and where you can get my LinkedIn and Github.
    }


    @FXML
    void saveImage() {
        SaveSVG.save(model);

        try {
            Image snapShot = canvas.snapshot(null, null);
            ImageIO.write(SwingFXUtils.fromFXImage(snapShot, null), "png", new File("paint.png"));
        } catch (Exception e) {
            System.out.println("Failed to save " + e);
        }

    }

    @FXML
    void switchColor(MouseEvent event) {
        model.switchColorOnSelected();
        drawOnExecute();
    }

    @FXML
    void switchSize(MouseEvent event) {
        model.switchSize();
        drawOnExecute();
    }

    private void drawOnExecute() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Shapes shape : model.getShapes()) {
            shape.draw(gc);
        }
    }
}