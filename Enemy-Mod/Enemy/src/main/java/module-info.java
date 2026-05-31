module Enemy {
    requires ColliderComponent;
    requires dk.sdu.cbse.common;
    requires javafx.graphics;
    requires EnemyComponent;

    provides dk.sdu.cbse.common.IGamePlugin with dk.sdu.cbse.enemy.EnemyPlugin;
    provides dk.sdu.cbse.common.IEntitySystem with dk.sdu.cbse.enemy.EnemySystem;
}