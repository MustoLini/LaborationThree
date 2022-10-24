module se.iths.jd.javafxttlabthree {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens se.iths.jd.javafxttlabthree to javafx.fxml;
    exports se.iths.jd.javafxttlabthree;
    exports se.iths.jd.javafxttlabthree.shapes.shapesMainClass;
    opens se.iths.jd.javafxttlabthree.shapes.shapesMainClass to javafx.fxml;
    exports se.iths.jd.javafxttlabthree.shapes;
    opens se.iths.jd.javafxttlabthree.shapes to javafx.fxml;
}