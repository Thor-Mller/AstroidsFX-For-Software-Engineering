package dk.sdu.cbse.astroid;

import dk.sdu.cbse.astroidComponent.SmallAstroidComponent;
import dk.sdu.cbse.colliderComponent.ColliderComponent;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IGamePlugin;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.components.AngleComponent;
import dk.sdu.cbse.common.components.PositionComponent;
import dk.sdu.cbse.common.components.SpriteComponent;
import dk.sdu.cbse.common.components.VelocityComponent;
import javafx.scene.image.Image;

public class SmallAstroidPlugin implements IGamePlugin{
    @Override
    public void start(IWorld world) {
    }

    public static void spawnSmallAstroid(IWorld world, PositionComponent pos, int offsetx, int offsety, double xVel){
        IEntity astroid = createSmallAstroid();

        VelocityComponent vel = new VelocityComponent(1,100,1);
        vel.setDy(2.5);
        vel.setDx(xVel);
        astroid.addComponent(vel);

        astroid.addComponent(new SmallAstroidComponent());

        astroid.addComponent(new AngleComponent(0));

        astroid.addComponent(new ColliderComponent(32));

        astroid.addComponent(new PositionComponent(pos.getX() + offsetx, pos.getY() + offsety));

        Image img = new Image(SmallAstroidPlugin.class.getResourceAsStream("/assets.astroid/asteroid.png"));
        astroid.addComponent(new SpriteComponent(img));

        world.addEntity(astroid);
    }

    public static IEntity createSmallAstroid(){
        return new SmallAstroid();
    }

    @Override
    public void stop(IWorld world) {

    }
}
