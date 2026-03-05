module Core {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.sdu.cbse.core to javafx.fxml;
    exports dk.sdu.cbse.core;
}