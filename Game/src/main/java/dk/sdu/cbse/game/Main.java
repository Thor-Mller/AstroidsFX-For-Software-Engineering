package dk.sdu.cbse.game;

import javafx.application.Application;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main  extends Application {
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage window) throws Exception {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(GameConfig.class);
        Game game = acac.getBean(Game.class);
        game.start(window);
    }
}
