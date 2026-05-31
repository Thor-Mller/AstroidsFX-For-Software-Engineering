package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.BaseLogicSystem;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.components.InputComponent;
import dk.sdu.cbse.playerComponents.PlayerComponent;
import dk.sdu.cbse.common.components.PositionComponent;

public class PlayerShootingSystem extends BaseLogicSystem {

    private float cooldown = 0;
    private final float firerate = 0.7f;

    BulletPlugin bullet = new BulletPlugin();

    @Override
    public void process(IWorld world, double deltaTime){
        for (IEntity entity : world.getEntitiesWithComponent(PlayerComponent.class, PositionComponent.class, InputComponent.class)){

            PositionComponent pos = (PositionComponent) entity.getComponent(PositionComponent.class);
            InputComponent inp = (InputComponent) entity.getComponent(InputComponent.class);

            updateShootingCooldown(deltaTime);

            //System.out.println("found player");

            if (inp != null){
                if (inp.SHOOT && canShoot()){

                    bullet.shoot(world, pos, 24, -10, 0);
                    resetCooldown();
                    //System.out.println("you just shot");
                }

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
