package dk.sdu.cbse.common;

import java.util.List;

public interface IWorld {
    List<IEntity> getEntitiesWithComponent(Class<? extends IComponent> componentClass);
}
