import dk.sdu.cbse.bullet.BulletPlugin;
import dk.sdu.cbse.bullet.ShootingSystem;

module dk.sdu.cbse.bullet {
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;
    requires dk.sdu.cbse.bulletcomponent;
    requires ColliderComponent;

    exports dk.sdu.cbse.bullet to dk.sdu.cbse.game;
    opens assest.bullet;

    provides dk.sdu.cbse.common.IGamePlugin with BulletPlugin;
    provides dk.sdu.cbse.common.IEntitySystem with ShootingSystem;
}