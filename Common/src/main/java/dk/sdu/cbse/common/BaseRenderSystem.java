package dk.sdu.cbse.common;

import javafx.scene.layout.Pane;

public class BaseRenderSystem implements IEntitySystem{

    public void process(IWorld world) {
    }

    public void initialize(Pane pane){
    }

    @Override
    public Priority getPriority() {
        return Priority.Render;
    }
}
