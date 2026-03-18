package dk.sdu.cbse.core;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.common.components.*;

import javax.swing.text.Position;

public class MovementSystem extends BaseLogicSystem {

    @Override
    public Priority getPriority(){
        return Priority.Logic;
    }

    @Override
    public void process(IWorld world) {
        for (IEntity entity : world.getEntitiesWithComponent(PositionComponent.class)) {

            PositionComponent pos = (PositionComponent) entity.getComponent(PositionComponent.class);
            VelocityComponent vel = (VelocityComponent) entity.getComponent(VelocityComponent.class);

            if (vel != null) {
                pos.setX(pos.getX() + vel.getDx());
                pos.setY(pos.getY() + vel.getDy());
            }
        }
    }
}
