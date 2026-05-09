package dk.sdu.cbse.common;


public class BaseIOSystem implements IEntitySystem{

    public void process(IWorld world, double deltaTime) {
    }

    public void initialize(GameData gameData){
    }

    @Override
    public Priority getPriority() {
        return Priority.Render;
    }
}
