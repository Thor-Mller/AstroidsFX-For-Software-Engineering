package dk.sdu.cbse.score;

import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IGamePlugin;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.scoreComponent.ScoreComponent;

public class ScorePlugin implements IGamePlugin {

    private IEntity score;

    @Override
    public void start(IWorld world) {
        score = createScore();

        score.addComponent(new ScoreComponent());

        world.addEntity(score);
    }

    @Override
    public void stop(IWorld world) {

    }

    public IEntity createScore(){
        return new Score();
    }
}

