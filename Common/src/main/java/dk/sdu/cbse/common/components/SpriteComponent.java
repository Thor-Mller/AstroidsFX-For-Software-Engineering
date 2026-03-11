package dk.sdu.cbse.common.components;

import dk.sdu.cbse.common.IComponent;

public class SpriteComponent implements IComponent {
    private final String imagePath;

    public SpriteComponent(String imagePath){
        this.imagePath = imagePath;
    }

    public String getPath(){
        return imagePath;
    }
}
