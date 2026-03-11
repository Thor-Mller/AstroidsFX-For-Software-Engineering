package dk.sdu.cbse.common;

import java.util.HashSet;

public interface IWorld {
    HashSet<IEntity> getEntitiesWithComponent(Class<? extends IComponent>... componentClass);
}
