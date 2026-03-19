package dk.sdu.cbse.game;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.core.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;

public class Game extends Application {
    private final Pane gamePane = new Pane();
    private final World world = World.getInstance();

    private final List<BaseLogicSystem> logicSystems = new ArrayList<>();
    private final List<BaseRenderSystem> renderSystems = new ArrayList<>();

    private void systemInitializer(){
        ServiceLoader<IEntitySystem> loader = ServiceLoader.load(IEntitySystem.class);
        for (IEntitySystem system : loader){
            if (system.getPriority() == Priority.Logic)
                logicSystems.add((BaseLogicSystem) system);
            else if (system.getPriority() == Priority.Render){
                BaseRenderSystem rendersystem = (BaseRenderSystem) system;
                rendersystem.initialize(gamePane);
                renderSystems.add(rendersystem);
            }
            // System.out.println("loaded 1 " + system.getClass().getName());
        }
    }

    private void modLoader(){
        ServiceLoader<IGamePlugin> loader = ServiceLoader.load(IGamePlugin.class);
        for (IGamePlugin mod : loader){
            mod.start(world);
            // System.out.println("loaded 1 " + mod.getClass().getName());
        }
    }

    @Override
    public void start(Stage primaryStage){
        Scene scene = new Scene(gamePane, 800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AstroidsFX");
        systemInitializer();
        modLoader();
        primaryStage.show();

        startGameLoop();
    }

    private void startGameLoop(){
        new javafx.animation.AnimationTimer(){
            @Override
            public void handle(long now){
                update();
                draw();
            }
        }.start();
    }

    private void update(){
        for (BaseLogicSystem system : logicSystems){
            system.process(world);
        }
    }

    private void draw(){
        for (BaseRenderSystem system : renderSystems){
            system.process(world);
        }
    }
}
