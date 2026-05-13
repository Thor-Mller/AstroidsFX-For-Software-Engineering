module dk.sdu.cbse{
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;
    requires spring.context;
    requires spring.beans;
    requires spring.core;

    opens assets.player;

    provides dk.sdu.cbse.common.IGamePlugin with dk.sdu.cbse.playermod.PlayerPlugin;
}