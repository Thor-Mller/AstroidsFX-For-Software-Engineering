package dk.sdu.cbse.game;

import dk.sdu.cbse.common.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

@Configuration
public class GameConfig {

    public GameConfig(){
    }

    @Bean
    public Game game(){
        return new Game(logicSystems(),renderSystems(),gamePlugins());
    }

    @Bean
    public List<BaseLogicSystem> logicSystems() {
        List<BaseLogicSystem> logicSystems = new ArrayList<>();
        ServiceLoader<IEntitySystem> loader = ServiceLoader.load(IEntitySystem.class);
        for (IEntitySystem system : loader){
            if (system.getPriority() == Priority.Logic){
                logicSystems.add((BaseLogicSystem) system);
            }
        }
        return logicSystems;
    }

    @Bean
    public List<BaseIOSystem> renderSystems() {
        List<BaseIOSystem> renderSystems = new ArrayList<>();
        ServiceLoader<IEntitySystem> loader = ServiceLoader.load(IEntitySystem.class);
        for (IEntitySystem system : loader){
            if (system.getPriority() == Priority.Render){
                renderSystems.add((BaseIOSystem) system);
            }
        }
        return renderSystems;
    }

    @Bean
    public List<IGamePlugin> gamePlugins(){
        List<IGamePlugin> gamePlugins = new ArrayList<>();
        ServiceLoader.load(IGamePlugin.class).forEach(gamePlugins::add);
        return gamePlugins;
    }

}