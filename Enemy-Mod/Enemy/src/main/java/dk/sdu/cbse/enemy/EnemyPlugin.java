package dk.sdu.cbse.enemy;

import dk.sdu.cbse.colliderComponent.ColliderComponent;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IGamePlugin;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.components.AngleComponent;
import dk.sdu.cbse.common.components.PositionComponent;
import dk.sdu.cbse.common.components.SpriteComponent;
import dk.sdu.cbse.common.components.VelocityComponent;
import javafx.scene.image.Image;
import dk.sdu.cbse.enemyComponent.EnemyComponent;

import java.util.Random;

public class EnemyPlugin implements IGamePlugin{
    @Override
    public void start(IWorld world) {
    }

    public void spawnEnemy(IWorld world){
        IEntity enemy = createEnemy();

        VelocityComponent vel = new VelocityComponent(1,100,1);
        vel.setDy(2.5);
        enemy.addComponent(vel);

        enemy.addComponent(new EnemyComponent());

        enemy.addComponent(new AngleComponent(0));

        enemy.addComponent(new ColliderComponent(32));

        enemy.addComponent(new PositionComponent(getRandomSpawnPosition(),0));

        Image img = new Image(EnemyPlugin.class.getResourceAsStream("/assets/enemy/enemy.png"));
        enemy.addComponent(new SpriteComponent(img));

        world.addEntity(enemy);
    }

    public IEntity createEnemy(){
        return new Enemy();
    }

    public int getRandomSpawnPosition(){
        Random random = new Random();
        return random.nextInt(800-64);
    }

    @Override
    public void stop(IWorld world) {

    }
}