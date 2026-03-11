module dk.sdu.cbse.core {
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.controls;
    exports dk.sdu.cbse.core to dk.sdu.cbse.game;
}