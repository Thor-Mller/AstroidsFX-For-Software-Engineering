package dk.sdu.cbse.playerSystem;

import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.BaseLogicSystem;
import dk.sdu.cbse.common.components.PlayerComponent;
import dk.sdu.cbse.common.components.PositionComponent;
import dk.sdu.cbse.common.components.VelocityComponent;
import dk.sdu.cbse.common.components.InputComponent;

public class PlayerMovementSystem extends BaseLogicSystem {

    private double movementSpeed = 2;

    @Override
    public void process(IWorld world, double deltaTime) {
        for (IEntity entity : world.getEntitiesWithComponent(PositionComponent.class, VelocityComponent.class, PlayerComponent.class, InputComponent.class)) {

            VelocityComponent vel = (VelocityComponent) entity.getComponent(VelocityComponent.class);
            InputComponent inp = (InputComponent) entity.getComponent(InputComponent.class);

            if (inp != null) {
                if (inp.UP) vel.setDy(-movementSpeed);
                if (inp.DOWN) vel.setDy(+movementSpeed);
                if (inp.RIGHT) vel.setDx(+movementSpeed);
                if (inp.LEFT) vel.setDx(-movementSpeed);
            }
        }
    }
}
