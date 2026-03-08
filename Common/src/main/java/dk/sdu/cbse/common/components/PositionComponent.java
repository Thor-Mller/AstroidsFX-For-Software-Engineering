package dk.sdu.cbse.common.components;

import dk.sdu.cbse.common.IComponent;

public class PositionComponent implements IComponent {
    public double x;
    public double y;


    PositionComponent(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {return this.x;}
    public double getY() {return this.y;}
    public void setX(double newX) {this.x = newX;}
    public void setY(double newY) {this.y = newY;}
}