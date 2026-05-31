package dk.sdu.cbse.astroid;

import dk.sdu.cbse.astroidComponent.AstroidComponent;
import dk.sdu.cbse.astroidComponent.AstroidIsHitComponent;
import dk.sdu.cbse.common.BaseLogicSystem;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.components.PositionComponent;

public class SplitSystem extends BaseLogicSystem{

    @Override
    public void process(IWorld world, double deltaTime){
        for (IEntity entity : world.getEntitiesWithComponent(PositionComponent.class,AstroidComponent.class, AstroidIsHitComponent.class)){
            //System.out.println("found entity" + entity);
            PositionComponent pos = (PositionComponent) entity.getComponent(PositionComponent.class);

            SmallAstroidPlugin.spawnSmallAstroid(world, pos, 0, 0, 1);
            SmallAstroidPlugin.spawnSmallAstroid(world, pos, 0, 0, -1);

            world.removeEntity(entity);

        }
    }
}
