module dk.sdu.cbse.playermod {
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;

    opens assets;

    provides dk.sdu.cbse.common.IGamePlugin with dk.sdu.cbse.playermod.PlayerPlugin;
}