module dk.sdu.cbse{
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;

    opens assets.player;

    provides dk.sdu.cbse.common.IGamePlugin with dk.sdu.cbse.playermod.PlayerPlugin;
}