package se.iths.jd.javafxttlabthree;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class HelloController {


    @FXML
    void closeProgram(ActionEvent event) {
        System.exit(1);
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



}