package dk.sdu.cbse;

import dk.sdu.cbse.astroidComponent.AstroidComponent;
import dk.sdu.cbse.bulletComponent.BulletComponent;
import dk.sdu.cbse.common.BaseLogicSystem;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.colliderComponent.ColliderComponent;
import dk.sdu.cbse.common.components.PlayerComponent;
import dk.sdu.cbse.common.components.PositionComponent;

public class colliderSystem extends BaseLogicSystem {
    @Override
    public void process(IWorld world, double deltaTime){
        for (IEntity entity : world.getEntitiesWithComponent(ColliderComponent.class, PositionComponent.class)){
                for (IEntity entity1 : world.getEntitiesWithComponent(ColliderComponent.class, PositionComponent.class)){
                    if (entity == entity1){
                        continue;
                    }
                    if (collides(entity,entity1)){
                        handleCollision(world, entity, entity1);
                    }
                }
        }
    }

    public boolean collides(IEntity e1, IEntity e2){
        PositionComponent pos1 = (PositionComponent) e1.getComponent(PositionComponent.class);
        PositionComponent pos2 = (PositionComponent) e2.getComponent(PositionComponent.class);
        ColliderComponent col1 = (ColliderComponent) e1.getComponent(ColliderComponent.class);
        ColliderComponent col2 = (ColliderComponent) e2.getComponent(ColliderComponent.class);

        double x1 = pos1.getX() + col1.getRadius();
        double y1 = pos1.getY() + col1.getRadius();
        double x2 = pos2.getX() + col2.getRadius();
        double y2 = pos2.getY() + col2.getRadius();

        double distanceX = x1 - x2;
        double distanceY = y1 - y2;
        double distance = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        if (distance < col1.getRadius() + col2.getRadius()){
            return true;
        } else return false;
    }

    public void handleCollision(IWorld world, IEntity e1, IEntity e2){

        if (isBullet(e1) && isAstroid(e2)){
            world.removeEntity(e1);
            world.removeEntity(e2);
            // System.out.println("Astroid Hit!!!");
        }

    }

    private boolean isBullet(IEntity e){ return e.getComponent(BulletComponent.class) != null;}
    private boolean isAstroid(IEntity e){ return e.getComponent(AstroidComponent.class) != null;}
    private boolean isPlayer(IEntity e){ return e.getComponent(PlayerComponent.class) != null;}
}
