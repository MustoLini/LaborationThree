package se.iths.jd.javafxttlabthree;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private Button button1;
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    void labelClicked(MouseEvent mouseEventevent) {
        if (mouseEventevent.isControlDown()){
            welcomeText.setBackground(Background.fill(Color.RED));
        }
    }



}