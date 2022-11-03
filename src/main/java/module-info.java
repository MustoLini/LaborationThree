module se.iths.jd.javafxttlabthree {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens se.iths.jd.javafxttlabthree to javafx.fxml;
    exports se.iths.jd.javafxttlabthree;
    exports se.iths.jd.javafxttlabthree.shapes.shapesMainClass;
    opens se.iths.jd.javafxttlabthree.shapes.shapesMainClass to javafx.fxml;
    exports se.iths.jd.javafxttlabthree.shapes;
    opens se.iths.jd.javafxttlabthree.shapes to javafx.fxml;
    exports se.iths.jd.javafxttlabthree.Model;
    opens se.iths.jd.javafxttlabthree.Model to javafx.fxml;
    exports se.iths.jd.javafxttlabthree.controller;
    opens se.iths.jd.javafxttlabthree.controller to javafx.fxml;
}