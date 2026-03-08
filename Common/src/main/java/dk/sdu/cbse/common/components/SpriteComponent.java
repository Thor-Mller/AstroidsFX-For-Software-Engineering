package dk.sdu.cbse.common.components;

public class SpriteComponent {
    private String path;
    private Float sizeX;
    private Float sizeY;

    SpriteComponent(String path, Float sizeX, Float sizeY){
        this.path = path;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }
}
