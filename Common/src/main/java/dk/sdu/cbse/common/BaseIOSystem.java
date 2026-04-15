package dk.sdu.cbse.common;

import javafx.scene.layout.Pane;

public class BaseIOSystem implements IEntitySystem{

    public void process(IWorld world) {
    }

    public void initialize(GameData gameData){
    }

    @Override
    public Priority getPriority() {
        return Priority.Render;
    }
}
