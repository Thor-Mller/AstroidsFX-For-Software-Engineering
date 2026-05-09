package dk.sdu.cbse.bullet;

import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IGamePlugin;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.components.AngleComponent;
import dk.sdu.cbse.common.components.PositionComponent;
import dk.sdu.cbse.common.components.SpriteComponent;
import dk.sdu.cbse.common.components.VelocityComponent;
import dk.sdu.cbse.bulletComponent.BulletComponent;

import javafx.scene.image.Image;

public class BulletPlugin implements IGamePlugin {
    @Override
    public void start(IWorld world) {

    }

    public void shoot(IWorld world, PositionComponent newpos, double offsetX, double offsetY, int angle){

        double newx = newpos.getX();
        double newy = newpos.getY();

        IEntity bullet = createBullet(world);

        VelocityComponent vel = new VelocityComponent(1,1000,1);
        vel.setDy(-10);
        bullet.addComponent(vel);

        bullet.addComponent(new BulletComponent());

        bullet.addComponent(new AngleComponent(angle));

        bullet.addComponent(new PositionComponent(newx + offsetX, newy + offsetY));

        Image img = new Image(getClass().getResourceAsStream("/assest/bullet/bullet.png"));
        bullet.addComponent(new SpriteComponent(img));

        world.addEntity(bullet);
    }

    public IEntity createBullet(IWorld world){
        return new Bullet();
    }

    @Override
    public void stop(IWorld world) {
    }
}
