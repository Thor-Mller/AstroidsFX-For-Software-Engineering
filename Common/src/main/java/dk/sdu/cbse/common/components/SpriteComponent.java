package dk.sdu.cbse.common.components;

import dk.sdu.cbse.common.IComponent;
import javafx.scene.image.Image;

public class SpriteComponent implements IComponent {
    private final Image image;

    public SpriteComponent(Image image){
        this.image = image;
    }

    public Image getPath(){
        return image;
    }
}
