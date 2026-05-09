import dk.sdu.cbse.playerSystem.PlayerMovementSystem;

module dk.sdu.cbse.playerSystem{
    requires dk.sdu.cbse.common;
    requires java.desktop;

    provides dk.sdu.cbse.common.IEntitySystem with PlayerMovementSystem;
}