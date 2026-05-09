package dk.sdu.playermovement;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.common.components.*;

public class PlayerMovementSystem extends BaseLogicSystem {

    private double movementSpeed = 2;

    @Override
    public void process(IWorld world, double deltaTime) {
        for (IEntity entity : world.getEntitiesWithComponent(PositionComponent.class, VelocityComponent.class, PlayerComponent.class, InputComponent.class)) {

            PositionComponent pos = (PositionComponent) entity.getComponent(PositionComponent.class);
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
