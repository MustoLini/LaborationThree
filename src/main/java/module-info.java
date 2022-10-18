module se.iths.jd.javafxttlabthree {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.iths.jd.javafxttlabthree to javafx.fxml;
    exports se.iths.jd.javafxttlabthree;
}