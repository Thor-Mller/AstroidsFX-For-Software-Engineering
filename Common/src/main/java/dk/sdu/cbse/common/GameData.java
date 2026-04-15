package dk.sdu.cbse.common;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameData {
    private final int displayWidth;
    private final int displayHeight;
    private final Scene scene;
    private final Pane pane;

    public GameData(int displayWidth, int displayHeight, Scene scene, Pane pane){
        this.displayWidth = displayWidth;
        this.displayHeight = displayHeight;
        this.scene = scene;
        this.pane = pane;
    }

    public Scene getScene(){return scene;}
    public Pane getPane(){return pane;}
    public int getDisplayWidth(){return displayWidth;}
    public int getDisplayHeight(){return displayHeight;}
}
