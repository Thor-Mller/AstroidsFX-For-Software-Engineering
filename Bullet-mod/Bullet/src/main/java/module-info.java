module dk.sdu.cbse.bullet {
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;

    exports dk.sdu.cbse to dk.sdu.cbse.game;
    opens assest.bullet;

    provides dk.sdu.cbse.common.IGamePlugin with dk.sdu.cbse.BulletPlugin;
    provides dk.sdu.cbse.common.IEntitySystem with dk.sdu.cbse.ShootingSystem;
}