package dk.sdu.cbse.core;

import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IEntitySystem;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.Priority;
import dk.sdu.cbse.common.components.*;

import javax.swing.text.Position;

public class MovementSystem implements IEntitySystem {

    @Override
    public Priority getPriority(){
        return Priority.Logic;
    }

    @Override
    public void process(IWorld world) {
        for (IEntity entity : world.getEntitiesWithComponent(PositionComponent.class)) {

            PositionComponent pos = entity.getComponent(PositionComponent.class);
            VelocityComponent vel = entity.getComponent(VelocityComponent.class);

            if (vel != null) {
                pos.setX(pos.getX() + vel.getDx());
                pos.setY(pos.getY() + vel.getDy());
            }
        }
    }
}
