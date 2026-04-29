import dk.sdu.cbse.core.RenderSystem;

module dk.sdu.cbse.core {
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;
    requires javafx.controls;
    exports dk.sdu.cbse.core to dk.sdu.cbse.game;
    opens dk.sdu.cbse.core to javafx.graphics;
    provides dk.sdu.cbse.common.IEntitySystem with RenderSystem, dk.sdu.cbse.core.MovementSystem, dk.sdu.cbse.core.InputSystem;
}