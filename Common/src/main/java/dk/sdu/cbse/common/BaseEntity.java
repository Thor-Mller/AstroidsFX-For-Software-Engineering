package dk.sdu.cbse.common;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEntity implements IEntity{
    List<IComponent> components = new ArrayList<IComponent>();

    @Override
    public List<IComponent> getComponents() {
        return components;
    }
}
