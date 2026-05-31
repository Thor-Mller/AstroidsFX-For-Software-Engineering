package dk.sdu.cbse.game;

import dk.sdu.cbse.common.*;
import dk.sdu.cbse.common.components.GameStateComponent;
import dk.sdu.cbse.core.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.List;

public class Game extends Application {
    private final Pane gamePane = new Pane();
    private final World world = World.getInstance();

    private final List<BaseLogicSystem> logicSystems;
    private final List<BaseIOSystem> renderSystems;
    private final List<IGamePlugin> gamePlugins;

    private long endTime;

    Game(List<BaseLogicSystem> logicSystems, List<BaseIOSystem> renderSystems, List<IGamePlugin> gamePlugins) {
        this.logicSystems = logicSystems;
        this.renderSystems = renderSystems;
        this.gamePlugins = gamePlugins;
    }

//    private void systemInitializer(GameData gameData){
//        ServiceLoader<IEntitySystem> loader = ServiceLoader.load(IEntitySystem.class);
//        for (IEntitySystem system : loader){
//            if (system.getPriority() == Priority.Logic)
//                logicSystems.add((BaseLogicSystem) system);
//            else if (system.getPriority() == Priority.Render){
//                BaseIOSystem rendersystem = (BaseIOSystem) system;
//                rendersystem.initialize(gameData);
//                renderSystems.add(rendersystem);
//            }
//            // System.out.println("loaded 1 " + system.getClass().getName());
//        }
//    }


//    private void modLoader(){
//        ServiceLoader<IGamePlugin> loader = ServiceLoader.load(IGamePlugin.class);
//        for (IGamePlugin mod : loader){
//            mod.start(world);
//            // System.out.println("loaded 1 " + mod.getClass().getName());
//        }
//    }

    @Override
    public void start(Stage primaryStage) {
        int Height = 800;
        int Width = 600;
        Scene scene = new Scene(gamePane, Height, Width);
        GameData gameData = new GameData(Width, Height, scene, gamePane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("AstroidsFX");
        // systemInitializer(gameData);
        // modLoader();

        IEntity gameSettings = new GameSettings();
        gameSettings.addComponent(new GameStateComponent());
        world.addEntity(gameSettings);

        renderSystems.forEach(r -> r.initialize(gameData));

        gamePlugins.forEach(p -> p.start(world));

        primaryStage.show();
        startGameLoop();
    }

    private void startGameLoop() {
        new javafx.animation.AnimationTimer() {
            @Override
            public void handle(long now) {
                if (endTime == 0) {
                    endTime = now;
                    return;
                }
                double deltaTime = (now - endTime) / 1_000_000_000.0;
                endTime = now;

                for (IEntity gameSettings : world.getEntitiesWithComponent(GameStateComponent.class)) {
                    GameStateComponent gameState = (GameStateComponent) gameSettings.getComponent(GameStateComponent.class);

                    if (gameState.getGameState() == GameStateComponent.GameState.Menu){

                    }
                    else if (gameState.getGameState() == GameStateComponent.GameState.Playin) {
                        update(deltaTime);
                        draw(deltaTime);
                    }
                    else if (gameState.getGameState() == GameStateComponent.GameState.Game_Over) {
                        draw(deltaTime);
                        System.out.println("Game_Over");
                    }
                }
            }
        }.start();
    }

    private void update(double dt) {
        for (BaseLogicSystem system : logicSystems) {
            system.process(world, dt);

        }
    }

    private void draw(double dt) {
        for (BaseIOSystem system : renderSystems) {
            system.process(world, dt);
        }
    }

//    public List<IEntitySystem> getLogicSystems(){
//        return logicSystems;
//    }
}
