import dk.sdu.cbse.enemy.EnemyPlugin;
import dk.sdu.cbse.enemy.EnemySystem;

module Enemy {
    requires dk.sdu.cbse.common;
    requires java.desktop;
    requires javafx.graphics;
    requires EnemyComponent;
    requires ColliderComponent;
    requires spring.context;
    requires spring.beans;
    requires spring.core;

    opens assets.enemy;
    exports dk.sdu.cbse.enemy to dk.sdu.cbse.game;

    provides dk.sdu.cbse.common.IGamePlugin with EnemyPlugin;
    provides dk.sdu.cbse.common.IEntitySystem with EnemySystem;

}