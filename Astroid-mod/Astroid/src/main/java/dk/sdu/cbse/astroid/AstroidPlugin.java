package dk.sdu.cbse.astroid;

import dk.sdu.cbse.colliderComponent.ColliderComponent;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IGamePlugin;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.components.AngleComponent;
import dk.sdu.cbse.common.components.PositionComponent;
import dk.sdu.cbse.common.components.SpriteComponent;
import dk.sdu.cbse.common.components.VelocityComponent;
import javafx.scene.image.Image;
import dk.sdu.cbse.astroidComponent.AstroidComponent;

import java.util.Random;

public class AstroidPlugin implements IGamePlugin{
    @Override
    public void start(IWorld world) {
    }

    public void spawnAstroid(IWorld world){
        IEntity astroid = createAstroid();

        VelocityComponent vel = new VelocityComponent(1,100,1);
        vel.setDy(2.5);
        astroid.addComponent(vel);

        astroid.addComponent(new AstroidComponent());

        astroid.addComponent(new AngleComponent(0));

        astroid.addComponent(new ColliderComponent(32));

        astroid.addComponent(new PositionComponent(getRandomSpawnPosition(),0));

        Image img = new Image(getClass().getResourceAsStream("/assets.astroid/asteroid.png"));
        astroid.addComponent(new SpriteComponent(img));

        world.addEntity(astroid);
    }

    public IEntity createAstroid(){
        return new Astroid();
    }

    public int getRandomSpawnPosition(){
        Random random = new Random();
        return random.nextInt(800-64);
    }

    @Override
    public void stop(IWorld world) {

    }
}
