package dk.sdu.cbse.core;

import dk.sdu.cbse.common.IComponent;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IWorld;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class World implements IWorld {
    private static final World _instance = new World();

    /**
     * Hashmap of all components and the values of witch entities uses the components.
     */
    final Map<Class<? extends IComponent>, List<IEntity>> activeComponentMap = new ConcurrentHashMap<>();

    private World(){}

    public static World getInstance() {
            return _instance;
    }

    public void addEntity(IEntity entity){
        for (IComponent component : entity.getComponents()){
            Class<? extends IComponent> type = component.getClass();
            // add new component key, if not there. else add entity.
            activeComponentMap.computeIfAbsent(type, k -> new CopyOnWriteArrayList<>()).add(entity);
        }
    }

    public void removeEntity(IEntity entity){
        for (List<IEntity> entities : activeComponentMap.values()){
            entities.remove(entity);
        }
    }

    public List<IEntity> getEntitiesWithComponent(Class<? extends IComponent> component){
        return activeComponentMap.getOrDefault(component, Collections.emptyList());
    }
}
