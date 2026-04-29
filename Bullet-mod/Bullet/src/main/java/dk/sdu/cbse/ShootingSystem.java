package dk.sdu.cbse;

import dk.sdu.cbse.common.BaseLogicSystem;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.components.InputComponent;
import dk.sdu.cbse.common.components.PlayerComponent;
import dk.sdu.cbse.common.components.PositionComponent;

public class ShootingSystem extends BaseLogicSystem {

    BulletPlugin bullet = new BulletPlugin();

    @Override
    public void process(IWorld world){
        for (IEntity entity : world.getEntitiesWithComponent(PlayerComponent.class, PositionComponent.class, InputComponent.class)){

            PositionComponent pos = (PositionComponent) entity.getComponent(PositionComponent.class);
            InputComponent inp = (InputComponent) entity.getComponent(InputComponent.class);

            //System.out.println("found player");

            if (inp != null){
                if (inp.SHOOT){
                    bullet.shoot(world, pos, 0, 0, 0);
                    //System.out.println("you just shot");
                }

            }
        }
    }
}
