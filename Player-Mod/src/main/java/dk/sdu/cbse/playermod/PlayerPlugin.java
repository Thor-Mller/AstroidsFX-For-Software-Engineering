package dk.sdu.cbse.playermod;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.common.components.*;

import javafx.scene.image.Image;
import java.util.List;

public class PlayerPlugin implements IGamePlugin{
    private IEntity player;

    @Override
    public void start(IWorld world) {
        player = createPlayer();
        player.addComponent(new PositionComponent(400, 300));
        Image img = new Image(getClass().getResourceAsStream("/assets/player.png"));
        player.addComponent(new SpriteComponent(img));

        world.addEntity(player);
    }

    private IEntity createPlayer(){
        return new Player();
    }

    @Override
    public void stop(IWorld world) {
        world.removeEntity(player);
    }
}
