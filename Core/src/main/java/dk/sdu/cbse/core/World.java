package dk.sdu.cbse.core;

import dk.sdu.cbse.common.IComponent;
import dk.sdu.cbse.common.IEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class World {
    private World _instance;

    private World get_instance() {
        if (_instance == null) {
            return _instance = new World();
        } else {
            return _instance;
        }
    }

    final Map<Class<? extends IComponent>, List<Class<? extends IEntity>>> activeComponentMap = new ConcurrentHashMap<>();
}
