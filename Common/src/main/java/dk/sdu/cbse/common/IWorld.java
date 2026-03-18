package dk.sdu.cbse.common;

import java.util.HashSet;

public interface IWorld {
    void addEntity(IEntity entity);
    void removeEntity(IEntity entity);
    HashSet<IEntity> getEntitiesWithComponent(Class<? extends IComponent>... componentClass);
}
