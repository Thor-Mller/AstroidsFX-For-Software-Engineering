package dk.sdu.cbse.common;

import java.util.List;

public interface IEntity {
    List<IComponent> getComponents();
    <T extends IComponent> T getComponent(Class<T> componentClass);
}
