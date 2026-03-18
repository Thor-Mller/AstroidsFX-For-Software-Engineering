package dk.sdu.cbse.common;

import java.util.List;

public interface IEntity {
    List<IComponent> getComponents();
    IComponent getComponent(Class<? extends IComponent> componentClass);
    void addComponent(IComponent component);
}
