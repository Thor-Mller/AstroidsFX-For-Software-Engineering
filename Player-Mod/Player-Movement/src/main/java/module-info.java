module dk.sdu.cbse.playermovement{
    requires dk.sdu.cbse.common;
    requires java.desktop;

    provides dk.sdu.cbse.common.IEntitySystem with PlayerMovementSystem;
}