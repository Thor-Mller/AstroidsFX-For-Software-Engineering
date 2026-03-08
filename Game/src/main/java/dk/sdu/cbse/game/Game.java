package dk.sdu.cbse.game;

import dk.sdu.cbse.common.IEntitySystem;
import dk.sdu.cbse.common.Priority;
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

    private final List<IEntitySystem> logicSystems = new ArrayList<>();
    private final List<IEntitySystem> renderSystems = new ArrayList<>();

    private void systemInitializer(){
        ServiceLoader<IEntitySystem> loader = ServiceLoader.load(IEntitySystem.class);
        for (IEntitySystem system : loader){
            if (system.getPriority() == Priority.Logic)
                logicSystems.add(system);
            else if (system.getPriority() == Priority.Render)
                renderSystems.add(system);
        }
    }

    @Override
    public void start(Stage primaryStage){
        Scene scene = new Scene(gamePane, 800,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AstroidsFX");
        systemInitializer();
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
        for (IEntitySystem system : logicSystems){
            system.process(world);
        }
    }

    private void draw(){
        for (IEntitySystem system : renderSystems){
            system.process(world);
        }
    }
}
