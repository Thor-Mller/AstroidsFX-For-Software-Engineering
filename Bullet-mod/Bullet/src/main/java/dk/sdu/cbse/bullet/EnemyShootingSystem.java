package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.BaseLogicSystem;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.components.PositionComponent;
import dk.sdu.cbse.enemyComponent.EnemyComponent;

public class EnemyShootingSystem extends BaseLogicSystem {

    private float cooldown = 0;
    private final float firerate = 1.5f;

    EnemyBulletPlugin bullet = new EnemyBulletPlugin();

    @Override
    public void process(IWorld world, double deltaTime){
        for (IEntity entity : world.getEntitiesWithComponent(EnemyComponent.class, PositionComponent.class)){

            PositionComponent pos = (PositionComponent) entity.getComponent(PositionComponent.class);

            updateShootingCooldown(deltaTime);

            //System.out.println("found player");

            if (canShoot()){
                bullet.shoot(world, pos, 15, 30, 0);
                resetCooldown();
            }


        }
    }

    public void updateShootingCooldown(double deltaTime){
        cooldown -= (float) deltaTime;
    }

    public boolean canShoot(){
        return (cooldown <= 0);
    }

    public void resetCooldown(){
        cooldown = firerate;
    }
}
