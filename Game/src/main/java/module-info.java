module dk.sdu.cbse.game {
    uses dk.sdu.cbse.common.IEntitySystem;
    uses dk.sdu.cbse.common.IGamePlugin;
    requires javafx.graphics;
    requires javafx.controls;
    requires spring.context;
    requires spring.beans;
    requires spring.core;

    requires dk.sdu.cbse.common;
    requires dk.sdu.cbse.core;

    opens dk.sdu.cbse.game to spring.core, spring.beans, spring.context, javafx.graphics;
}