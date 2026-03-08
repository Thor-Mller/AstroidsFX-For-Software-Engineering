package dk.sdu.cbse.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseEntity implements IEntity{

    private String id = UUID.randomUUID().toString();

    private final Map<Class<? extends IComponent>, IComponent> components = new ConcurrentHashMap<>();


    /**
     *
     * @return Returns the UUID of the entity.
     */
    public String getId(){
        return id;
    }

    /**
     *
     * @return Returns an arraylist with components active in the entity called on.
     */
    @Override
    public List<IComponent> getComponents() {
        return new ArrayList<>(components.values());
    }

    public void addComponent(IComponent component){
        components.put(component.getClass(), component);
    }

    public <T extends IComponent> T getComponent(Class<T> componentClass){
        return componentClass.cast(components.getClass());
    }

    /** Java checks to see if two objects is the same
     *
     * @param o   the reference object with which to compare.
     * @return bool = true, if they are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return id.equals(that.id);
    }

    /**
     *
     * @return Returns a hash version of the UUID of the entity.
     */
    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
