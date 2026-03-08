module dk.sdu.cbse.game {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;

    requires dk.sdu.cbse.common;
    requires dk.sdu.cbse.core;

    opens dk.sdu.cbse.game to javafx.fxml;
    exports dk.sdu.cbse.game;
}