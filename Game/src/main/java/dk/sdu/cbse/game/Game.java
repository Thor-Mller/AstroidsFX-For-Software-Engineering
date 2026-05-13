package dk.sdu.cbse.game;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.core.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

@Component("game")
public class Game extends Application {
    private final Pane gamePane = new Pane();
    private final World world = World.getInstance();

    private final List<BaseLogicSystem> logicSystems = new ArrayList<>();
    private final List<BaseIOSystem> renderSystems = new ArrayList<>();

    private long endTime;

    private void systemInitializer(GameData gameData){
        ServiceLoader<IEntitySystem> loader = ServiceLoader.load(IEntitySystem.class);
        for (IEntitySystem system : loader){
            if (system.getPriority() == Priority.Logic)
                logicSystems.add((BaseLogicSystem) system);
            else if (system.getPriority() == Priority.Render){
                BaseIOSystem rendersystem = (BaseIOSystem) system;
                rendersystem.initialize(gameData);
                renderSystems.add(rendersystem);
            }
            // System.out.println("loaded 1 " + system.getClass().getName());
        }
    }

    @Autowired
    private List<IGamePlugin> gamePlugins;

//    private void modLoader(){
//        ServiceLoader<IGamePlugin> loader = ServiceLoader.load(IGamePlugin.class);
//        for (IGamePlugin mod : loader){
//            mod.start(world);
//            // System.out.println("loaded 1 " + mod.getClass().getName());
//        }
//    }

    @Override
    public void start(Stage primaryStage){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(GameConfig.class);
        context.refresh();

        context.getAutowireCapableBeanFactory().autowireBean(this);

        int Height = 800;
        int Width = 600;
        Scene scene = new Scene(gamePane, Height,Width);
        GameData gameData = new GameData(Width, Height, scene, gamePane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AstroidsFX");
        systemInitializer(gameData);
        // modLoader();
        gamePlugins.forEach(p -> p.start(world));
        primaryStage.show();

        startGameLoop();
    }

    private void startGameLoop(){
        new javafx.animation.AnimationTimer(){
            @Override
            public void handle(long now){
                if (endTime == 0){
                    endTime = now;
                    return;
                }
                double deltaTime = (now - endTime) / 1_000_000_000.0;
                endTime = now;
                update(deltaTime);
                draw(deltaTime);
            }
        }.start();
    }

    private void update(double dt){
        for (BaseLogicSystem system : logicSystems){
            system.process(world, dt);

        }
    }

    private void draw(double dt){
        for (BaseIOSystem system : renderSystems){
            system.process(world, dt);
        }
    }
}
