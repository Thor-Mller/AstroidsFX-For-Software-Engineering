import dk.sdu.cbse.player.PlayerPlugin;

module dk.sdu.cbse{
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;
    requires PlayerComponents;
    requires ColliderComponent;

    opens assets.player;

    provides dk.sdu.cbse.common.IGamePlugin with PlayerPlugin;
}