package dk.sdu.cbse.playerDeathSystem;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.common.components.GameStateComponent;
import dk.sdu.cbse.playerComponents.*;

public class PlayerDeathSystem extends BaseLogicSystem{
    @Override
    public void process(IWorld world, double deltaTime) {
        for (IEntity player : world.getEntitiesWithComponent(PlayerComponent.class, PlayerIsDeadComponent.class)) {
            world.removeEntity(player);
            for (IEntity gameSettings : world.getEntitiesWithComponent(GameStateComponent.class)) {
                GameStateComponent gameSetting = (GameStateComponent) gameSettings.getComponent(GameStateComponent.class);
                gameSetting.setCurrentState(GameStateComponent.GameState.Game_Over);
                world.updateEntity(gameSettings);
                world.updateEntity(player);
            }
        }
    }
}
