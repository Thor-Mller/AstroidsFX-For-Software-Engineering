package dk.sdu.cbse.common;

public class BaseLogicSystem implements IEntitySystem{

    public void process(IWorld world, double deltaTime) {
    }

    @Override
    public Priority getPriority() {
        return Priority.Logic;
    }
}

