package dk.sdu.cbse.core;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.common.components.InputComponent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import java.util.HashSet;
import java.util.Set;

public class InputSystem extends BaseIOSystem {
    private final Set<KeyCode> keypressed = new HashSet<>();

    public InputSystem(){}

    @Override
    public void initialize(GameData gameData){
        Scene scene = gameData.getScene();
        scene.setOnKeyPressed(event -> keypressed.add(event.getCode()));
        // scene.setOnKeyPressed(event -> System.out.println("keypressed " + event.getCode().toString()));
        scene.setOnKeyReleased(event -> keypressed.remove(event.getCode()));
    }

    @Override
    public void process(IWorld world, double deltaTime) {
        for (IEntity entities : world.getEntitiesWithComponent(InputComponent.class)){
            InputComponent input = (InputComponent) entities.getComponent(InputComponent.class);

            input.UP = keypressed.contains(KeyCode.W) || keypressed.contains(KeyCode.UP);
            input.DOWN = keypressed.contains(KeyCode.S) || keypressed.contains(KeyCode.DOWN);
            input.RIGHT = keypressed.contains(KeyCode.D) || keypressed.contains(KeyCode.RIGHT);
            input.LEFT = keypressed.contains(KeyCode.A) || keypressed.contains(KeyCode.LEFT);
            input.SHOOT = keypressed.contains(KeyCode.SPACE) || keypressed.contains(KeyCode.M);
        }
    }
}
