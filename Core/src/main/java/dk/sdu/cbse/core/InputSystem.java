package dk.sdu.cbse.core;

import dk.sdu.cbse.common.BaseLogicSystem;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IWorld;
import dk.sdu.cbse.common.components.InputComponent;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class InputSystem extends BaseLogicSystem {
    private final Set<KeyCode> keypressed = new HashSet<>();

    @Override
    public void process(IWorld world) {
        for (IEntity entities : world.getEntitiesWithComponent(InputComponent.class)){
            InputComponent input = (InputComponent) entities.getComponent(InputComponent.class);
            
        }
    }
}
