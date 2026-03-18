module dk.sdu.cbse.game {
    uses dk.sdu.cbse.common.IEntitySystem;
    uses dk.sdu.cbse.common.IGamePlugin;
    requires javafx.graphics;
    requires javafx.controls;

    requires dk.sdu.cbse.common;
    requires dk.sdu.cbse.core;

    opens dk.sdu.cbse.game to javafx.graphics;
}