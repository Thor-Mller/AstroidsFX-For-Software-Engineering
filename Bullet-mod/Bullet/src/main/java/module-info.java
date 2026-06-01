import dk.sdu.cbse.bullet.EnemyBulletPlugin;
import dk.sdu.cbse.bullet.EnemyShootingSystem;
import dk.sdu.cbse.bullet.PlayerBulletPlugin;
import dk.sdu.cbse.bullet.PlayerShootingSystem;

module dk.sdu.cbse.bullet {
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;
    requires dk.sdu.cbse.bulletcomponent;
    requires ColliderComponent;
    requires PlayerComponents;
    requires EnemyComponent;
    requires EnemyBulletComponent;

    exports dk.sdu.cbse.bullet to dk.sdu.cbse.game;
    opens assest.bullet;

    provides dk.sdu.cbse.common.IGamePlugin with PlayerBulletPlugin, EnemyBulletPlugin;
    provides dk.sdu.cbse.common.IEntitySystem with PlayerShootingSystem, EnemyShootingSystem;
}