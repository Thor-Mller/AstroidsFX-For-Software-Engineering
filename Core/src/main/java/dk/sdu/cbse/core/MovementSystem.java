package dk.sdu.cbse.core;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.common.components.*;

import javax.swing.text.Position;

public class MovementSystem extends BaseLogicSystem {

    private double drag = 0.5;
    private double movementSpeed = 2;

    @Override
    public Priority getPriority(){
        return Priority.Logic;
    }

    @Override
    public void process(IWorld world) {
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

            if (vel != null) {
                pos.setX(pos.getX() + vel.getDx());
                pos.setY(pos.getY() + vel.getDy());
            }

            vel.setDx(vel.getDx() * vel.getDrag());
            vel.setDy(vel.getDy() * vel.getDrag());
        }
    }
}
