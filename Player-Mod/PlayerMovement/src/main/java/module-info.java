import dk.sdu.cbse.playerSystem.PlayerMovementSystem;

module dk.sdu.cbse.playerSystem{
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires PlayerComponents;

    provides dk.sdu.cbse.common.IEntitySystem with PlayerMovementSystem;
}