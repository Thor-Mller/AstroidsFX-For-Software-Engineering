package dk.sdu.cbse.core;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.common.components.*;

public class MovementSystem extends BaseLogicSystem {


    @Override
    public Priority getPriority(){
        return Priority.Logic;
    }

    @Override
    public void process(IWorld world, double deltaTime) {
        for (IEntity entity : world.getEntitiesWithComponent(PositionComponent.class, VelocityComponent.class)) {

            PositionComponent pos = (PositionComponent) entity.getComponent(PositionComponent.class);
            VelocityComponent vel = (VelocityComponent) entity.getComponent(VelocityComponent.class);


            if (vel != null) {
                pos.setX(pos.getX() + vel.getDx());
                pos.setY(pos.getY() + vel.getDy());
            }

            vel.setDx(vel.getDx() * vel.getDrag());
            vel.setDy(vel.getDy() * vel.getDrag());
        }
    }
}
