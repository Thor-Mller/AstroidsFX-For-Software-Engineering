package dk.sdu.cbse.core;

import dk.sdu.cbse.common.IComponent;
import dk.sdu.cbse.common.IEntity;
import dk.sdu.cbse.common.IWorld;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class World implements IWorld {
    private static final World _instance = new World();

    /**
     * Hashmap of all components and the values of witch entities uses the components.
     */
    final Map<Class<? extends IComponent>, HashSet<IEntity>> activeComponentMap = new ConcurrentHashMap<>();

    private World() {
    }

    public static World getInstance() {
        return _instance;
    }

    /**
     * Adds the entity to every component key in world HashMap.
     *
     * @param entity
     */
    public void addEntity(IEntity entity) {
        for (IComponent component : entity.getComponents()) {
            Class<? extends IComponent> type = component.getClass();
            // add new component key, if not there. else add entity.
            activeComponentMap.computeIfAbsent(type, k -> new HashSet<>()).add(entity);
        }
    }

    /**
     * Removes the entity for every component the entity implements from world HashMap.
     *
     * @param entity to remove in world Hashmap
     */
    public void removeEntity(IEntity entity) {
        for (HashSet<IEntity> entities : activeComponentMap.values()) {
            entities.remove(entity);
        }
    }

    @SafeVarargs
    public final HashSet<IEntity> getEntitiesWithComponent(Class<? extends IComponent>... component) {
        HashSet<IEntity> result = new HashSet<>(activeComponentMap.getOrDefault(component[0], new HashSet<>()));
        for (Class<? extends IComponent> aClass : component) {
            result.retainAll(activeComponentMap.getOrDefault(aClass, new HashSet<>()));
        }
        return result;
    }
}
