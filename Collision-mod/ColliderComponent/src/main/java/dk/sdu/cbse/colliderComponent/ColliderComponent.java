package dk.sdu.cbse.colliderComponent;

import dk.sdu.cbse.common.IComponent;

public class ColliderComponent implements IComponent {
    float radius;


    public ColliderComponent(float radius){
        this.radius = radius;
    }
    public float getRadius(){return radius;}
    public void setRadius(float radius){this.radius = radius;}
}
